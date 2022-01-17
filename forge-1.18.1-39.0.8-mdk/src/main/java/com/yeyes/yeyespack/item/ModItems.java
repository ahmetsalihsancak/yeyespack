package com.yeyes.yeyespack.item;

import com.yeyes.yeyespack.YeyesPack;
import com.yeyes.yeyespack.item.custom.ModArmorItem;
import com.yeyes.yeyespack.item.custom.TraderVillagerItem;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, YeyesPack.MOD_ID);
	
	public static final RegistryObject<Item> GOLD_CURRENCY = ITEMS.register("gold_currency", () -> getCurrencyItem());
	
	public static final RegistryObject<Item> SILVER_CURRENCY = ITEMS.register("silver_currency", () -> getCurrencyItem());

	public static final RegistryObject<Item> BRONZE_CURRENCY = ITEMS.register("bronze_currency", () -> getCurrencyItem());
	
	public static final RegistryObject<Item> TRADER_SUIT_BOOTS = ITEMS.register("trader_suit_boots", 
			() -> new ArmorItem(ModArmorMaterial.TRADER_SUIT, EquipmentSlot.FEET,
					getTraderSuitArmorProperties()));

	public static final RegistryObject<Item> TRADER_SUIT_LEGGINGS = ITEMS.register("trader_suit_leggings", 
			() -> new ArmorItem(ModArmorMaterial.TRADER_SUIT, EquipmentSlot.LEGS,
					getTraderSuitArmorProperties()));

	public static final RegistryObject<Item> TRADER_SUIT_CHESTPLATE = ITEMS.register("trader_suit_chestplate", 
			() -> new ModArmorItem(ModArmorMaterial.TRADER_SUIT, EquipmentSlot.CHEST,
					getTraderSuitArmorProperties()));

	public static final RegistryObject<Item> TRADER_SUIT_HELMET = ITEMS.register("trader_suit_helmet", 
			() -> new ArmorItem(ModArmorMaterial.TRADER_SUIT, EquipmentSlot.HEAD,
					getTraderSuitArmorProperties()));
	
	public static final RegistryObject<Item> GOD_TIER_SWORD = ITEMS.register("god_tier_sword", 
			() -> new SwordItem(ModTiers.GOD_TIER, 2, 2f, new Item.Properties().tab(CreativeModeTabCreator.YEYES_PACK_TAB)));

    public static final RegistryObject<BlockItem> WOODWORKING_TABLE = ITEMS.register("woodworking_table",
            () -> new BlockItem(ModBlocks.WOODWORKING_TABLE.get(), new Item.Properties().tab(CreativeModeTabCreator.YEYES_PACK_TAB)));
    
    public static final RegistryObject<Item> TRADER_VILLAGER_ITEM = ITEMS.register("trader_villager_item",
            () -> new TraderVillagerItem(getTraderVillagerItemProperties()));
    
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
	
	private static Item getCurrencyItem() {
		Item.Properties currencyProperties = new Item.Properties();
		currencyProperties.stacksTo(64);
		currencyProperties.tab(CreativeModeTabCreator.YEYES_PACK_TAB);
		return new Item(currencyProperties);
	}

	private static Properties getTraderSuitArmorProperties() {
		Item.Properties properties = new Item.Properties();
		properties.tab(CreativeModeTabCreator.YEYES_PACK_TAB);
		return properties;
	}
	
	private static Properties getTraderVillagerItemProperties() {
		Item.Properties properties = new Item.Properties();
		properties.defaultDurability(1);
		properties.durability(1);
		properties.tab(CreativeModeTabCreator.YEYES_PACK_TAB);
		return properties;
	}
}
