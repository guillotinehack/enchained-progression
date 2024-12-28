package net.guillotine.enchained.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.guillotine.enchained.Enchained;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //test

    //creating the items
    public static final Item FIBER = registerItem("fiber", new Item(new Item.Settings()));
    public static final Item SLING = registerItem("sling", new Item(new Item.Settings()));

    //helper methods
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Enchained.MOD_ID, name), item);
    }

    //the above
    public static void registerModItems() {
        Enchained.LOGGER.info("Registering Mod Items for "+Enchained.MOD_ID);

        //adds it to the ingredients tab in creative mode
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(FIBER);
    });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(SLING);
        });
    }
}

// you can find and change the recipe for items under data/enchained/recipe