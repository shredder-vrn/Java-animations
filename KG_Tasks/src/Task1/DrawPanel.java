package Task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DrawPanel extends JPanel implements ActionListener {

    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final int TIMER_DELAY;
    private Timer timer;
    private int ticksFromStart = 0;
    private int secondTicksFromStart = 0;
    private int thirdTicksFromStart = 0;
    private int fourthTicksFromStart = 0;


    private Daytime daytime;
    private Sun sun;
    private Mountain[] mountain;
    private Background background;
    private Cloud[] cloud;
    private Road road;
    private Curve curve;
    private Curve curve2;
    private Wheel wheel;
    private Tent tent;
    private Flashlight[] flashlights;
    private Fence fence;
    private Moon moon;

    private Nighttime nighttime;
    private NightLight nightLight;
    private Horse horse1;
    private Horse horse2;
    private Horse horse3;

    private Star[] star;
    private Star[] star2;

    public DrawPanel(final int width, final int height, final int timerDelay) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.TIMER_DELAY = timerDelay;
        timer = new Timer(timerDelay, this);
        timer.start();

        Random random = new Random();

        this.daytime = new Daytime(new Color(47, 205, 232));
        this.sun = new Sun(-40, 40, 25, 15, 8, new Color(255, 242, 0));
        this.mountain = new Mountain[4];
        for (int i = 0; i < mountain.length; i++) {
            mountain[i] = new Mountain(i*800/mountain.length-50, 180,
                    random.nextInt(1000/mountain.length-50, 1000/mountain.length+50), random.nextInt(80, 120),
                    new Color(112, 146, 190), new Color(68, 88, 115));
        }
        this.background = new Background(new int[]{0, 800, 800, 0}, new int[]{180, 180, 600, 600}, 4, new Color(83, 232, 89));
        this.cloud = new Cloud[8];
        for (int i = 0; i < cloud.length; i++) {
            cloud[i] = new Cloud(random.nextInt(1600/cloud.length*i-400, 1600/cloud.length*(i+1)-400),
                    random.nextInt(20, 100), random.nextInt(15, 20),
                    random.nextInt(15, 20), random.nextInt(15, 20),
                    random.nextInt(15, 20), 10, Color.WHITE);
        }
        this.road = new Road(new int[]{0, 800, 385, 385, 385, 0}, new int[]{230, 230, 230, 600, 450, 450}, 6, new Color(127, 127, 127));
        this.curve = new Curve(385, 450, 605, 450, 620, 450 ,620, 230, 10, new Color(127, 127, 127));
        this.curve2 = new Curve(510, 700, 560, 490, 750, 490, 900, 400, 20, new Color(127, 127, 127));
        this.wheel = new Wheel(200, 326, 95, 18, 12, Color.DARK_GRAY, new Color(200, 0, 20), Color.WHITE, Color.WHITE, Color.WHITE, 4);



        this.flashlights = new Flashlight[8];

        flashlights[0] = new Flashlight(20, 260, 20, Color.GRAY, Color.BLACK, Color.WHITE, Color.YELLOW);
        flashlights[1] = new Flashlight(350, 260, 20, Color.GRAY, Color.BLACK, Color.WHITE, Color.YELLOW);
        flashlights[2] = new Flashlight(415, 260, 20, Color.GRAY, Color.BLACK, Color.WHITE, Color.YELLOW);
        flashlights[3] = new Flashlight(585, 260, 20, Color.GRAY, Color.BLACK, Color.WHITE, Color.YELLOW);
        flashlights[4] = new Flashlight(650, 260, 20, Color.GRAY, Color.BLACK, Color.WHITE, Color.YELLOW);
        flashlights[5] = new Flashlight(20, 430, 20, Color.GRAY, Color.BLACK, Color.WHITE, Color.YELLOW);
        flashlights[6] = new Flashlight(350, 430, 20, Color.GRAY, Color.BLACK, Color.WHITE, Color.YELLOW);
        flashlights[7] = new Flashlight(415, 430, 20, Color.GRAY, Color.BLACK, Color.WHITE, Color.YELLOW);

        this.fence = new Fence(0, 220, 10, 4, Color.BLACK);
        this.nighttime = new Nighttime(new Color(71, 13, 110));
        this.nightLight = new NightLight(new Color(71, 13, 110, 80));

        this.moon = new Moon(-30, 40, 30, 12, rnd(48, 0, 25));

        this.star = new Star[10];
        this.star2 = new Star[10];


        for (int i = 0; i < star.length; i++) {
            star[i] = new Star(random.nextInt(800/star.length*i, 800/star.length*(i+1)),
                    random.nextInt(20, 50), 24, 24, Color.WHITE);
        }
        for (int i = 0; i < star2.length; i++) {
            star2[i] = new Star(random.nextInt(800/star.length*i, 800/star.length*(i+1)),
                    random.nextInt(50, 100), 24, 24, Color.WHITE);
        }


        this.tent = new Tent(500, 250,  13, 50, 40, 80, new Color(255, 150, 150), Color.RED, Color.CYAN);
        this.horse1 = new Horse(500-22, 250+50+80*2/4, Color.YELLOW, 0.25);
        this.horse2 = new Horse(500-22+50, 250+50+80*2/4+3, Color.RED, 0.25);
        this.horse3 = new Horse(500-22-50, 250+50+80*2/4+6, Color.MAGENTA, 0.25);



        /*addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Мышь кликнула на " + e.getX() + ", " + e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Мышь зажали на " + e.getX() + ", " + e.getY());

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Мышь отпустили на " + e.getX() + ", " + e.getY());

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });*/
    }

    @Override
    public void paint(final Graphics g) {
        super.paint(g);

        Random random = new Random();
        if (ticksFromStart < 900){
            daytime.drawDaytime((Graphics2D)g);
            wheel.setR2(4);
            for (int i = 0; i < wheel.getN(); i++) {
                wheel.setC3(Color.WHITE);
                wheel.setC4(Color.WHITE);
                wheel.setC5(Color.WHITE);
            }

            for (Flashlight flash:flashlights) {
                flash.setC4(new Color(0,0,0,0));
            }
        } else {
            nighttime.drawNighttime((Graphics2D)g);

            for (int i = 0; i < star.length; i++) {
                star[i].drawStar((Graphics2D)g);
            }

            for (int i = 0; i < star2.length; i++) {
                star2[i].drawStar((Graphics2D)g);
            }

            wheel.setR2(80);
            if (ticksFromStart%100 == 0){
                wheel.setC3(new Color(random.nextInt(200), random.nextInt(200), random.nextInt(200), 240));
                wheel.setC4(new Color(random.nextInt(200), random.nextInt(200), random.nextInt(200), 240));
                wheel.setC5(new Color(random.nextInt(200), random.nextInt(200), random.nextInt(200), 240));
            }
            for (Flashlight flash:flashlights) {
                flash.setC4(Color.YELLOW);
            }

        }

        sun.setX(ticksFromStart-60);
        sun.drawSun((Graphics2D)g);

        moon.setX(ticksFromStart-920);
        moon.drawMoon((Graphics2D)g);

        for (int i = 0; i < mountain.length; i++) {
            mountain[i].drawMountain((Graphics2D)g);
        } // горы

        background.drawBackground((Graphics2D)g); // трава


        for (int i = 0; i < cloud.length; i++) {
            cloud[i].drawCloud((Graphics2D)g);
        } // облака

        road.drawRoad((Graphics2D)g); // дороги
        curve.drawCurve((Graphics2D)g);
        curve2.drawCurve((Graphics2D)g);

        fence.drawFence((Graphics2D)g);


        tent.drawTent((Graphics2D)g);
        horse1.drawHorse((Graphics2D)g);
        horse2.drawHorse((Graphics2D)g);
        horse3.drawHorse((Graphics2D)g);

        if (ticksFromStart >= 900){
            nightLight.drawNightLight((Graphics2D)g);
        }

        wheel.setAngleOffset(ticksFromStart*0.01); // колесо
        wheel.drawWheel((Graphics2D)g);

        for (Flashlight flash:flashlights) {
            flash.drawFlashLight((Graphics2D)g);
        }


        if (sun.getX() >= 900+860){
            ticksFromStart = 0;
        }














    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();

            ticksFromStart = ticksFromStart+1;

            if (secondTicksFromStart < 10) {
                for (int i = 0; i < star.length; i++) {
                    if (i%2 == 0){
                        star[i].setW(1);
                        star[i].setL(3);

                        star2[i].setW(3);
                        star2[i].setL(5);
                    } else {
                        star[i].setW(3);
                        star[i].setL(5);

                        star2[i].setW(1);
                        star2[i].setL(3);
                    }
                }
            } else if (secondTicksFromStart < 20){
                for (int i = 0; i < star.length; i++) {
                    if (i%2 == 0){
                        star[i].setW(3);
                        star[i].setL(5);

                        star2[i].setW(1);
                        star2[i].setL(3);
                    } else {
                        star[i].setW(1);
                        star[i].setL(3);

                        star2[i].setW(3);
                        star2[i].setL(5);
                    }
                }
            } else {
                secondTicksFromStart = 0;
            }
            secondTicksFromStart = secondTicksFromStart+1;
            if (thirdTicksFromStart%3==0) {
                if (horse1.isCheck()) {
                    horse1.setY(horse1.getY() + 1);
                    if (horse1.getY() > 250 + 50 + 80 * 2 / 4 + 6) {
                        horse1.setCheck(false);
                    }
                } else {
                    horse1.setY(horse1.getY() - 1);
                    if (horse1.getY() < 250 + 50 + 80 * 2 / 4) {
                        horse1.setCheck(true);
                    }
                }
                if (horse2.isCheck()) {
                    horse2.setY(horse2.getY() + 1);
                    if (horse2.getY() > 250 + 50 + 80 * 2 / 4 + 6) {
                        horse2.setCheck(false);
                    }
                } else {
                    horse2.setY(horse2.getY() - 1);
                    if (horse2.getY() < 250 + 50 + 80 * 2 / 4) {
                        horse2.setCheck(true);
                    }
                }
                if (horse3.isCheck()) {
                    horse3.setY(horse3.getY() + 1);
                    if (horse3.getY() > 250 + 50 + 80 * 2 / 4 + 6) {
                        horse3.setCheck(false);
                    }
                } else {
                    horse3.setY(horse3.getY() - 1);
                    if (horse3.getY() < 250 + 50 + 80 * 2 / 4) {
                        horse3.setCheck(true);
                    }
                }
            }
            thirdTicksFromStart = thirdTicksFromStart+1;

            for (Cloud cloud1: cloud) {
                if (cloud1.getX() < 1600){
                    cloud1.setX(cloud1.getX()+3);
                } else{
                    cloud1.setX(-400);
                }
            }
            fourthTicksFromStart = fourthTicksFromStart+1;
        }
    }

    private int[] rnd(int n, int min, int max){
        int[] arr = new int [n];
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            arr[i] = random.nextInt(min, max);
        }
        return arr;
    }

}
