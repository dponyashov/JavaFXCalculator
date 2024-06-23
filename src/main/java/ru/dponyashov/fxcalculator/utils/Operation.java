package ru.dponyashov.fxcalculator.utils;

public enum Operation {
    EMPTY(""),
    ADDITION(" + "),
    SUBTRACTION(" - "),
    MULTIPLICATION(" * "),
    DIVISION(" / "),
    PERCENT(" % "),
    SQRT(" √ "),
    EXP(" ^ ");

    private final String value;

    Operation(String value){
        this.value = value;
    }

    public String value(){
        return value;
    }
}
