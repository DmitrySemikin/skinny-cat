package xyz.dsemikin.skinnycat.guiswing;

import xyz.dsemikin.skinnycat.guiswing.logic.SkinnyCatRootController;

import javax.swing.SwingUtilities;

public class SkinnyCatGuiSwing {
    public static void main(String[] argv) {
        SwingUtilities.invokeLater(SkinnyCatGuiSwing::startApplication);
    }

    private static void startApplication() {
        final SkinnyCatRootController rootController = Bootstrapper.bootstrap();
        rootController.run();
    }
}
