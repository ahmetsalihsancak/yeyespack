package com.yeyes.yeyespack.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeModeTabCreator {

	public static final CreativeModeTab YEYES_PACK_TAB = new CreativeModeTab("yeyesPackTab") {
		
		@Override
		public ItemStack makeIcon() {
			// TODO Auto-generated method stub
			return new ItemStack(ModItems.GOLD_CURRENCY.get());
		}
	};
	
}
