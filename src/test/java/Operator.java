public enum Operator {
    PLUS("+"), MINUS("-"), MULTIPLE("*"), DIVISOIN("/");
    private String operator;

    Operator(String operator){
        this.operator = operator;
    }

    public String getOperator(){
        return this.operator;
    }

}
