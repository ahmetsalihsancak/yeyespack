package com.yeyes.yeyespack.item.custom;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.yeyes.yeyespack.item.ModArmorMaterial;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ModArmorItem extends ArmorItem {

	
	private static final Map<ArmorMaterial, MobEffect> MATERIAL_TO_EFFECT_MAP = 
			(new ImmutableMap.Builder<ArmorMaterial, MobEffect>().put(ModArmorMaterial.TRADER_SUIT,
					MobEffects.MOVEMENT_SPEED).build());
	
	public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
		super(material, slot, properties);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
		if (!world.isClientSide()) {
			if (entity instanceof Player) {
				Player player = (Player)entity;
				if(hasFullSuitOfArmorOn(player)){
					evaluateArmorEffect(player);
				}
			}
		}
		super.inventoryTick(stack, world, entity, slot, selected);
	}

	private void evaluateArmorEffect(Player player) {
		// TODO Auto-generated method stub
		for (Map.Entry<ArmorMaterial, MobEffect> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
			ArmorMaterial mapArmorMat = entry.getKey();
			MobEffect mobEf = entry.getValue();
			if (hasCorrectArmorOn(mapArmorMat, player)) {
				addStatusEffectForMaterial(player, mapArmorMat, mobEf);
			}
		}
		
	}

	private boolean hasCorrectArmorOn(ArmorMaterial mapArmorMat, Player player) {
		// TODO Auto-generated method stub
		ArmorItem chestplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
		return chestplate.getMaterial() == mapArmorMat;
	}

	private void addStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMat, MobEffect mobEf) {
		// TODO Auto-generated method stub
		boolean hasPlayerEffect = player.hasEffect(mobEf);
		
		if (hasCorrectArmorOn(mapArmorMat, player) && !hasPlayerEffect) {
			player.addEffect(new MobEffectInstance(mobEf, 200));
		}
		
	}

	private boolean hasFullSuitOfArmorOn(Player player) {
		// TODO Auto-generated method stub
		ItemStack chestplate = player.getInventory().getArmor(2);
		return !chestplate.isEmpty();
	}

}
