package net.guillotine.enchained.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.guillotine.enchained.Enchained;
import net.guillotine.enchained.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

	 //creating the item
	 public static final Block IRON_NUGGET_CUBE = registerBlock("iron_nugget_cube",
	 	new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.GILDED_BLACKSTONE)));

	 //helper methods
	 private static Block registerBlock(String name, Block block) {
		  registerBlockItem(name, block);
		  return Registry.register(Registries.BLOCK, Identifier.of(Enchained.MOD_ID, name), block);
	 }
	 //the above
	 private static void registerBlockItem(String name, Block block) {
		  Registry.register(Registries.ITEM, Identifier.of(Enchained.MOD_ID, name),
					new BlockItem(block, new Item.Settings()));
	 }

	 public static void registerModBlocks() {
		  Enchained.LOGGER.info("Registering mod blocks for "+Enchained.MOD_ID);

		  //adding it to a creative mod tab
		  ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
					entries.add(ModBlocks.IRON_NUGGET_CUBE);
		  });
	 }
}

