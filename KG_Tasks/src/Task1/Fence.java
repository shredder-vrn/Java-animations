package Task1;

import java.awt.*;

public class Fence {
    private int x;
    private int y;
    private int size;
    private int empty;
    private Color color;

    public Fence(int x, int y, int size, int empty, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.empty = empty;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getEmpty() {
        return empty;
    }

    public void setEmpty(int empty) {
        this.empty = empty;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void drawFence(Graphics2D g){
        g.setStroke(new BasicStroke(2));
        g.setColor(color);
        g.drawLine(x, y-size/4, 800, y-size/4);
        g.drawLine(x, y-size*2+size/4, 800, y-size*2+size/4);
        g.setColor(new Color(179, 103, 5));
        int newX = 0;
        while (newX<900){
            g.fillPolygon(new int[]{newX, newX+size, newX+size, newX+size/2, newX}, new int[]{y, y, y-2*size, y-2*size-size/2, y-2*size}, 5);
            newX = newX+empty+size;
        }
    }
}
