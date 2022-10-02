package stringcalculator.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static stringcalculator.exception.ExceptionEnum.FORMULA_NULL_ERROR;

class ReaderTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "%$",
            "",
            "1 1 1"
    })
    @DisplayName("입력 예외처리 테스트")
    void readExceptionTest(String inputForm) {
        System.setIn(new ByteArrayInputStream(inputForm.getBytes(StandardCharsets.UTF_8)));
        Exception exception = assertThrows(
                RuntimeException.class,
                Reader::read);

        assertEquals(FORMULA_NULL_ERROR, exception.getMessage());
    }
}