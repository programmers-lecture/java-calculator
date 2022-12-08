import java.util.ArrayList;
import java.util.List;

public class Result {
    private static final Integer initResult = 0;
    private List<Integer> resultList = new ArrayList<>();

    public Result() {
        resultList.add(initResult);
    }

    public int resultListLastNumber() {
        return resultList.size() - 1;
    }

    public void addResultList(Integer resultNumber) {
        resultList.add(resultNumber);
    }

    public Integer getResult(int index) {
        return resultList.get(index);
    }
}
