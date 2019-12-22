package com.github.commoble.potionofbees;

import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;

public class RegistryObjects
{
	public static final PotionOfBeesItem POTION_OF_BEES_ITEM = (PotionOfBeesItem) Registry.ITEM.get(Identifiers.POTION_OF_BEES);
	public static final SplashPotionOfBeesItem SPLASH_POTION_OF_BEES_ITEM = (SplashPotionOfBeesItem) Registry.ITEM.get(Identifiers.SPLASH_POTION_OF_BEES);
	
	public static final EvanescenceEffect EVANESCENCE_EFFECT = (EvanescenceEffect) Registry.STATUS_EFFECT.get(Identifiers.EVANESCENCE);

	public static final EntityType<SplashPotionOfBeesEntity> SPLASH_POTION_OF_BEES_ENTITY_TYPE = (EntityType<SplashPotionOfBeesEntity>) Registry.ENTITY_TYPE.get(Identifiers.SPLASH_POTION_OF_BEES);
}
