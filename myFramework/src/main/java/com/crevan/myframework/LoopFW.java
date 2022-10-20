package com.crevan.myframework;

import java.util.Date;

public class LoopFW implements Runnable {

    private final float fps = 60;
    private final float second = 1_000_000_000;
    private final float updateTime = second / fps;

    private boolean isRunning = false;

    private Thread gameThread = null;

    //TEMP start
    float updates = 0;
    float drawing = 0;
    long timer = 0;
    //TEMP end

    public void startGame() {
        if (isRunning) {
            return;
        }
        isRunning = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void stopGame() {
        if (!isRunning) {
            return;
        }
        isRunning = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void updateGame() {

    }

    private void drawingGame() {

    }

    @Override
    public void run() {
        float lastTime = System.nanoTime();
        float delta = 0;
        //tmp
        timer = System.currentTimeMillis();

        while (isRunning) {
            float nowTime = System.nanoTime();
            float elapsedTime = nowTime - lastTime;
            lastTime = nowTime;
            delta += elapsedTime / updateTime;
            if (delta > 1) {
                updateGame();
                drawingGame();
                delta--;
            }
            if ((System.currentTimeMillis() - timer) > 1000) {
                Date date = new Date();
                System.out.println("UPDATES = " + updates + " DRAWING = " + drawing + " " + date);
                updates = 0;
                drawing = 0;
                timer += 1000;
            }
        }
    }
}
