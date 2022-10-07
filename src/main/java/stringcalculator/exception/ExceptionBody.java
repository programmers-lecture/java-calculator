package stringcalculator.exception;

import static stringcalculator.exception.ExceptionEnum.throwException;

public class ExceptionBody extends RuntimeException {

    public ExceptionBody(ExceptionEnum exceptionType) {
        throwException(exceptionType);
    }

    private ExceptionBody() {
    }

    private ExceptionBody(String message) {
        super(message);
    }

    private ExceptionBody(String message, Throwable cause) {
        super(message, cause);
    }

    private ExceptionBody(Throwable cause) {
        super(cause);
    }

    private ExceptionBody(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
