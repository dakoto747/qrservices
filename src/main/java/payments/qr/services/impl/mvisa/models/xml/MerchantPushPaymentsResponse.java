package payments.qr.services.impl.mvisa.models.xml;

import payments.qr.services.impl.mvisa.models.xml.nested.CardAcceptor;
import payments.qr.services.impl.mvisa.models.xml.nested.PurchaseIdentifier;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="OctV2V2Response", namespace="http://www.visa.com/vpp/api/oct")
@XmlAccessorType(XmlAccessType.FIELD)
public class MerchantPushPaymentsResponse {
/*
{
"transactionIdentifier": 106502203735019,
"actionCode": "00",
"approvalCode": "21324K",
"responseCode": "5",
"transmissionDateTime": "2018-05-11T11:29:27.000Z",
"retrievalReferenceNumber": "412770451035",
"purchaseIdentifier": {
"type": "1",
"referenceNumber": "REF_123456789123456789123"
},
"feeProgramIndicator": "123",
"merchantCategoryCode": 5812,
"cardAcceptor": {
"name": "mVisa Merchant",
"terminalId": "MER-ID00",
"idCode": "MvisaMerchant-1",
"address": {
"city": "mVisa City",
"country": "IN"
}
},
"merchantVerificationValue": "0A45AF98FC"
}
 */

    @XmlElement
    private long transactionIdentifier;

    @XmlElement
    private String actionCode;

    @XmlElement
    private String approvalCode;

    @XmlElement
    private String responseCode;

    @XmlElement
    private String transmissionDateTime;

    @XmlElement
    private String retrievalReferenceNumber;

    @XmlElement
    private PurchaseIdentifier purchaseIdentifier;

    @XmlElement
    private String feeProgramIndicator;

    @XmlElement// 5812,
    private int merchantCategoryCode;

    @XmlElement
    private CardAcceptor cardAcceptor;

    @XmlElement
    private String merchantVerificationValue;


    public long getTransactionIdentifier() {
        return transactionIdentifier;
    }

    public void setTransactionIdentifier(long transactionIdentifier) {
        this.transactionIdentifier = transactionIdentifier;
    }

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

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getTransmissionDateTime() {
        return transmissionDateTime;
    }

    public void setTransmissionDateTime(String transmissionDateTime) {
        this.transmissionDateTime = transmissionDateTime;
    }

    public String getRetrievalReferenceNumber() {
        return retrievalReferenceNumber;
    }

    public void setRetrievalReferenceNumber(String retrievalReferenceNumber) {
        this.retrievalReferenceNumber = retrievalReferenceNumber;
    }

    public PurchaseIdentifier getPurchaseIdentifier() {
        return purchaseIdentifier;
    }

    public void setPurchaseIdentifier(PurchaseIdentifier purchaseIdentifier) {
        this.purchaseIdentifier = purchaseIdentifier;
    }

    public String getFeeProgramIndicator() {
        return feeProgramIndicator;
    }

    public void setFeeProgramIndicator(String feeProgramIndicator) {
        this.feeProgramIndicator = feeProgramIndicator;
    }

    public int getMerchantCategoryCode() {
        return merchantCategoryCode;
    }

    public void setMerchantCategoryCode(int merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
    }

    public CardAcceptor getCardAcceptor() {
        return cardAcceptor;
    }

    public void setCardAcceptor(CardAcceptor cardAcceptor) {
        this.cardAcceptor = cardAcceptor;
    }

    public String getMerchantVerificationValue() {
        return merchantVerificationValue;
    }

    public void setMerchantVerificationValue(String merchantVerificationValue) {
        this.merchantVerificationValue = merchantVerificationValue;
    }

    @Override
    public String toString(){

        return "{\n" +
                "\"transactionIdentifier\": "+this.transactionIdentifier+",\n" +
                "\"actionCode\": "+this.actionCode+",\n" +
                "\"approvalCode\": "+this.approvalCode+",\n" +
                "\"cardAcceptor\": "+this.cardAcceptor.toString()+"\n" +
                "\"purchaseIdentifier\": " + this.purchaseIdentifier.toString() +"\n" +
                "\"responseCode\": "+this.responseCode+",\n" +
                "\"transmissionDateTime\": "+this.transmissionDateTime+",\n" +
                "\"retrievalReferenceNumber\": "+this.retrievalReferenceNumber+",\n" +
                "\"merchantVerificationValue\": "+this.merchantCategoryCode+"\n" +
                "}";
    }
}
