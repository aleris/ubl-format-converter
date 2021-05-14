package ro.aleris.ublformatconverter

/**
 * Implements UBL JSON Alternative Representation Version 1.0
 * http://docs.oasis-open.org/ubl/UBL-2.1-JSON/v1.0/cnd02/UBL-2.1-JSON-v1.0-cnd02.html
 * WARNING: not schema aware, uses simple heuristics to determine the mapped attribute names, with string matching
 */
class UBLJsonNameMapperV1 : UBLJsonNameMapper {

    companion object {
        private val TEXT_CONTENT_IDENTIFIED_BY_NAME = setOf(
            "Note",
            "Value",

            "Postbox",
            "Floor",
            "Room",
            "StreetName",
            "AdditionalStreetName",
            "BlockName",
            "BuildingName",
            "BuildingNumber",
            "InhouseMail",
            "Department",
            "MarkAttention",
            "MarkCare",
            "CitySubdivisionName",
            "CityName",
            "PostalZone",
            "CountrySubentity",
            "Region",
            "District",
            "TimezoneOffset",

            "Telephone",
            "Telefax",
            "ElectronicMail",
            "OtherCommunication",

            "Title",
            "NameSuffix",
            "JobTitle",
            "OrganizationDepartment",

            "Line",
            "AccountingCost",
            "SpecialTerms",
            "LossRisk",

            "SpecialInstructions",
            "CancellationNote",
            "DeliveryInstructions",
            "RegistrationNationality",
            "ShippingMarks",
            "LevelPrerequisite",
            "Condition",
            "PrintQualifier",

            "SignatureValue",
            "SignatureMethod",
            "XPath",
            "DocumentHash",
            "CanonicalizationMethod",
            "SignatureValue",
            "XMLTimeStamp",
            "DigestValue",
            "X509SerialNumber",
            "SigningTime",
            "Exponent",
            "Modulus",
            "X509Certificate"
        )
    }

    enum class NamespacePrefixes(val value: String?) {
        Document("_D"),
        CommonAggregateComponents("_S"),
        CommonBasicComponents("_B"),
        CommonExtensionComponents("_E"),
        CommonSignatureComponents(null),
        QualifiedDataTypes(null),
        SignatureAggregateComponents(null),
        SignatureBasicComponents(null),
        UnqualifiedDataTypes(null),
    }

