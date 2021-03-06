package ro.aleris.ublformatconverter

enum class DeclaredXMLNamespaces(val schemaNamespace: String) {
    CommonAggregateComponents(
        "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2"
    ),
    CommonBasicComponents(
        "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2"
    ),
    CommonExtensionComponents(
        "urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2"
    ),
    CommonSignatureComponents(
        "urn:oasis:names:specification:ubl:schema:xsd:CommonSignatureComponents-2"
    ),
    QualifiedDataTypes("urn:oasis:names:specification:ubl:schema:xsd:QualifiedDataTypes-2"),
    SignatureAggregateComponents(
        "urn:oasis:names:specification:ubl:schema:xsd:SignatureAggregateComponents-2"
    ),
    SignatureBasicComponents("urn:oasis:names:specification:ubl:schema:xsd:SignatureBasicComponents-2"),
    UnqualifiedDataTypes(
        "urn:oasis:names:specification:ubl:schema:xsd:UnqualifiedDataTypes-2"
    ),
    ApplicationResponse("urn:oasis:names:specification:ubl:schema:xsd:ApplicationResponse-2"),
    AttachedDocument("urn:oasis:names:specification:ubl:schema:xsd:AttachedDocument-2"),
    AwardedNotification(
        "urn:oasis:names:specification:ubl:schema:xsd:AwardedNotification-2"
    ),
    BillOfLading("urn:oasis:names:specification:ubl:schema:xsd:BillOfLading-2"),
    BusinessCard("urn:oasis:names:specification:ubl:schema:xsd:BusinessCard-2"),
    CallForTenders(
        "urn:oasis:names:specification:ubl:schema:xsd:CallForTenders-2"
    ),
    Catalogue("urn:oasis:names:specification:ubl:schema:xsd:Catalogue-2"),
    CatalogueDeletion("urn:oasis:names:specification:ubl:schema:xsd:CatalogueDeletion-2"),
    CatalogueItemSpecificationUpdate(
        "urn:oasis:names:specification:ubl:schema:xsd:CatalogueItemSpecificationUpdate-2"
    ),
    CataloguePricingUpdate("urn:oasis:names:specification:ubl:schema:xsd:CataloguePricingUpdate-2"),
    CatalogueRequest("urn:oasis:names:specification:ubl:schema:xsd:CatalogueRequest-2"),
    CertificateOfOrigin(
        "urn:oasis:names:specification:ubl:schema:xsd:CertificateOfOrigin-2"
    ),
    CommonTransportationReport(
        "urn:oasis:names:specification:ubl:schema:xsd:CommonTransportationReport-2"
    ),
    ContractAwardNotice(
        "urn:oasis:names:specification:ubl:schema:xsd:ContractAwardNotice-2"
    ),
    ContractNotice("urn:oasis:names:specification:ubl:schema:xsd:ContractNotice-2"),
    CreditNote("urn:oasis:names:specification:ubl:schema:xsd:CreditNote-2"),
    DebitNote(
        "urn:oasis:names:specification:ubl:schema:xsd:DebitNote-2"
    ),
    DespatchAdvice("urn:oasis:names:specification:ubl:schema:xsd:DespatchAdvice-2"),
    DigitalAgreement("urn:oasis:names:specification:ubl:schema:xsd:DigitalAgreement-2"),
    DigitalCapability(
        "urn:oasis:names:specification:ubl:schema:xsd:DigitalCapability-2"
    ),
    DocumentStatus("urn:oasis:names:specification:ubl:schema:xsd:DocumentStatus-2"),
    DocumentStatusRequest("urn:oasis:names:specification:ubl:schema:xsd:DocumentStatusRequest-2"),
    Enquiry(
        "urn:oasis:names:specification:ubl:schema:xsd:Enquiry-2"
    ),
    EnquiryResponse("urn:oasis:names:specification:ubl:schema:xsd:EnquiryResponse-2"),
    ExceptionCriteria("urn:oasis:names:specification:ubl:schema:xsd:ExceptionCriteria-2"),
    ExceptionNotification(
        "urn:oasis:names:specification:ubl:schema:xsd:ExceptionNotification-2"
    ),
    ExportCustomsDeclaration("urn:oasis:names:specification:ubl:schema:xsd:ExportCustomsDeclaration-2"),
    ExpressionOfInterestRequest(
        "urn:oasis:names:specification:ubl:schema:xsd:ExpressionOfInterestRequest-2"
    ),
    ExpressionOfInterestResponse(
        "urn:oasis:names:specification:ubl:schema:xsd:ExpressionOfInterestResponse-2"
    ),
    Forecast(
        "urn:oasis:names:specification:ubl:schema:xsd:Forecast-2"
    ),
    ForecastRevision("urn:oasis:names:specification:ubl:schema:xsd:ForecastRevision-2"),
    ForwardingInstructions("urn:oasis:names:specification:ubl:schema:xsd:ForwardingInstructions-2"),
    FreightInvoice(
        "urn:oasis:names:specification:ubl:schema:xsd:FreightInvoice-2"
    ),
    FulfilmentCancellation("urn:oasis:names:specification:ubl:schema:xsd:FulfilmentCancellation-2"),
    GoodsCertificate("urn:oasis:names:specification:ubl:schema:xsd:GoodsCertificate-2"),
    GoodsItemItinerary(
        "urn:oasis:names:specification:ubl:schema:xsd:GoodsItemItinerary-2"
    ),
    GoodsItemPassport("urn:oasis:names:specification:ubl:schema:xsd:GoodsItemPassport-2"),
    GuaranteeCertificate("urn:oasis:names:specification:ubl:schema:xsd:GuaranteeCertificate-2"),
    ImportCustomsDeclaration(
        "urn:oasis:names:specification:ubl:schema:xsd:ImportCustomsDeclaration-2"
    ),
    InstructionForReturns("urn:oasis:names:specification:ubl:schema:xsd:InstructionForReturns-2"),
    InventoryReport("urn:oasis:names:specification:ubl:schema:xsd:InventoryReport-2"),
    Invoice(
        "urn:oasis:names:specification:ubl:schema:xsd:Invoice-2"
    ),
    ItemInformationRequest("urn:oasis:names:specification:ubl:schema:xsd:ItemInformationRequest-2"),
    Manifest("urn:oasis:names:specification:ubl:schema:xsd:Manifest-2"),
    Order(
        "urn:oasis:names:specification:ubl:schema:xsd:Order-2"
    ),
    OrderCancellation("urn:oasis:names:specification:ubl:schema:xsd:OrderCancellation-2"),
    OrderChange("urn:oasis:names:specification:ubl:schema:xsd:OrderChange-2"),
    OrderResponse(
        "urn:oasis:names:specification:ubl:schema:xsd:OrderResponse-2"
    ),
    OrderResponseSimple("urn:oasis:names:specification:ubl:schema:xsd:OrderResponseSimple-2"),
    PackingList("urn:oasis:names:specification:ubl:schema:xsd:PackingList-2"),
    PriorInformationNotice(
        "urn:oasis:names:specification:ubl:schema:xsd:PriorInformationNotice-2"
    ),
    ProductActivity("urn:oasis:names:specification:ubl:schema:xsd:ProductActivity-2"),
    ProofOfReexportation("urn:oasis:names:specification:ubl:schema:xsd:ProofOfReexportation-2"),
    ProofOfReexportationReminder(
        "urn:oasis:names:specification:ubl:schema:xsd:ProofOfReexportationReminder-2"
    ),
    ProofOfReexportationRequest(
        "urn:oasis:names:specification:ubl:schema:xsd:ProofOfReexportationRequest-2"
    ),
    QualificationApplicationRequest(
        "urn:oasis:names:specification:ubl:schema:xsd:QualificationApplicationRequest-2"
    ),
    QualificationApplicationResponse(
        "urn:oasis:names:specification:ubl:schema:xsd:QualificationApplicationResponse-2"
    ),
    Quotation(
        "urn:oasis:names:specification:ubl:schema:xsd:Quotation-2"
    ),
    ReceiptAdvice("urn:oasis:names:specification:ubl:schema:xsd:ReceiptAdvice-2"),
    Reminder("urn:oasis:names:specification:ubl:schema:xsd:Reminder-2"),
    RemittanceAdvice(
        "urn:oasis:names:specification:ubl:schema:xsd:RemittanceAdvice-2"
    ),
    RequestForQuotation("urn:oasis:names:specification:ubl:schema:xsd:RequestForQuotation-2"),
    RetailEvent("urn:oasis:names:specification:ubl:schema:xsd:RetailEvent-2"),
    SelfBilledCreditNote(
        "urn:oasis:names:specification:ubl:schema:xsd:SelfBilledCreditNote-2"
    ),
    SelfBilledInvoice("urn:oasis:names:specification:ubl:schema:xsd:SelfBilledInvoice-2"),
    Statement("urn:oasis:names:specification:ubl:schema:xsd:Statement-2"),
    StockAvailabilityReport(
        "urn:oasis:names:specification:ubl:schema:xsd:StockAvailabilityReport-2"
    ),
    Tender("urn:oasis:names:specification:ubl:schema:xsd:Tender-2"),
    TenderContract("urn:oasis:names:specification:ubl:schema:xsd:TenderContract-2"),
    TenderReceipt(
        "urn:oasis:names:specification:ubl:schema:xsd:TenderReceipt-2"
    ),
    TenderStatus("urn:oasis:names:specification:ubl:schema:xsd:TenderStatus-2"),
    TenderStatusRequest("urn:oasis:names:specification:ubl:schema:xsd:TenderStatusRequest-2"),
    TenderWithdrawal(
        "urn:oasis:names:specification:ubl:schema:xsd:TenderWithdrawal-2"
    ),
    TendererQualification("urn:oasis:names:specification:ubl:schema:xsd:TendererQualification-2"),
    TendererQualificationResponse(
        "urn:oasis:names:specification:ubl:schema:xsd:TendererQualificationResponse-2"
    ),
    TradeItemLocationProfile("urn:oasis:names:specification:ubl:schema:xsd:TradeItemLocationProfile-2"),
    TransitCustomsDeclaration(
        "urn:oasis:names:specification:ubl:schema:xsd:TransitCustomsDeclaration-2"
    ),
    TransportExecutionPlan("urn:oasis:names:specification:ubl:schema:xsd:TransportExecutionPlan-2"),
    TransportExecutionPlanRequest(
        "urn:oasis:names:specification:ubl:schema:xsd:TransportExecutionPlanRequest-2"
    ),
    TransportProgressStatus("urn:oasis:names:specification:ubl:schema:xsd:TransportProgressStatus-2"),
    TransportProgressStatusRequest(
        "urn:oasis:names:specification:ubl:schema:xsd:TransportProgressStatusRequest-2"
    ),
    TransportServiceDescription(
        "urn:oasis:names:specification:ubl:schema:xsd:TransportServiceDescription-2"
    ),
    TransportServiceDescriptionRequest(
        "urn:oasis:names:specification:ubl:schema:xsd:TransportServiceDescriptionRequest-2"
    ),
    TransportationStatus("urn:oasis:names:specification:ubl:schema:xsd:TransportationStatus-2"),
    TransportationStatusRequest(
        "urn:oasis:names:specification:ubl:schema:xsd:TransportationStatusRequest-2"
    ),
    UnawardedNotification("urn:oasis:names:specification:ubl:schema:xsd:UnawardedNotification-2"),
    UnsubscribeFromProcedureRequest(
        "urn:oasis:names:specification:ubl:schema:xsd:UnsubscribeFromProcedureRequest-2"
    ),
    UnsubscribeFromProcedureResponse(
        "urn:oasis:names:specification:ubl:schema:xsd:UnsubscribeFromProcedureResponse-2"
    ),
    UtilityStatement(
        "urn:oasis:names:specification:ubl:schema:xsd:UtilityStatement-2"
    ),
    Waybill("urn:oasis:names:specification:ubl:schema:xsd:Waybill-2"),
    WeightStatement("urn:oasis:names:specification:ubl:schema:xsd:WeightStatement-2");

    companion object {
        private val map = values().associateBy { it.schemaNamespace }
        fun valueOfOrNull(value: String): DeclaredXMLNamespaces? {
            return map[value]
        }
    }
}
