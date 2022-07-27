package xyz.dsemikin.skinnycat.guiswing;

import xyz.dsemikin.skinnycat.guiswing.gui2.SkinnyCatMainWindowView2;
import xyz.dsemikin.skinnycat.guiswing.gui2.SkinnyCatMainWindowViewController2;
import xyz.dsemikin.skinnycat.guiswing.gui2.activedaymenus.ActiveDayMenusView2;
import xyz.dsemikin.skinnycat.guiswing.gui2.alldaymenus.AllDayMenusView2;
import xyz.dsemikin.skinnycat.guiswing.gui2.alldaymenus.AllDayMenusViewController2;
import xyz.dsemikin.skinnycat.guiswing.gui2.daymenudetails.DayMenuDetailsView2;
import xyz.dsemikin.skinnycat.guiswing.logic.AllDayMenusFeatureController;
import xyz.dsemikin.skinnycat.guiswing.logic.AllDayMenusPersistencyController;
import xyz.dsemikin.skinnycat.guiswing.logic.SkinnyCatRootController;

/**
 * For now I am going to implement dependency injection (via constructor) manually.
 * And this class (bootstrapper) is aimed to create all needed objects and to pass
 * them to each other's constructors.
 */
public class Bootstrapper {

    public static SkinnyCatRootController bootstrap() {

        //        new SkinnyCatMainWindowViewController();


        final var allDayMenusView = new AllDayMenusView2();
        final var allDayMenusViewController = new AllDayMenusViewController2(allDayMenusView);
        final var allDayMenusPersistencyController = new AllDayMenusPersistencyController();
        final var allDayMenusFeatureController = new AllDayMenusFeatureController(allDayMenusViewController, allDayMenusPersistencyController);

        final var activeDayMenusView = new ActiveDayMenusView2();

        final var dayMenuDetailsView = new DayMenuDetailsView2();

        final var mainWindowView = new SkinnyCatMainWindowView2(allDayMenusView, activeDayMenusView, dayMenuDetailsView);
        final var mainWindowViewController = new SkinnyCatMainWindowViewController2(mainWindowView);

        @SuppressWarnings("UnnecessaryLocalVariable")
        final var rootController = new SkinnyCatRootController(mainWindowViewController);

        return rootController;
    }

}
