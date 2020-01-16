package me.abdullah.sim.render;

import me.abdullah.sim.computations.Calc;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Sums {

    public int subdivisions = 1;
    private Draw draw;
    private Calc calc;
    public Sums(Draw draw){
        this.draw = draw;
        this.calc = new Calc(draw);
    }

    public void render(Graphics g){
        g.setFont(new Font("Ariel", Font.BOLD, 32));
        g.drawString("Subdivisions: " + subdivisions, 100, 100);

        if(draw.pixels.isEmpty()) return;
        int space = calc.space(subdivisions);
        Map<Integer, Integer> rectPoints = calc.getNSubdivisions(subdivisions);
        for (Integer integer : rectPoints.keySet()) {
            g.drawRect(integer, rectPoints.get(integer), space, 900-rectPoints.get(integer));
        }
    }
}
