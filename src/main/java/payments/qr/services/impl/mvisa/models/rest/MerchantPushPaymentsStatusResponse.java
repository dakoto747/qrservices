package payments.qr.services.impl.mvisa.models.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MerchantPushPaymentsStatusResponse {
/*
{
"actionCode": "00",
"approvalCode": "21324K",
"feeProgramIndicator": "123",
"responseCode": "5",
"transactionIdentifier": 23423400,
"transmissionDateTime": "2016-01-07T06:58:17.000Z"
}
 */
    @JsonProperty("actionCode")
    private String actionCode;

    @JsonProperty("approvalCode")
    private String approvalCode;

    @JsonProperty("feeProgramIndicator")
    private String feeProgramIndicator;

    @JsonProperty("responseCode")
    private String responseCode;

    @JsonProperty("transactionIdentifier")
    private long transactionIdentifier; //23423400,

    @JsonProperty("transmissionDateTime")
    private String transmissionDateTime;


    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getFeeProgramIndicator() {
        return feeProgramIndicator;
    }

    public void setFeeProgramIndicator(String feeProgramIndicator) {
        this.feeProgramIndicator = feeProgramIndicator;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public long getTransactionIdentifier() {
        return transactionIdentifier;
    }

    public void setTransactionIdentifier(long transactionIdentifier) {
        this.transactionIdentifier = transactionIdentifier;
    }

    public String getTransmissionDateTime() {
        return transmissionDateTime;
    }

    public void setTransmissionDateTime(String transmissionDateTime) {
        this.transmissionDateTime = transmissionDateTime;
    }

    @Override
    public String toString(){

        return "{\n" +
                "\"actionCode\": "+this.actionCode+",\n" +
                "\"approvalCode\": "+this.approvalCode+",\n" +
                "\"feeProgramIndicator\": "+this.feeProgramIndicator+",\n" +
                "\"responseCode\": "+this.responseCode+",\n" +
                "\"transactionIdentifier\": "+this.transactionIdentifier+",\n" +
                "\"transmissionDateTime\": "+this.transmissionDateTime+"\n" +
                "}";
    }
}
