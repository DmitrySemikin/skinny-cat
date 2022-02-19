package data;

import java.util.List;

public class DayMenu {

    private final long id;
    private String name;
    private String description;
    private final List<FoodstuffUse> foodstuffs;

    public DayMenu(
            final long id,
            final String name,
            final String description,
            final List<FoodstuffUse> foodstuffs
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.foodstuffs = foodstuffs;
    }

    public long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public String description() {
        return description;
    }

    public void description(String description) {
        this.description = description;
    }

    public List<FoodstuffUse> foodstuffs() {
        return foodstuffs;
    }

    public void replaceFoodstuffs(final List<FoodstuffUse> foodstuffs) {
        this.foodstuffs.clear();
        this.foodstuffs.addAll(foodstuffs);
    }
}
