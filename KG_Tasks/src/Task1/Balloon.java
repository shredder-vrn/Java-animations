package Task1;

import java.awt.*;

public class Balloon {
    private int x;
    private int y;
    private int r;
    private int l;
    private Color c1;
    private Color c2;

    public Balloon(int x, int y, int r, int l, Color c1, Color c2) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.l = l;
        this.c1 = c1;
        this.c2 = c2;
    }

    public void drawBalloon(Graphics2D g2) {
        g2.setColor(c1);
        g2.fillOval(x - r, y - r, 2 * r, 2 * r);

        g2.setColor(c2);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(x, y + r, x, y + r + l);

        g2.fillOval(x - 5, y + r - 5, 10, 10);
    }
}
