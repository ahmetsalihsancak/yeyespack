package com.yeyes.yeyespack.villager;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.yeyes.yeyespack.YeyesPack;
import com.yeyes.yeyespack.item.ModBlocks;
import com.yeyes.yeyespack.item.ModItems;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillager {

	public static final DeferredRegister<PoiType> POINT_OF_INTEREST_TYPE = DeferredRegister.create(ForgeRegistries.POI_TYPES, YeyesPack.MOD_ID);
	public static final DeferredRegister<VillagerProfession> VILLAGER_PROF = DeferredRegister.create(ForgeRegistries.PROFESSIONS, YeyesPack.MOD_ID);
	
	public static final RegistryObject<PoiType> YEYESPACK_POI = POINT_OF_INTEREST_TYPE.register("example",
			() -> new PoiType("example", PoiType.getBlockStates(ModBlocks.WOODWORKING_TABLE.get()), 1, 1));
	public static final RegistryObject<VillagerProfession> YEYESPACK_PROF = VILLAGER_PROF.register("example", 
			() -> new VillagerProfession("example", YEYESPACK_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_CLERIC));
	
	public static void register(IEventBus eventBus) {
		POINT_OF_INTEREST_TYPE.register(eventBus);
		VILLAGER_PROF.register(eventBus);
	}
	
	public static void registerPOI() {
		try {
			ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, YEYESPACK_POI.get());
		} catch (InvocationTargetException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void fillTradeData() {
		ModVillagerTrades trade = new ModVillagerTrades();
		VillagerTrades.ItemListing[] trade2 = new VillagerTrades.ItemListing[] {trade}; 
		VillagerTrades.TRADES.put(YEYESPACK_PROF.get(),toIntMap(ImmutableMap.of(1, trade2, 2, trade2, 3, trade2, 4, trade2, 5, trade2)));
	}
	
	private static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> p_35631_) {
	      return new Int2ObjectOpenHashMap<>(p_35631_);
	}
}