    override fun mapAttributeName(elementName: String, attributeName: String, value: String): String {
        val isNumeric = value.toBigDecimalOrNull() != null

        return when {
            elementName.endsWith("Amount") -> {
                when (attributeName) {
                    UBLToJsonFormatConverter.CONTENT -> "AmountContent"
                    "currencyID" -> "AmountCurrencyIdentifier"
                    "codeListVersionID" -> "AmountCurrencyCodeListVersionIdentifier"
                    else -> attributeName
                }
            }

            elementName.endsWith("BinaryObject") ||
                    elementName.endsWith("Graphic") ||
                    elementName.endsWith("Picture") ||
                    elementName.endsWith("Sound") ||
                    elementName.endsWith("Video") -> {
                when (attributeName) {
                    UBLToJsonFormatConverter.CONTENT -> "BinaryObjectContent"
                    "mimeCode" -> "BinaryObjectMimeCode"
                    "format" -> "BinaryObjectFormatText"
                    "encodingCode" -> "BinaryObjectEncodingCode"
                    "characterSetCode" -> "BinaryObjectCharacterSetCode"
                    "URI" -> "BinaryObjectUniformResourceIdentifier"
                    "filename" -> "BinaryObjectFilenameText"
                    else -> attributeName
                }
            }

            elementName.endsWith("Code") -> {
                when (attributeName) {
                    UBLToJsonFormatConverter.CONTENT -> "CodeContent"
                    "listID" -> "CodeListIdentifier"
                    "listAgencyID" -> "CodeListAgencyIdentifier"
                    "listAgencyName" -> "CodeListAgencyNameText"
                    "listName" -> "CodeListNameText"
                    "listVersionID" -> "CodeListVersionIdentifier"
                    "name" -> "CodeNameText"
                    "languageID" -> "LanguageIdentifier"
                    "listURI" -> "CodeListUniformResourceIdentifier"
                    "listSchemeURI" -> "CodeListSchemeUniformResourceIdentifier"
                    else -> attributeName
                }
            }

            elementName.endsWith("DateTime") -> {
                when (attributeName) {
                    UBLToJsonFormatConverter.CONTENT -> "DateTimeContent"
                    else -> attributeName
                }
            }

            elementName.endsWith("Date") -> {
                when (attributeName) {
                    UBLToJsonFormatConverter.CONTENT -> "DateContent"
                    else -> attributeName
                }
            }

            elementName.endsWith("Time") -> {
                when (attributeName) {
                    UBLToJsonFormatConverter.CONTENT -> "TimeContent"
                    else -> attributeName
                }
            }

            elementName.endsWith("ID") ||
                    elementName.endsWith("URI") ||
                    elementName.endsWith("Identification")-> {
                when (attributeName) {
                    UBLToJsonFormatConverter.CONTENT -> "IdentifierContent"
                    "schemeID" -> "IdentificationSchemeIdentifier"
                    "schemeName" -> "IdentificationSchemeNameText"
                    "schemeAgencyID" -> "IdentificationSchemeAgencyIdentifier"
                    "schemeAgencyName" -> "IdentificationSchemeAgencyNameText"
                    "schemeVersionID" -> "IdentificationSchemeVersionIdentifier"
                    "schemeDataURI" -> "IdentificationSchemeDataUniformResourceIdentifier"
                    "schemeURI" -> "IdentificationSchemeUniformResourceIdentifier"
                    else -> attributeName
                }
            }

            elementName.endsWith("Indicator") -> {
                when (attributeName) {
                    UBLToJsonFormatConverter.CONTENT -> "IndicatorContent"
                    else -> attributeName
                }
            }

            elementName.endsWith("Measure") -> {
                when (attributeName) {
                    UBLToJsonFormatConverter.CONTENT -> "MeasureContent"
                    "unitCode" -> "MeasureUnitCode"
                    "unitCodeListVersionID" -> "MeasureUnitCodeListVersionIdentifier"
                    else -> attributeName
                }
            }

            elementName.endsWith("Text") ||
                    elementName.endsWith("Name") ||
                    elementName.endsWith("Type") ||
                    elementName.endsWith("Reason") ||
                    elementName.endsWith("Description") ||
                    TEXT_CONTENT_IDENTIFIED_BY_NAME.contains(elementName) -> {
                when (attributeName) {
                    UBLToJsonFormatConverter.CONTENT -> "TextContent"
                    "languageID" -> "LanguageIdentifier"
                    "languageLocaleID" -> "LanguageLocaleIdentifier"
                    else -> attributeName
                }
            }

            elementName.endsWith("Numeric") ||
                    elementName.endsWith("Value") ||
                    elementName.endsWith("Rate") ||
                    elementName.endsWith("Percent") -> {
                when (attributeName) {
                    UBLToJsonFormatConverter.CONTENT -> "NumericContent"
                    "format" -> "NumericFormatText"
                    else -> attributeName
                }
            }

            elementName.endsWith("Quantity") -> {
                when (attributeName) {
                    UBLToJsonFormatConverter.CONTENT -> "QuantityContent"
                    "unitCode" -> "QuantityUnitCode"
                    "unitCodeListID" -> "QuantityUnitCodeListIdentifier"
                    "unitCodeListAgencyID" -> "QuantityUnitCodeListAgencyIdentifier"
                    "unitCodeListAgencyName" -> "QuantityUnitCodeListAgencyNameText"
                    else -> attributeName
                }
            }

            else -> {
                when (attributeName) {
                    UBLToJsonFormatConverter.CONTENT -> "Content"
                    else -> attributeName
                }
            }
        }
    }

    override fun mapNamespaceNameToPrefix(namespace: DeclaredXMLNamespaces): String? {
        return when (namespace) {
            DeclaredXMLNamespaces.CommonAggregateComponents -> NamespacePrefixes.CommonAggregateComponents.value
            DeclaredXMLNamespaces.CommonBasicComponents -> NamespacePrefixes.CommonBasicComponents.value
            DeclaredXMLNamespaces.CommonExtensionComponents -> NamespacePrefixes.CommonExtensionComponents.value
            DeclaredXMLNamespaces.CommonSignatureComponents -> NamespacePrefixes.CommonSignatureComponents.value
            DeclaredXMLNamespaces.QualifiedDataTypes -> NamespacePrefixes.QualifiedDataTypes.value
            DeclaredXMLNamespaces.SignatureAggregateComponents -> NamespacePrefixes.SignatureAggregateComponents.value
            DeclaredXMLNamespaces.SignatureBasicComponents -> NamespacePrefixes.SignatureBasicComponents.value
            DeclaredXMLNamespaces.UnqualifiedDataTypes -> NamespacePrefixes.UnqualifiedDataTypes.value
            else -> NamespacePrefixes.Document.value
        }
    }
}