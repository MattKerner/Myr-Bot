package commands.basic;

import commands.Command;
import commands.CommandModule;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HelpCommand extends Command {
    public HelpCommand(CommandModule module) {
        super("Help", module);
    }

    private String informUser() {
        String inform = "Here is a list of all my current commands! \n\n";
        return inform;
    }

    private String commandList() {
        StringBuilder builder = new StringBuilder();

        builder.append("```");
        builder.append("!rollstats - this generates stats for DnD characters! \n");
        builder.append("!shutdown - this shuts me down! (Only Matt can use this command.)");
        builder.append("```");

        return builder.toString();
    }

    @Override
    protected void doCommand(MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(informUser()).queue();
        event.getTextChannel().sendMessage(commandList()).queue();

    }
}
