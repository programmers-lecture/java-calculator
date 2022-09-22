package stringcalculator.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringcalculator.view.Reader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostfixConverterTest {

    private final PostfixConverter converter = new PostfixConverter();

    @Test
    @DisplayName("후위 표기식 작성 메서드 테스트")
    void postfixFormatTest() {

        String str = " 1-4+2+(3*2+(1+1)-1)";
        List<String> format = converter.getFormula(Reader.splitWithoutSpace(str));

        assertEquals("[1, 4, -, 2, +, 3, 2, *, 1, 1, +, +, 1, -, +]", format.toString());
    }
}
