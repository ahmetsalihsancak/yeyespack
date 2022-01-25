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
			if (true/*clickedBlock.getBlock() == Blocks.GLASS*/) {
				String pos = String.valueOf(blockPos.getX()) + " " + String.valueOf(blockPos.getY()+1) + " " + String.valueOf(blockPos.getZ());
				String command = "/summon villager "
						+ pos
						+ " {VillagerData:{profession:\"yeyespack:example\",level:99},PersistenceRequired:1,Silent:1,CustomName:\"\\\"Trader\\\"\","
						+ "	Offers:{"
						+ "		Recipes:[{"
						+ "			buy:{"
						+ "				id:\"yeyespack:bronze_currency\",Count:64"
						+ "				},"
						+ "			sell:{"
						+ "				id:\"yeyespack:silver_currency\",Count:1"
						+ "				},"
						+ "			rewardExp:0b,maxUses:4"
						+ "			},{"
						+ "			buy:{"
						+ "				id:\"yeyespack:silver_currency\",Count:1"
						+ "				},"
						+ "			sell:{"
						+ "				id:\"yeyespack:bronze_currency\",Count:64"
						+ "				},"
						+ "			rewardExp:0b,maxUses:4"
						+ "			},{"
						+ "			buy:{"
						+ "				id:\"yeyespack:silver_currency\",Count:64"
						+ "				},"
						+ "			sell:{"
						+ "				id:\"yeyespack:gold_currency\",Count:1"
						+ "				},"
						+ "			rewardExp:0b,maxUses:4"
						+ "			},{"
						+ "			buy:{"
						+ "				id:\"yeyespack:gold_currency\",Count:1"
						+ "				},"
						+ "			sell:{"
						+ "				id:\"yeyespack:silver_currency\",Count:64"
						+ "				},"
						+ "			rewardExp:0b,maxUses:4"
						+ "			},{"
						+ "			buy:{"
						+ "				id:\"yeyespack:bronze_currency\",Count:4"
						+ "				},"
						+ "			sell:{"
						+ "				id:\"minecraft:dirt\",Count:1"
						+ "				},"
						+ "			rewardExp:0b,maxUses:600"
						+ "			},{"
						+ "			buy:{"
						+ "				id:\"yeyespack:silver_currency\",Count:1"
						+ "				},"
						+ "			sell:{"
						+ "				id:\"minecraft:cobblestone\",Count:1"
						+ "				},"
						+ "			rewardExp:0b,maxUses:600"
						+ "			},{"
						+ "			buy:{"
						+ "				id:\"yeyespack:silver_currency\",Count:2"
						+ "				},"
						+ "			sell:{"
						+ "				id:\"minecraft:stone\",Count:1"
						+ "				},"
						+ "			rewardExp:0b,maxUses:600"
						+ "			},{"
						+ "			buy:{"
						+ "				id:\"yeyespack:silver_currency\",Count:1"
						+ "				},"
						+ "			sell:{"
						+ "				id:\"minecraft:andesite\",Count:1"
						+ "				},"
						+ "			rewardExp:0b,maxUses:600"
						+ "			},{"
						+ "			buy:{"
						+ "				id:\"yeyespack:silver_currency\",Count:1"
						+ "				},"
						+ "			sell:{"
						+ "				id:\"minecraft:granite\",Count:1"
						+ "				},"
						+ "			rewardExp:0b,maxUses:600"
						+ "			},{"
						+ "			buy:{"
						+ "				id:\"yeyespack:silver_currency\",Count:1"
						+ "				},"
						+ "			sell:{"
						+ "				id:\"minecraft:diorite\",Count:1"
						+ "				},"
						+ "			rewardExp:0b,maxUses:600"
						+ "			},{"
						+ "			buy:{"
						+ "				id:\"yeyespack:silver_currency\",Count:2"
						+ "				},"
						+ "			sell:{"
						+ "				id:\"minecraft:sand\",Count:1"
						+ "				},"
						+ "			rewardExp:0b,maxUses:600"
						+ "			},{"
						+ "			buy:{"
						+ "				id:\"yeyespack:silver_currency\",Count:2"
						+ "				},"
						+ "			sell:{"
						+ "				id:\"minecraft:gravel\",Count:1"
						+ "				},"
						+ "			rewardExp:0b,maxUses:600"
						+ "			},{"
						+ "			buy:{"
						+ "				id:\"yeyespack:silver_currency\",Count:2"
						+ "				},"
						+ "			sell:{"
						+ "				id:\"minecraft:clay\",Count:1"
						+ "				},"
						+ "			rewardExp:0b,maxUses:600"
						+ "			},{"
						+ "			buy:{"
						+ "				id:\"yeyespack:gold_currency\",Count:1"
						+ "				},"
						+ "			sell:{"
						+ "				id:\"minecraft:gunpowder\",Count:4"
						+ "				},"
						+ "			rewardExp:0b,maxUses:16"
						+ "			},{"
						+ "			buy:{"
						+ "				id:\"yeyespack:gold_currency\",Count:2"
						+ "				},"
						+ "			sell:{"
						+ "				id:\"minecraft:golden_apple\",Count:1"
						+ "				},"
						+ "			rewardExp:0b,maxUses:1"
						+ "			}]"
						+ "		}"
						+ "}";
				world.getServer().getCommands().performCommand(player.createCommandSourceStack(), command);
				stack.shrink(1);
			}
		}
		return super.onItemUseFirst(stack, context);
	}
	
}
