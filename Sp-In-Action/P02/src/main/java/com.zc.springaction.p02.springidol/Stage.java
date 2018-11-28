package com.zc.springaction.p02.springidol;

public class Stage
{
    private Stage()
    {
    }

    // 静态内部类
    private static class StageSingletonHolder
    {
        static Stage instance = new Stage();
    }

    public static Stage getInstance()
    {
        return StageSingletonHolder.instance;
    }
}
