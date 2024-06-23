package ru.dponyashov.fxcalculator.fxcontroller;

import ru.dponyashov.fxcalculator.calculator.Calculator;
import ru.dponyashov.fxcalculator.exception.CalculatorException;
import ru.dponyashov.fxcalculator.utils.Operation;

public class CalculatorController {
    private final Calculator calculator;
    private String savedResult;
    private final StringBuilder currentString;
    private Operation currentOperation;

    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
        currentString = new StringBuilder();
        currentOperation = Operation.EMPTY;
        savedResult = "";
    }

    public String receiveDigit(String digit) {
        if(currentString.toString().equals("0") && !digit.equals(".")){
            currentString.deleteCharAt(0);
        }
        if(digit.equals(".")) {
            if (currentString.toString().contains(".")) {
                return returnString();
            }
            if (currentString.isEmpty()) {
                currentString.append("0");
            }
        }
        currentString.append(digit);
        return returnString();
    }

    private String returnString() {
        StringBuilder result = new StringBuilder();
        if (currentOperation != Operation.EMPTY) {
            if (!savedResult.isEmpty()) {
                result.append(savedResult);
            } else {
                result.append(0);
            }
            result.append(currentOperation.value());
        }
        if (!currentString.isEmpty()){
            result.append(currentString.toString());
        }
        return result.toString();
    }

    public String receiveOperation(String operation){
        switch(operation){
            case "AC":{
                if(!currentString.isEmpty()){// && !currentString.toString().equals("0")
                    deleteLastSymbol(currentString);
                } else {
                    currentOperation = Operation.EMPTY;
                    replaceSavedWithCurrent();
                }
                break;
            }
            case "√":{
                executeCurrentOperation();
                currentOperation = Operation.SQRT;
                break;
            }
            case "X^y":{
                executeCurrentOperation();
                currentOperation = Operation.EXP;
                break;
            }
            case "%":{
                executeCurrentOperation();
                currentOperation = Operation.PERCENT;
                break;
            }
            case "+":{
                executeCurrentOperation();
                currentOperation = Operation.ADDITION;
                break;
            }
            case "-":{
                executeCurrentOperation();
                currentOperation = Operation.SUBTRACTION;
                break;
            }
            case "*":{
                executeCurrentOperation();
                currentOperation = Operation.MULTIPLICATION;
                break;
            }
            case "/":{
                executeCurrentOperation();
                currentOperation = Operation.DIVISION;
                break;
            }
            case "=":{
                executeCurrentOperation();
                currentOperation = Operation.EMPTY;
                replaceSavedWithCurrent();
            }
        }
        return returnString();
    }

    private void replaceSavedWithCurrent() {
        currentString.delete(0, currentString.length());
        currentString.append(savedResult);
        savedResult = "";
    }

    private void executeCurrentOperation(){
        if(currentString.isEmpty()){
            return;
        }
        double variable1 = convertStringToDouble(savedResult);
        double variable2 = convertStringToDouble(currentString.toString());
        switch (currentOperation) {
            case EMPTY -> savedResult = currentString.toString();
            case ADDITION -> savedResult = prepareDoubleForOutput(calculator.addition(variable1, variable2));
            case SUBTRACTION -> savedResult = prepareDoubleForOutput(calculator.subtraction(variable1, variable2));
            case MULTIPLICATION -> savedResult = prepareDoubleForOutput(calculator.multiplication(variable1, variable2));
            case DIVISION -> savedResult = prepareDoubleForOutput(calculator.division(variable1, variable2));
            case PERCENT -> savedResult = prepareDoubleForOutput(calculator.percent(variable1, variable2));
            case SQRT -> savedResult = prepareDoubleForOutput(calculator.sqrt(variable1, variable2));
            case EXP -> savedResult = prepareDoubleForOutput(calculator.pow(variable1, variable2));
        }
        currentString.delete(0, currentString.length());
    }

    private void deleteLastSymbol(StringBuilder sb) {
        sb.deleteCharAt(sb.length() - 1);
    }

    private double convertStringToDouble(String value) {
        if (value.isEmpty()) {
            return 0;
        }
        if (value.endsWith(".")) {
            throw new CalculatorException("Неверный ввод");
        }
        try{
            return Double.parseDouble(value);
        } catch(Exception e) {
            throw new CalculatorException("Неверный ввод");
        }
    }

    private String prepareDoubleForOutput(double value){
        int decimals = 1000000;
        return deleteEmptyDecimal((double) Math.round(value * decimals) / decimals);
    }

    private String deleteEmptyDecimal(double value){
        long integerPart = Math.round(value);

        if (integerPart == value) {
            return String.valueOf(integerPart);
        }
        return String.valueOf(value);
    }
}
