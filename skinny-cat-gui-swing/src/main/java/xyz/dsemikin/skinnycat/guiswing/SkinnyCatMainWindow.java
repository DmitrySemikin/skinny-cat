package xyz.dsemikin.skinnycat.guiswing;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Dimension;

public class SkinnyCatMainWindow {

    private final JFrame frame;

    public SkinnyCatMainWindow() {
        frame = new JFrame("Skinny Cat");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
