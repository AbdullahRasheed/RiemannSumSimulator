package me.abdullah.sim.controls;

import me.abdullah.sim.render.Sums;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Sums sums;
    public KeyInput(Sums sums){
        this.sums = sums;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_UP:
                sums.subdivisions += 1;
                break;

            case KeyEvent.VK_DOWN:
                if(sums.subdivisions < 2) break;
                sums.subdivisions -= 1;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
