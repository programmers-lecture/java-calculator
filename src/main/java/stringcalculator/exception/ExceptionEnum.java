package stringcalculator.exception;

import java.util.Arrays;
import java.util.Optional;

public enum ExceptionEnum {

    FAILURE("999", "어플리케이션 오류가 발생하였습니다."),
    FORMULA_NULL_ERROR("101", "입력하신 연산식이 잘못되어 오류가 발생하였습니다."),
    DIVIDE_ZERO_ERROR("102", "0으로 나눌 수 없습니다.");

    private final String code;
    private final String desc;

    ExceptionEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static void throwException(ExceptionEnum exceptionType) {
        ExceptionEnum findException = findException(exceptionType).orElse(FAILURE);
        throw new RuntimeException(getErrorMessage(findException));
    }

    private static Optional<ExceptionEnum> findException(ExceptionEnum exceptionType) {
        return Arrays.stream(values())
                .filter(exception -> exception.name().equals(exceptionType))
                .findFirst();
    }

    private static String getErrorMessage(ExceptionEnum findException) {
        return findException.getCode() + " :: " + findException.getDesc();
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
