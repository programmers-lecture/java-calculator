package stringcalculator.exception;

public enum ExceptionMessage {

    FAILURE("999", "어플리케이션 오류가 발생하였습니다."),
    FORMULA_NULL_ERROR("101", "입력하신 연산식이 잘못되어 오류가 발생하였습니다."),
    DIVIDE_ZERO_ERROR("102", "0으로 나눌 수 없습니다.");

    private final String code;
    private final String desc;

    ExceptionMessage(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getMessage() {
        return code + " :: " + desc;
    }

}
