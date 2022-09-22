package domain;

import java.util.EnumMap;

public class Priority {
    private final EnumMap<Operator, Integer> priorityMap = new EnumMap<>(Operator.class);

    public Priority() {
        priorityMap.put(Operator.ADDITION, 1);
        priorityMap.put(Operator.SUBTRACTION, 1);
        priorityMap.put(Operator.MULTIPLICATION, 2);
        priorityMap.put(Operator.DIVISION, 2);
    }

    public boolean isPrior(String operator1, String operator2) {
        return priorityMap.get(operator1) > priorityMap.get(operator2);
    }
}
