package payments.qr.libs.response.moneysend;

public class MoneysendResponseDetails {

    private String transferRequestId;

    private String transferTransactionReference;

    private String transferTrasactionHistoryType;

    private String transferTrasactionHistorySystemTraceAuditNumber;

    private String transferTrasactionHistoryNetworkReferenceNumber;

    private String transferTrasactionHistorySettlementDate;

    private String transferTrasactionHistoryResponseCode;

    private String transferTrasactionHistoryResponseDescription;

    private String transferTrasactionHistorySubmitDateTime;

    private boolean completedSuccessfully;

    private String httpStatus;

    private String errorMessage;

    private String reasonCode;

    private String source;


    public String getTransferRequestId() {
        return transferRequestId;
    }

    public void setTransferRequestId(String transferRequestId) {
        this.transferRequestId = transferRequestId;
    }

    public String getTransferTransactionReference() {
        return transferTransactionReference;
    }

    public void setTransferTransactionReference(String transferTransactionReference) {
        this.transferTransactionReference = transferTransactionReference;
    }

    public String getTransferTrasactionHistoryType() {
        return transferTrasactionHistoryType;
    }

    public void setTransferTrasactionHistoryType(String transferTrasactionHistoryType) {
        this.transferTrasactionHistoryType = transferTrasactionHistoryType;
    }

    public String getTransferTrasactionHistorySystemTraceAuditNumber() {
        return transferTrasactionHistorySystemTraceAuditNumber;
    }

    public void setTransferTrasactionHistorySystemTraceAuditNumber(String transferTrasactionHistorySystemTraceAuditNumber) {
        this.transferTrasactionHistorySystemTraceAuditNumber = transferTrasactionHistorySystemTraceAuditNumber;
    }

    public String getTransferTrasactionHistoryNetworkReferenceNumber() {
        return transferTrasactionHistoryNetworkReferenceNumber;
    }

    public void setTransferTrasactionHistoryNetworkReferenceNumber(String transferTrasactionHistoryNetworkReferenceNumber) {
        this.transferTrasactionHistoryNetworkReferenceNumber = transferTrasactionHistoryNetworkReferenceNumber;
    }

    public String getTransferTrasactionHistorySettlementDate() {
        return transferTrasactionHistorySettlementDate;
    }

    public void setTransferTrasactionHistorySettlementDate(String transferTrasactionHistorySettlementDate) {
        this.transferTrasactionHistorySettlementDate = transferTrasactionHistorySettlementDate;
    }

    public String getTransferTrasactionHistoryResponseCode() {
        return transferTrasactionHistoryResponseCode;
    }

    public void setTransferTrasactionHistoryResponseCode(String transferTrasactionHistoryResponseCode) {
        this.transferTrasactionHistoryResponseCode = transferTrasactionHistoryResponseCode;
    }

    public String getTransferTrasactionHistoryResponseDescription() {
        return transferTrasactionHistoryResponseDescription;
    }

    public void setTransferTrasactionHistoryResponseDescription(String transferTrasactionHistoryResponseDescription) {
        this.transferTrasactionHistoryResponseDescription = transferTrasactionHistoryResponseDescription;
    }

    public String getTransferTrasactionHistorySubmitDateTime() {
        return transferTrasactionHistorySubmitDateTime;
    }

    public void setTransferTrasactionHistorySubmitDateTime(String transferTrasactionHistorySubmitDateTime) {
        this.transferTrasactionHistorySubmitDateTime = transferTrasactionHistorySubmitDateTime;
    }

    public boolean isCompletedSuccessfully() {
        return completedSuccessfully;
    }

    public void setCompletedSuccessfully(boolean completedSuccessfully) {
        this.completedSuccessfully = completedSuccessfully;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
