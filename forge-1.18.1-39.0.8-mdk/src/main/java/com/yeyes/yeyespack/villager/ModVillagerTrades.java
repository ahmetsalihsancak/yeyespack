package com.yeyes.yeyespack.villager;

import java.util.Random;

import com.yeyes.yeyespack.item.ModItems;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;

public class ModVillagerTrades implements VillagerTrades.ItemListing {

	@Override
	public MerchantOffer getOffer(Entity p_35706_, Random p_35707_) {
		// TODO Auto-generated method stub
		return new MerchantOffer(new ItemStack(ModItems.GOLD_CURRENCY.get(), 1), 
				new ItemStack(Items.GUNPOWDER, 5), 10, 1, 1);
	}

}
