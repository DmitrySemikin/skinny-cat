package xyz.dsemikin.skinnycat.guiswing.logic;

import xyz.dsemikin.skinnycat.data.DayMenu;
import xyz.dsemikin.skinnycat.jpa.dao.DayMenuDao;
import xyz.dsemikin.skinnycat.jpa.dao.EntityManagerProvider;
import xyz.dsemikin.skinnycat.jpa.dto.DayMenuDtoJpa;
import xyz.dsemikin.skinnycat.jpa.mapper.DayMenuMapperJpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AllDayMenusController {

    private final DayMenuDao dao;
    private final DayMenuMapperJpa mapper;

    public AllDayMenusController(final EntityManagerProvider entityManagerProvider) {
        this.mapper = new DayMenuMapperJpa();
        this.dao = new DayMenuDao(entityManagerProvider);
    }

    public List<Long> allIds() {
        return mapper.fromDtoList(dao.all()).stream().map(DayMenu::id).sorted().toList();
    }

    public Optional<DayMenu> get(final long id) {
        DayMenuDtoJpa maybeDto = dao.findById(id);
        if (maybeDto != null) {
            return Optional.of(mapper.fromDto(maybeDto)); // TODO: check for null
        } else {
            return Optional.empty();
        }
    }

    public void setName(final long id, final String name) {
        final DayMenuDtoJpa maybeDayMenu = dao.findById(id);
        if (maybeDayMenu != null) {
            maybeDayMenu.setName(name);
            dao.persistExisting(maybeDayMenu);
        }
        // TODO: else
    }

    public void setDescription(final long id, final String description) {
        final DayMenuDtoJpa maybeDayMenu = dao.findById(id);
        if (maybeDayMenu != null) {
            maybeDayMenu.setDescription(description);
            dao.persistExisting(maybeDayMenu);
        }
        // TODO: else
    }

    public void addDayMenuWithDefaultParameters() {
        final DayMenuDtoJpa dayMenuDto = mapper.toDto(new DayMenu(0L, "DayMenu Name", "Description", new ArrayList<>()));
        dayMenuDto.setId(null);
        dao.persistNew(dayMenuDto);
    }

    public void deleteDayMenu(final long id) {
        dao.delete(id);
    }
}
