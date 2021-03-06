package payments.qr.services.impl.mvisa.utils;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.Charset;

public class BasicAuthHeaderGenerator {

    public static String getBasicAuthHeader() {
        String userId = VisaProperties.getProperty(Property.USER_ID);
        String password = VisaProperties.getProperty(Property.PASSWORD);
        return "Basic " + base64Encode(userId + ":" + password);
    }

    private static String base64Encode(String token) {
        byte[] encodedBytes = Base64.encodeBase64(token.getBytes());
        return new String(encodedBytes, Charset.forName("UTF-8"));
    }

}
