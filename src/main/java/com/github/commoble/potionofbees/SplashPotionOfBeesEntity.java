package com.github.commoble.potionofbees;

import com.github.commoble.potionofbees.networking.Packets;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

@SuppressWarnings("EntityConstructor")
public class SplashPotionOfBeesEntity extends ThrownItemEntity
{
	public SplashPotionOfBeesEntity(EntityType<? extends SplashPotionOfBeesEntity> entityType, World world)
	{
		super(entityType, world);
	}
	
	private SplashPotionOfBeesEntity(World worldIn, LivingEntity throwerIn)
	{
		super(RegistryObjects.getSplashPotionOfBeesEntityType(), throwerIn, worldIn);
	}
	
	public static SplashPotionOfBeesEntity asThrownEntity(World worldIn, LivingEntity throwerIn)
	{
		return new SplashPotionOfBeesEntity(worldIn, throwerIn);
	}

	@Override
	protected Item getDefaultItem()
	{
		return RegistryObjects.getSplashPotionOfBeesItem();
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
			this.world.syncGlobalEvent(2002, this.getBlockPos(), PotionUtil.getColor(Potions.FIRE_RESISTANCE));
			WorldUtil.spawnAngryBees(this.world, result.getPos());
		}

		this.remove();
	}

	@Override
	public Packet<?> createSpawnPacket() {
		return Packets.newSpawnPacket(this);
	}
}
