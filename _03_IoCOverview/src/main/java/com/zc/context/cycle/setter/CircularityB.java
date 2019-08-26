package com.zc.context.cycle.setter;

public class CircularityB {
    private CircularityC circularityC;

    public CircularityB() {
    }

    public void setCircularityC(CircularityC circularityC) {
        this.circularityC = circularityC;
    }

    public void b() {
        circularityC.c();
    }
}  