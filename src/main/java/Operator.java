public enum Operator{
    PLUE("+"){
        @Override
        public Integer calculate(Integer a, Integer b) {
            return a+b;
        }
    },
    MINUE("-") {
        @Override
        public Integer calculate(Integer a, Integer b) {
            return a-b;
        }
    },
    DIVIDE("/"){
        @Override
        public Integer calculate(Integer a, Integer b) {
            return return a/b;
        }
    },
    MULTIPLE("*"){
        @Override
        public Integer calculate(Integer a, Integer b) {
            return a*b;
        }
    };
    
    private String operation;
    
    Operator(String operation){
        this.operation=operation;
    }
    public abstract Integer calculate(Integer a, Integer b);

    public String getOperation(){
        return operation;
    }
}