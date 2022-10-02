package stringcalculator.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static stringcalculator.view.Reader.splitWithoutSpace;

class PostfixConverterTest {

    private final PostfixConverter converter = new PostfixConverter();

    @ParameterizedTest(name = "[{index}] 연산식 = {0}, 변환 결과 = {1}")
    @MethodSource("getFormulaToTestWhenConvertToPostfixThenSuccess")
    @DisplayName("후위 표기식 변환 성공 테스트")
    void whenConvertToPostfixFormThenSuccessTest(String formula, String result) {
        List<String> convertedResult = converter.getFormula(splitWithoutSpace(formula));
        assertThat(convertedResult.toString()).isEqualTo(result);
    }

    static Stream<Arguments> getFormulaToTestWhenConvertToPostfixThenSuccess() {
        return Stream.of(
                Arguments.arguments("1 + 2", "[1, 2, +]"),
                Arguments.arguments("1 - 2", "[1, 2, -]"),
                Arguments.arguments("1 * 2", "[1, 2, *]"),
                Arguments.arguments("1 / 2", "[1, 2, /]"),
                Arguments.arguments("1 + 2 + 3", "[1, 2, +, 3, +]"),
                Arguments.arguments("1 + 2 * 3", "[1, 2, 3, *, +]"),
                Arguments.arguments("1 * 2 + 3", "[1, 2, *, 3, +]"),
                Arguments.arguments("1 * 2 / 3", "[1, 2, *, 3, /]"),
                Arguments.arguments("1 / 2 * 3", "[1, 2, /, 3, *]"),
                Arguments.arguments(
                        "1 - 4 + 2 + ( 3 * 2 + ( 1 + 1 ) - 1 )",
                        "[1, 4, -, 2, +, 3, 2, *, 1, 1, +, +, 1, -, +]"
                )
        );
    }

}
