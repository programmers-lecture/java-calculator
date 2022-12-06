import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CalculatorMain {
    public static void main(String[] args) {
        System.out.println("사칙연산 식을 입력해주세요.");

        Scanner sc = new Scanner(System.in);
        String cal = sc.next();

//30-3*30+30+30*300/30*30  곱하기 곱하기 나누기 곱하기
        int reuslt = 0;
        //우선순위
        while (true) {
            if(cal.indexOf("*") ==-1 && cal.indexOf("/") ==-1 ) break;
            int multiIdx = cal.indexOf("*") == -1 ? cal.length() : cal.indexOf("*");
            int divIdx = cal.indexOf("/") == -1 ? cal.length() : cal.indexOf("/");
            if(multiIdx < divIdx) {
                int idx = cal.indexOf("*");//현재 연산자 인덱스
                int before = beforeFindIdx(cal, idx);
                int after = afterFindIdx(cal, idx);
                String str = cal.substring(before +1, idx) + "*" + cal.substring(idx+1, after);//연산식

                reuslt = Integer.parseInt(cal.substring(before +1, idx)) * Integer.parseInt(cal.substring(idx+1, after));
                cal = cal.replace(str, String.valueOf(reuslt));
            }
            else if(divIdx < multiIdx) {
                int idx = cal.indexOf("/");//현재 연산자 인덱스
                int before = beforeFindIdx(cal, idx);
                int after = afterFindIdx(cal, idx);
                String str = cal.substring(before +1, idx) + "/" + cal.substring(idx+1, after);//연산식

                reuslt = Integer.parseInt(cal.substring(before +1, idx)) / Integer.parseInt(cal.substring(idx+1, after));
                cal = cal.replace(str, String.valueOf(reuslt));
            }


        }
        System.out.println("최종결과 : " + cal);
//60-30+40
        //우선순위 후 차례대로


    }

    public static int beforeFindIdx(String str, int idx) {
        int before = -1;

        //전인덱스
        if(str.lastIndexOf("+", idx-1) > 0) {
            before = str.lastIndexOf("+", idx - 1);
        }
        if (str.lastIndexOf("-", idx-1) > 0) {
            before = str.lastIndexOf("-", idx-1) > before ? str.lastIndexOf("-", idx-1): before;
        }
        if (str.lastIndexOf("*", idx-1) > 0) {
            before = str.lastIndexOf("*", idx-1) > before ? str.lastIndexOf("*", idx-1): before;
        }
        if (str.lastIndexOf("/", idx-1) > 0) {
            before = str.lastIndexOf("/", idx-1) > before ? str.lastIndexOf("/", idx-1): before;
        }
        return before;
    }

    public static int afterFindIdx(String str, int idx) {
        int after = str.length();
        if(str.indexOf("+", idx+1) > 0) {
            after = str.indexOf("+", idx + 1);
        }
        if (str.indexOf("-", idx+1) > 0) {
            after = str.indexOf("-", idx+1) < after ? str.indexOf("-", idx+1): after;
        }
        if (str.indexOf("*", idx+1) > 0) {
            after = str.indexOf("*", idx+1) < after ? str.indexOf("*", idx+1): after;
        }
        if (str.indexOf("/", idx+1) > 0) {
            after = str.indexOf("/", idx+1) < after ? str.indexOf("/", idx+1): after;
        }
        return after;
    }
}
