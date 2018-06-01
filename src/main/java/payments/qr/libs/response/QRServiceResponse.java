package payments.qr.libs.response;


public class QRServiceResponse {


    private String narration;
    private String userCode;


    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }


    public static QRServiceResponse fromCodeAndNarration(String msg) {
        QRServiceResponse qrServiceResponse = new QRServiceResponse();
        qrServiceResponse.setNarration(msg);
        return qrServiceResponse;
    }
}
