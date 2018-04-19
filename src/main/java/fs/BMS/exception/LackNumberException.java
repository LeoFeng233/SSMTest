package fs.BMS.exception;

/**
 * 库存不足异常
 */
public class LackNumberException extends RuntimeException {

    public LackNumberException(String message) {
        super(message);
    }

    public LackNumberException(String message ,Throwable cause) {
        super(message, cause);
    }
}
