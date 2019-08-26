package com.zc.context.cycle.construct;

public class CircularityB {
    private CircularityC circularityC;

    public CircularityB() {
    }

    public CircularityB(CircularityC circularityC) {
        this.circularityC = circularityC;
    }

    public void b() {
        circularityC.c();
    }
}  