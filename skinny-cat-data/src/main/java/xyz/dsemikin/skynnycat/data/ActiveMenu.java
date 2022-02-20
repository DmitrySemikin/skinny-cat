package xyz.dsemikin.skynnycat.data;

import java.util.List;

public record ActiveMenu(
        String name,
        List<DayMenu> dayMenus
)
{}
