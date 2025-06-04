package Task1;

import java.awt.*;

public class Nighttime {
    private Color c;

    public Nighttime(Color c) {
        this.c = c;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public void drawNighttime(Graphics2D g){

        g.setColor(c);
        g.fillRect(0, 0, 800, 600);
    }
}
