package sample;

public class Calculator {

    double number1;
    double number2;
    byte operator;
    String result;
    boolean isFirstCalc;
    private double memory;

    public Calculator() {
        number1 = 0;
        number2 = 0;
        operator = 0;
        result = "0";
        isFirstCalc = true;
    }

    public void calculate(){
        switch (operator){
            case 1 : // +
                result = String.valueOf(number1 + number2);
                break;
            case 2 : // -
                result = String.valueOf(number1 - number2);
                break;
            case 3 : // *
                result = String.valueOf(number1 * number2);
                break;
            case  4 : // /
                result = String.valueOf(number1 / number2);
                break;
            case  5 : // x^y
                result = String.valueOf(Math.pow(number1, number2));
                break;
            case 6 : // sqrt()
                result = number1 < 0? "No SQRT From negative" : String.valueOf(Math.sqrt(number1));
                break;
                default:
                    result = "Unknown operation";
        }
        result = result.endsWith("0")?result.substring(0, result.length() - 2) : result;
    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public byte getOperator() {
        return operator;
    }

    public void setOperator(byte operator) {
        this.operator = operator;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setFirstCalc(boolean firstCalc) {
        isFirstCalc = firstCalc;
    }

    public boolean isFirstCalc() {
        return isFirstCalc;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }
}
