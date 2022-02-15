package xyz.dsemikin.skinnycat.guiswing;

import javax.swing.SwingUtilities;
import java.lang.reflect.InvocationTargetException;

public class SkinnyCatGuiSwing {
    public static void main(String[] argv) {
        SwingUtilities.invokeLater(SkinnyCatMainWindow::new);
    }
}
