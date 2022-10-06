package com.emented.weblab2.util;

public class Validator {

    public void validate(String x, String y, String r, String offset) {
        if (x == null || y == null || r == null || offset == null) {
            throw new IllegalArgumentException("Some of parameters are not set!");
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Integer.parseInt(x);
        } catch (NumberFormatException e) {
            stringBuilder.append("X should be an Integer number!").append("\n");
        }
        try {
            Double.parseDouble(y);
        } catch (NumberFormatException e) {
            stringBuilder.append("Y should be an Double number!").append("\n");
        }
        try {
            Integer.parseInt(r);
        } catch (NumberFormatException e) {
            stringBuilder.append("R should be an Integer number!").append("\n");
        }
        try {
            Integer.parseInt(offset);
        } catch (NumberFormatException e) {
            stringBuilder.append("Offset should be an Integer number!").append("\n");
        }
        if (stringBuilder.length() != 0) {
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
