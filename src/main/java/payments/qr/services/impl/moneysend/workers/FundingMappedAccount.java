package payments.qr.services.impl.moneysend.workers;

/**
 *
 * Script-Name: FundingMappedAccount
 */

import com.mastercard.api.core.ApiConfig;
import com.mastercard.api.core.exception.*;
import com.mastercard.api.core.model.*;
import com.mastercard.api.core.security.oauth.OAuthAuthentication;
import com.mastercard.api.moneysend.*;
import org.springframework.beans.factory.annotation.Value;

import java.io.FileInputStream;
import java.io.InputStream;

public class FundingMappedAccount {

    @Value("${moneysend.api.authentication.consumer.key}")
    private String consumerKey;   // You should copy this from "My Keys" on your project page e.g. UTfbhDCSeNYvJpLL5l028sWL9it739PYh6LU5lZja15xcRpY!fd209e6c579dc9d7be52da93d35ae6b6c167c174690b72fa

    @Value("${moneysend.api.authentication.key.alias}")
    private String keyAlias;   // For production: change this to the key alias you chose when you created your production key

    @Value("${moneysend.api.authentication.key.password}")
    private String keyPassword;   // For production: change this to the key alias you chose when you created your production key

    @Value("${moneysend.api.authentication.p12.file.path}")
    private String p12FilePath;

