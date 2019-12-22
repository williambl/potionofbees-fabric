package com.github.commoble.potionofbees;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SplashPotionItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SplashPotionOfBeesItem extends Item
{

	public SplashPotionOfBeesItem(Settings settings)
	{
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		ItemStack itemstack = playerIn.getStackInHand(handIn);
		worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.ENTITY_EXPERIENCE_BOTTLE_THROW,
			SoundCategory.NEUTRAL, 0.5F, 0.4F / (worldIn.random.nextFloat() * 0.4F + 0.8F));
		if (!worldIn.isClient)
		{
			SplashPotionOfBeesEntity potionEntity = SplashPotionOfBeesEntity.asThrownEntity(worldIn, playerIn);
			potionEntity.setItem(itemstack);
			potionEntity.setProperties(playerIn, playerIn.pitch, playerIn.yaw, -20.0F, 0.7F, 1.0F);
			worldIn.spawnEntity(potionEntity);
		}

		playerIn.incrementStat(Stats.USED.getOrCreateStat(this));
		if (!playerIn.abilities.creativeMode)
		{
			itemstack.decrement(1);
		}

		return TypedActionResult.success(itemstack);
	}
}
