package payments.qr.services.impl.moneysend.workers;

/**
 *
 * Script-Name: PaymentSpecifiedAccountNumber
 */

import com.mastercard.api.core.ApiConfig;
import com.mastercard.api.core.exception.ApiException;
import com.mastercard.api.core.model.RequestMap;
import com.mastercard.api.core.security.oauth.OAuthAuthentication;
import com.mastercard.api.moneysend.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import payments.qr.libs.response.moneysend.MoneysendResponseDetails;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Component
public class PaymentSpecifiedAccountNumber {

    @Value("${moneysend.api.authentication.consumer.key}")
    private String consumerKey;   // You should copy this from "My Keys" on your project page e.g. UTfbhDCSeNYvJpLL5l028sWL9it739PYh6LU5lZja15xcRpY!fd209e6c579dc9d7be52da93d35ae6b6c167c174690b72fa

    @Value("${moneysend.api.authentication.key.alias}")
    private String keyAlias;   // For production: change this to the key alias you chose when you created your production key

    @Value("${moneysend.api.authentication.key.password}")
    private String keyPassword;   // For production: change this to the key alias you chose when you created your production key

    @Value("${moneysend.api.authentication.p12.file.path}")
    private String p12FilePath; // e.g. /Users/yourname/project/sandbox.p12 | C:\Users\yourname\project\sandbox.p12

