package knights;

/**
 * @author flyingzc
 * 勇士
 */
public class BraveKnight implements Knight
{
    private Quest quest;

    public BraveKnight(Quest quest)
    {
        // Quest通过构造函数被注入进来.依赖注入方式1:构造器注入
        this.quest = quest;
    }

    public void embarkOnQuest() throws QuestException
    {
        quest.embark();
    }
}
