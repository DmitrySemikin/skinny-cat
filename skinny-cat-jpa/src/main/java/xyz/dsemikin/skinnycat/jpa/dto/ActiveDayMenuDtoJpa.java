package xyz.dsemikin.skinnycat.jpa.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "active_day_menu")
@Table(name = "active_day_menu")
public class ActiveDayMenuDtoJpa {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="day_menu")
    private DayMenuDtoJpa dayMenu;

    /** Used to order activeDayMenus in activeDayMenuList */
    @Column(name="order_position")
    private Integer orderPosition;

    public ActiveDayMenuDtoJpa() {
    }

    public ActiveDayMenuDtoJpa(Long id, DayMenuDtoJpa dayMenu, Integer orderPosition) {
        this.id = id;
        this.dayMenu = dayMenu;
        this.orderPosition = orderPosition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayMenuDtoJpa getDayMenu() {
        return dayMenu;
    }

    public void setDayMenu(DayMenuDtoJpa dayMenu) {
        this.dayMenu = dayMenu;
    }

    public Integer getOrderPosition() {
        return orderPosition;
    }

    public void setOrderPosition(Integer orderPosition) {
        this.orderPosition = orderPosition;
    }
}
