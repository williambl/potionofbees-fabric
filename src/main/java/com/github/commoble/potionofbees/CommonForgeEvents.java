package com.github.commoble.potionofbees;

import net.minecraft.world.World;
import net.minecraftforge.event.entity.ProjectileImpactEvent;

public class CommonForgeEvents
{
	public static void onProjectileImpact(ProjectileImpactEvent event)
	{
		World world = event.getEntity().getEntityWorld();
		if (!world.isRemote)
		{
			WorldUtil.spawnAngryBees(world, event.getRayTraceResult().getHitVec());
		}
	}
}
