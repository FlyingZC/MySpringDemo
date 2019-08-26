package com.zc.context.cycle.setter;

public class CircularityC {
    private CircularityA circularityA;

    public CircularityC() {
    }

    public void setCircularityA(CircularityA circularityA) {
        this.circularityA = circularityA;
    }

    public void c() {
        circularityA.a();
    }
}  