package com.zc.context.cycle.construct;

public class CircularityA {
    private CircularityB circularityB;

    public CircularityA() {
    }

    public CircularityA(CircularityB circularityB) {
        this.circularityB = circularityB;
    }

    public void a() {
        circularityB.b();
    }
}