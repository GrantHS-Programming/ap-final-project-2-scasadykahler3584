import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class PongPanel extends JPanel{
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT=100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddles paddles1;
    Paddles paddles2;
    Ball ball;
    Score score;
    PongPanel(){
        newPaddles();
        newBall();
        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);
        gameThread = new Thread();
        gameThread.start();

    }
    public void newBall(){

    }
    public void newPaddles(){
        //paddles1 = new Paddles(0,(GAME_HEIGHT/2)-PADDLE_HEIGHT/2),PADDLE_HEIGHT,PADDLE_WIDTH,1);
        //paddles2 = new Paddles((GAME_WIDTH-PADDLE_WIDTH),(GAME_HEIGHT/2)-PADDLE_HEIGHT/2),PADDLE_HEIGHT,PADDLE_WIDTH,2);
    }
    public void paint(Graphics g){
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);

    }
    public void draw(Graphics graphics){

    }
    public void move(){

    }
    public void checkCollisions(){

    }
    public void run(){
        //game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true){
            long now = System.nanoTime();
            delta +=(now-lastTime)/ns;
            lastTime= now;
            if(delta>=1){
                move();
                checkCollisions();
                repaint();
                delta--;
            }
        }
    }
    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){

        }
        public void keyReleased(KeyEvent e){

        }
    }
}
