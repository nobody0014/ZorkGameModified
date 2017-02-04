package io.muic.ooc.Test;

import io.muic.ooc.Command.Command;
import io.muic.ooc.Command.CommandParser;
import io.muic.ooc.MainLoop.ZorkGame;
import io.muic.ooc.MainLoop.ZorkRunner;
import io.muic.ooc.MainLoop.ZorkView;
import io.muic.ooc.RoomAndLevel.Level;
import io.muic.ooc.RoomAndLevel.LevelFactory;
import io.muic.ooc.Unit.Player;
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

    @Test
    public void executeMoveRoomInHub() throws Exception {
        ZorkRunner zorkRunner = new ZorkRunner("wit");
        Command cmd  = CommandParser.parseInput("go north");

        Assert.assertTrue(zorkRunner.executeCommand(cmd));
        Assert.assertSame("hub", zorkRunner.getCurrentLevel().getLevelName());
    }

    @Test
    public void executeMoveToForestLevel() throws Exception {
        ZorkRunner zorkRunner = new ZorkRunner("wit");
        Command cmd  = CommandParser.parseInput("go forest");

        Assert.assertTrue(zorkRunner.executeCommand(cmd));
        Assert.assertSame("forest", zorkRunner.getCurrentLevel().getLevelName());
    }

    @Test
    public void executeMoveBackToHubLevel() throws Exception {
        ZorkRunner zorkRunner = new ZorkRunner("wit");
        Command cmd  = CommandParser.parseInput("go hub");

        Assert.assertTrue(zorkRunner.executeCommand(cmd));
        Assert.assertSame("hub", zorkRunner.getCurrentLevel().getLevelName());
    }

    @Test
    public void executeMoveToForestLevelGoSouth() throws Exception {
        ZorkRunner zorkRunner = new ZorkRunner("wit");
        Command cmd  = CommandParser.parseInput("go forest");

        Assert.assertTrue(zorkRunner.executeCommand(cmd));

        cmd  = CommandParser.parseInput("go south");
        Assert.assertTrue(zorkRunner.executeCommand(cmd));
        Assert.assertSame(0, zorkRunner.getCurrentLevel().getPlayerX());
        Assert.assertSame(1, zorkRunner.getCurrentLevel().getPlayerY());

    }

    @Test
    public void executeMoveToForestLevelGoEast() throws Exception {
        ZorkRunner zorkRunner = new ZorkRunner("wit");
        Command cmd  = CommandParser.parseInput("go forest");

        zorkRunner.executeCommand(cmd);

        cmd  = CommandParser.parseInput("go east");
        zorkRunner.executeCommand(cmd);
        Assert.assertSame(1, zorkRunner.getCurrentLevel().getPlayerX());
        Assert.assertSame(0, zorkRunner.getCurrentLevel().getPlayerY());
    }

    @Test
    public void executeMoveToForestLevelGoEastGoEast() throws Exception {
        ZorkRunner zorkRunner = new ZorkRunner("wit");
        Command cmd  = CommandParser.parseInput("go forest");

        Assert.assertTrue(zorkRunner.executeCommand(cmd));

        cmd  = CommandParser.parseInput("go east");
        Assert.assertTrue(zorkRunner.executeCommand(cmd));
        Assert.assertTrue(zorkRunner.executeCommand(cmd));
        Assert.assertSame(2, zorkRunner.getCurrentLevel().getPlayerX());
        Assert.assertSame(0, zorkRunner.getCurrentLevel().getPlayerY());
    }

    @Test
    public void executeMoveToForestLevelGoEastGoWest() throws Exception {
        ZorkRunner zorkRunner = new ZorkRunner("wit");
        Command cmd  = CommandParser.parseInput("go forest");

        Assert.assertTrue(zorkRunner.executeCommand(cmd));

        cmd  = CommandParser.parseInput("go east");
        Assert.assertTrue(zorkRunner.executeCommand(cmd));
        cmd  = CommandParser.parseInput("go west");
        Assert.assertTrue(zorkRunner.executeCommand(cmd));
        Assert.assertSame(0, zorkRunner.getCurrentLevel().getPlayerX());
        Assert.assertSame(0, zorkRunner.getCurrentLevel().getPlayerY());
    }

    @Test
    public void executeResetForest() throws Exception {
        ZorkRunner zorkRunner = new ZorkRunner("wit");
        Command cmd  = CommandParser.parseInput("go forest");

        Assert.assertTrue(zorkRunner.executeCommand(cmd));

        cmd  = CommandParser.parseInput("go east");
        Assert.assertTrue(zorkRunner.executeCommand(cmd));
        cmd  = CommandParser.parseInput("go west");
        Assert.assertTrue(zorkRunner.executeCommand(cmd));
        Assert.assertSame(0, zorkRunner.getCurrentLevel().getPlayerX());
        Assert.assertSame(0, zorkRunner.getCurrentLevel().getPlayerY());


        cmd  = CommandParser.parseInput("go hub");
        zorkRunner.executeCommand(cmd);
        cmd = CommandParser.parseInput("reset forest");
        zorkRunner.executeCommand(cmd);
        cmd  = CommandParser.parseInput("go forest");
        zorkRunner.executeCommand(cmd);
        Assert.assertTrue(zorkRunner.getCurrentLevel().getCurrentRoom().isVisited());
    }

    @Test
    public void executeResetForestVisted() throws Exception {
        ZorkRunner zorkRunner = new ZorkRunner("wit");
        Command cmd  = CommandParser.parseInput("go forest");

        Assert.assertTrue(zorkRunner.executeCommand(cmd));

        cmd  = CommandParser.parseInput("go east");
        Assert.assertTrue(zorkRunner.executeCommand(cmd));
        cmd  = CommandParser.parseInput("go west");
        Assert.assertTrue(zorkRunner.executeCommand(cmd));
        Assert.assertSame(0, zorkRunner.getCurrentLevel().getPlayerX());
        Assert.assertSame(0, zorkRunner.getCurrentLevel().getPlayerY());


        cmd  = CommandParser.parseInput("go hub");
        zorkRunner.executeCommand(cmd);
        cmd = CommandParser.parseInput("reset forest");
        zorkRunner.executeCommand(cmd);
        Assert.assertFalse(zorkRunner.getCurrentLevel().getCurrentRoom().getLevelExit("forest").getSpecifiedRoom(1,0).isVisited());
    }


    @Test
    public void executeLevelUp() throws Exception {
        Player player = new Player("wit");
        player.gainExp(20);
        Assert.assertSame(5,player.getStatPoints());
        player.gainExp(30);
        Assert.assertSame(10,player.getStatPoints());
        Assert.assertSame(3,player.getLevel());
    }

    @Test
    public void executeFillFunctions() throws Exception {
        Player player = new Player("wit");
        for (int i = 0; i < player.getStatPoints(); i++){
            player.increaseCon();
        }
        player.fillHP();
        player.fillMana();
        Assert.assertSame(player.getMaxHp(),player.getCurrentHp());
        Assert.assertSame(player.getMaxMana(),player.getCurrentMana());
    }
}