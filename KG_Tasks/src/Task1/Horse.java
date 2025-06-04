package Task1;

import java.awt.*;

public class Horse {
    private int x;
    private int y;
    private Color c;
    private double size;
    private boolean check = true;

    public Horse(int x, int y, Color c, double size) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.size = size;
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

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public void drawHorse(Graphics2D g){

        int[] xPoints = {2, 43, 69, 145, 205, 178, 145, 145, 159, 145, 140, 148, 117, 69, 72, 53, 48, 57, 32, 20, 10, 1, 8};
        int[] yPoints = {0, 14, 33, 36, 140, 122, 58, 89, 125, 165, 165, 123, 96, 96, 125, 165, 165, 125, 58, 32, 58, 45, 19};

        for (int i = 0; i < xPoints.length; i++) {
            xPoints[i] = (int)(xPoints[i]*size);
            xPoints[i] = xPoints[i] + x;

            yPoints[i] = (int)(yPoints[i]*size);
            yPoints[i] = yPoints[i]+ y;
        }

        g.setColor(c);
        g.fillPolygon(xPoints, yPoints, xPoints.length);

    }
}
