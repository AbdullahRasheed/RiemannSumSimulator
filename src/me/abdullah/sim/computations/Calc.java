package me.abdullah.sim.computations;

import me.abdullah.sim.render.Draw;

import java.util.HashMap;
import java.util.Map;

public class Calc {

    public static final int PIXEL_RATIO = 200;

    private Draw draw;
    public Calc(Draw draw) {
        this.draw = draw;
    }

    public int func(int x){
        if(draw.pixels.containsKey(x)) return draw.pixels.get(x);
        int nearest = (int)draw.pixels.keySet().toArray()[0];
        for (Integer integer : draw.pixels.keySet()) {
            if(Math.abs(integer - x) < Math.abs(nearest - x)) nearest = integer;
        }
        return draw.pixels.get(nearest);
    }

    public int lowestX(){
        int lowest = (int)draw.pixels.keySet().toArray()[0];
        for (Integer integer : draw.pixels.keySet()) {
            if(integer < lowest) lowest = integer;
        }
        return lowest;
    }

    public int highestX(){
        int highest = (int)draw.pixels.keySet().toArray()[0];
        for (Integer integer : draw.pixels.keySet()) {
            if(integer > highest) highest = integer;
        }
        return highest;
    }

    public Map<Integer, Integer> getNSubdivisions(int n){
        Map<Integer, Integer> sub = new HashMap<>();
        int lowestX = lowestX();
        int highestX = highestX();
        int space = (highestX - lowestX)/n;
        for(int i = 0; i < n; i++){
            int x = lowestX + (space * i);
            sub.put(x, func(x));
        }
        return sub;
    }

    public int space(int subdivisions){
        int lowestX = lowestX();
        int highestX = highestX();
        return (highestX - lowestX)/subdivisions;
    }

}
