package payments.qr.libs.request;

import payments.qr.libs.request.moneysend.MoneysendQRServiceRequest;
import payments.qr.libs.request.mvisa.MVisaQRServiceRequest;

public class QRServiceRequest {

    private QRServiceRequestType qrServiceRequestType;

    private int interchangeId;

    private String bankId;

    private MoneysendQRServiceRequest moneysendQRServiceRequest;

    private MVisaQRServiceRequest mVisaQRServiceRequest;


    public QRServiceRequestType getQrServiceRequestType() {
        return qrServiceRequestType;
    }

    public void setQrServiceRequestType(QRServiceRequestType qrServiceRequestType) {
        this.qrServiceRequestType = qrServiceRequestType;
    }

    public void setInterchangeId(int interchangeId) {
        this.interchangeId = interchangeId;
    }

    public int getInterchangeId() {
        return interchangeId;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }
}
