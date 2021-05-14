package ro.aleris.ublformatconverter

import javax.json.stream.JsonGenerator
import javax.xml.stream.XMLEventReader
import javax.xml.stream.events.Attribute
import javax.xml.stream.events.Namespace
import javax.xml.stream.events.StartElement
import javax.xml.stream.events.XMLEvent

class UBLToJsonFormatConverter(
    private val reader: XMLEventReader,
    private val jsonGenerator: JsonGenerator,
    private val ublJsonNameMapper: UBLJsonNameMapper
) {
    companion object {
        const val CONTENT = "[CONTENT]"
    }

    fun convert() {
        jsonGenerator.writeStartObject()

        val startElementsStack = ArrayDeque<StartElement>()
        var namespacesWritten = false

        while (reader.hasNext()) {
            val event = reader.next() as XMLEvent

            peekSkipWhiteSpace(reader)

            if (event.isStartElement) {
                val startElement = event.asStartElement()

                if (!namespacesWritten) {
                    writeNamespaces(startElement)
                    namespacesWritten = true
                }

                // only start array if different start element
                if (startElementsStack.lastOrNull()?.name?.localPart != startElement.name.localPart) {
                    jsonGenerator.writeStartArray(startElement.name.localPart)
                    startElementsStack.addLast(startElement)
                }

                jsonGenerator.writeStartObject()

                val content = readContent()
                if (content != null) {
                    writeJsonElementWithContent(startElement, content)
                }
            }

            if (event.isEndElement) {
                val endElement = event.asEndElement()

                // close object
                jsonGenerator.writeEnd()

                // close array if next element is not the same type
                val next = peekSkipWhiteSpace(reader) ?: break
                if (next.isStartElement) {
                    val nextStartElement = next.asStartElement()
                    if (endElement.name.localPart != nextStartElement.name.localPart) {
                        jsonGenerator.writeEnd()
                        startElementsStack.removeLast()
                    }
                } else {
                    jsonGenerator.writeEnd()
                    startElementsStack.removeLast()
                }
            }
        }

        jsonGenerator.writeEnd()
        jsonGenerator.flush()
    }

    private fun readContent(): String? {
        var next: XMLEvent
        val contentBuffer = StringBuffer()
        var contentExists = false
        while (true) {
            next = reader.peek()
            if (next.isCharacters) {
                contentBuffer.append(next.asCharacters().data)
                contentExists = true
                reader.next()
                continue
            }
            break
        }
        return if (contentExists) {
            contentBuffer.toString()
        } else {
            null
        }
    }

    private fun peekSkipWhiteSpace(reader: XMLEventReader): XMLEvent? {
        while (true) {
            if (!reader.hasNext()) {
                return null
            }
            val next = reader.peek()
            if (next.isCharacters) {
                val characters = next.asCharacters()
                if (characters.isWhiteSpace) {
                    reader.next()
                    continue
                }
            }
            return next
        }
    }

    private fun writeJsonElementWithContent(startElement: StartElement, content: String) {
        val startElementName = startElement.name.localPart
        val contentAttributeName = ublJsonNameMapper.mapAttributeName(startElementName, CONTENT, content)
        writeTypedJsonValue(startElementName, contentAttributeName, content)

        startElement.attributes.forEach { attributeAny ->
            val attribute = attributeAny as Attribute?
            if (attribute != null) {
                val attributeName = ublJsonNameMapper.mapAttributeName(startElementName, attribute.name.localPart, content)
                jsonGenerator.write(attributeName, attribute.value)
            }
        }
    }

    private fun writeTypedJsonValue(elementName: String, contentAttributeName: String, rawData: String) {
        when {
            rawData.isEmpty() -> jsonGenerator.write(contentAttributeName, rawData)

            elementName.endsWith("Amount") ||
                    elementName.endsWith("Numeric") ||
                    (elementName != "Value" && elementName.endsWith("Value")) ||
                    elementName.endsWith("Rate") ||
                    elementName.endsWith("Percent") ||
                    elementName.endsWith("Quantity") ||
                    elementName.endsWith("Measure") -> {
                val numeric = rawData.toBigDecimalOrNull()
                if (numeric != null) {
                    jsonGenerator.write(contentAttributeName, numeric)
                } else {
                    jsonGenerator.write(contentAttributeName, rawData)
                }
            }

            elementName.endsWith("Indicator") -> {
                val bool = rawData.toBooleanStrictOrNull()
                if (bool != null) {
                    jsonGenerator.write(contentAttributeName, bool)
                } else {
                    jsonGenerator.write(contentAttributeName, rawData)
                }
            }

            else -> jsonGenerator.write(contentAttributeName, rawData)
        }
    }

    private fun writeNamespaces(
        startElement: StartElement
    ) {
        val namespaces = getWritableJsonNamespaces(startElement)
        namespaces.forEach { namespaceEntry ->
            jsonGenerator.write(namespaceEntry.key, namespaceEntry.value)
        }
    }

    private fun getWritableJsonNamespaces(
        startElement: StartElement
    ): MutableSet<MutableMap.MutableEntry<String, String>> {
        val map = LinkedHashMap<String, String>()
        startElement.namespaces.forEach { namespaceAny ->
            if (namespaceAny != null) {
                val namespace = namespaceAny as Namespace?
                val value = namespace?.value
                if (value != null) {
                    val xmlNamespace = DeclaredXMLNamespaces.valueOfOrNull(value)
                    if (xmlNamespace != null) {
                        val prefix = ublJsonNameMapper.mapNamespaceNameToPrefix(xmlNamespace)
                        if (prefix != null) {
                            map[prefix] = namespace.value
                        }
                    }
                }
            }
        }
        return map.entries
    }
}
