package com.github.commoble.potionofbees;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class EvanescenceEffect extends StatusEffect
{
	public EvanescenceEffect(StatusEffectType typeIn, int liquidColorIn)
	{
		super(typeIn, liquidColorIn);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier)
	{
		return duration <= 1;
	}

	@Override
	public void applyUpdateEffect(LivingEntity entityLivingBaseIn, int amplifier)
	{
		entityLivingBaseIn.kill();
	}
}
