package xyz.dsemikin.skinnycat.guiswing.logic;

import xyz.dsemikin.skinnycat.guiswing.gui2.alldaymenus.AllDayMenusViewController2;

public class AllDayMenusFeatureController {

    private final AllDayMenusViewController2 viewController;
    private final AllDayMenusPersistencyController persistencyController;

    public AllDayMenusFeatureController(
            final AllDayMenusViewController2 viewController,
            final AllDayMenusPersistencyController persistencyController
    ) {
        this.viewController = viewController;
        this.persistencyController = persistencyController;
    }
}
