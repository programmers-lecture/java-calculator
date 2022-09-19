package converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PostfixConverterTest {

    private final PostfixConverter postfixConverter = new PostfixConverter();

    @Test
    @DisplayName("후위 표기식 작성 메서드 테스트")
    public void postfixFormatTest() {
        String str = " 1 - 4    + 2 + (3 *   2 + (1           + 1) - 1)";

        List<String> postfixFormat = postfixConverter.getPostfixFormat(getStringList(str));

        System.out.println("postfixFormat = " + postfixFormat);
    }

    private List<String> getStringList(String str) {
        return Stream.of(str.split(""))
                .filter(o -> !o.equals(" "))
                .collect(Collectors.toList());
    }
}