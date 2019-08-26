package com.zc.context.cycle.construct;

public class CircularityC {
    private CircularityA circularityA;

    public CircularityC() {
    }

    public CircularityC(CircularityA circularityA) {
        this.circularityA = circularityA;
    }

    public void c() {
        circularityA.a();
    }
}  