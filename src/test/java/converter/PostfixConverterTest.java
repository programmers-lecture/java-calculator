package converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostfixConverterTest {

    private final PostfixConverter converter = new PostfixConverter();

    @Test
    @DisplayName("후위 표기식 작성 메서드 테스트")
    public void postfixFormatTest() {

        String str = " 1-4+2+(3*2+(1+1)-1)";
        List<String> format = converter.getFormat(getStringList(str));

        assertEquals("[1, 4, -, 2, +, 3, 2, *, 1, 1, +, +, 1, -, +]", format.toString());
    }

    private List<String> getStringList(String str) {
        return Stream.of(str.split(""))
                .filter(o -> !o.equals(" "))
                .collect(Collectors.toList());
    }
}