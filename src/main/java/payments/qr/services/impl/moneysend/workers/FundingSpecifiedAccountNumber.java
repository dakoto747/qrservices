package payments.qr.services.impl.moneysend.workers;

/**
 *
 * Script-Name: FundingSpecifiedAccountNumber
 */

import com.mastercard.api.core.ApiConfig;
import com.mastercard.api.core.exception.ApiException;
import com.mastercard.api.core.model.RequestMap;
import com.mastercard.api.core.security.oauth.OAuthAuthentication;
import com.mastercard.api.moneysend.Funding;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;

@Component
public class FundingSpecifiedAccountNumber {

    @Value("${moneysend.api.authentication.consumer.key}")
    private String consumerKey;   // You should copy this from "My Keys" on your project page e.g. UTfbhDCSeNYvJpLL5l028sWL9it739PYh6LU5lZja15xcRpY!fd209e6c579dc9d7be52da93d35ae6b6c167c174690b72fa

    @Value("${moneysend.api.authentication.key.alias}")
    private String keyAlias;   // For production: change this to the key alias you chose when you created your production key

    @Value("${moneysend.api.authentication.key.password}")
    private String keyPassword;   // For production: change this to the key alias you chose when you created your production key

    @Value("${moneysend.api.authentication.p12.file.path}")
    private String p12FilePath;

