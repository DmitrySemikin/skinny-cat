package xyz.dsemikin.skinnycat.guiswing.logic;

import xyz.dsemikin.skinnycat.data.Foodstuff;
import xyz.dsemikin.skinnycat.data.FoodstuffUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FoodstuffController {

    // TODO: Current implementation will be just in memory backed by some container.
    // TODO: Connect it to corresponding REST service instead

    private final List<Foodstuff> content;

    public FoodstuffController() {
        content = new ArrayList<>();
        content.add(new Foodstuff(1, "apple", FoodstuffUnit.UNIT));
        content.add(new Foodstuff(2, "egg", FoodstuffUnit.UNIT));
        content.add(new Foodstuff(3, "chicken", FoodstuffUnit.GRAM));
    }

    public void addFoodstuff(final String name, final FoodstuffUnit unit) {
        // TODO: add check for setName uniqueness
        final Optional<Long> maybeMaxId = content.stream().map(Foodstuff::id).max(Long::compareTo);
        final long newId = maybeMaxId.orElse(0L) + 1L;
        final Foodstuff newFoodstuff = new Foodstuff(newId, name, unit);
        content.add(newFoodstuff);
    }

    public void deleteFoodstuff(final long id) {
        content.removeIf(fs -> fs.id() == id);
    }

    public List<Long> allIds() {
        return content.stream().map(Foodstuff::id).sorted().toList();
    }

    public Foodstuff get(final long id) {
        //noinspection OptionalGetWithoutIsPresent
        return content.stream().filter(fs -> fs.id() == id).findFirst().get();
    }

    public void setName(final long id, final String newName) {
        final Foodstuff oldValue = get(id);
        deleteFoodstuff(id);
        content.add(new Foodstuff(id, newName, oldValue.unit()));
    }

    public void setUnit(final long id, final FoodstuffUnit newUnit) {
        final Foodstuff oldValue = get(id);
        deleteFoodstuff(id);
        content.add(new Foodstuff(id, oldValue.name(), newUnit));
    }
}
