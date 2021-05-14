package ro.aleris.ublformatconverter

/**
 * Implements UBL JSON Alternative Representation Version 2.0
 * http://docs.oasis-open.org/ubl/UBL-2.1-JSON/v2.0/UBL-2.1-JSON-v2.0.html
 */
class UBLJsonNameMapperV2: UBLJsonNameMapper {
    companion object {
        private const val CONTENT_KEY = "_"
    }

    enum class NamespacePrefixes(val value: String?) {
        Document("_D"),
        CommonAggregateComponents("_A"),
        CommonBasicComponents("_B"),
        CommonExtensionComponents("_E"),
        CommonSignatureComponents(null),
        QualifiedDataTypes(null),
        SignatureAggregateComponents(null),
        SignatureBasicComponents(null),
        UnqualifiedDataTypes(null),
    }

    override fun mapAttributeName(elementName: String, attributeName: String, value: String): String {
        return when (attributeName) {
            UBLToJsonFormatConverter.CONTENT -> CONTENT_KEY
            else -> attributeName
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