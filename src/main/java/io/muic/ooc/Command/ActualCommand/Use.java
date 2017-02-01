package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Use extends Command {

    String consumableName;
    public Use(String consumableName){
        this.consumableName = consumableName;
    }

    /**
     * Use the consumable if possible --> works only with consumable
     */
    @Override
    public void execute() {

    }
}
