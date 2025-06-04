package Task1;

import java.awt.*;

public class Background {

    private int[] x;
    private int[] y;
    private int n;
    private Color c;

    public Background(int[] x, int[] y, int n, Color c) {
        this.x = x;
        this.y = y;
        this.n = n;
        this.c = c;
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

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public void drawBackground(Graphics2D g){
        g.setColor(c);
        g.fillPolygon(x, y, n);
    }
}
