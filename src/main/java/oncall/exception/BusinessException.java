package oncall.exception;

public class BusinessException extends IllegalArgumentException {

    private BusinessException(ErrorCode errorMessage) {
        super(errorMessage.getMessage());
    }

    public static BusinessException from(ErrorCode errorMessage) {
        return new BusinessException(errorMessage);
    }
}
