package com.zc.springaction.p03.autodiscovery;

/**
 * 音乐演奏家, 演示setter注入
 */
public class Instrumentalist1 implements Performer
{
    public Instrumentalist1()
    {
    }

    public void perform() throws PerformanceException
    {
        System.out.print("Playing " + song + " : ");
        instrument.play();
    }

    private String song;

    public void setSong(String song)
    {
        // 注入song
        this.song = song;
    }

    public String getSong()
    {
        return song;
    }

    public String screamSong()
    {
        return song;
    }

    private Instrument instrument;

    public void setInstrument(Instrument instrument)
    {
        // 注入 instrument
        this.instrument = instrument;
    }

    public Instrument getInstrument()
    {
        return instrument;
    }
    
    
}
