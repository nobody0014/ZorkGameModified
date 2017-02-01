package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Look extends Command {
    String point;

    public Look(String point){
        this.point = point;
    }

    /**
     * Look at a chance item?
     * Probably not implemented
     */
    @Override
    public void execute() {

    }
}
