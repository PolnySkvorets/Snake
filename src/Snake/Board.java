package Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {
    private final int B_WIDTH = 300; //Здесь заданы размеры игрового поля
    private final int B_HEIGHT = 300;
    private final int DOT_SIZE = 10; // размер клетки
    private final int ALL_DOTS = 900; // количество всех клеток на игровом поле
    private final int RAND_POS = 29; // случайная позиция
    private final int DELAY = 140;   // задержка появления яблок

        private final int x[] = new int [ALL_DOTS];  // массивы кооординат x и y
        private final int y[] = new int [ALL_DOTS];

    private int dots;
    private int apple_x;
    private int apple_y;

        public static boolean leftDirection = false;
        public static boolean rightDirection = false;
        public static boolean upDirection = false;
        public static boolean downDirection = false;
        public boolean inGame = true;

    private Timer timer;
    private Image ball;
    private Image apple;
    private Image head;


    public Board(){

        initBoard();
    }

    private void initBoard() {
        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);
        setFocusable(true);
        setDoubleBuffered(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }


    private void loadImages() {

        ImageIcon iid = new ImageIcon("src/resources/ball.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("src/resources/apple.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("src/resources/head.png");
        head = iih.getImage();
    }

    private void initGame() {

        dots = 3;

        for (int z = 0; z < dots ; z++)
        {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }

        locateApple();

        timer = new Timer(DELAY, this);
        timer.start();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        doDrawing(g);
    }



        private void doDrawing(Graphics g){

            if (inGame){
                g.drawImage(apple, apple_x, apple_y, this);

                for (int z = 0; z < dots; z ++) {

                    if ( z == 0) {
                        g.drawImage(head, x[z], y[z], this);
                    }
                    else{
                        g.drawImage(ball, x[z], y[z], this);
                    }
                }

               Toolkit.getDefaultToolkit().sync();
            }
            else
            {
                gameOver(g);
            }
        }

    private void gameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font ("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString (msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);

    }

    private void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {

            dots++;
            locateApple();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame){
            checkApple();

        }
    }
}
