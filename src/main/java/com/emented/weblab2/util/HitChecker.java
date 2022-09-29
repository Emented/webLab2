package com.emented.weblab2.util;

public class HitChecker {

    public boolean checkHit(int x, double y, int r) {
        return checkSquare(x, y, r) || checkTriangle(x, y, r) || checkCircle(x, y, r);
    }

    private boolean checkSquare(int x, double y, int r) {
        return true;
    }

    private boolean checkTriangle(int x, double y, int r) {
        return true;
    }

    private boolean checkCircle(int x, double y, int r) {
        return true;
    }
}
