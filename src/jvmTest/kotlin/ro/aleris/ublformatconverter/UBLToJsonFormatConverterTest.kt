package ro.aleris.ublformatconverter

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.skyscreamer.jsonassert.JSONAssert
import java.io.ByteArrayOutputStream
import java.io.File
import java.nio.file.Paths
import java.util.concurrent.TimeUnit
import java.util.stream.Stream

internal class UBLToJsonFormatConverterTest {

    @ParameterizedTest
    @MethodSource("provideTestXmlFiles")
    fun convert__json_v2(xmlFile: File) {
        testSingleFile(UBLJsonVersion.V2, false, xmlFile)
    }

    @ParameterizedTest
    @MethodSource("provideTestXmlFiles")
    fun convert__json_v2_pretty_print(xmlFile: File) {
        testSingleFile(UBLJsonVersion.V2, true, xmlFile)
    }

    @ParameterizedTest
    @MethodSource("provideTestXmlFiles")
    fun convert__json_v1(xmlFile: File) {
        testSingleFile(UBLJsonVersion.V1, false, xmlFile)
    }

    @ParameterizedTest
    @MethodSource("provideTestXmlFiles")
    fun convert__json_v1_pretty_print(xmlFile: File) {
        testSingleFile(UBLJsonVersion.V1, true, xmlFile)
    }

    private fun testSingleFile(version: UBLJsonVersion, prettyPrint: Boolean, xmlFile: File) {
        print("\"${xmlFile.nameWithoutExtension}\" XML -> JSON $version${if (prettyPrint) " [pretty]" else ""} ...")

        val xmlInputStream = xmlFile.inputStream()
        val jsonOutputStream = ByteArrayOutputStream()
        val converter = UBLToJsonFormatConverterFactory(prettyPrint = prettyPrint, version = version)
            .createConverter(xmlInputStream, jsonOutputStream)
        converter.convert()
        val convertedJsonString = jsonOutputStream.toString(Charsets.UTF_8.name())
//        println(convertedJsonString)

        val versionNumber = if (version == UBLJsonVersion.V1) 1 else 2
        val jsonFile = getOtherFormatFile(xmlFile, "json",  "-v$versionNumber")
        if (jsonFile.exists()) {
            val expectedJsonString = jsonFile.readText(Charsets.UTF_8)
            JSONAssert.assertEquals(expectedJsonString, convertedJsonString, true)
            println(" OK")
        } else {
            println(" JSON file not found, SKIPPED")
        }
    }

    @Test
    @Disabled
    fun convert__performance() {
        val xmlFile = File(javaClass.getResource("/UBL/Real/xml/UBL-Invoice-2-Example-ManyLines.xml")!!.file)
        val converterFactory = UBLToJsonFormatConverterFactory(prettyPrint = false, version = UBLJsonVersion.V2)

        val iterations = 2_500
        val startTime = System.nanoTime()
        var i = 0
        while (i++ != iterations) {
            val xmlInputStream = xmlFile.inputStream()
            val jsonOutputStream = ByteArrayOutputStream()
            converterFactory.createConverter(xmlInputStream, jsonOutputStream).convert()
        }
        val endTime = System.nanoTime()
        val elapsedTimeNano = endTime - startTime
        val elapsedTimeMillis = TimeUnit.MILLISECONDS.convert(elapsedTimeNano, TimeUnit.NANOSECONDS)
        val perConversion = elapsedTimeMillis.toDouble() / iterations

        println("DONE $iterations conversions in $elapsedTimeMillis ms, $perConversion ms per conversion.")
    }

    companion object {
        @JvmStatic
        fun provideTestXmlFiles(): Stream<Arguments> {
            val list = ArrayList<Arguments>()
            val dir = File(javaClass.getResource("/UBL")!!.file)
            dir.walk().forEach { file ->
                if (file.extension == "xml") {
                    list.add(Arguments.of(file))
                }
            }
            return list.stream()
        }

        private fun getOtherFormatFile(file: File, extension: String, versionSuffix: String = ""): File {
            return Paths.get(
                file.parentFile.parentFile.path,
                "$extension$versionSuffix",
                "${file.nameWithoutExtension}.$extension"
            ).toFile()
        }
    }
}
