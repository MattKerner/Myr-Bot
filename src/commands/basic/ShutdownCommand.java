package commands.basic;

import commands.Command;
import commands.CommandModule;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by SirensBell on 6/1/2017.
 */
public class ShutdownCommand extends Command {

    public ShutdownCommand(CommandModule module) {

        super("shutdown", module);
    }

    @Override protected void doCommand(MessageReceivedEvent event) {


        if(!event.getAuthor().getId().equals("173526747755708416")) {
            return;
        }
        else
            event.getChannel().sendMessage("Goodbye").queue();

        System.exit(0);
    }
}
