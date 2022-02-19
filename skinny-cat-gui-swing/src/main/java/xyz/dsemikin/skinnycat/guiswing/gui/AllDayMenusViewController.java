package xyz.dsemikin.skinnycat.guiswing.gui;

import xyz.dsemikin.skinnycat.guiswing.gui.daymenuslist.DayMenusList;
import xyz.dsemikin.skinnycat.guiswing.logic.AllDayMenusController;

public class AllDayMenusViewController {

    final DayMenusList dayMenusList;


    public AllDayMenusViewController(final DayMenusList dayMenusList) {

        this.dayMenusList = dayMenusList;

        final AllDayMenusController controller = new AllDayMenusController();

        dayMenusList.dayMenusTable().setModel(new AllDayMenusTableModel(controller));
    }



}
