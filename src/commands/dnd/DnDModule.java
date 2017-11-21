package commands.dnd;

import commands.CommandModule;
import commands.basic.ShutdownCommand;

/**
 * Created by SirensBell on 6/1/2017.
 */
public class DnDModule extends CommandModule {

    public DnDModule() {

        super(null, "");

        //Add commands here
        //this.addCommand(new ShutdownCommand(this));
        this.addCommand(new StatRollerCommand(this));
        this.addCommand(new HPRollerCommand(this));
    }

    @Override protected String getCompleteName() {

        return "";
    }
}