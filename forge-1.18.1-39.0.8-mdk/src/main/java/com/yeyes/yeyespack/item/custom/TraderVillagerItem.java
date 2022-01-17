package com.yeyes.yeyespack.item.custom;

import java.util.Objects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class TraderVillagerItem extends Item {

	public TraderVillagerItem(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
		// TODO Auto-generated method stub
		
		Level world = context.getLevel();
		
		if (!world.isClientSide) {
			Player player = Objects.requireNonNull(context.getPlayer());
			BlockPos blockPos = context.getClickedPos();
			BlockState clickedBlock = world.getBlockState(blockPos);
			if (clickedBlock.getBlock() == Blocks.GLASS) {
				String pos = String.valueOf(blockPos.getX()) + " " + String.valueOf(blockPos.getY()+1) + " " + String.valueOf(blockPos.getZ());
				String facing = " " + String.valueOf(player.xRotO) + " " + String.valueOf(player.yRotO);
				String command = "/summon villager "
						+ pos + facing
						+ " {VillagerData:{profession:\"yeyespack:example\",level:99},PersistenceRequired:1,Silent:1,NoAI:1,CustomName:\"\\\"Trader\\\"\","
						+ "	Offers:{"
						+ "		Recipes:[{"
						+ "			buy:{"
						+ "				id:\"yeyespack:gold_currency\",Count:1"
						+ "				},"
						+ "			sell:{"
						+ "				id:\"yeyespack:silver_currency\",Count:64"
						+ "				},"
						+ "			rewardExp:0b,maxUses:12"
						+ "			},{"
						+ "			buy:{"
						+ "				id:\"yeyespack:silver_currency\",Count:64"
						+ "				},"
						+ "			sell:{"
						+ "				id:\"yeyespack:gold_currency\",Count:1"
						+ "				},"
						+ "			rewardExp:0b,maxUses:12"
						+ "			},{"
						+ "			buy:{"
						+ "				id:\"yeyespack:gold_currency\",Count:1"
						+ "				},"
						+ "			sell:{"
						+ "				id:\"minecraft:gunpowder\",Count:64"
						+ "				},"
						+ "			rewardExp:0b,maxUses:12"
						+ "			}]"
						+ "		}"
						+ "}";
				world.getServer().getCommands().performCommand(player.createCommandSourceStack(), command);
			}
		}
		return super.onItemUseFirst(stack, context);
	}
	
}
