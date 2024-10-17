package view;

import controller.CollisionManager;
import model.scenes.Scene;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Objects;

public class PhysicsSimulator implements Runnable {

    private Display display;
    private Thread thread;
    private boolean running = false;
    private final CollisionManager collisionManager;
    private static String OS = System.getProperty("os.name").toLowerCase();

    public PhysicsSimulator(){
        display = new Display("Physics", 1600, 900);
        this.collisionManager = CollisionManager.getInstance();
    }

    @Override
    public void run() {
        init();

        int FPS = 60;
        double timePerTick = 1000000000 / FPS;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        double lastTimeT = System.nanoTime();

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;

            long currentTime = System.currentTimeMillis();
            double deltaTime = (currentTime - lastTimeT) / 1000.0;
            lastTimeT = currentTime;
            if(delta >= 1){
                update(deltaTime);
                render();
                delta--;
            }

        }
        stop();
    }
    private void init(){

    }
    private void render(){
        BufferStrategy bs = display.getBufferStrategy();
        if(bs == null){
            display.createBufferStrategy();
            return; // Evitar continuar sem a estratégia de buffer
        }
        Graphics g = bs.getDrawGraphics();

        // Sincroniza para suavizar a animação no Linux
        if (Objects.equals(OS, "linux")) {
            Toolkit.getDefaultToolkit().sync();
        }

        // Limpar a tela (opcional)
        g.clearRect(0, 0, display.getCanvasWidth(), display.getCanvasHeight());

        // Desenhar os corpos na tela
        Scene.getInstance().drawAllBodies((Graphics2D) g);

        g.dispose();
        bs.show();
    }
    private void update(double deltaTime) {
        Scene.getInstance().getDrawableBodies().forEach(body -> {
            body.update(deltaTime);
        });
        collisionManager.checkForCollision();
    }

    public synchronized void start(){
        if(thread != null){
            return;
        } else {
        thread = new Thread(this);
        thread.start();
        running = true;
        }
    }
    public synchronized void stop(){
        if(thread == null){
            return;
        } else {
            try {
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
