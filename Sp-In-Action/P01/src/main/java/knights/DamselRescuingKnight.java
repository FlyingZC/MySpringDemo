package knights;

/**
 * 拯救少女的勇士
 * damsel : 少女
 */
public class DamselRescuingKnight implements Knight
{
    private RescueDamselQuest quest;

    public DamselRescuingKnight()
    {
        // 与RescueDamselQuest耦合紧密
        quest = new RescueDamselQuest();
    }

    public void embarkOnQuest() throws QuestException
    {
        quest.embark();
    }
}
