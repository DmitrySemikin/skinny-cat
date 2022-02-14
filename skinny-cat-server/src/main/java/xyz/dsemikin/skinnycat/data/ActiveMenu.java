package xyz.dsemikin.skinnycat.data;

import java.util.List;

public record ActiveMenu(
        String name,
        List<DayMenu> dayMenus
)
{}
