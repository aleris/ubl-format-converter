# UBL Format Converter

Converts UBL documents to / from XML / JSON formats with fast javax XML/JSON streaming.

# Usage

Convert from UBL XML to JSON example (Kotlin):

```kotlin
val xmlFile = File("/path/to/file.xml")
val xmlInputStream = xmlFile.inputStream()
val jsonOutputStream = ByteArrayOutputStream()

val converter = UBLToJsonFormatConverterFactory(prettyPrint = true, version = UBLJsonVersion.V2)
    .createConverter(xmlInputStream, jsonOutputStream)
converter.convert()

val convertedJsonString = jsonOutputStream.toString(Charsets.UTF_8.name())

println(convertedJsonString)

```

# Features

- Generate UBL 2.1 JSON Alternative Representation from XML for both
  [version 1.0](http://docs.oasis-open.org/ubl/UBL-2.1-JSON/v1.0/UBL-2.1-JSON-v1.0.html) and 
  [version 2.0](https://docs.oasis-open.org/ubl/UBL-2.1-JSON/v2.0/cnd01/UBL-2.1-JSON-v2.0-cnd01.html).
- Compact or pretty print output (with javax.json.stream.JsonGenerator).
- Quick (uses XML and JSON streaming API).

# Caveats

It does not use schema for output generation, it uses some heuristics for determining types and name mapping.
Especially for JSON V1 this may fail. That being said, it has extensive tests that covers all examples in the
UBL standard, so this should provide a certain level of confidence.
