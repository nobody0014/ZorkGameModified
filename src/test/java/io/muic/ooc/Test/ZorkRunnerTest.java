package io.muic.ooc.Test;

import io.muic.ooc.MainLoop.ZorkRunner;
import io.muic.ooc.MainLoop.ZorkView;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

/**
 * Created by wit on 1/30/2017 AD.
 */
public class ZorkRunnerTest {
    @Test
    public void executeCommand() throws Exception {
        ZorkRunner zorkRunner = new ZorkRunner("wit");
        String[] inputs = new String[3];

        inputs[0] = "quit";

        ZorkView.input = new ByteArrayInputStream("y".getBytes(StandardCharsets.UTF_8));
        Assert.assertFalse(zorkRunner.executeCommand(inputs));

        ZorkView.input = new ByteArrayInputStream("n".getBytes(StandardCharsets.UTF_8));
        Assert.assertTrue(zorkRunner.executeCommand(inputs));

        inputs[0] = "help";
        Assert.assertTrue(zorkRunner.executeCommand(inputs));

        inputs[0] = "go";
        inputs[1] = "north";
    }

}