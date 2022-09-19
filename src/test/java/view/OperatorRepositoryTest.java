package view;

import operator.OperatorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OperatorRepositoryTest {

    private final OperatorRepository operatorRepository = new OperatorRepository();

    @Test
    @DisplayName("문장 포맷 스택 테스트")
    public void separateToStackTest() {
        String str1 = " 1    + 2 + (3 * (1           + 1) - 1)";
        String str2 = " 1 - 4    + 2 + (3 *   2 + (1           + 1) - 1)";
        String str3 = " 1    + 2 + (3 * (1        - 2   + 1) - 1)";
        String str4 = " 1    + 2 + 2 + 2 -      1 - 1-  1-(3 / (1           + 1) - 1)";
        String str5 = " 1    + 2 + (3 *        (    1           + 1) - 1                                         )";

        List<String> strings1 = getStringList(str1);
        List<String> strings2 = getStringList(str2);
        List<String> strings3 = getStringList(str3);
        List<String> strings4 = getStringList(str4);
        List<String> strings5 = getStringList(str5);

        String expected1 = Arrays.toString(strings1.toArray());
        String expected2 = Arrays.toString(strings2.toArray());
        String expected3 = Arrays.toString(strings3.toArray());
        String expected4 = Arrays.toString(strings4.toArray());
        String expected5 = Arrays.toString(strings5.toArray());

        Stack<String> stack1 = operatorRepository.getStack(strings1);
        Stack<String> stack2 = operatorRepository.getStack(strings2);
        Stack<String> stack3 = operatorRepository.getStack(strings3);
        Stack<String> stack4 = operatorRepository.getStack(strings4);
        Stack<String> stack5 = operatorRepository.getStack(strings5);

        assertEquals(expected1, stack1.toString());
        assertEquals(expected2, stack2.toString());
        assertEquals(expected3, stack3.toString());
        assertEquals(expected4, stack4.toString());
        assertEquals(expected5, stack5.toString());
    }

    private List<String> getStringList(String str) {
        return Stream.of(str.split(""))
                .filter(o -> !o.equals(" "))
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("두 자리 숫자 스택 테스트")
    public void numbersTest() {
        String str = "10 + 20 + 30 + 44 + 55 / 66 / 77 * ( 10 + 20 * 30 ) - 10 / 10 * ( 10 * 10 * 10 ( 10 - 10 * 10 / 20 ) )";

        String expected = Arrays.toString(str.split(" "));
        Stack<String> stack = operatorRepository.getStack(List.of(str.split("")));

        assertEquals(expected, stack.toString());
    }

    /**
     * 10 + 20 * (20 * (10 / 2) + 3 * ( 1 + 1 ) + 1)
     * 10 20 20 10 2 3 1 1
     *
     * 10 + 20 * (20 * (10 / 2))
     *
     * + *
     * 10 20 20 * 10 / 2 * +
     * 2010
     *
     *
     *
     *
     */
}