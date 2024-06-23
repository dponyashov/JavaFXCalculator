package ru.dponyashov.fxcalculator.calculator;

import ru.dponyashov.fxcalculator.exception.CalculatorException;

public class CalculatorImpl implements Calculator {

    @Override
    public double addition(double variable1, double variable2) {
        return variable1 + variable2;
    }

    @Override
    public double subtraction(double variable1, double variable2) {
        return variable1 - variable2;
    }

    @Override
    public double multiplication(double variable1, double variable2) {
        return variable1 * variable2;
    }

    @Override
    public double division(double variable1, double variable2) {
        if(variable2 == 0.0){
            throw new CalculatorException("Деление на ноль");
        }
        return variable1 / variable2;
    }

    @Override
    public double percent(double variable1, double variable2) {
        return variable1 / variable2 * 100;
    }

    @Override
    public double sqrt(double variable1, double variable2) {
        int roundDecimals = 1000000;
        return ((double) Math.round(Math.pow(variable1, 1.0 / variable2) * roundDecimals))/ roundDecimals;
    }

    @Override
    public double pow(double variable1, double variable2) {
        return Math.pow(variable1, variable2);
    }
}
