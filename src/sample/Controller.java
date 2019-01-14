package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Controller {
    @FXML
    public TextField txtData;
    @FXML
    private Label lblMemory;
    private Calculator calculator;
    private boolean isSecondNumber;

    public Controller() {
        txtData = new TextField();
        calculator = new Calculator();
        isSecondNumber = false;
    }

    private String delZeroAndEnd(String input){
        return input.endsWith("0") ? input.substring(0, input.length() - 2) : input ;
    }

    public void btnCommaClick(ActionEvent actionEvent) {
        txtData.setText(txtData.getText() + (!txtData.getText().contains(".")? "." : ""));
        calculator.isFirstCalc = true;
    }

    public void btnNumberClick(ActionEvent actionEvent) {
        String btnText = ((Button) actionEvent.getSource()).getText();
        txtData.setText(txtData.getText().equals("0") || (isSecondNumber == true) ? btnText : txtData.getText() + btnText);
        isSecondNumber = false;
        calculator.isFirstCalc = true;
    }

    public void btnSignClick(ActionEvent actionEvent) {
        txtData.setText(delZeroAndEnd(String.valueOf(-1 * Double.parseDouble(txtData.getText()))));
        calculator.isFirstCalc = true;
    }

    public void btnOperationClick(ActionEvent actionEvent) {
        try {
            calculator.number1 = Double.parseDouble(txtData.getText());
            switch (((Button) actionEvent.getSource()).getText()){
                case "+":
                    calculator.operator = 1;
                    break;
                case "-":
                    calculator.operator = 2;
                    break;
                case "*":
                    calculator.operator = 3;
                    break;
                case "/":
                    calculator.operator = 4;
                    break;
                case "x^y":
                    calculator.operator = 5;
                    break;
                case "√":
                    calculator.operator = 6;
                    calculator.calculate();
                    txtData.setText(delZeroAndEnd(calculator.result));
                    break;
                case "1/x":
                    calculator.operator = 7;
                    break;
                    default:
                        calculator.operator = 0;
            }
            isSecondNumber = true;
            calculator.isFirstCalc = true;
        } catch (NumberFormatException ex)
        {
            txtData.setText("Number conversion error");
        } catch (Exception ex)
        {
            txtData.setText(ex.getMessage());
        }

    }

    public void btnResultClick(ActionEvent actionEvent) {
        try{
            if (calculator.isFirstCalc){
                calculator.number2 = Double.parseDouble(txtData.getText());
            }
        }catch (NumberFormatException ex){
            txtData.setText("Number conversion error");
        }catch (Exception ex){
            txtData.setText(ex.getMessage());
        }
        calculator.calculate();
        calculator.number1 = Double.parseDouble(calculator.result);
        calculator.isFirstCalc = false;
        txtData.setText(calculator.result);
    }

    public void btnMemoryClearClick(ActionEvent actionEvent) {
        calculator.setMemory(0);
        isSecondNumber = true;
        lblMemory.setVisible(false);

    }

    public void btnMemoryReadClick(ActionEvent actionEvent) {
        txtData.setText(delZeroAndEnd(String.valueOf(calculator.getMemory())));
        isSecondNumber = true;
    }

    public void btnMemoryAddClick(ActionEvent actionEvent) {
        double memory = 0;
        try{
            memory = Double.parseDouble(txtData.getText());
        }catch (NumberFormatException ex) {
            txtData.setText("Number conversion error");
            return;
        }
        calculator.setMemory(calculator.getMemory() + memory);
        isSecondNumber = true;
        lblMemory.setVisible(calculator.getMemory() != 0 ? true : false);
    }

    public void btnMemorySubClick(ActionEvent actionEvent) {
        double memory = 0;
        try{
            memory = Double.parseDouble(txtData.getText());
        }catch (Exception ex) {
            txtData.setText("Number conversion error");
            return;
        }
        calculator.setMemory(calculator.getMemory() - memory);
        isSecondNumber = true;
        lblMemory.setVisible(calculator.getMemory() != 0 ? true : false);

    }

    public void btnClearClick(ActionEvent actionEvent) {
        txtData.setText("0");
        calculator.isFirstCalc = true;
    }

    public void buttonPressed(KeyEvent keyEvent) {
        txtData.setText(txtData.getText() + (keyEvent.getText().contains("0") ? keyEvent.getText() : ""));
        //
    }
}
