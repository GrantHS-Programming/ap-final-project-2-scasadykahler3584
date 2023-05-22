import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    //screen size
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;

    //speed of game
    static final int DELAY = 75;

    //array of gameboard units
    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];

    //snakes starting bodyparts
    int bodyparts = 6;

    //apple counter and location
    int applesEaten;
    int appleY;
    int appleX;

    //starting direction
    char direction = 'R';

    //idk yet *edit later me*
    boolean running = false;
    Timer timer;
    Random random;
    GamePanel(){
        //random initialized
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        //background color
        this.setBackground(Color.black);
        this.setFocusable(true);
        //action listener
        this.addKeyListener(new MyKeyAdapter());
        //startgame method call
        startGame();
    }
    public void startGame(){
        //newApple called
        newApple();
        //switch running from false to true
        running = true;
        //timer set
        timer = new Timer(DELAY,this);
        timer.start();
    }
    public void paintComponent(Graphics g){
        //calling draw()
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        //possibly temp lines forming grid
        for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
            g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,SCREEN_HEIGHT);
            g.drawLine(0,i*UNIT_SIZE,i*SCREEN_WIDTH,i*UNIT_SIZE);
        }
        //drawing apple
        g.setColor(Color.red);
        g.fillOval(appleX,appleY,UNIT_SIZE,UNIT_SIZE);
    }
    public void newApple(){
        //setting random position of apple
        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }
    public void move(){
        for (int i = bodyparts; i >0 ; i++) {
            x[i]=x[i-1];
            y[i]=y[i-1];
        }
        //direction
        switch (direction){
            case 'U':
                y[0]=y[0]-UNIT_SIZE;
                break;
            case 'D':
                y[0]=y[0]+UNIT_SIZE;
                break;
            case 'L':
                x[0]=x[0]-UNIT_SIZE;
                break;
            case 'R':
                x[0]=x[0]+UNIT_SIZE;
                break;
        }
    }
    public void checkApple(){
        //checking if touching apple

    }
    public void checkCollisions(){
        //checking if touching self or wall

    }
    public void gameOver(Graphics g){

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

        }
    }
}