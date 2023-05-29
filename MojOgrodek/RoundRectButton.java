package MojOgrodek;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class RoundRectButton extends JButton {

   Color buttoncolor = new Color(0,76,153);


    public RoundRectButton(String label) {
        super(label);

        setBackground(buttoncolor);
        setContentAreaFilled(false);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(new Color(0, 128, 191));
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 20,10);

        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(buttoncolor);
        g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 20, 10);
    }

    Shape shape;

    public boolean contains(int x, int y) {

        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new Rectangle2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }
}
