package me.pk.life.service.impl;

import me.pk.life.model.Grid;
import me.pk.life.service.GridRenderer;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by prasad on 07/07/2016.
 */
public class ConsoleGridRenderer implements GridRenderer {

    private final PrintStream printStream;

    public ConsoleGridRenderer(OutputStream stream) {
        printStream = new PrintStream(stream);
    }

    @Override
    public void render(Grid grid) {

    }
}
