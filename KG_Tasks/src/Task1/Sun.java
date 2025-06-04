package Task1;

import java.awt.*;

public class Sun {
    private int x;
    private int y;
    private int r;
    private int l;
    private int n;
    private Color c;

    public Sun(int x, int y, int r, int l, int n, Color c) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.l = l;
        this.n = n;
        this.c = c;
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

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
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

    public void drawSun(Graphics2D g){
        Paint p = new RadialGradientPaint(x, y, r, new float[] {0, 0.5f, 1},
                new Color[]{Color.ORANGE, Color.YELLOW, Color.ORANGE});

        g.setPaint(p);

        g.setColor(c);
        g.setStroke(new BasicStroke(5));

        g.fillOval(x-r, y-r, r*2, r*2);

        double da = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {
            double a = i * da;
            double x1 = r*Math.cos(a);
            double y1 = r*Math.sin(a);
            double x2 = (r+l)*Math.cos(a);
            double y2 = (r+l)*Math.sin(a);
            g.drawLine((int) x1 + x, (int) y1 + y, (int) x2 + x, (int) y2 + y);
        }
    }
}
