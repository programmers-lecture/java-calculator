package application.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionTest {
    private static final String SPACE = " ";
    @DisplayName("입력받은 식에서 숫자만 뽑아 List<Integer>로 반환")
    @Test
    void getNumbers() {
        Expression expression1 = new Expression("1 + 2".split(SPACE));
        Expression expression2 = new Expression("1 * 3 / 10".split(SPACE));
        Expression expression3 = new Expression("10 + 7 - 2 * 1 / 5".split(SPACE));

        List<Double> numbers1 = new ArrayList<>();
        numbers1.add(1.0);
        numbers1.add(2.0);

        List<Double> numbers2 = new ArrayList<>();
        numbers2.add(1.0);
        numbers2.add(3.0);
        numbers2.add(10.0);

        List<Double> numbers3 = new ArrayList<>();
        numbers3.add(10.0);
        numbers3.add(7.0);
        numbers3.add(2.0);
        numbers3.add(1.0);
        numbers3.add(5.0);

        assertThat(expression1.getNumbers()).isEqualTo(numbers1);
        assertThat(expression2.getNumbers()).isEqualTo(numbers2);
        assertThat(expression3.getNumbers()).isEqualTo(numbers3);
    }
    @DisplayName("입력받은 식에서 연산자만 뽑아 List<Operator>로 반환")
    @Test
    void getOperators() {
        Expression expression1 = new Expression("1 + 2".split(SPACE));
        Expression expression2 = new Expression("1 - 2".split(SPACE));
        Expression expression3 = new Expression("1 * 2".split(SPACE));
        Expression expression4 = new Expression("1 / 2".split(SPACE));
        Expression expression5 = new Expression("1 + 2 - 3 * 4 / 5".split(SPACE));

        List<Operator> operators1 = new ArrayList<>();
        List<Operator> operators2 = new ArrayList<>();
        List<Operator> operators3 = new ArrayList<>();
        List<Operator> operators4 = new ArrayList<>();
        List<Operator> operators5 = new ArrayList<>();

        operators1.add(Operator.ADDITION);

        operators2.add(Operator.SUBTRACTION);

        operators3.add(Operator.MULTIPLICATION);

        operators4.add(Operator.DIVISION);

        operators5.add(Operator.ADDITION);
        operators5.add(Operator.SUBTRACTION);
        operators5.add(Operator.MULTIPLICATION);
        operators5.add(Operator.DIVISION);

        assertThat(expression1.getOperators()).isEqualTo(operators1);
        assertThat(expression2.getOperators()).isEqualTo(operators2);
        assertThat(expression3.getOperators()).isEqualTo(operators3);
        assertThat(expression4.getOperators()).isEqualTo(operators4);
        assertThat(expression5.getOperators()).isEqualTo(operators5);
    }
}