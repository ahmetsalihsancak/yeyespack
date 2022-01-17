package com.yeyes.yeyespack.events;

import java.util.Random;

import com.yeyes.yeyespack.YeyesPack;
import com.yeyes.yeyespack.item.ModItems;
import com.yeyes.yeyespack.villager.ModVillager;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = YeyesPack.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

	/*private static Item gold_currency = ModItems.GOLD_CURRENCY.get();
	private static Item silver_currency = ModItems.SILVER_CURRENCY.get();
	private static Item bronze_currency = ModItems.BRONZE_CURRENCY.get();*/

	private static ItemStack currency = null;
	
	@SubscribeEvent
	public static void commonSetup(FMLCommonSetupEvent e) {
		e.enqueueWork(() -> {
            ModVillager.registerPOI();
            ModVillager.fillTradeData();
        });
	}

	@SubscribeEvent
	public static void mobDrop(LivingDropsEvent e) {
		Entity entity = e.getEntity();
		BlockPos epos = entity.blockPosition();
		Entity source = e.getSource().getEntity();
		Player player = null;
		if (entity.level.isClientSide()) {
			return;
		}
		
		/*if (entity instanceof Cow == false) {
			return;
		}*/
		
		if (source instanceof Player == false) {
			return;
		}
		player = (Player) source;
		Random random = player.getRandom();
		int i = 0;
		String entityName = entity.getName().getString();
		
		switch (entityName) {
		case "Cow":
			i = random.nextInt(3) + 7;
			currency = new ItemStack(ModItems.BRONZE_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Sheep":
			i = random.nextInt(3) + 7;
			currency = new ItemStack(ModItems.BRONZE_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Creeper":
			i = random.nextInt(3) + 5;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Zombie":
			i = random.nextInt(3) + 5;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Skeleton":
			i = random.nextInt(3) + 5;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "CaveSpider":
			i = random.nextInt(3) + 5;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Spider":
			i = random.nextInt(3) + 5;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Witch":
			i = random.nextInt(3) + 5;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Husk":
			i = random.nextInt(3) + 5;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "WitherBoss":
			i = random.nextInt(2) + 1;
			currency = new ItemStack(ModItems.GOLD_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "EnderDragon":
			i = random.nextInt(6) + 10;
			currency = new ItemStack(ModItems.GOLD_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		default:
			return;
		}
	} 
	
}
