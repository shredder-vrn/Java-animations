package Task1;

import java.awt.*;

public class Mountain {
    private int x;
    private int y;
    private int w;
    private int h;
    private Color c1;
    private Color c2;

    public Mountain(int x, int y, int w, int h, Color c1, Color c2) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.c1 = c1;
        this.c2 = c2;
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

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Color getC1() {
        return c1;
    }

    public void setC1(Color c1) {
        this.c1 = c1;
    }

    public Color getC2() {
        return c2;
    }

    public void setC2(Color c2) {
        this.c2 = c2;
    }

    public void drawMountain(Graphics2D g){
        g.setStroke(new BasicStroke(5));
        g.setColor(c1);
        int[] xPoints = {x, x+w/2, x+w};
        int[] yPoints = {y, y-h, y};
        g.fillPolygon(xPoints, yPoints, 3);
        g.setColor(c2);
        g.drawPolygon(xPoints, yPoints, 3);
    }
}
