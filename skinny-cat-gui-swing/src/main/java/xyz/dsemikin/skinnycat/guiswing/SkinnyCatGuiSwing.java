package xyz.dsemikin.skinnycat.guiswing;

import xyz.dsemikin.skinnycat.guiswing.gui.SkinnyCatMainWindow;

import javax.swing.SwingUtilities;

public class SkinnyCatGuiSwing {
    public static void main(String[] argv) {
        SwingUtilities.invokeLater(SkinnyCatMainWindow::new);
    }
}
