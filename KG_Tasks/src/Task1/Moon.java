package Task1;

import java.awt.*;
import java.util.Random;

public class Moon {
    private int x;
    private int y;
    private int r;
    private int n;
    private Color c;
    private int[] random;

    public Moon(int x, int y, int r, int n, int[] random) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.n = n;
        this.random = random;
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

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
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

    public void drawMoon(Graphics2D g){
        Paint p = new RadialGradientPaint(x, y, r, new float[] {0, 0.5f, 1},
                new Color[]{new Color(245, 241, 169), new Color(237, 232, 126), new Color(156, 152, 79)});

        g.setStroke(new BasicStroke(1));
        g.setPaint(p);
        g.setStroke(new BasicStroke(1));

        g.fillOval(x-r, y-r, r*2, r*2);

        double da = 2 * Math.PI / n;
        for (int i = 0; i < n*4; i++) {
            double a = i * da;
            double x1 = random[i]*Math.cos(a);
            double y1 = random[i]*Math.sin(a);

            g.setColor(new Color(227, 227, 227));
            g.fillOval((int) x1 + x-4, (int) y1 + y-4, 8, 8);
        }
    }
}
