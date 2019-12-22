package com.github.commoble.potionofbees;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SplashPotionOfBeesEntity extends ThrownItemEntity
{
	public SplashPotionOfBeesEntity(EntityType<? extends SplashPotionOfBeesEntity> entityType, World world)
	{
		super(entityType, world);
	}
	
	private SplashPotionOfBeesEntity(World worldIn, LivingEntity throwerIn)
	{
		super(RegistryObjects.SPLASH_POTION_OF_BEES_ENTITY_TYPE, throwerIn, worldIn);
	}
	
	public static SplashPotionOfBeesEntity asThrownEntity(World worldIn, LivingEntity throwerIn)
	{
		return new SplashPotionOfBeesEntity(worldIn, throwerIn);
	}
	
	@Override
	protected Item getDefaultItem()
	{
		return RegistryObjects.SPLASH_POTION_OF_BEES_ITEM;
	}

	@Override
	protected float getGravity()
	{
		return 0.07F;
	}

	@Override
	protected void onCollision(HitResult result)
	{
		if (!this.world.isClient)
		{
			this.world.playGlobalEvent(2002, new BlockPos(this), PotionUtil.getColor(Potions.FIRE_RESISTANCE));
			WorldUtil.spawnAngryBees(this.world, result.getPos());
		}

		this.remove();
	}
}
