package com.zc.springaction.p02.springidol;

/**
 * @author flyingzc
 * 杂技师,默认可以同时抛3个豆袋子
 */
public class Juggler implements Performer
{
    /**
     * 个豆袋子 数目
     */
    private int beanBags = 3;

    public Juggler()
    {
        System.out.println("Juggler的无参构造器");
    }

    public Juggler(int beanBags)
    {
        this.beanBags = beanBags;
        System.out.println("Juggler的有参构造器");
    }

    public void perform() throws PerformanceException
    {
        System.out.println("JUGGLING " + beanBags + " BEANBAGS");
    }
}
