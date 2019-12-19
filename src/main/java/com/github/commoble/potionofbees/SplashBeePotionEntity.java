package com.github.commoble.potionofbees;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages.SpawnEntity;
import net.minecraftforge.fml.network.NetworkHooks;

public class SplashBeePotionEntity extends ProjectileItemEntity
{
	public SplashBeePotionEntity(EntityType<? extends SplashBeePotionEntity> entityType, World world)
	{
		super(entityType, world);
	}
	
	private SplashBeePotionEntity(World worldIn, LivingEntity throwerIn)
	{
		super(RegistryObjects.getSplashPotionOfBeesEntityType(), throwerIn, worldIn);
	}
	
	public static SplashBeePotionEntity asThrownEntity(World worldIn, LivingEntity throwerIn)
	{
		return new SplashBeePotionEntity(worldIn, throwerIn);
	}
	
	public static SplashBeePotionEntity spawnOnClient(SpawnEntity spawnPacket, World world)
	{
		return new SplashBeePotionEntity(RegistryObjects.getSplashPotionOfBeesEntityType(), world);
	}

	@Override
	protected Item func_213885_i()
	{
		return RegistryObjects.BEE_POTION_ITEM.get();
	}

	/**
	 * Gets the amount of gravity to apply to the thrown entity with each tick.
	 */
	@Override
	protected float getGravityVelocity()
	{
		return 0.07F;
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	@Override
	protected void onImpact(RayTraceResult result)
	{
		if (!this.world.isRemote)
		{
			this.world.playEvent(2002, new BlockPos(this), PotionUtils.getPotionColor(Potions.FIRE_RESISTANCE));
			WorldUtil.spawnAngryBees(this.world, result.getHitVec());
		}

		this.remove();

	}
	
	@Override
	public IPacket<?> createSpawnPacket()
	{
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