    public void performPayment() throws Exception {

        InputStream is = new FileInputStream(p12FilePath); // e.g. /Users/yourname/project/sandbox.p12 | C:\Users\yourname\project\sandbox.p12
        ApiConfig.setAuthentication(new OAuthAuthentication(consumerKey, is, keyAlias, keyPassword));   // You only need to set this once
        ApiConfig.setDebug(true);   // Enable http wire logging
        ApiConfig.setSandbox(true); // For production: use ApiConfig.setSandbox(false);
        //ApiConfig.setEnvironment(Environment.SANDBOX);

        try {
            RequestMap map = new RequestMap();
            map.set("FundingRequestV3.LocalDate", "0817");
            map.set("FundingRequestV3.LocalTime", "145547");
            map.set("FundingRequestV3.TransactionReference", "1111774875227082093");
            map.set("FundingRequestV3.FundingCard.AccountNumber", "5184680470000023");
            map.set("FundingRequestV3.FundingCard.ExpiryMonth", "11");
            map.set("FundingRequestV3.FundingCard.ExpiryYear", "2017");
            map.set("FundingRequestV3.FundingUCAF", "5400984MTFTESTUCAFAAV9999999");
            map.set("FundingRequestV3.FundingMasterCardAssignedId", "400984");
            map.set("FundingRequestV3.FundingAmount.Value", "798");
            map.set("FundingRequestV3.FundingAmount.Currency", "840");
            map.set("FundingRequestV3.ReceiverName.First", "Jose");
            map.set("FundingRequestV3.ReceiverName.Middle", "B");
            map.set("FundingRequestV3.ReceiverName.Last", "Lopez");
            map.set("FundingRequestV3.ReceiverAddress.Line1", "Pueblo Street");
            map.set("FundingRequestV3.ReceiverAddress.Line2", "PO BOX 12");
            map.set("FundingRequestV3.ReceiverAddress.City", "El PASO");
            map.set("FundingRequestV3.ReceiverAddress.CountrySubdivision", "TX");
            map.set("FundingRequestV3.ReceiverAddress.Country", "USA");
            map.set("FundingRequestV3.ReceiverPhone", "1800639426");
            map.set("FundingRequestV3.ReceivingAccountNumber", "5184680420000073");
            map.set("FundingRequestV3.ReceiverDateOfBirth", "06211977");
            map.set("FundingRequestV3.SenderName.First", "Test");
            map.set("FundingRequestV3.SenderName.Middle", "T");
            map.set("FundingRequestV3.SenderName.Last", "Test");
            map.set("FundingRequestV3.SenderDateOfBirth", "08061977");
            map.set("FundingRequestV3.SenderAddress.Line1", "123 Main Street");
            map.set("FundingRequestV3.SenderAddress.Line2", "5A");
            map.set("FundingRequestV3.SenderAddress.City", "Arlington");
            map.set("FundingRequestV3.SenderAddress.CountrySubdivision", "VA");
            map.set("FundingRequestV3.SenderAddress.PostalCode", "22207");
            map.set("FundingRequestV3.SenderAddress.Country", "USA");
            map.set("FundingRequestV3.SenderPhoneNumber", "7031234567");
            map.set("FundingRequestV3.AdditionalMessage", "Test");
            map.set("FundingRequestV3.LanguageData", "Test");
            map.set("FundingRequestV3.LanguageIdentification", "Tes");
            map.set("FundingRequestV3.ParticipationID", "Test");
            map.set("FundingRequestV3.Channel", "W");
            map.set("FundingRequestV3.UCAFSupport", "true");
            map.set("FundingRequestV3.ICA", "009674");
            map.set("FundingRequestV3.ProcessorId", "9000000442");
            map.set("FundingRequestV3.RoutingAndTransitNumber", "990442082");
            map.set("FundingRequestV3.CardAcceptor.Name", "THE BEST BANK");
            map.set("FundingRequestV3.CardAcceptor.City", "ANYTOWN");
            map.set("FundingRequestV3.CardAcceptor.State", "MO");
            map.set("FundingRequestV3.CardAcceptor.Country", "USA");
            map.set("FundingRequestV3.TransactionDesc", "GDB");
            map.set("FundingRequestV3.MerchantId", "12345");
            map.set("FundingRequestV3.ReceiverIdentification.Type", "01");
            map.set("FundingRequestV3.ReceiverIdentification.Number", "2147483647");
            map.set("FundingRequestV3.ReceiverIdentification.CountryCode", "USA");
            map.set("FundingRequestV3.ReceiverIdentification.ExpirationDate", "10102017");
            map.set("FundingRequestV3.ReceiverNationality", "USA");
            map.set("FundingRequestV3.ReceiverCountryOfBirth", "USA");
            map.set("FundingRequestV3.SenderIdentification.Type", "01");
            map.set("FundingRequestV3.SenderIdentification.Number", "2147483647");
            map.set("FundingRequestV3.SenderIdentification.CountryCode", "USA");
            map.set("FundingRequestV3.SenderIdentification.ExpirationDate", "10102017");
            map.set("FundingRequestV3.SenderNationality", "USA");
            map.set("FundingRequestV3.SenderCountryOfBirth", "USA");
            map.set("FundingRequestV3.TransactionPurpose", "01");
            Funding response = Funding.create(map);

            System.out.println("Transfer.RequestId-->"+response.get("Transfer.RequestId")); // Transfer.RequestId-->1413210
            System.out.println("Transfer.TransactionReference-->"+response.get("Transfer.TransactionReference")); // Transfer.TransactionReference-->1111774875227082093
            System.out.println("Transfer.TransactionHistory.Transaction[0].Type-->"+response.get("Transfer.TransactionHistory.Transaction[0].Type")); // Transfer.TransactionHistory.Transaction[0].Type-->FUNDING
            System.out.println("Transfer.TransactionHistory.Transaction[0].SystemTraceAuditNumber-->"+response.get("Transfer.TransactionHistory.Transaction[0].SystemTraceAuditNumber")); // Transfer.TransactionHistory.Transaction[0].SystemTraceAuditNumber-->212837
            System.out.println("Transfer.TransactionHistory.Transaction[0].NetworkReferenceNumber-->"+response.get("Transfer.TransactionHistory.Transaction[0].NetworkReferenceNumber")); // Transfer.TransactionHistory.Transaction[0].NetworkReferenceNumber-->213721259
            System.out.println("Transfer.TransactionHistory.Transaction[0].SettlementDate-->"+response.get("Transfer.TransactionHistory.Transaction[0].SettlementDate")); // Transfer.TransactionHistory.Transaction[0].SettlementDate-->0818
            System.out.println("Transfer.TransactionHistory.Transaction[0].Response.Code-->"+response.get("Transfer.TransactionHistory.Transaction[0].Response.Code")); // Transfer.TransactionHistory.Transaction[0].Response.Code-->00
            System.out.println("Transfer.TransactionHistory.Transaction[0].Response.Description-->"+response.get("Transfer.TransactionHistory.Transaction[0].Response.Description")); // Transfer.TransactionHistory.Transaction[0].Response.Description-->Approved or completed successfully
            System.out.println("Transfer.TransactionHistory.Transaction[0].SubmitDateTime-->"+response.get("Transfer.TransactionHistory.Transaction[0].SubmitDateTime")); // Transfer.TransactionHistory.Transaction[0].SubmitDateTime-->2016-08-17T09:25:50Z

        } catch (ApiException e) {
            System.err.println("HttpStatus: "+e.getHttpStatus());
            System.err.println("Message: "+e.getMessage());
            System.err.println("ReasonCode: "+e.getReasonCode());
            System.err.println("Source: "+e.getSource());
        }
    }
}