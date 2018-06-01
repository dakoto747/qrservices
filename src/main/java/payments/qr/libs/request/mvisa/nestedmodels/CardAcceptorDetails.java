package payments.qr.libs.request.mvisa.nestedmodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardAcceptorDetails {

    @JsonProperty("address")
    private Address address;

    @JsonProperty("idCode")
    private String idCode;

    @JsonProperty("name")
    private String name;

    public CardAcceptorDetails(Address address, String idCode, String name) {

        this.address = address;
        this.idCode = idCode;
        this.name = name;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
