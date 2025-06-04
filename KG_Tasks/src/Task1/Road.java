package Task1;

import java.awt.*;

public class Road {

    private int[] x;
    private int[] y;
    private Color c1;
    private int n;

    public Road(int[] x, int[] y, int n, Color c1) {
        this.x = x;
        this.y = y;
        this.c1 = c1;
        this.n = n;
    }

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }

    public Color getC1() {
        return c1;
    }

    public void setC1(Color c1) {
        this.c1 = c1;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void drawRoad(Graphics2D g) {
        g.setColor(c1);
        g.setStroke(new BasicStroke(10));

        for (int i = 0; i < n-1; i++) {
            g.drawLine(x[i], y[i], x[i+1], y[i+1]);
        }
    }
}