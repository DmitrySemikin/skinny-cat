package xyz.dsemikin.skinnycat.guiswing.logic;

import data.DayMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AllDayMenusController {

    final List<DayMenu> allDayMenus;

    public AllDayMenusController() {

        allDayMenus = new ArrayList<>();

        allDayMenus.add(new DayMenu(1L, "Week 1, Day 1", "Breakfast: bla, Supper: bla", new ArrayList<>()));
        allDayMenus.add(new DayMenu(2L, "Week 1, Day 2", "some other description", new ArrayList<>()));
    }

    public List<Long> allIds() {
        return allDayMenus.stream().map(DayMenu::id).toList();
    }

    public Optional<DayMenu> get(final long id) {
        return allDayMenus.stream().filter(dayMenu -> dayMenu.id() == id).findFirst();
    }

    public void setName(final long id, final String name) {
        final Optional<DayMenu> maybeDayMenu = get(id);
        maybeDayMenu.ifPresent(dayMenu -> dayMenu.name(name));
    }

    public void setDescription(final long id, final String description) {
        final Optional<DayMenu> maybeDayMenu = get(id);
        maybeDayMenu.ifPresent(dayMenu -> dayMenu.description(description));
    }
}
