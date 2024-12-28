package net.guillotine.enchained;

import net.fabricmc.api.ModInitializer;

import net.guillotine.enchained.block.ModBlocks;
import net.guillotine.enchained.item.ModItems;
import net.guillotine.enchained.util.ECLootTables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Enchained implements ModInitializer {
	public static final String MOD_ID = "enchained";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ECLootTables.modifyLootTables();
		ModBlocks.registerModBlocks();
	}
}