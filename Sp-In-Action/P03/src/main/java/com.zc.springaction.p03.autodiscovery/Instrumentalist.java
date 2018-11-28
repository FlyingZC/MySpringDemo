package com.zc.springaction.p03.autodiscovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
// 使用@Component注解定义一个Bean,并显式命名为eddie
@Component("eddie")
@Qualifier("guitar")
public class Instrumentalist implements Performer
{
    // ...
    public void perform() throws PerformanceException
    {
        instrument.play();
    }
    // 使用@Autowired注解实现属性的依赖注入
    @Autowired
    // 使用@Qualifier指定注入Bean的名称
    // @Qualifier("instrument")
    private Instrument instrument;

    public Instrument getInstrument()
    {
        return instrument;
    }
    //@Autowired
    public void setInstrument(Instrument instrument)
    {
        this.instrument = instrument;
    }
}
