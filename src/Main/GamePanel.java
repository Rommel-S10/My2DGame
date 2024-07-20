package Main;

import java.awt.*;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    final int originalTitleSize = 16;
    final int scale = 3;
    final int titleSize = 48;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = 768;
    final int screenHeigth = 576;
    final int FPS = 60;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;

    int playerPositionx = 200;
    int playerPositiony = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(768, 576));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThreat() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    public void run() {
        while(this.gameThread != null) {

            //There is two ways to this. We have Sleep method and the DELTA/ACCUMULATOR Method which is more accurate.
            // Sleep requires a try block, things could go wrong. Therefore, we will be using the DELTA/ACCUMULATOR emthod

            double drawInterval = 1000000000/FPS;
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime;

            while(gameThread != null) {

                currentTime = System.nanoTime();
                delta += (currentTime - lastTime) / drawInterval;
                lastTime = currentTime;



                if(delta >= 1) {
                    //1. Updated player position
                    updated();

                    //2. Draw/update game
                    repaint();
                    delta--;
                }

            }
        }

    }

    public void updated(){

        if(keyHandler.upBottom == true){
            playerPositiony -= playerSpeed;
        }
        else if(keyHandler.downBottom == true){
            playerPositiony += playerSpeed;
        }

        else if(keyHandler.rightBottom == true){
            playerPositionx += playerSpeed;
        }
        else if(keyHandler.leftButom == true){
            playerPositionx -= playerSpeed;
        }

    }

    public void paintComponent(Graphics g){ //normal en java
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);

        g2.fillRect(playerPositionx, playerPositiony, titleSize, titleSize);

        g2.dispose();

    }
}

