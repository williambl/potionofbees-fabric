package com.github.commoble.potionofbees;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BeePotionEntity extends ProjectileItemEntity
{
	public BeePotionEntity(EntityType<? extends BeePotionEntity> entityType, World world)
	{
		super(entityType, world);
	}

	@Override
	protected Item func_213885_i()
	{
		return PotionOfBeesMod.BEE_POTION_ITEM.get();
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
			this.world.playEvent(2002, new BlockPos(this), PotionUtils.getPotionColor(Potions.WATER));
			int i = 3 + this.world.rand.nextInt(5) + this.world.rand.nextInt(5);

			while (i > 0)
			{
				i--;
				Vec3d hitVec = result.getHitVec();
				BlockPos spawnPos = new BlockPos(hitVec.x, hitVec.y, hitVec.z);
				Entity ent = PotionOfBeesMod.BEE_POTION_ENTITY_TYPE.get().spawn(this.world, null, null, spawnPos, SpawnReason.EVENT, false, false);
				if (ent instanceof BeeEntity)
				{
					BeeEntity bee = (BeeEntity)ent;
				}
				
			}

			this.remove();
		}

	}
}
