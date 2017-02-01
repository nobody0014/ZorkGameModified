package io.muic.ooc.Test;

import io.muic.ooc.Command.Command;
import io.muic.ooc.Command.CommandParser;
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
    public void executeQuitCommandTrue() throws Exception {
        ZorkRunner zorkRunner = new ZorkRunner("wit");
        Command cmd  = CommandParser.parseInput("quit");

        ZorkView.input = new ByteArrayInputStream("y".getBytes(StandardCharsets.UTF_8));
        Assert.assertFalse(zorkRunner.executeCommand(cmd));
    }

    @Test
    public void executeQuitCommandFalse() throws Exception {
        ZorkRunner zorkRunner = new ZorkRunner("wit");
        Command cmd  = CommandParser.parseInput("quit");

        ZorkView.input = new ByteArrayInputStream("n".getBytes(StandardCharsets.UTF_8));
        Assert.assertTrue(zorkRunner.executeCommand(cmd));
    }

}