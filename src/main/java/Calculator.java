import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import javax.swing.*;


public class Calculator extends JFrame {//계산기 GUI 구현을 위해 JFrame 상속

    public static void main(String[] args) {
        new Calculator();
    }

    private JTextField inputSpace;

    private String num = "";
    private ArrayList<String> equation = new ArrayList<>();

    public Calculator() {
        /*========================= Calculator Layout Setting Start =========================*/
        setLayout(null);
        setTitle("Integer Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 500);
        setVisible(true);

        inputSpace = new JTextField();

        inputSpace.setEditable(false);
        inputSpace.setHorizontalAlignment(JTextField.RIGHT);
        inputSpace.setBackground(Color.WHITE);
        inputSpace.setFont(new Font("Arial", Font.BOLD, 20));
        inputSpace.setBounds(10, 10, 280, 70);

        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        buttonPanel.setBounds(10, 90, 280, 280);

        String buttonNames[] = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "C", "=", "/"};
        JButton buttons[] = new JButton[buttonNames.length];

        for(int i = 0; i < buttonNames.length; i++) {
            buttons[i] = new JButton(buttonNames[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 20));

            buttons[i].setBorderPainted(false);
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setForeground(Color.WHITE);

            if(buttonNames[i] == "C") {
                buttons[i].setBackground(Color.RED);
            }

            buttons[i].addActionListener(new ButtonActionListener());

            buttonPanel.add(buttons[i]);
        }

        add(inputSpace);
        add(buttonPanel);
        /*========================= Calculator Layout Setting End =========================*/

    }

    //접근제한자가 default 인 클래스. 클래스 내부에서만 사용할 새로운 inner class 를 만드는데 사용함.
    class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            //내가 누른 키의 값을 가져온다.
            String buttonOperation = e.getActionCommand();

            //C버튼을 누르면 모든 값을 초기화한다.
            if(buttonOperation == "C") {
                inputSpace.setText("");
            } else if(buttonOperation == "=") { //등호를 만나면 계산 함수를 호출한다.
                String result = Integer.toString(calculate(inputSpace.getText()));
                inputSpace.setText(result);
                num = "";
            } else {// C나 = 이 아닐 경우에는 버튼이 눌릴 때마다 입력창에 하나씩 더해나간다.
                inputSpace.setText(inputSpace.getText() + buttonOperation);
            }
        }
    }

    //입력된 전체 텍스트를 파싱하는 함수
    public void parseEntireText(String input) {
        //배열을 초기화 한다.
        equation.clear();

        //입력값의 길이만큼 반복문을 돌리면서, 숫자인지 연산자인지를 구분한다.
        for(int i=0; i<input.length(); i++) {

            //숫자가 아닌 문자가 나오면 숫자를 equation 에 넣고 num 을 초기화한다.
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
                equation.add(num);
                equation.add(Character.toString(input.charAt(i)));
                num = "";
            } else {
                num += input.charAt(i);
            }
        }
        equation.add(num);
    }

    public boolean isNumberString(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int calculate(String input) {

        parseEntireText(input);

        int prev = 0;
        int curr = 0;

        int first;
        int second;
        int result;

        String mode = "";

        for(int i=0; i<equation.size(); i++) {
            String s = equation.get(i);

            if(s=="+"){
                mode = "add";
            }
            if(s=="-"){
                mode = "sub";
            }
            if(s=="*"){
                mode = "mul";
            }
            if(s=="/"){
                mode = "div";
            }

            if(mode == "mul" && isNumberString(s)){
                first  = Integer.parseInt(equation.get(i-2));
                second = Integer.parseInt(equation.get(i));
                result = first * second;

                equation.add(i+1, Integer.toString(result));
                equation.remove(i-2);
                i-=2;
            }
        }

        for(String s : equation) {
            switch(s) {
                case "+":
                    mode = "add";
                    break;
                case "-":
                    mode = "sub";
                    break;

                case "*":
                    mode = "mul";
                    break;

                case "/":
                    mode = "div";
                    break;

                default:
                    mode = null;
                    curr = Integer.parseInt(s);

                    if(mode == "add") {
                        prev += curr;
                    }

                    if(mode == "sub") {
                        prev -= curr;
                    }

                    if(mode == null) {
                        prev = curr;
                    }
            }
        }

        return prev;
    }
}
