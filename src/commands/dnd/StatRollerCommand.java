package commands.dnd;

import commands.Command;
import commands.CommandModule;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.concurrent.ThreadLocalRandom;

public class StatRollerCommand extends Command {

    public StatRollerCommand(CommandModule module) {
        super("RollStats", module);
    }

    private int rollDropDice() {

        int die1 = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        int die2 = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        int die3 = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        int die4 = ThreadLocalRandom.current().nextInt(1, 6 + 1);

        int min1 = Math.min(die1, die2);
        int min2 = Math.min(die3, die4);
        int minimum = Math.min(min1, min2);

        int statTotal = (die1 + die2 + die3 + die4) - minimum;

        return statTotal;
    }

    private String calcModifier(int rolledStat) {

        if(rolledStat ==1)
            return "-5";
        else if(rolledStat >= 2 && rolledStat <= 3)
            return "-4";
        else if(rolledStat >= 4 && rolledStat <= 5)
            return "-3";
        else if(rolledStat >= 6 && rolledStat <= 7)
            return "-2";
        else if(rolledStat >= 8 && rolledStat <= 9)
            return "-1";
        else if(rolledStat >= 10 && rolledStat <= 11)
            return "0";
        else if(rolledStat >= 12 && rolledStat <= 13)
            return "+1";
        else if(rolledStat >= 14 && rolledStat <= 15)
            return "+2";
        else if(rolledStat >= 16 && rolledStat <= 17)
            return "+3";
        else if(rolledStat == 18)
            return "+4";
        else
            return "How did you do that?";

}

    private String returnTotalStats() {

        StringBuilder builder = new StringBuilder();

        int stat;
        int statTotal = 0;

        stat = rollDropDice();
        statTotal += stat;
        builder.append("`Your stats are: ` \n");
        builder.append("`Str: " + stat + " (" + calcModifier(stat) + ")`\n");
        stat = rollDropDice();
        statTotal += stat;
        builder.append("`Dex: " + stat + " (" + calcModifier(stat) + ")`\n");
        stat = rollDropDice();
        statTotal += stat;
        builder.append("`Con: " + stat + " (" + calcModifier(stat) + ")`\n");
        stat = rollDropDice();
        statTotal += stat;
        builder.append("`Int: " + stat + " (" + calcModifier(stat) + ")`\n");
        stat = rollDropDice();
        statTotal += stat;
        builder.append("`Wis: " + stat + " (" + calcModifier(stat) + ")`\n");
        stat = rollDropDice();
        statTotal += stat;
        builder.append("`Cha: " + stat + " (" + calcModifier(stat) + ")`\n");

        if(statTotal < 70)
            builder.append("`Your stat total is less than 70! Feel free to roll again.`");
        return builder.toString();
    }

    @Override
    protected void doCommand(MessageReceivedEvent event) {

        event.getTextChannel().sendMessage(returnTotalStats()).queue();
    }
}
