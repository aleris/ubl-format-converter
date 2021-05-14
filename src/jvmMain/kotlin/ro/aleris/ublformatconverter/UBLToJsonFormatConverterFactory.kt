package ro.aleris.ublformatconverter

import java.io.InputStream
import java.io.OutputStream
import java.io.PrintWriter
import javax.json.Json
import javax.json.stream.JsonGenerator
import javax.xml.stream.XMLInputFactory

class UBLToJsonFormatConverterFactory(val prettyPrint: Boolean = true, val version: UBLJsonVersion = UBLJsonVersion.V2) {
    private val xmlInputFactory: XMLInputFactory = XMLInputFactory.newFactory()
    private val jsonGeneratorFactory = Json.createGeneratorFactory(null)
    private val jsonGeneratorFactoryPrettyPrint = Json.createGeneratorFactory(mapOf(Pair(
        JsonGenerator.PRETTY_PRINTING,
        java.lang.Boolean.TRUE
    )))

    fun createConverter(xmlInputStream: InputStream, jsonOutputStream: OutputStream): UBLToJsonFormatConverter {
        val printWriter = PrintWriter(jsonOutputStream)

        val reader = xmlInputFactory.createXMLEventReader(xmlInputStream)

        val jsonGenerator =
            if (prettyPrint) jsonGeneratorFactoryPrettyPrint.createGenerator(printWriter)
            else jsonGeneratorFactory.createGenerator(printWriter)

        val ublJsonNameMapper =
            when (version) {
                UBLJsonVersion.V1 -> UBLJsonNameMapperV1()
                UBLJsonVersion.V2 -> UBLJsonNameMapperV2()
            }

        return UBLToJsonFormatConverter(reader, jsonGenerator, ublJsonNameMapper)
    }
}