package domain;

import java.util.function.BiFunction;

public interface EnumCalculator {

    BiFunction<Integer, String, Integer> calculate(Integer num1, String type, Integer num2);
}
