package caculator.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class PostfixConvertorTest {

    private PostfixConvertor postfixConvertor;

    @BeforeEach
    void setUp() {
        postfixConvertor = new PostfixConvertor();
    }

    static Stream<Arguments> getParametersForConvertPostfixFormulaSuccessText() {
        return Stream.of(
                Arguments.arguments(
                        new String[] {"5", "+", "4", "*", "8", "/", "2", "-", "10"},
                        List.of("5", "4", "8", "*", "2", "/", "10", "-", "+")
                )
        );
    }

    @ParameterizedTest
    @DisplayName("올바른 계산식으로 후위 계산식 변경 성공 테스트")
    @MethodSource("getParametersForConvertPostfixFormulaSuccessText")
    void convertPostfixFormulaSuccessTest(String[] formula, List<String> expected) {
        List<String> actual = postfixConvertor.convertPostfixFormula(formula);
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> getParametersForConvertPostfixFormulaFailTestByIncorrectFormula() {
        return Stream.of(
                Arguments.arguments(
                        new String[] {"5", "&", "4"},
                        new String[] {"6", "2", "@"}
                )
        );
    }

    @ParameterizedTest
    @DisplayName("숫자도 연산자도 아닌 글자 포함으로 알맞지 않은 공식으로 후위 계산식 변경 실패 테스트")
    @MethodSource("getParametersForConvertPostfixFormulaFailTestByIncorrectFormula")
    void convertPostfixFormulaFailTestByIncorrectFormula(String[] incorrectFormula) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                        postfixConvertor.convertPostfixFormula(incorrectFormula))
                .withMessage("올바르지 않은 계산식입니다.");
    }
}
