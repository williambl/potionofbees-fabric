package com.github.commoble.potionofbees;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class PotionOfBeesItem extends Item
{
	public PotionOfBeesItem(Settings settings)
	{
		super(settings);
	}

	@Override
	public int getMaxUseTime(ItemStack stack)
	{
		return 32;
	}

	@Override
	public UseAction getUseAction(ItemStack stack)
	{
		return UseAction.DRINK;
	}

	@Override
	public TypedActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		playerIn.setCurrentHand(handIn);
		return TypedActionResult.consume(playerIn.getStackInHand(handIn));
	}

	/**
	 * Called when the player finishes using this Item (E.g. finishes eating.). Not
	 * called when the player stops using the Item before the action is complete.
	 */
	@Override
	public ItemStack finishUsing(ItemStack stack, World worldIn, LivingEntity entityLiving)
	{
		PlayerEntity playerentity = entityLiving instanceof PlayerEntity ? (PlayerEntity) entityLiving : null;
		if (playerentity instanceof ServerPlayerEntity)
		{
			Criteria.CONSUME_ITEM.trigger((ServerPlayerEntity) playerentity, stack);
		}

		if (!worldIn.isClient)
		{
			entityLiving.damage(DamageSource.CRAMMING, 4F);
			WorldUtil.spawnAngryBees(worldIn, entityLiving.getPos());
		}

		if (playerentity != null)
		{
			playerentity.incrementStat(Stats.USED.getOrCreateStat(this));
			if (!playerentity.abilities.creativeMode)
			{
				stack.decrement(1);
			}
		}

		if (playerentity == null || !playerentity.abilities.creativeMode)
		{
			if (stack.isEmpty())
			{
				return new ItemStack(Items.GLASS_BOTTLE);
			}

			if (playerentity != null)
			{
				playerentity.inventory.insertStack(new ItemStack(Items.GLASS_BOTTLE));
			}
		}

		return stack;
	}
}
