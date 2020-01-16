package me.abdullah.sim.controls;

import me.abdullah.sim.render.Draw;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseMotionInput extends MouseMotionAdapter {

    private Draw draw;
    public MouseMotionInput(Draw draw){
        this.draw = draw;
    }

    public void mouseDragged(MouseEvent event){
        if(!draw.drawing) return;
        draw.addPixel(event.getX(), event.getY());
    }
}
