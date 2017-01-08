package com.thetoxin.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by theto on 08.01.2017.
 */
public class PlayerTest {
    @Test
    public void getName() throws Exception {
        final String testValue = "Vasa";
        final String exceptionValue = testValue;

        final Player player = new Player(testValue, null);

        final String actualValue = player.getName();

        assertEquals(exceptionValue, player.getName());
    }

    @Test
    public void getFigure() throws Exception {
        final Figure testValue = Figure.X;
        final Figure exceptionValue = testValue;

        final Player player = new Player(null, testValue);

        final Figure actualValue = player.getFigure();

        assertEquals(exceptionValue, player.getFigure());
    }

}