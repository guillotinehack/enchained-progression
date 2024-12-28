package net.guillotine.enchained.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.guillotine.enchained.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ECLootTables {
	 public static void modifyLootTables() {
		  //changes the loot table for short grass to ADD fiber as a drop
		  LootTableEvents.MODIFY.register((key, tableBuilder, source, build) -> {
			   if(source.isBuiltin() && (Blocks.SHORT_GRASS.getLootTableKey().equals(key))) {
					LootPool.Builder poolBuilder = LootPool.builder()
							  .rolls(ConstantLootNumberProvider.create(1))
							  .conditionally(RandomChanceLootCondition.builder(0.1f)) //10% chance drop
							  .with(ItemEntry.builder(ModItems.FIBER))
							  .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build());
					tableBuilder.pool(poolBuilder.build());
			   }
		  });
	 }
}