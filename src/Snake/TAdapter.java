package Snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Snake.Board;

import static Snake.Board.*;

public  class TAdapter extends KeyAdapter{


    @Override
    public  void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();


        if((key == KeyEvent.VK_LEFT) && (!rightDirection) ){
            leftDirection = true;
            upDirection = false;
            downDirection = false;


        }
        if((key == KeyEvent.VK_RIGHT) && (!leftDirection) ){
            rightDirection = true;
            upDirection = false;
            downDirection = false;


        }

        if((key == KeyEvent.VK_UP) && (!downDirection) ){
            rightDirection = false;
            upDirection = true;
            leftDirection = false;


        }

        if((key == KeyEvent.VK_DOWN) && (!upDirection) ){
            rightDirection = false;
            downDirection = true;
            leftDirection = false;


        }


    }


}
