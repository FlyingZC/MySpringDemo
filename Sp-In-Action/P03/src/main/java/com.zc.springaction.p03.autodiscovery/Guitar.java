package com.zc.springaction.p03.autodiscovery;

import org.springframework.stereotype.Component;

@Component
public class Guitar implements Instrument
{
    public void play()
    {
        System.out.println("Strum strum strum");
    }
}
