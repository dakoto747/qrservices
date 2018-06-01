package payments.qr.services.impl.mvisa.models.xml.nested;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CardAcceptor")
@XmlAccessorType(XmlAccessType.FIELD)
public class CardAcceptor {

    @XmlElement
    private String name;

    @XmlElement
    private String terminalId;

    @XmlElement
    private String idCode;

    @XmlElement
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString(){

        return "{" +
                "\naddress: " +address.toString()+", \n"+
                "\nidCode: " +idCode+", \n"+
                "\nname: " +name+"\n"+
                "}";
    }
}
