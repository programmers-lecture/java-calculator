//package stringcalculator.converter;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import stringcalculator.view.Reader;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class FormConverterTest {
//
//    private final FormConverter formConverter = new FormConverter();
//
//    @ParameterizedTest
//    @CsvSource({
//            "10 + 20, " +
//                    "'[10, +, 20]'",
//            "10 - 20, " +
//                    "'[10, -, 20]'",
//            "10 * 20, " +
//                    "'[10, *, 20]'",
//            "10 / 20, " +
//                    "'[10, /, 20]'",
//            "123 + 123 * 123 + (123 - 10 * 123 ( 10 + 10 + (20) / 2) /2 ), " +
//                    "'[123, +, 123, *, 123, +, (, (, 123, -, 10, *, 123, (, (, 10, +, 10, +, (, (, 20, ), ), /, 2, ), ), /, 2, ), )]'"
//    })
//    @DisplayName("분리된 연산식 배열 조합 테스트")
//    void separateStringTest(String formula, String result) {
//        List<String> separateResult = formConverter.getFormula(Reader.splitWithoutSpace(formula));
//        assertEquals(result, separateResult.toString());
//    }
//
//}