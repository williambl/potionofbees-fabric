package com.github.commoble.potionofbees;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.passive.BeeEntity;

public class AttackThingsThatAreNotBeesGoal extends FollowTargetGoal<LivingEntity>
{
	public static boolean isThingNotBee(LivingEntity ent)
	{
		return (ent.getType() != EntityType.BEE);
	}
	
	AttackThingsThatAreNotBeesGoal(BeeEntity entity)
	{
		super(entity, LivingEntity.class, 10, true, false, AttackThingsThatAreNotBeesGoal::isThingNotBee);
	}

	@Override
	public boolean canStart()
	{
		return this.canSting() && super.canStart();
	}

	@Override
	protected void findClosestTarget()
	{
		this.targetEntity = this.mob.world.getClosestEntity(
			this.targetClass,
			this.targetPredicate,
			this.mob,
			this.mob.getX(),
			this.mob.getY(),
			this.mob.getZ(),
			this.getSearchBox(this.getFollowRange()));
	}

	@Override
	public boolean shouldContinue()
	{
		boolean flag = this.canSting();
		if (flag && this.mob.getTarget() != null)
		{
			return super.shouldContinue();
		}
		else
		{
			this.target = null;
			return false;
		}
	}

	private boolean canSting()
	{
		BeeEntity beeentity = (BeeEntity) this.mob;
		return beeentity.hasAngerTime() && !beeentity.hasStung();
	}
}
