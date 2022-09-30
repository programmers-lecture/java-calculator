package caculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class UtilTest {

    @ParameterizedTest(name = "strings: 숫자에 해당되는 글자")
    @DisplayName("숫자인지 여부 판단 성공 테스트")
    @ValueSource(strings = {"1", "2", "10", "5.5"})
    public void isNumberSuccessTest(String number) {
        boolean actual = Util.isNumber(number);
        assertThat(actual).isTrue();
    }

    @ParameterizedTest(name = "strings: 숫자에 해당되지 않는 글자")
    @DisplayName("숫자인지 여부 판단 실패 테스트")
    @ValueSource(strings = {"(", "+", "숫자아님"})
    public void isNumberFailTest(String notNumber) {
        boolean actual = Util.isNumber(notNumber);
        assertThat(actual).isFalse();
    }
}
