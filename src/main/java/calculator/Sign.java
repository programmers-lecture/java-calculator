package calculator;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum Sign {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String sign;

    public static Sign fromSignStr(String sign) {
        return Arrays.stream(Sign.values())
                .filter(s -> s.sign.equals(sign))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean isPrimal() {
        return this == MULTIPLY || this == DIVIDE;
    }
}
