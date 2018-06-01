package payments.qr.services.impl.mvisa.models.xml.nested;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PurchaseIdentifier")
@XmlAccessorType(XmlAccessType.FIELD)
public class PurchaseIdentifier {

    @XmlElement
    private String type;

    @XmlElement
    private String referenceNumber;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    @Override
    public String toString(){

        return "{" +
                "\nreferenceNumber: " +referenceNumber+", \n"+
                "\ntype: " +type+"\n"+
                "}";
    }
}
