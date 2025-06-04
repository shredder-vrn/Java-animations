package Task1;


import java.awt.*;
import java.util.Random;

public class Wheel {

    private int x;
    private int y;
    private int r;
    private int n;
    private int l;
    private double angleOffset;
    private Color c1;
    private Color c2;
    private Color c3;
    private Color c4;
    private Color c5;
    private int r2;

    public Wheel(int x, int y, int r, int n, int l, Color c1, Color c2, Color c3, Color c4, Color c5, int r2) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.n = n;
        this.l = l;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.c5 = c5;
        this.r2 = r2;
    }

    public double getAngleOffset() {
        return angleOffset;
    }

    public void setAngleOffset(double angleOffset) {
        this.angleOffset = angleOffset;
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

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
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

    public Color getC3() {
        return c3;
    }

    public void setC3(Color c3) {
        this.c3 = c3;
    }

    public Color getC4() {
        return c4;
    }

    public void setC4(Color c4) {
        this.c4 = c4;
    }

    public Color getC5() {
        return c5;
    }

    public void setC5(Color c5) {
        this.c5 = c5;
    }

    public int getR2() {
        return r2;
    }

    public void setR2(int r2) {
        this.r2 = r2;
    }

    public void drawWheel(Graphics2D g) {

        g.setStroke(new BasicStroke((float) (r*0.04)));
        g.setColor(Color.BLACK);

        double b1 = 5*2*Math.PI/22;
        double b2 = 6*2*Math.PI/22;
        double xb1 = (r+(double)r/4)*Math.cos(b1);
        double yb1 = (r+(double)r/4)*Math.sin(b1);
        double xb2 = (r+(double)r/4)*Math.cos(b2);
        double yb2 = (r+(double)r/4)*Math.sin(b2);


        g.drawLine(x, y, (int) xb1 + x, (int) yb1+y);
        g.drawLine(x, y, (int) xb2 + x, (int) yb2+y);
        g.drawLine((int) xb1 + x + r/4, (int) yb1+y, (int) xb2 + x - r/4, (int) yb2+y);


        g.setColor(c1);
        g.setStroke(new BasicStroke(3));

        g.drawOval(x - r, y - r, 2 * r, 2 * r);

        double da = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {
            double a = i * da + angleOffset;
            double x2 = r*Math.cos(a);
            double y2 = r*Math.sin(a);




            g.setColor(c1);
            g.drawLine(x, y, (int) x2+x, (int) y2+y);
            g.setColor(c2);
            g.fillRect((int) x2+x-l/2, (int) y2+y-l/2, l, l+l/2);

            Color color = new Color(0, 0, 0, 0);

            if (i%3 == 0){
                Paint p = new RadialGradientPaint((int)(x2+x), (int)(y2+y), (int)(r2/2), new float[] {0, 0.9f, 1},
                        new Color[]{c3, color, color});
                g.setPaint(p);
            } else if (i%3 == 1){
                Paint p = new RadialGradientPaint((int)(x2+x), (int)(y2+y), (int)(r2/2), new float[] {0, 0.9f, 1},
                        new Color[]{c4, color, color});
                g.setPaint(p);
            } else {
                Paint p = new RadialGradientPaint((int)(x2+x), (int)(y2+y), (int)(r2/2), new float[] {0, 0.9f, 1},
                        new Color[]{c5, color, color});
                g.setPaint(p);
            }




            g.fillOval((int)(x2+x-r2/2), (int)y2+y-r2/2, r2, r2);

            System.out.println();
            System.out.println((r2/2));

            g.setStroke(new BasicStroke(1));
            g.setColor(Color.BLACK);
            g.drawOval((int)x2+x-2, (int)y2+y-2, 4, 4);
        }

        g.setStroke(new BasicStroke(1));
    }
}