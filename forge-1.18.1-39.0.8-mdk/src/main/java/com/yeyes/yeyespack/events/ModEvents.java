package com.yeyes.yeyespack.events;

import java.util.Random;

import com.yeyes.yeyespack.YeyesPack;
import com.yeyes.yeyespack.item.ModItems;
import com.yeyes.yeyespack.villager.ModVillager;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = YeyesPack.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

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
		/*NEUTRAL MOBS*/
		case "Goat":
			i = random.nextInt(3) + 7;
			currency = new ItemStack(ModItems.BRONZE_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Salmon":
			i = random.nextInt(3) + 7;
			currency = new ItemStack(ModItems.BRONZE_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Cod":
			i = random.nextInt(3) + 7;
			currency = new ItemStack(ModItems.BRONZE_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Chicken":
			i = random.nextInt(3) + 7;
			currency = new ItemStack(ModItems.BRONZE_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Cow":
			i = random.nextInt(3) + 7;
			currency = new ItemStack(ModItems.BRONZE_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Pig":
			i = random.nextInt(3) + 7;
			currency = new ItemStack(ModItems.BRONZE_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Sheep":
			i = random.nextInt(3) + 7;
			currency = new ItemStack(ModItems.BRONZE_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
			/*MOBS*/
		case "Silverfish":
			i = random.nextInt(3) + 5;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Phantom":
			i = random.nextInt(3) + 5;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Chicken Jockey":
			i = random.nextInt(3) + 10;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
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
		case "Cave Spider":
			i = random.nextInt(3) + 5;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Spider":
			i = random.nextInt(3) + 5;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Stray":
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
			/*BOSSES*/
		case "Wither":
			i = random.nextInt(3) + 8;
			currency = new ItemStack(ModItems.GOLD_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Ender Dragon":
			i = random.nextInt(6) + 15;
			currency = new ItemStack(ModItems.GOLD_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
			/*NETHER*/
		case "Piglin":
			i = random.nextInt(4) + 7;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Zombified Piglin":
			i = random.nextInt(4) + 7;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Blaze":
			i = random.nextInt(3) + 10;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Hoglin":
			i = random.nextInt(4) + 7;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Piglin Brute":
			i = random.nextInt(3) + 20;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Zoglin":
			i = random.nextInt(4) + 7;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Wither Skeleton":
			i = random.nextInt(3) + 10;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Ghast":
			i = random.nextInt(3) + 7;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
			/*WATER MOBS*/
		case "Drowned":
			i = random.nextInt(3) + 5;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Elder Guardian":
			i = random.nextInt(6) + 15;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Guardian":
			i = random.nextInt(6) + 10;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
			/*VILLAGER*/
		case "Pillager":
			i = random.nextInt(3) + 5;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Ravager":
			i = random.nextInt(3) + 20;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Vindicator":
			i = random.nextInt(6) + 10;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Vex":
			i = random.nextInt(4) + 7;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
			/*END*/
		case "Shulker":
			i = random.nextInt(3) + 5;
			currency = new ItemStack(ModItems.SILVER_CURRENCY.get(), i);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		default:
			return;
		}
	} 
}
