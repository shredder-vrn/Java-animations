package Task1;

import java.awt.*;

public class Tent {

    private int x;
    private int y;
    private int n;
    private int r;
    private int w;
    private int h;
    private Color c1;
    private Color c2;
    private Color c3;

    public Tent(int x, int y, int n, int r, int w, int h, Color c1, Color c2, Color c3) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.n = n;
        this.r = r;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
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

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Color getC3() {
        return c3;
    }

    public void setC3(Color c3) {
        this.c3 = c3;
    }

    public void drawTent(Graphics2D g) {
        g.setStroke(new BasicStroke(1));
        g.setColor(c3);

        double j = (double) n/4;
        double c = (j)*Math.PI/n;
        double y1 = (r * 1.5) * Math.sin(c);
        double x1 = x-w/2;
        g.fillRect((int)x1, (int)y1+y, w, h);


        for (int i = 0; i <= n; i++) {
            double w2 = w/n;
            g.setColor(Color.BLUE);
            if (i%2 == 0){
                g.fillRect((int)x1+(int)w2*i, (int)y1+y, (int)w2, h);
            }
        }

        double da = Math.PI / n;
        for (int i = 1; i < n-1; i++) {
            if (i % 2 == 0) {
                g.setColor(c1);
            } else {
                g.setColor(c2);
            }

            double a = i * da;
            double x2 = (r * 1.5) * Math.cos(a);

            double b = (i+1) * da;
            double x3 = (r * 1.5) * Math.cos(b);

            g.fillPolygon(new int[]{x, (int)x2+x, (int)x3+x}, new int[]{y, (int)y1+y, (int)y1+y}, 3);
        }
        g.setStroke(new BasicStroke(4));
        g.setColor(Color.BLACK);
        g.drawLine(x, y, x, y-(int)(r*0.4));

        g.setStroke(new BasicStroke(1));
        g.setColor(c2);
        g.fillPolygon(
                new int[]{x, x, x+(int)(r*0.5), x+(int)(r*0.3), x+(int)(r*0.5)},
                new int[]{y-(int)(r*0.2), y-(int)(r*0.4), y-(int)(r*0.4), y-(int)(r*0.3), y-(int)(r*0.2) }, 5);

        g.setColor(new Color(100, 50, 1));
        g.fillRect(x - (int) ((r * 1.5) * Math.cos(da)), (int)y1+y+h, (int) ((r * 1.5) * Math.cos(da))*2, (int) (h*0.15));

        g.setStroke(new BasicStroke(1));
        g.setColor(Color.BLACK);
        double r2 = 2;
        int n2 = 6;
        int w1 = (int) (((r * 1.5) * Math.cos(da))*2/n2);
        for (int k = 0; k < n2; k++) {

            for (int i = 0; i < (int)(h*0.65/r2); i++) {
                if (k%2 == 1){
                    g.drawOval((x-(int)((r * 1.5)*Math.cos(da)))+w1*k, (int)(y+y1+(r2*i)), (int)(r2), (int)(r2));


                }
            }
        }
    }
}