package com.yeyes.yeyespack.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class ModTiers {

	public static final ForgeTier GOD_TIER = new ForgeTier(5, 20310, 90.0F, 40.0F, 150, Tags.Blocks.NEEDS_NETHERITE_TOOL,
			() -> Ingredient.of(Items.NETHERITE_INGOT));
	
}
