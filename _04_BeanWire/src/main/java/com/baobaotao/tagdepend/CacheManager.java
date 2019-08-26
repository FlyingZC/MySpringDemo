package com.baobaotao.tagdepend;

import java.util.Timer;
import java.util.TimerTask;

public class CacheManager {
    public CacheManager() {
        System.out.println("CacheManager构造器,该构造器会在SysInit创建完成后再调用");
        Timer timer = new Timer();
        TimerTask cacheTask = new CacheTask();
        timer.schedule(cacheTask, 0, SystemSettings.REFPRESH_CYCLE);
    }
}