    public void performPayment() {

        MoneysendResponseDetails moneysendResponseDetails = new MoneysendResponseDetails();

        try {
            InputStream is = new FileInputStream(p12FilePath);
            ApiConfig.setAuthentication(new OAuthAuthentication(consumerKey, is, keyAlias, keyPassword));   // You only need to set this once
            ApiConfig.setDebug(true);   // Enable http wire logging
            ApiConfig.setSandbox(true); // For production: use ApiConfig.setSandbox(false);
            //ApiConfig.setEnvironment(Environment.SANDBOX);
            System.out.println("\n perform payment called ############################################## \n ###############################################\n\n\n\n\n ");

            RequestMap map = new RequestMap();
            map.set("PaymentRequestV3.LocalDate", "0817");
            map.set("PaymentRequestV3.LocalTime", "150149");
            map.set("PaymentRequestV3.TransactionReference", "1191784875227082100");
            map.set("PaymentRequestV3.SenderName.First", "Test");
            map.set("PaymentRequestV3.SenderName.Middle", "T");
            map.set("PaymentRequestV3.SenderName.Last", "Test");
            map.set("PaymentRequestV3.SenderPhone", "7031234567");
            map.set("PaymentRequestV3.SenderDateOfBirth", "08061977");
            map.set("PaymentRequestV3.SenderAddress.Line1", "123 Main Street");
            map.set("PaymentRequestV3.SenderAddress.Line2", "5A");
            map.set("PaymentRequestV3.SenderAddress.City", "Arlington");
            map.set("PaymentRequestV3.SenderAddress.CountrySubdivision", "VA");
            map.set("PaymentRequestV3.SenderAddress.PostalCode", "22207");
            map.set("PaymentRequestV3.SenderAddress.Country", "USA");
            map.set("PaymentRequestV3.FundingCard.AccountNumber", "5184680470000023");
            map.set("PaymentRequestV3.FundingSource", "03");
            map.set("PaymentRequestV3.AdditionalMessage", "Test");
            map.set("PaymentRequestV3.ParticipationID", "Test");
            map.set("PaymentRequestV3.LanguageIdentification", "Tes");
            map.set("PaymentRequestV3.LanguageData", "Test");
            map.set("PaymentRequestV3.ReceivingCard.AccountNumber", "5184680430000006");
            map.set("PaymentRequestV3.ReceiverName.Middle", "B");
            map.set("PaymentRequestV3.ReceiverName.Last", "Lopez");
            map.set("PaymentRequestV3.ReceiverAddress.Line1", "Pueblo Street");
            map.set("PaymentRequestV3.ReceiverAddress.Line2", "PO BOX 12");
            map.set("PaymentRequestV3.ReceiverAddress.City", "El PASO");
            map.set("PaymentRequestV3.ReceiverAddress.CountrySubdivision", "TX");
            map.set("PaymentRequestV3.ReceiverAddress.PostalCode", "79906");
            map.set("PaymentRequestV3.ReceiverAddress.Country", "USA");
            map.set("PaymentRequestV3.ReceiverPhone", "1800639426");
            map.set("PaymentRequestV3.ReceiverDateOfBirth", "06211977");
            map.set("PaymentRequestV3.ReceivingAmount.Value", "054");
            map.set("PaymentRequestV3.ReceivingAmount.Currency", "840");
            map.set("PaymentRequestV3.ICA", "009674");
            map.set("PaymentRequestV3.ProcessorId", "9000000442");
            map.set("PaymentRequestV3.RoutingAndTransitNumber", "990442082");
            map.set("PaymentRequestV3.CardAcceptor.Name", "THE BEST BANK");
            map.set("PaymentRequestV3.CardAcceptor.City", "ANYTOWN");
            map.set("PaymentRequestV3.CardAcceptor.State", "MO");
            map.set("PaymentRequestV3.CardAcceptor.PostalCode", "99999-1234");
            map.set("PaymentRequestV3.CardAcceptor.Country", "USA");
            map.set("PaymentRequestV3.TransactionDesc", "P2P");
            map.set("PaymentRequestV3.MerchantId", "123456");
            map.set("PaymentRequestV3.ReceiverIdentification.Type", "01");
            map.set("PaymentRequestV3.ReceiverIdentification.Number", "2147483647");
            map.set("PaymentRequestV3.ReceiverIdentification.CountryCode", "USA");
            map.set("PaymentRequestV3.ReceiverIdentification.ExpirationDate", "10102017");
            map.set("PaymentRequestV3.ReceiverNationality", "USA");
            map.set("PaymentRequestV3.ReceiverCountryOfBirth", "USA");
            map.set("PaymentRequestV3.SenderIdentification.Type", "01");
            map.set("PaymentRequestV3.SenderIdentification.Number", "2147483647");
            map.set("PaymentRequestV3.SenderIdentification.CountryCode", "USA");
            map.set("PaymentRequestV3.SenderIdentification.ExpirationDate", "10102017");
            map.set("PaymentRequestV3.SenderNationality", "USA");
            map.set("PaymentRequestV3.SenderCountryOfBirth", "USA");
            map.set("PaymentRequestV3.TransactionPurpose", "01");
            Payment response = Payment.create(map);

            System.out.println("Transfer.RequestId-->"+response.get("Transfer.RequestId")); // Transfer.RequestId-->1413236
            System.out.println("Transfer.TransactionReference-->"+response.get("Transfer.TransactionReference")); // Transfer.TransactionReference-->1091774875227082093
            System.out.println("Transfer.TransactionHistory.Transaction[0].Type-->"+response.get("Transfer.TransactionHistory.Transaction.Type")); // Transfer.TransactionHistory.Transaction[0].Type-->PAYMENT
            System.out.println("Transfer.TransactionHistory.Transaction[0].SystemTraceAuditNumber-->"+response.get("Transfer.TransactionHistory.Transaction.SystemTraceAuditNumber")); // Transfer.TransactionHistory.Transaction[0].SystemTraceAuditNumber-->212849
            System.out.println("Transfer.TransactionHistory.Transaction[0].NetworkReferenceNumber-->"+response.get("Transfer.TransactionHistory.Transaction.NetworkReferenceNumber")); // Transfer.TransactionHistory.Transaction[0].NetworkReferenceNumber-->313371112
            System.out.println("Transfer.TransactionHistory.Transaction[0].SettlementDate-->"+response.get("Transfer.TransactionHistory.Transaction.SettlementDate")); // Transfer.TransactionHistory.Transaction[0].SettlementDate-->0818
            System.out.println("Transfer.TransactionHistory.Transaction[0].Response.Code-->"+response.get("Transfer.TransactionHistory.Transaction.Response.Code")); // Transfer.TransactionHistory.Transaction[0].Response.Code-->00
            System.out.println("Transfer.TransactionHistory.Transaction[0].Response.Description-->"+response.get("Transfer.TransactionHistory.Transaction.Response.Description")); // Transfer.TransactionHistory.Transaction[0].Response.Description-->Approved or completed successfully
            System.out.println("Transfer.TransactionHistory.Transaction[0].SubmitDateTime-->"+response.get("Transfer.TransactionHistory.Transaction.SubmitDateTime")); // Transfer.TransactionHistory.Transaction[0].SubmitDateTime-->2016-08-17T09:31:54Z

            moneysendResponseDetails.setCompletedSuccessfully(true);
            moneysendResponseDetails.setTransferRequestId(String.valueOf(response.get("Transfer.RequestId")));
            moneysendResponseDetails.setTransferTransactionReference(String.valueOf(response.get("Transfer.TransactionReference")));
            moneysendResponseDetails.setTransferTrasactionHistoryType(String.valueOf(response.get("Transfer.TransactionHistory.Transaction.Type")));
            moneysendResponseDetails.setTransferTrasactionHistorySystemTraceAuditNumber(String.valueOf(response.get("Transfer.TransactionHistory.Transaction.SystemTraceAuditNumber")));
            moneysendResponseDetails.setTransferTrasactionHistorySettlementDate(String.valueOf(response.get("Transfer.TransactionHistory.Transaction.SettlementDate")));
            moneysendResponseDetails.setTransferTrasactionHistoryResponseCode(String.valueOf(response.get("Transfer.TransactionHistory.Transaction.Response.Code")));
            moneysendResponseDetails.setTransferTrasactionHistorySubmitDateTime(String.valueOf(response.get("Transfer.TransactionHistory.Transaction.SubmitDateTime")));
            moneysendResponseDetails.setTransferTrasactionHistoryResponseDescription(String.valueOf(response.get("Transfer.TransactionHistory.Transaction.Response.Description")));
            moneysendResponseDetails.setTransferTrasactionHistoryNetworkReferenceNumber(String.valueOf(response.get("Transfer.TransactionHistory.Transaction.NetworkReferenceNumber")));

        } catch (ApiException e) {
            System.err.println("HttpStatus: "+e.getHttpStatus());
            System.err.println("Message: "+e.getMessage());
            System.err.println("ReasonCode: "+e.getReasonCode());
            System.err.println("Source: "+e.getSource());

            moneysendResponseDetails.setCompletedSuccessfully(false);
            moneysendResponseDetails.setHttpStatus(String.valueOf(e.getHttpStatus()));
            moneysendResponseDetails.setErrorMessage(e.getMessage());
            moneysendResponseDetails.setReasonCode(e.getReasonCode());
            moneysendResponseDetails.setSource(e.getSource());

        }catch (FileNotFoundException e){
            moneysendResponseDetails.setCompletedSuccessfully(false);
            moneysendResponseDetails.setErrorMessage("the p12 security file seems to be missing. Please make sure it's available and the path is configured in your .properties file");

            System.err.println("\n file not found");

        }

    }
}