package com.github.commoble.potionofbees;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Optional;

public class WorldUtil
{
	public static void spawnAngryBees(World world, Vec3d vec)
	{
		Box targetBox = new Box(vec,vec).expand(PotionOfBeesMod.BEE_SEARCH_RADIUS);

		Optional<LivingEntity> foundTarget =
				world.getEntities(LivingEntity.class, targetBox, WorldUtil::isValidBeeTarget).stream()
						.reduce((entityA, entityB) -> entityB.squaredDistanceTo(vec) < entityA.squaredDistanceTo(vec) ? entityB : entityA);


		int bees = 3 + world.random.nextInt(5) + world.random.nextInt(5);

		int maxTime = 3000;
		int ticksToExist = maxTime/bees;

		for (int i=0; i<bees; i++)
		{
			BlockPos spawnPos = new BlockPos(vec.x, vec.y, vec.z);
			BeeEntity bee = EntityType.BEE.spawn(world, null, null, null, spawnPos, SpawnType.EVENT, false, false);
			bee.setPosition(vec.x, vec.y, vec.z);
			bee.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, maxTime, 1, false, false));
			bee.addStatusEffect(new StatusEffectInstance(RegistryObjects.EVANESCENCE_EFFECT, ticksToExist, 0, false, false));
			foundTarget.ifPresent(target -> { // make bee angry at target
				bee.setBeeAttacker(target);
				((MobEntityTargetSelectorAccessor) bee).getTargetSelector().add(0, new AttackThingsThatAreNotBeesGoal(bee));
			});
		}
	}

	public static boolean isValidBeeTarget(LivingEntity ent)
	{
		return (ent.getType() != EntityType.BEE) && (!ent.isInvulnerable());
	}
}
