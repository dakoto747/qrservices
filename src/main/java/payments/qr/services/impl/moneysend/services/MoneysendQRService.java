package payments.qr.services.impl.moneysend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payments.qr.libs.ThirdPartyProcessorQRInterface;
import payments.qr.libs.response.QRServiceResponse;
import payments.qr.services.impl.moneysend.workers.PaymentSpecifiedAccountNumber;

import javax.annotation.PostConstruct;

/**
 Payment
 CREATE
 Use the Transfer resource to transfer funds to a recipient with an eligible Mastercard card account.

 mapped - proxy ... (develop with specified ) \


 we're not using funding (it's like cash-in push payment)
 Funding
 CREATE
 Use the Transfer resource to transfer funds to a recipient with an eligible Mastercard card account.

 Transfer Reversal
 CREATE
 The Transfer Reversal resource is a request to reverse a previously submitted Transfer and is only available in extremely
 limited circumstances. Transfer reversal must be submitted within 24 hours of processing the original transfer request -
 this applies to the payment transaction only. Reversal ProcessingThe following limited reversals or corrections are permitted
 for MoneySend Payment Transactions:1.Capability to reverse a Funding Transaction and credit the refund to the sender's
 Funding Account.2.Capability to process an online reversal request within one calendar day of the date the MoneySend Payment
 Transaction was authorized only in the event of a documented clerical error.3.Capability to ensure that the Receiving
 Institution has approved the MoneySend Payment Transaction reversal request, prior to crediting the refund to the sender's
 Funding Account. Use this resource to reverse a previously submitted Transfer.

 Card Mapping
 CREATE
 Allows a customer to create a card mapping for their MoneySend subscription using an API call. Creation of a Card
 Mapping allows a Mastercard customer to associate their card account to a unique identifier or ‘alias' within the
 customer's MoneySend enrollment profile. This unique identifier can be used to send or receive funds via the MoneySend
 service without sharing card account information.This also enables MoneySend to execute transactions between senders
 and receivers who bank with different Mastercard Members while protecting the card account information of each customer.
 Card Mappings are stored in a secure encrypted environment which is a PCI compliant data storage facility managed by
 Mastercard.

 */

@Service
public class MoneysendQRService implements ThirdPartyProcessorQRInterface {

    @Autowired
    private PaymentSpecifiedAccountNumber paymentSpecifiedAccountNumber;

    @PostConstruct
    public void runSample(){
        performQRMerchantPayment();
    }

    @Override
    public QRServiceResponse performQRMerchantPayment(){
        
         paymentSpecifiedAccountNumber.performPayment();
         return null;
    }
}
