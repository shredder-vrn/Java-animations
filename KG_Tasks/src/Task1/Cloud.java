package Task1;

import java.awt.*;
import java.util.Random;

public class Cloud {

    private int x;
    private int y;
    private int minR;
    private int minR2;
    private int maxR;
    private int maxR2;
    private int n;
    private Color c1;

    public Cloud(int x, int y, int minR, int minR2, int maxR, int maxR2, int n, Color c1) {
        this.x = x;
        this.y = y;
        this.minR = minR;
        this.minR2 = minR2;
        this.maxR = maxR;
        this.maxR2 = maxR2;
        this.n = n;
        this.c1 = c1;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMinR() {
        return minR;
    }

    public void setMinR(int minR) {
        this.minR = minR;
    }

    public int getMinR2() {
        return minR2;
    }

    public void setMinR2(int minR2) {
        this.minR2 = minR2;
    }

    public int getMaxR() {
        return maxR;
    }

    public void setMaxR(int maxR) {
        this.maxR = maxR;
    }

    public int getMaxR2() {
        return maxR2;
    }

    public void setMaxR2(int maxR2) {
        this.maxR2 = maxR2;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Color getC1() {
        return c1;
    }

    public void setC1(Color c1) {
        this.c1 = c1;
    }

    public void drawCloud(Graphics2D g) {
        Random rand = new Random();
        g.setColor(c1);

        int currentX = x;
        for (int i = 0; i < n; i++) {
            if (i < n/4){
                int radius = minR+i;
                g.fillOval(currentX - radius, y - radius, 2 * radius*3, 2 * radius);
                currentX += radius;
            } else if (i<n/2){
                int radius = getMinR()-i;
                g.fillOval(currentX - radius, y - radius, 2 * radius*3, 2 * radius);
                currentX += radius;
            } else if (i<n*0.75){
                int radius = maxR-i;
                g.fillOval(currentX - radius, y - radius, 2 * radius*3, 2 * radius);
                currentX += radius;
            } else {
                int radius = maxR2-i;
                g.fillOval(currentX - radius, y - radius, 2 * radius*3, 2 * radius);
                currentX += radius;
            }

        }
    }
}