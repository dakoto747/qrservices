package payments.qr.libs.request.mvisa.nestedmodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {

    @JsonProperty("city")
    private String city;

    @JsonProperty("country")
    private String country;

    public Address(String city, String country){

        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString(){

        return "{" +
                "\ncity: " +city+", \n"+
                "\ncountry: " +country+"\n"+
                "}";
    }
}
