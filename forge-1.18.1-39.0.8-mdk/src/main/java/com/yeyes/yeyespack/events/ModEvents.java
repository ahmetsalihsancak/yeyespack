package com.yeyes.yeyespack.events;

import com.yeyes.yeyespack.YeyesPack;
import com.yeyes.yeyespack.item.ModItems;
import com.yeyes.yeyespack.villager.ModVillager;

import net.minecraft.client.renderer.DimensionSpecialEffects.OverworldEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraftforge.event.entity.living.LivingConversionEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = YeyesPack.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

	@SubscribeEvent
	public static void commonSetup(FMLCommonSetupEvent e) {
		e.enqueueWork(() -> {
            ModVillager.registerPOI();
            ModVillager.fillTradeData();
        });
	}
	
	@SubscribeEvent
	public static void marketVillagerAction (PlayerInteractEvent.EntityInteract e) {
		Entity entity = e.getEntity();
		if (entity.level.isClientSide()) {
			return;
		}
		Player player = e.getPlayer();
		Entity target = e.getTarget();
		MerchantOffers offers = null;
		Villager villager = (Villager)target;
		offers = villager.getOffers();
		if (player.hasEffect(MobEffects.HERO_OF_THE_VILLAGE)) {
			System.out.println("22222222");
			e.getPlayer().removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
		}
		System.out.println(offers);
		System.out.println(villager);
		if (villager.getName().toString() == "Example Villager") {
			System.out.println("33");
		}
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
		
		ItemStack currency;
		switch (entity.getName().getString()) {
		case "Cow":
			currency = new ItemStack(ModItems.GOLD_CURRENCY.get(), 1);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		case "Sheep":
			currency = new ItemStack(ModItems.BRONZE_CURRENCY.get(), 1);
			e.getDrops().add(new ItemEntity(entity.getCommandSenderWorld(),epos.getX(), epos.getY()+1, epos.getZ(), currency));
			return;
		default:
			return;
		}
	} 
	
}
