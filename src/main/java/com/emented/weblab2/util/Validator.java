package com.emented.weblab2.util;

public class Validator {

    public void validate(String x, String y, String r, String offset) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Integer.parseInt(x);
        } catch (NumberFormatException e) {
            stringBuilder.append("Failed to parse x!").append("\n");
        }
        try {
            Double.parseDouble(y);
        } catch (NumberFormatException e) {
            stringBuilder.append("Failed to parse y!").append("\n");
        }
        try {
            Integer.parseInt(r);
        } catch (NumberFormatException e) {
            stringBuilder.append("Failed to parse r!").append("\n");
        }
        try {
            Integer.parseInt(offset);
        } catch (NumberFormatException e) {
            stringBuilder.append("Failed to parse offset!").append("\n");
        }
        if (stringBuilder.length() != 0) {
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
