package payments.qr.services.impl.moneysend.workers;

/**
 *
 * Script-Name: PaymentSpecifiedMappedAccount
 */

import com.mastercard.api.core.ApiConfig;
import com.mastercard.api.core.exception.*;
import com.mastercard.api.core.model.*;
import com.mastercard.api.core.security.oauth.OAuthAuthentication;
import com.mastercard.api.moneysend.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;

@Component
public class PaymentSpecifiedMappedAccount {

    @Value("${moneysend.api.authentication.consumer.key}")
    private String consumerKey;   // You should copy this from "My Keys" on your project page e.g. UTfbhDCSeNYvJpLL5l028sWL9it739PYh6LU5lZja15xcRpY!fd209e6c579dc9d7be52da93d35ae6b6c167c174690b72fa

    @Value("${moneysend.api.authentication.key.alias}")
    private String keyAlias;   // For production: change this to the key alias you chose when you created your production key

    @Value("${moneysend.api.authentication.key.password}")
    private String keyPassword;   // For production: change this to the key alias you chose when you created your production key

    @Value("${moneysend.api.authentication.p12.file.path}")
    private String p12FilePath;

    public void main() throws Exception {

        InputStream is = new FileInputStream(p12FilePath); // e.g. /Users/yourname/project/sandbox.p12 | C:\Users\yourname\project\sandbox.p12
        ApiConfig.setAuthentication(new OAuthAuthentication(consumerKey, is, keyAlias, keyPassword));   // You only need to set this once
        ApiConfig.setDebug(true);   // Enable http wire logging
        ApiConfig.setSandbox(true); // For production: use ApiConfig.setSandbox(false);
        //ApiConfig.setEnvironment(Environment.SANDBOX);

        try {
            RequestMap map = new RequestMap();
            map.set("PaymentRequestV3.LocalDate", "0726");
            map.set("PaymentRequestV3.LocalTime", "125334");
            map.set("PaymentRequestV3.TransactionReference", "1101774875227082093");
            map.set("PaymentRequestV3.SenderName.First", "John");
            map.set("PaymentRequestV3.SenderName.Middle", "T");
            map.set("PaymentRequestV3.SenderName.Last", "Doe");
            map.set("PaymentRequestV3.SenderPhone", "7031234567");
            map.set("PaymentRequestV3.SenderDateOfBirth", "08061977");
            map.set("PaymentRequestV3.SenderAddress.Line1", "123 Main Street");
            map.set("PaymentRequestV3.SenderAddress.City", "Arlington");
            map.set("PaymentRequestV3.SenderAddress.CountrySubdivision", "VA");
            map.set("PaymentRequestV3.SenderAddress.PostalCode", "22207");
            map.set("PaymentRequestV3.SenderAddress.Country", "USA");
            map.set("PaymentRequestV3.FundingMapped.SubscriberId", "CMV2944028228@mc.com");
            map.set("PaymentRequestV3.FundingMapped.SubscriberType", "EMAIL_ADDRESS");
            map.set("PaymentRequestV3.FundingMapped.SubscriberAlias", "Email Address Test");
            map.set("PaymentRequestV3.FundingSource", "03");
            map.set("PaymentRequestV3.AdditionalMessage", "Personal Message here");
            map.set("PaymentRequestV3.ParticipationID", "12345678");
            map.set("PaymentRequestV3.LanguageIdentification", "ENG");
            map.set("PaymentRequestV3.LanguageData", "Test");
            map.set("PaymentRequestV3.ReceiverName.First", "John");
            map.set("PaymentRequestV3.ReceiverName.Middle", "B");
            map.set("PaymentRequestV3.ReceiverName.Last", "Sammy");
            map.set("PaymentRequestV3.ReceiverAddress.Line1", "Pueblo Street");
            map.set("PaymentRequestV3.ReceiverAddress.City", "El PASO");
            map.set("PaymentRequestV3.ReceiverAddress.CountrySubdivision", "TX");
            map.set("PaymentRequestV3.ReceiverAddress.PostalCode", "79906");
            map.set("PaymentRequestV3.ReceiverAddress.Country", "USA");
            map.set("PaymentRequestV3.ReceiverPhone", "1800639426");
            map.set("PaymentRequestV3.ReceiverDateOfBirth", "06211977");
            map.set("PaymentRequestV3.ReceivingMapped.SubscriberId", "CMV2944028228@mc.com");
            map.set("PaymentRequestV3.ReceivingMapped.SubscriberType", "EMAIL_ADDRESS");
            map.set("PaymentRequestV3.ReceivingMapped.SubscriberAlias", "Email Address Test");
            map.set("PaymentRequestV3.ReceivingAmount.Value", "735");
            map.set("PaymentRequestV3.ReceivingAmount.Currency", "840");
            map.set("PaymentRequestV3.Channel", "W");
            map.set("PaymentRequestV3.ICA", "009674");
            map.set("PaymentRequestV3.ProcessorId", "9000000442");
            map.set("PaymentRequestV3.RoutingAndTransitNumber", "990442082");
            map.set("PaymentRequestV3.CardAcceptor.Name", "My Local Bank");
            map.set("PaymentRequestV3.CardAcceptor.City", "Saint Louis");
            map.set("PaymentRequestV3.CardAcceptor.State", "MO");
            map.set("PaymentRequestV3.CardAcceptor.PostalCode", "63101");
            map.set("PaymentRequestV3.CardAcceptor.Country", "USA");
            map.set("PaymentRequestV3.TransactionDesc", "P2P");
            map.set("PaymentRequestV3.MerchantId", "123456");
            Payment response = Payment.create(map);

            System.out.println("Transfer.RequestId-->"+response.get("Transfer.RequestId")); // Transfer.RequestId-->400399
            System.out.println("Transfer.TransactionReference-->"+response.get("Transfer.TransactionReference")); // Transfer.TransactionReference-->1101774875227082093
            System.out.println("Transfer.TransactionHistory.Transaction[0].Type-->"+response.get("Transfer.TransactionHistory.Transaction[0].Type")); // Transfer.TransactionHistory.Transaction[0].Type-->PAYMENT
            System.out.println("Transfer.TransactionHistory.Transaction[0].SystemTraceAuditNumber-->"+response.get("Transfer.TransactionHistory.Transaction[0].SystemTraceAuditNumber")); // Transfer.TransactionHistory.Transaction[0].SystemTraceAuditNumber-->073162
            System.out.println("Transfer.TransactionHistory.Transaction[0].NetworkReferenceNumber-->"+response.get("Transfer.TransactionHistory.Transaction[0].NetworkReferenceNumber")); // Transfer.TransactionHistory.Transaction[0].NetworkReferenceNumber-->412371237
            System.out.println("Transfer.TransactionHistory.Transaction[0].SettlementDate-->"+response.get("Transfer.TransactionHistory.Transaction[0].SettlementDate")); // Transfer.TransactionHistory.Transaction[0].SettlementDate-->0626
            System.out.println("Transfer.TransactionHistory.Transaction[0].Response.Code-->"+response.get("Transfer.TransactionHistory.Transaction[0].Response.Code")); // Transfer.TransactionHistory.Transaction[0].Response.Code-->00
            System.out.println("Transfer.TransactionHistory.Transaction[0].Response.Description-->"+response.get("Transfer.TransactionHistory.Transaction[0].Response.Description")); // Transfer.TransactionHistory.Transaction[0].Response.Description-->Approved or completed successfully
            System.out.println("Transfer.TransactionHistory.Transaction[0].SubmitDateTime-->"+response.get("Transfer.TransactionHistory.Transaction[0].SubmitDateTime")); // Transfer.TransactionHistory.Transaction[0].SubmitDateTime-->2012-06-25T19:28:23Z

        } catch (ApiException e) {
            System.err.println("HttpStatus: "+e.getHttpStatus());
            System.err.println("Message: "+e.getMessage());
            System.err.println("ReasonCode: "+e.getReasonCode());
            System.err.println("Source: "+e.getSource());
        }
    }
}