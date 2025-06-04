package Task1;

import java.awt.*;
import java.awt.geom.CubicCurve2D;

public class Flashlight {
    private int x;
    private int y;
    private int size;
    private Color c1;
    private Color c2;
    private Color c3;
    private Color c4;

    public Flashlight(int x, int y, int size, Color c1, Color c2, Color c3, Color c4) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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

    public void drawFlashLight(Graphics2D g){
        size = 20;
        g.setStroke(new BasicStroke((int)(size/6)));
        g.setColor(c1);
        g.fillOval(x-size, y-size, size*2, size);
        g.setColor(c2);
        g.drawOval(x-size, y-size, size*2, size);
        g.setStroke(new BasicStroke((int)(size/3)));
        g.drawLine(x, y-(size/2), x, y-size*3);
        g.setStroke(new BasicStroke((int)(size/6)));
        CubicCurve2D curve2D = new CubicCurve2D.Double(x, y-size*3, x-size/3, (y-size*3)-size/2, x-size*2/3, (y-size*3)-size/2, x-size, y-size*3);
        CubicCurve2D curve2D2 = new CubicCurve2D.Double(x, y-size*3, x+size/3, (y-size*3)-size/2, x+size*2/3, (y-size*3)-size/2, x+size, y-size*3);
        g.draw(curve2D);
        g.draw(curve2D2);
        g.setColor(c3);
        g.drawOval(x-size-size/4, y-size*3, size/4, size/4);
        g.drawOval(x+size, y-size*3, size/4, size/4);

        int[] xPoints = {x-size-size/6, x, x-size*2-size/4};
        int[] yPoints = {y-size*3, y, y};

        LinearGradientPaint gradientPaint = new LinearGradientPaint((x-size-size/4),y - (size * 3),  x-size-size/4, y, new float[]{0.0f, 1.0f}, new Color[]{c4, new Color(0, 255, 255, 0)});
        g.setPaint(gradientPaint);
        g.fillPolygon(xPoints, yPoints, 3);

        int[] x2Points = {x+size+size/6, x, x+size*2+size/4};
        int[] y2Points = {y-size*3, y, y};

        LinearGradientPaint gradientPaint2 = new LinearGradientPaint((x+size+size/4),y - (size * 3),  x+size+size/4, y, new float[]{0.0f, 1.0f}, new Color[]{c4, new Color(0, 255, 255, 0)});
        g.setPaint(gradientPaint2);
        g.fillPolygon(x2Points, y2Points, 3);

    }
}
