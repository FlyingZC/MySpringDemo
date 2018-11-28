package com.zc.springaction.p02.springidol;

import java.util.Collection;

/**
 * 一人乐队,一个人 可以同时 演奏多种乐器
 * 演示集合的装配
 */
public class OneManBand implements Performer
{
    public OneManBand()
    {
    }

    public void perform() throws PerformanceException
    {
        for (Instrument instrument : instruments)
        {
            instrument.play();
        }
    }

    private Collection<Instrument> instruments;

    public void setInstruments(Collection<Instrument> instruments)
    {
        this.instruments = instruments; //注入乐器集合
    }
}
