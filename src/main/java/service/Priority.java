package service;

import domain.Operator;

import java.util.EnumMap;

public class Priority {
    private final EnumMap<Operator, Integer> priorityMap = new EnumMap<>(Operator.class);

    public Priority() {
        priorityMap.put(Operator.ADDITION, 1);
        priorityMap.put(Operator.SUBTRACTION, 1);
        priorityMap.put(Operator.MULTIPLICATION, 2);
        priorityMap.put(Operator.DIVISION, 2);
    }

    public boolean isPriorOrEqual(String symbol1, String symbol2) {
        Operator operator1 = Operator.findOperatorBySymbol(symbol1);
        Operator operator2 = Operator.findOperatorBySymbol(symbol2);
        return priorityMap.get(operator1) >= priorityMap.get(operator2);
    }
}
