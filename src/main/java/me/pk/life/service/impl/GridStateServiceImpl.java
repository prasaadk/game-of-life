package me.pk.life.service.impl;

import me.pk.life.model.Grid;
import me.pk.life.service.GridStateService;

/**
 * Created by prasad on 07/07/2016.
 */
public class GridStateServiceImpl implements GridStateService {

    private Grid grid;

    public void init(Grid grid) {
        this.grid = grid;
    }

    @Override
    public Grid tick() {
        return grid.nextGen();
    }

}
