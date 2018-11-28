package com.zc.springaction.p02.springidol;

/**
 * @author flyingzc
 * 门票
 */
public class Ticket
{
    public void globalInit()
    {
        System.out.println("Ticket类中的default-init-method");
    }
    
    public void globalDestroy()
    {
        System.out.println("Ticket类中的default-destroy-method");
    }
    
}
