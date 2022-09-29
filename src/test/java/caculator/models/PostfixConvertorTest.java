package caculator.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PostfixConvertorTest {

    private final PostfixConvertor postfixConvertor = new PostfixConvertor();

    @Test
    @DisplayName("후위 계산식 변경 테스트")
    void convertPostfixFormulaTest() {
        String[] formula = new String[] {"5", "+", "4", "*", "8", "/", "2", "-", "10"};
        List<String> postfixFormula = new ArrayList<>(Arrays.asList("5", "4", "8", "*", "2", "/", "10", "-", "+"));

        assertThat(postfixConvertor.convertPostfixFormula(formula))
                .isEqualTo(postfixFormula);
    }

}
