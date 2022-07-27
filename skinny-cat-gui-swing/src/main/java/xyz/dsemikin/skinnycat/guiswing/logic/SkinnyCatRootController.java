package xyz.dsemikin.skinnycat.guiswing.logic;

import xyz.dsemikin.skinnycat.guiswing.gui2.SkinnyCatMainWindowViewController2;

public class SkinnyCatRootController {

    private final SkinnyCatMainWindowViewController2 mainWindowViewController;

    public SkinnyCatRootController(final SkinnyCatMainWindowViewController2 mainWindowViewController) {
        this.mainWindowViewController = mainWindowViewController;
    }

    public void run() {
        mainWindowViewController.show();
    }
}
