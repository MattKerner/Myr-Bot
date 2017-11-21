package commands.dnd;

import commands.Command;
import commands.CommandModule;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HPRollerCommand extends Command {
    public HPRollerCommand(CommandModule module) {
        super("rollhp", module);
    }

    private String rollHealth(int level, String hitDie, int conMod) {
        boolean hasRunOnce = false;
        StringBuilder builder = new StringBuilder();
        int hp = 0;
        int hpVal = 0;

        if(level == 0)
            return "`Sorry, 0 is not a valid level!`";
        else if(conMod <= -6)
            return "`Sorry, your constitution modifier is too low!`";
        else if(conMod >= 8)
            return "`Sorry, your constitution modifier is too high!`";

        else if (hitDie.equalsIgnoreCase("d6")) {
            for (int i = 0; i < level; i++) {
                if (!hasRunOnce) {
                    hp += 6 + conMod;
                    hasRunOnce = true;
                    continue;
                }
                hpVal += ThreadLocalRandom.current().nextInt(1, 6 + 1);
                if (hpVal < 4) {
                    hp += 4 + conMod;
                    hpVal = 0;
                } else {
                    hp += hpVal + conMod;
                    hpVal = 0;
                }
            }
        }
        else if (hitDie.equalsIgnoreCase("d8")) {
            for (int i = 0; i < level; i++) {
                if (!hasRunOnce) {
                    hp += 8 + conMod;
                    hasRunOnce = true;
                    continue;
                }
                hpVal += ThreadLocalRandom.current().nextInt(1, 8 + 1);
                if (hpVal < 5) {
                    hp += 5 + conMod;
                    hpVal = 0;
                } else {
                    hp += hpVal + conMod;
                    hpVal = 0;
                }
            }
        }
        else if (hitDie.equalsIgnoreCase("d10")) {
            for (int i = 0; i < level; i++) {
                if (!hasRunOnce) {
                    hp += 10 + conMod;
                    hasRunOnce = true;
                    continue;
                }
                hpVal += ThreadLocalRandom.current().nextInt(1, 10 + 1);
                if (hpVal < 6) {
                    hp += 6 + conMod;
                    hpVal = 0;
                } else {
                    hp += hpVal + conMod;
                    hpVal = 0;
                }
            }
        }
        else if (hitDie.equalsIgnoreCase("d12")) {
            for (int i = 0; i < level; i++) {
                if (!hasRunOnce) {
                    hp += 12 + conMod;
                    hasRunOnce = true;
                    continue;
                }
                hpVal += ThreadLocalRandom.current().nextInt(1, 12 + 1);
                if (hpVal < 7) {
                    hp += 7 + conMod;
                    hpVal = 0;
                } else {
                    hp += hpVal + conMod;
                    hpVal = 0;
                }
            }
        }
        else
            return "`Sorry, your hit die is incorrect!`";

        builder.append("`Your HP at level " + level + " is: ");
        builder.append(hp + "`");

        return builder.toString();
    }

    @Override
    protected void doCommand(MessageReceivedEvent event) {

        String[] input = event.getMessage().getContent().substring(1).split(" ");
        int level = Integer.parseInt(input[1]);
        String hitDie = input[2];
        int conMod = Integer.parseInt(input[3]);
        event.getTextChannel().sendMessage(rollHealth(level, hitDie, conMod)).queue();

    }

}