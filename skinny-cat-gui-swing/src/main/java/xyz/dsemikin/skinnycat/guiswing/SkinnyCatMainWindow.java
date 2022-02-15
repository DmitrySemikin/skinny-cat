package xyz.dsemikin.skinnycat.guiswing;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

public class SkinnyCatMainWindow {

    private final JFrame frame;

    public SkinnyCatMainWindow() {
        frame = new JFrame("Skinny Cat");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JButton startFoodstuffEditorButton = new JButton("Foodstuff Editor");
        startFoodstuffEditorButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startFoodstuffEditor();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(startFoodstuffEditorButton);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void startFoodstuffEditor() {
        new FoodstuffEditor();
    }

}
