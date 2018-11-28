package knights;

/**
 * 勇士探险前后,吟游诗人sing,不用aop的实现
 * @author flyingzc
 *
 */
public class BraveKnightNoAOP implements Knight
{
    private Quest quest;

    private Minstrel minstrel;

    public BraveKnightNoAOP(Quest quest, Minstrel minstrel)
    {
        // Quest通过构造函数被注入进来.依赖注入方式1:构造器注入
        this.quest = quest;
        this.minstrel = minstrel;
    }

    public void embarkOnQuest() throws QuestException
    {
        // 骑士执行探险任务之前. 吟游诗人 singBeforeQuest()
        // 但是Kight不应管理Minstrel(吟游诗人)
        minstrel.singBeforeQuest();
        quest.embark();
        minstrel.singAfterQuest();
    }
}
