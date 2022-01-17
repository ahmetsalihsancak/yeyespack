package com.yeyes.yeyespack.item.custom;

import java.util.Objects;

import net.minecraft.server.MinecraftServer;
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
			BlockState clickedBlock = world.getBlockState(context.getClickedPos());
			if (clickedBlock.getBlock() == Blocks.GLASS) {
				String command = "/summon villager ~ ~1 ~ {VillagerData:{profession:cleric,level:99,type:plains},PersistenceRequired:1,Silent:1,NoAI:1,CustomName:\"\\\"Trader\\\"\","
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
				System.out.println(context.toString() + "  stack:   " + stack.getDisplayName().getString());
				world.getServer().getCommands().performCommand(player.createCommandSourceStack(), command);
				
			}
		}
		return super.onItemUseFirst(stack, context);
	}
	
}
