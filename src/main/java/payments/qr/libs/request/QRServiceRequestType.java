package payments.qr.libs.request;

public enum QRServiceRequestType {

    PERFORM_MONEYSEND_QR_PAYMENT,
    PERFORM_MVISA_QR_PAYMENT,

    GET_MVISA_QR_PAYMENT_STATUS,
    GET_MONEYSEND_PAYMENT_STATUS,

    PERFORM_MONYESEND_CASHBACK,
    PERFORM_MVISA_CASHBACK,

    FUND_MONEYSEND_ACCT,
    FUND_MVISA_ACCT
}