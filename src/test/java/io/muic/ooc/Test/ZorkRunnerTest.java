package io.muic.ooc.Test;

import io.muic.ooc.MainLoop.ZorkRunner;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wit on 1/30/2017 AD.
 */
public class ZorkRunnerTest {
    @Test
    public void executeCommand() throws Exception {
        ZorkRunner zorkRunner = new ZorkRunner();
        String[] inputs = new String[3];

//        inputs[0] = "quit";
//        Assert.assertTrue(zorkRunner.executeCommand(inputs));

        inputs[0] = "help";
        Assert.assertTrue(zorkRunner.executeCommand(inputs));

        inputs[0] = "go";
        inputs[1] = "north";

    }

}