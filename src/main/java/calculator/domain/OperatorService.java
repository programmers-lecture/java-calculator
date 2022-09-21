package calculator.domain;

import java.util.Arrays;

public class OperatorService {

  public Operator findOperator(String symbol){
    return Arrays.asList(Operator.values())
        .stream()
        .filter(s->s.getSymbol().equals(symbol))
        .findFirst()
        .get();
  }

  public int findPriority(String symbol){
    return findOperator(symbol).getPriority();
  }
}
