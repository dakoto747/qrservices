package payments.qr.libs.exceptions;

public class NotSupportedOperationException extends Exception {

    private static final String DEFAULT_MSG = "OPERATION NOT SUPPORTED";

    public NotSupportedOperationException() {
        super(DEFAULT_MSG);
    }

    public NotSupportedOperationException(String msg) {
        super(msg);
    }

    public NotSupportedOperationException(String msg, Throwable inner) {
        super(msg, inner);
    }

    public NotSupportedOperationException(Throwable inner) {
        super(inner);
    }
}
