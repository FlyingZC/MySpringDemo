package com.zc.springaction.p02.springidol;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class OneManBand3 implements Performer
{
    public OneManBand3()
    {
    }

    public void perform() throws PerformanceException
    {
        for (Entry<Object, Object> every : instruments.entrySet())
        {
            System.out.print(every.getKey() + " : " + every.getValue());
        }
    }

    private Properties instruments;

    public void setInstruments(Properties instruments)
    {
        this.instruments = instruments; //<co id="co_injectInstrumentMap"/>
    }
}
