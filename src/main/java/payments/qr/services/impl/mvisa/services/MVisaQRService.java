package payments.qr.services.impl.mvisa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payments.qr.libs.ThirdPartyProcessorQRInterface;
import payments.qr.libs.request.mvisa.MVisaQRServiceRequest;
import payments.qr.libs.request.mvisa.nestedmodels.Address;
import payments.qr.libs.request.mvisa.nestedmodels.CardAcceptorDetails;
import payments.qr.libs.request.mvisa.nestedmodels.PurchaseIdentifier;
import payments.qr.libs.response.QRServiceResponse;
import payments.qr.services.impl.mvisa.workers.MVisaQRClient;

import javax.annotation.PostConstruct;

/**
 https://developer.visa.com/capabilities/visa_direct/reference?next=visa_direct__mvisa#visa_direct__mvisa__v1__cash_in_push_payments

 MerchantPushPayments POST
 MerchantPushPayments is used for payment to a merchant for goods or services purchased, either face-to-face or
 remote__This API is invoked in the following sequence:
 1. The consumer connects the account through the mobile device, provides payment instructions and authenticates
 themselves. The merchant information is captured by the consumer’s mobile from the merchant information display
 which can be through key entry, QR code, NFC or other means. The payment instructions include mVisa merchant ID
 (which is used to identify the merchant PAN), the amount to be paid and optionally a payment reference such as an
 invoice or bill number.
 2. _Upon receiving the payment instructions, the consumer’s issuer invokes MerchantPushPayments POST operation to
 push payment instructions to the merchant’s account.
 3. _The merchant acquirer processes the Visa message, creates a record of merchant payment and reverts back with a
 response message containing the MerchantPushPayments Response Attributes.
 4. On completion, both the consumer and the merchant receive confirmation or denial notification.
 _Note: If the POST call times out, the resource will return a statusIdentifier which can be used in the_MerchantPushPayments
 Transactions GET_operation as the statusIdentifier in the URL: X-Client-Transaction-ID
 Optional A unique value for a transaction unique at the level of the individual service invoker and can be recycled
 every 24 hours. This identifies the transaction uniquely and can help reference the results of the original transaction.

 MerchantPushPayments GET
 Get the status and details for a specific MerchantPushPayments POST request.

 CashOutPushPayments POST
 CashOutPushPayments POST allows consumer to withdraw cash from their own account at any mVisa accepting agent.
 The API is invoked in the following sequence
 1. The consumer connects to their account through the mobile device,provides withdrawal instructions and authenticates
 themselves. The withdrawal instructions provided by the consumer includes the mVisa agent’s PAN used to route the
 transaction to the agent, and the amount to be withdrawn.
 2. Upon receiving the payment instructions, the consumer’s issuer invokes CashOutPushPayments POST operation to push
 cash out instructions to the agent’s visa account.
 3. The agent acquirer processes the Visa message, credits the
 agent account if valid and reverts back with a response message containing the CashOutPushPayments Response Attributes.
 4. On completion, both the consumer and agent receive confirmation or denial notification. The agent then provides
 the cash to the consumer.
 Note- If the POST call times out, the resource will return a statusIdentifier which can be used in the CashOutPushPayments
 operation as the statusIdentifier in the URL HEADER - X-Client-Transaction-ID
 Optional A unique value for a transaction (unique at the level of the individual service invoker and can be
 recycled every 24 hours). This identifies the transaction uniquely and can help reference the results of the
 original transaction.

 CashOutPushPayments GET
 Get the status and details for a specific CashOutPushPayments POST request.


 CashInPushPayments POST
 Cash In Push Payments allows consumer to deposit cash into their own account at any mVisa accepting agent.
 The API is invoked in the following sequence:
 1. An agent connects to their account through the mobile device, provides transfer instructions and authenticates
 themselves. The transfer instructions provided by the agent includes the depositing consumer’s PAN used to route
 the transaction, and the amount to be deposited.
 2. Upon receiving the payment instructions, the agent’s acquirer invokes CashInPushPayments POST operation to push
 cash in instructions to the consumer’s Vvisa account.
 3. The issuer processes the Visa message, instantly credits the consumer account if valid and reverts back with a
 response message containing the CashInPushPayments Response Attributes.4. On completion, both the consumer and
 agent receive confirmation or denial notification. The consumer then provides the cash to the agent.
 NOTE If the POST call times out, the resource will return a statusIdentifier which can be used in the
 CashInPushPayments Transaction operation as the statusIdentifier in the URL HEADER X-Client-Transaction-ID
 Optional A unique value for a transaction (unique at the level of the individual service invoker and can be recycled
 every 24 hours). This identifies the transaction uniquely and can help reference the results of the original transaction.

 CashInPushPayments GET
 Get the status and details for a specific CashInPushPayments POST request.

 */
@Service
public class MVisaQRService implements ThirdPartyProcessorQRInterface {

    @Autowired
    private MVisaQRClient mVisaQRClient;

    @PostConstruct
    public void runSample(){
        MVisaQRServiceRequest mVisaQRServiceRequest = new MVisaQRServiceRequest();
        mVisaQRServiceRequest.setAcquirerCountryCode("356");
        mVisaQRServiceRequest.setAcquiringBin("408972");
        mVisaQRServiceRequest.setAmount("124.05");
        mVisaQRServiceRequest.setBusinessApplicationId("MP");
        mVisaQRServiceRequest.setCardAcceptor(new CardAcceptorDetails(new Address("KOLKATA", "IND"), "CA-IDCode-77765", "Visa Inc. USA-Foster City"));
        mVisaQRServiceRequest.setFeeProgramIndicator("123");
        mVisaQRServiceRequest.setLocalTransactionDateTime("2018-05-25T16:40:58");
        mVisaQRServiceRequest.setPurchaseIdentifier(new PurchaseIdentifier("REF_123456789123456789123", "1"));
        mVisaQRServiceRequest.setRecipientName("Jasper");
        mVisaQRServiceRequest.setRecipientPrimaryAccountNumber("4123640062698797");
        mVisaQRServiceRequest.setRetrievalReferenceNumber("412770451035");
        mVisaQRServiceRequest.setSecondaryId("123TEST");
        mVisaQRServiceRequest.setSenderAccountNumber("4027290077881587");
        mVisaQRServiceRequest.setSenderName("Jasper");
        mVisaQRServiceRequest.setSenderReference("");
        mVisaQRServiceRequest.setSystemsTraceAuditNumber("451035");
        mVisaQRServiceRequest.setTransactionCurrencyCode("INR");
        mVisaQRServiceRequest.setTransactionIdentifier("381228649430015");
        performQRMerchantPayment(mVisaQRServiceRequest);
    }

    public QRServiceResponse performQRMerchantPayment(MVisaQRServiceRequest mVisaQRServiceRequest){

        return mVisaQRClient.performMerchantPushPayment(mVisaQRServiceRequest);
    }

}
