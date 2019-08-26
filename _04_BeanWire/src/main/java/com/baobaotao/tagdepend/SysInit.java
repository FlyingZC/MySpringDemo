package com.baobaotao.tagdepend;

public class SysInit {
    public SysInit() {
        System.out.println("SysInit");
        SystemSettings.REFPRESH_CYCLE = 100;
        SystemSettings.SESSION_TIMEOUT = 10;
        System.out.println("SysInit构造器, SysInit对象创建完成");
    }
}
