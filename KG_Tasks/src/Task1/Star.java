package Task1;

import java.awt.*;

public class Star {
    private int x;
    private int y;
    private int w;
    private int l;
    private Color color;

    public Star(int x, int y, int w, int l, Color color) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.l = l;
        this.color = color;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public void drawStar(Graphics2D g){
        g.setStroke(new BasicStroke(w));
        g.setColor(color);
        g.drawLine(x-l, y, x+l, y);
        g.drawLine(x, y-l, x, y+l);



    }
}
