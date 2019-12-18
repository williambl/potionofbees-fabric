package com.github.commoble.potionofbees;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.ProjectileImpactEvent;

public class CommonForgeEvents
{
	public static void onProjectileImpact(ProjectileImpactEvent event)
	{
		World world = event.getEntity().getEntityWorld();
		if (!world.isRemote)
		{
			int i = 3 + world.rand.nextInt(5) + world.rand.nextInt(5);

			while (i > 0)
			{
				i--;
				Vec3d hitVec = event.getRayTraceResult().getHitVec();
				BlockPos spawnPos = new BlockPos(hitVec.x, hitVec.y, hitVec.z);
				Entity ent = EntityType.field_226289_e_.spawn(world, null, null, spawnPos, SpawnReason.EVENT, false, false);
				if (ent instanceof BeeEntity)
				{
					BeeEntity bee = (BeeEntity)ent;
					PlayerEntity player = world.getClosestPlayer(bee, 40D);
					bee.addPotionEffect(new EffectInstance(Effects.SPEED));
					bee.func_226391_a_(player);
				}
				
			}
		}
	}
}
