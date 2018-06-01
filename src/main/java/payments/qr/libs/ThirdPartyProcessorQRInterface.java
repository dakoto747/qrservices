package payments.qr.libs;


import payments.qr.libs.exceptions.NotSupportedOperationException;
import payments.qr.libs.response.QRServiceResponse;

public interface ThirdPartyProcessorQRInterface {

    default QRServiceResponse performQRMerchantPayment() throws NotSupportedOperationException {
        throw new NotSupportedOperationException();
    }

    default QRServiceResponse getPaymentStatus() throws NotSupportedOperationException {
        throw new NotSupportedOperationException();
    }

    default QRServiceResponse cashback()  throws NotSupportedOperationException {
//        CashOutPushPayments POST allows consumer to withdraw cash from their own account at any mVisa accepting agent.
        throw new NotSupportedOperationException();
    }

    default QRServiceResponse fundAccount() throws NotSupportedOperationException { // depositIntoOwnAccount
//      POST  Cash In Push Payments allows consumer to deposit cash into their own account at any mVisa accepting agent.
        throw new NotSupportedOperationException();
    }

//    Get the status and details for a specific CashInPushPayments POST request.

//    MerchantPushPayments is used for payment to a merchant for goods or services purchased, either face-to-face or remote__This API is invoked in the following sequence

}
