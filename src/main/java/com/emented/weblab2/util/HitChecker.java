package com.emented.weblab2.util;

public class HitChecker {

    public boolean checkHit(int x, double y, int r) {
        return checkSquare(x, y, r) ||
                checkTriangle(x, y, r) ||
                checkCircle(x, y, r);
    }

    private boolean checkSquare(int x, double y, int r) {
        return x >= 0 &&
                x <= r &&
                y >= 0 &&
                y <= (double) r / 2;
    }

    private boolean checkTriangle(int x, double y, int r) {
        return x <= 0 &&
                y >= 0 &&
                y <= (double) x / 2 + (double) r / 2;
    }

    private boolean checkCircle(int x, double y, int r) {
        return x >= 0 &&
                y <= 0 &&
                Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow((double) r / 2, 2);
    }
}
