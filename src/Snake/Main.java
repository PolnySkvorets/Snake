package Snake;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    public Main() {

        initUI();
    }

    private void initUI() {
        add( new Board());
        setResizable(false);
        pack();

        setTitle("Snake");
        setLocationRelativeTo( null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame ex = new Main();
            ex.setVisible(true);
        });
	// write your code here
    }
}
