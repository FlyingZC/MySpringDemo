package com.zc.context.cycle.setter;

public class CircularityA {
    private CircularityB circularityB;

    public CircularityA() {
    }

    public void setCircularityB(CircularityB circularityB) {
        this.circularityB = circularityB;
    }

    public void a() {
        circularityB.b();
    }
}