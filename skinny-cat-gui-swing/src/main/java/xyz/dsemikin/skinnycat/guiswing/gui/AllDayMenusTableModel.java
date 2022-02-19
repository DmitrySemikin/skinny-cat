package xyz.dsemikin.skinnycat.guiswing.gui;

import data.DayMenu;
import xyz.dsemikin.skinnycat.guiswing.logic.AllDayMenusController;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AllDayMenusTableModel extends AbstractTableModel {

    private static final int NAME_COLUMN_IDX = 0;
    private static final int DESCRIPTION_COLUMN_IDX = 1;
    private static final int COLUMN_COUNT = 2; // one after the latest real one.

    private final AllDayMenusController controller;
    private List<Long> ids;

    public AllDayMenusTableModel(final AllDayMenusController controller) {
        this.controller = controller;
        ids = controller.allIds();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch(columnIndex) {
            case NAME_COLUMN_IDX -> String.class;
            case DESCRIPTION_COLUMN_IDX -> String.class;
            default -> throw new IllegalArgumentException("Must be 0 or 1, but it is " + columnIndex);
        };
    }

    @Override
    public int getRowCount() {
        return ids.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        final DayMenu dayMenu = controller.get(ids.get(rowIndex)).get();
        return switch(columnIndex) {
            case NAME_COLUMN_IDX -> dayMenu.name();
            case DESCRIPTION_COLUMN_IDX -> dayMenu.description();
            default -> throw new IllegalArgumentException("Must be 0 or 1, but it is " + columnIndex);
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch(column) {
            case NAME_COLUMN_IDX -> "Name";
            case DESCRIPTION_COLUMN_IDX -> "Description";
            default -> throw new IllegalArgumentException("Must be 0 or 1, but it is " + column);
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // TODO
        switch (columnIndex) {
            case NAME_COLUMN_IDX -> controller.setName(ids.get(rowIndex), (String) aValue);
            case DESCRIPTION_COLUMN_IDX -> controller.setDescription(ids.get(rowIndex), (String)aValue);
            default -> throw new IllegalArgumentException("columnIndex must be 0 or 1, but it is " + columnIndex);
        }
        refreshData();
    }

    private void refreshData() {
        ids = controller.allIds();
        // Theoretically we could use more efficient ways,
        // but performance in not a concern in this case
        fireTableDataChanged();
    }


}
