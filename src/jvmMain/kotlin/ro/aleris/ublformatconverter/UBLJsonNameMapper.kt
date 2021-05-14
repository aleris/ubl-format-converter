package ro.aleris.ublformatconverter

import javax.json.stream.JsonGenerator
import javax.xml.stream.events.Characters
import javax.xml.stream.events.Namespace
import javax.xml.stream.events.StartElement

interface UBLJsonNameMapper {
    fun mapAttributeName(elementName: String, attributeName: String, value: String): String
    fun mapNamespaceNameToPrefix(namespace: DeclaredXMLNamespaces): String?
}
