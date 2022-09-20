package calculator;

import java.util.Optional;
import java.util.List;

public interface Calculator {

    Optional<Integer> getResult(List<String> formulaList);
}
