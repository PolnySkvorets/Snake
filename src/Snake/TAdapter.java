package Snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Snake.Board;

public  class TAdapter extends KeyAdapter{


    @Override
    public  void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();


        if((key == KeyEvent.VK_LEFT) && (!Board.rightDirection) ){
            Board.leftDirection = true;

        }




    }


}
