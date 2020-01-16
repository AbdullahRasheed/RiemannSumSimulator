package me.abdullah.sim.controls;

import me.abdullah.sim.render.Draw;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

    private Draw draw;

    public MouseInput(Draw draw){
        this.draw = draw;
    }

    public void mousePressed(MouseEvent event) {
        draw.clear = true;
        draw.drawing = true;
    }

    public void mouseReleased(MouseEvent event){
        draw.drawing = false;
    }
}
