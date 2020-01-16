package me.abdullah.sim.main;

import me.abdullah.sim.controls.KeyInput;
import me.abdullah.sim.controls.MouseInput;
import me.abdullah.sim.controls.MouseMotionInput;
import me.abdullah.sim.render.Draw;
import me.abdullah.sim.render.Sums;
import me.abdullah.sim.render.Window;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable {

    public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width
            , HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    private boolean running = false;

    private Thread thread;
    private Draw draw;
    private Sums sums;

    public Main(){
        draw = new Draw();
        sums = new Sums(draw);

        initObjects();

        this.addMouseMotionListener(new MouseMotionInput(draw));
        this.addMouseListener(new MouseInput(draw));
        this.addKeyListener(new KeyInput(sums));
        new Window(WIDTH, HEIGHT, "Sim", this);
    }

    public void initObjects(){

    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1){
                tick();
                delta--;
            }
            if(running) render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        draw.render(g);
        sums.render(g);

        g.dispose();
        bs.show();
    }

    private void tick(){
        draw.tick();
    }

    public static void main(String[] args){
        new Main();
    }
}
