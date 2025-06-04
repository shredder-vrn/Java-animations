package Task1;

import java.awt.*;

public class NightLight {
    private Color c;

    public NightLight(Color c) {
        this.c = c;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public void drawNightLight(Graphics2D g) {

        g.setColor(c);
        g.fillRect(0, 0, 800, 600);
    }
}