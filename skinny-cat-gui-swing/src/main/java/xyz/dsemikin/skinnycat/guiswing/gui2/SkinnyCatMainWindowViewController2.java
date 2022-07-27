package xyz.dsemikin.skinnycat.guiswing.gui2;

public class SkinnyCatMainWindowViewController2 {

    private final SkinnyCatMainWindowView2 view;

    public SkinnyCatMainWindowViewController2(final SkinnyCatMainWindowView2 view) {
        this.view = view;
    }

    public void show() {
        view.frame().setVisible(true);
    }
}
