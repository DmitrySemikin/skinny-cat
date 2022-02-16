package xyz.dsemikin.skinnycat.guiswing.gui.foodstuff;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class FoodstuffWindow {

    private final JFrame frame;

    public FoodstuffWindow() {
        frame = new JFrame("Foodstuff Editor");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JTable table = new JTable(new FoodstuffTableModel());
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

}

