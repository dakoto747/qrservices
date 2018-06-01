package payments.qr.libs.request.mvisa.nestedmodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PurchaseIdentifier {

    @JsonProperty("referenceNumber")
    private String referenceNumber;

    @JsonProperty("type")
    private String type;

    public PurchaseIdentifier(String referenceNumber, String type){

        this.referenceNumber = referenceNumber;
        this.type = type;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString(){

        return "{" +
                "\nreferenceNumber: " +referenceNumber+", \n"+
                "\ntype: " +type+"\n"+
                "}";
    }
}
