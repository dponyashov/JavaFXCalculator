package ru.dponyashov.fxcalculator.calculator;

public interface Calculator {
    double addition(double variable1, double variable2);

    double subtraction(double variable1, double variable2);

    double multiplication(double variable1, double variable2);

    double division(double variable1, double variable2);

    double percent(double variable1, double variable2);

    double sqrt(double variable1, double variable2);

    double pow(double variable1, double variable2);
}
