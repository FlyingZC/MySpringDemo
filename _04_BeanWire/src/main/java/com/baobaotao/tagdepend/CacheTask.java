package com.baobaotao.tagdepend;

import java.util.TimerTask;

public class CacheTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("doing clean cache");
    }
}
