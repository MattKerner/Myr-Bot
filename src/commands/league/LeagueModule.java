package commands.league;

import commands.CommandModule;
import commands.basic.ShutdownCommand;

/**
 * Created by SirensBell on 6/1/2017.
 */
public class LeagueModule extends CommandModule {

    public LeagueModule() {

        super(null, "");

        //Add commands here
        //this.addCommand(new ShutdownCommand(this));
    }

    @Override protected String getCompleteName() {

        return "";
    }
}