    public void main( ) throws Exception {

        InputStream is = new FileInputStream(p12FilePath); // e.g. /Users/yourname/project/sandbox.p12 | C:\Users\yourname\project\sandbox.p12
        ApiConfig.setAuthentication(new OAuthAuthentication(consumerKey, is, keyAlias, keyPassword));   // You only need to set this once
        ApiConfig.setDebug(true);   // Enable http wire logging
        ApiConfig.setSandbox(true); // For production: use ApiConfig.setSandbox(false);
        //ApiConfig.setEnvironment(Environment.SANDBOX);

        try {
            RequestMap map = new RequestMap();
            map.set("FundingRequestV3.LocalDate", "0612");
            map.set("FundingRequestV3.LocalTime", "161222");
            map.set("FundingRequestV3.TransactionReference", "1121774875227082093");
            map.set("FundingRequestV3.FundingMapped.SubscriberId", "CMV2944028228@mc.com");
            map.set("FundingRequestV3.FundingMapped.SubscriberType", "EMAIL_ADDRESS");
            map.set("FundingRequestV3.FundingMapped.SubscriberAlias", "Email Address Test");
            map.set("FundingRequestV3.FundingUCAF", "MjBjaGFyYWN0ZXJqdW5rVUNBRjU=1111");
            map.set("FundingRequestV3.FundingMasterCardAssignedId", "123456");
            map.set("FundingRequestV3.FundingAmount.Value", "151");
            map.set("FundingRequestV3.FundingAmount.Currency", "840");
            map.set("FundingRequestV3.ReceiverName.First", "Lopez");
            map.set("FundingRequestV3.ReceiverName.Middle", "R");
            map.set("FundingRequestV3.ReceiverName.Last", "Jose");
            map.set("FundingRequestV3.ReceiverAddress.Line1", "Pueblo Street");
            map.set("FundingRequestV3.ReceiverAddress.City", "El PASO");
            map.set("FundingRequestV3.ReceiverAddress.CountrySubdivision", "TX");
            map.set("FundingRequestV3.ReceiverAddress.PostalCode", "79906");
            map.set("FundingRequestV3.ReceiverAddress.Country", "USA");
            map.set("FundingRequestV3.ReceiverPhone", "1800639426");
            map.set("FundingRequestV3.ReceivingAccountNumber", "5184680420000073");
            map.set("FundingRequestV3.ReceiverDateOfBirth", "06061980");
            map.set("FundingRequestV3.SenderName.First", "Lopez");
            map.set("FundingRequestV3.SenderName.Middle", "R");
            map.set("FundingRequestV3.SenderName.Last", "Jose");
            map.set("FundingRequestV3.SenderDateOfBirth", "06061980");
            map.set("FundingRequestV3.SenderPhoneNumber", "1800639426");
            map.set("FundingRequestV3.SenderAddress.Line1", "123 Main Street");
            map.set("FundingRequestV3.SenderAddress.Line2", "5A");
            map.set("FundingRequestV3.SenderAddress.City", "Arlington");
            map.set("FundingRequestV3.SenderAddress.CountrySubdivision", "VA");
            map.set("FundingRequestV3.SenderAddress.PostalCode", "22207");
            map.set("FundingRequestV3.SenderAddress.Country", "USA");
            map.set("FundingRequestV3.Channel", "W");
            map.set("FundingRequestV3.UCAFSupport", "true");
            map.set("FundingRequestV3.ICA", "009674");
            map.set("FundingRequestV3.ProcessorId", "9000000442");
            map.set("FundingRequestV3.RoutingAndTransitNumber", "990442082");
            map.set("FundingRequestV3.CardAcceptor.Name", "My Local Bank");
            map.set("FundingRequestV3.CardAcceptor.City", "Saint Louis");
            map.set("FundingRequestV3.CardAcceptor.State", "MO");
            map.set("FundingRequestV3.CardAcceptor.PostalCode", "63101");
            map.set("FundingRequestV3.CardAcceptor.Country", "USA");
            map.set("FundingRequestV3.TransactionDesc", "P2P");
            map.set("FundingRequestV3.MerchantId", "123456");
            map.set("FundingRequestV3.LanguageData", "Test");
            map.set("FundingRequestV3.LanguageIdentification", "ENG");
            map.set("FundingRequestV3.ParticipationID", "154789564");
            map.set("FundingRequestV3.AdditionalMessage", "Personal message here");
            Funding response = Funding.create(map);

            System.out.println("Transfer.RequestId-->"+response.get("Transfer.RequestId")); // Transfer.RequestId-->1199008
            System.out.println("Transfer.TransactionReference-->"+response.get("Transfer.TransactionReference")); // Transfer.TransactionReference-->1121774875227082093
            System.out.println("Transfer.TransactionHistory.Transaction[0].Type-->"+response.get("Transfer.TransactionHistory.Transaction[0].Type")); // Transfer.TransactionHistory.Transaction[0].Type-->FUNDING
            System.out.println("Transfer.TransactionHistory.Transaction[0].SystemTraceAuditNumber-->"+response.get("Transfer.TransactionHistory.Transaction[0].SystemTraceAuditNumber")); // Transfer.TransactionHistory.Transaction[0].SystemTraceAuditNumber-->007512
            System.out.println("Transfer.TransactionHistory.Transaction[0].NetworkReferenceNumber-->"+response.get("Transfer.TransactionHistory.Transaction[0].NetworkReferenceNumber")); // Transfer.TransactionHistory.Transaction[0].NetworkReferenceNumber-->313286843
            System.out.println("Transfer.TransactionHistory.Transaction[0].SettlementDate-->"+response.get("Transfer.TransactionHistory.Transaction[0].SettlementDate")); // Transfer.TransactionHistory.Transaction[0].SettlementDate-->0105
            System.out.println("Transfer.TransactionHistory.Transaction[0].Response.Code-->"+response.get("Transfer.TransactionHistory.Transaction[0].Response.Code")); // Transfer.TransactionHistory.Transaction[0].Response.Code-->00
            System.out.println("Transfer.TransactionHistory.Transaction[0].Response.Description-->"+response.get("Transfer.TransactionHistory.Transaction[0].Response.Description")); // Transfer.TransactionHistory.Transaction[0].Response.Description-->Approved or completed successfully
            System.out.println("Transfer.TransactionHistory.Transaction[0].SubmitDateTime-->"+response.get("Transfer.TransactionHistory.Transaction[0].SubmitDateTime")); // Transfer.TransactionHistory.Transaction[0].SubmitDateTime-->2016-01-04T18:12:40Z

        } catch (ApiException e) {
            System.err.println("HttpStatus: "+e.getHttpStatus());
            System.err.println("Message: "+e.getMessage());
            System.err.println("ReasonCode: "+e.getReasonCode());
            System.err.println("Source: "+e.getSource());
        }
    }
}