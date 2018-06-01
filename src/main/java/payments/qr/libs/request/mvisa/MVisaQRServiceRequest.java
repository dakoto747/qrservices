package payments.qr.libs.request.mvisa;

import com.fasterxml.jackson.annotation.JsonProperty;
import payments.qr.libs.request.mvisa.nestedmodels.CardAcceptorDetails;
import payments.qr.libs.request.mvisa.nestedmodels.PurchaseIdentifier;

public class MVisaQRServiceRequest {

    @JsonProperty("acquirerCountryCode")
    private String acquirerCountryCode;

    @JsonProperty("acquiringBin")
    private String acquiringBin;

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("businessApplicationId")
    private String businessApplicationId;

    @JsonProperty("cardAcceptor")
    private CardAcceptorDetails cardAcceptor;

    @JsonProperty("feeProgramIndicator")
    private String feeProgramIndicator;

    @JsonProperty("localTransactionDateTime")
    private String localTransactionDateTime;

    @JsonProperty("purchaseIdentifier")
    private PurchaseIdentifier purchaseIdentifier;

    @JsonProperty("recipientName")
    private String recipientName;

    @JsonProperty("recipientPrimaryAccountNumber")
    private String recipientPrimaryAccountNumber;

    @JsonProperty("retrievalReferenceNumber")
    private String retrievalReferenceNumber;

    @JsonProperty("secondaryId")
    private String secondaryId;

    @JsonProperty("senderAccountNumber")
    private String senderAccountNumber;

    @JsonProperty("senderName")
    private String senderName;

    @JsonProperty("senderReference")
    private String senderReference;

    @JsonProperty("systemsTraceAuditNumber")
    private String systemsTraceAuditNumber;

    @JsonProperty("transactionCurrencyCode")
    private String transactionCurrencyCode;

    @JsonProperty("transactionIdentifier")
    private String transactionIdentifier;


    public String getAcquirerCountryCode() {
        return acquirerCountryCode;
    }

    public void setAcquirerCountryCode(String acquirerCountryCode) {
        this.acquirerCountryCode = acquirerCountryCode;
    }

    public String getAcquiringBin() {
        return acquiringBin;
    }

    public void setAcquiringBin(String acquiringBin) {
        this.acquiringBin = acquiringBin;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBusinessApplicationId() {
        return businessApplicationId;
    }

    public void setBusinessApplicationId(String businessApplicationId) {
        this.businessApplicationId = businessApplicationId;
    }

    public CardAcceptorDetails getCardAcceptor() {
        return cardAcceptor;
    }

    public void setCardAcceptor(CardAcceptorDetails cardAcceptor) {
        this.cardAcceptor = cardAcceptor;
    }


    public String getFeeProgramIndicator() {
        return feeProgramIndicator;
    }

    public void setFeeProgramIndicator(String feeProgramIndicator) {
        this.feeProgramIndicator = feeProgramIndicator;
    }

    public String getLocalTransactionDateTime() {
        return localTransactionDateTime;
    }

    public void setLocalTransactionDateTime(String localTransactionDateTime) {
        this.localTransactionDateTime = localTransactionDateTime;
    }

    public PurchaseIdentifier getPurchaseIdentifier() {
        return purchaseIdentifier;
    }

    public void setPurchaseIdentifier(PurchaseIdentifier purchaseIdentifier) {
        this.purchaseIdentifier = purchaseIdentifier;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPrimaryAccountNumber() {
        return recipientPrimaryAccountNumber;
    }

    public void setRecipientPrimaryAccountNumber(String recipientPrimaryAccountNumber) {
        this.recipientPrimaryAccountNumber = recipientPrimaryAccountNumber;
    }

    public String getRetrievalReferenceNumber() {
        return retrievalReferenceNumber;
    }

    public void setRetrievalReferenceNumber(String retrievalReferenceNumber) {
        this.retrievalReferenceNumber = retrievalReferenceNumber;
    }

    public String getSecondaryId() {
        return secondaryId;
    }

    public void setSecondaryId(String secondaryId) {
        this.secondaryId = secondaryId;
    }

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderReference() {
        return senderReference;
    }

    public void setSenderReference(String senderReference) {
        this.senderReference = senderReference;
    }

    public String getSystemsTraceAuditNumber() {
        return systemsTraceAuditNumber;
    }

    public void setSystemsTraceAuditNumber(String systemsTraceAuditNumber) {
        this.systemsTraceAuditNumber = systemsTraceAuditNumber;
    }

    public String getTransactionCurrencyCode() {
        return transactionCurrencyCode;
    }

    public void setTransactionCurrencyCode(String transactionCurrencyCode) {
        this.transactionCurrencyCode = transactionCurrencyCode;
    }

    public String getTransactionIdentifier() {
        return transactionIdentifier;
    }

    public void setTransactionIdentifier(String transactionIdentifier) {
        this.transactionIdentifier = transactionIdentifier;
    }

    @Override
    public String toString(){

        return "{\n" +
                "\"acquirerCountryCode\": "+this.acquirerCountryCode+",\n" +
                "\"acquiringBin\": "+this.acquiringBin+",\n" +
                "\"amount\": "+this.amount+",\n" +
                "\"businessApplicationId\": "+this.businessApplicationId+",\n" +
                "\"cardAcceptor\": "+cardAcceptor.toString()+"\n" +
                "\"feeProgramIndicator\": "+this.feeProgramIndicator+",\n" +
                "\"localTransactionDateTime\": "+this.localTransactionDateTime+",\n" +
                "\"purchaseIdentifier\": " + purchaseIdentifier.toString() +"\n" +
                "\"recipientName\": "+this.recipientName+",\n" +
                "\"recipientPrimaryAccountNumber\": "+this.recipientPrimaryAccountNumber+",\n" +
                "\"retrievalReferenceNumber\": "+this.retrievalReferenceNumber+",\n" +
                "\"secondaryId\": "+this.secondaryId+",\n" +
                "\"senderAccountNumber\": "+this.senderAccountNumber+",\n" +
                "\"senderName\": "+this.senderName+",\n" +
                "\"senderReference\": "+this.senderReference+",\n" +
                "\"systemsTraceAuditNumber\": "+this.senderReference+",\n" +
                "\"transactionCurrencyCode\": "+this.transactionCurrencyCode+",\n" +
                "\"transactionIdentifier\": "+this.transactionIdentifier+"\n" +
                "}";
    }
}
