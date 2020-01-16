package me.abdullah.sim.render;

import me.abdullah.sim.computations.Calc;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Draw {

    public boolean drawing = false;
    public boolean clear = false;
    public Map<Integer, Integer> pixels = new HashMap<>();
    private Map<Integer, Integer> pushMap = new HashMap<>();

    public void tick(){

    }

    public void addPixel(int x, int y){
        pushMap.put(x, y);
    }

    public void render(Graphics g){
        for (Integer integer : pushMap.keySet()) {
            pixels.put(integer, pushMap.get(integer));
        }
        pushMap.clear();

        g.setColor(Color.WHITE);
        for (Integer integer : pixels.keySet()) {
            g.fillOval(integer - 10, pixels.get(integer) - 10, 20, 20);
        }
        if(clear){
            pixels.clear();
            clear = false;
        }

        //line

        g.fillRect(50, 900, 1800, 20);

    }
}
