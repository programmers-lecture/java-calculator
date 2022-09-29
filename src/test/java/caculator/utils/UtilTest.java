package caculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UtilTest {

    @Test
    @DisplayName("숫자인지 여부 판단 테스트")
    public void isNumberTest() {
        assertThat(Util.isNumber("1"))
                .isTrue();
        assertThat(Util.isNumber("숫자아님"))
                .isFalse();
    }
}
