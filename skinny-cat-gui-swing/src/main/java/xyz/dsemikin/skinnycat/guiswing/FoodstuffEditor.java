package xyz.dsemikin.skinnycat.guiswing;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class FoodstuffEditor {

    private final JFrame frame;

    public FoodstuffEditor() {
        frame = new JFrame("Foodstuff Editor");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

}
