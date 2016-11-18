package xyz.vopen.passport.facade.exception;

/**
 * 非法请求异常
 * Created by ive on 08/11/2016.
 */
public class NSIllegalRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NSIllegalRequestException () {
    }

    public NSIllegalRequestException (String message) {
        super(message);
    }

    public NSIllegalRequestException (String message, Throwable cause) {
        super(message, cause);
    }

    public NSIllegalRequestException (Throwable cause) {
        super(cause);
    }

}
