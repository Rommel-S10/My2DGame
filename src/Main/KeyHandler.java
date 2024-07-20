package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upBottom, downBottom, leftButom, rightBottom;

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        //No need to use this method
    }

    @Override
    public void keyPressed(KeyEvent b) {

        int code = b.getKeyCode();

        if(code == KeyEvent.VK_W){
            upBottom = true;
        }
        if(code == KeyEvent.VK_S){
            downBottom = true;
        }
        if(code == KeyEvent.VK_A){
            leftButom = true;
        }
        if(code == KeyEvent.VK_D){
            rightBottom = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent b) {
            int code = b.getKeyCode();
        if(code == KeyEvent.VK_W){
            upBottom = false;
        }
        if(code == KeyEvent.VK_S){
            downBottom = false;
        }
        if(code == KeyEvent.VK_A){
            leftButom = false;
        }
        if(code == KeyEvent.VK_D){
            rightBottom = false;
        }

    }
}
