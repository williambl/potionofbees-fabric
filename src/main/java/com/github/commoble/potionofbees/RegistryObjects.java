package com.github.commoble.potionofbees;

import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;

public class RegistryObjects {
	public static PotionOfBeesItem getPotionOfBeesItem() {
		return (PotionOfBeesItem) Registry.ITEM.get(Identifiers.POTION_OF_BEES);
	}

	public static SplashPotionOfBeesItem getSplashPotionOfBeesItem() {
		return (SplashPotionOfBeesItem)Registry.ITEM.get(Identifiers.SPLASH_POTION_OF_BEES);
	}

	public static EvanescenceEffect getEvanescenceEffect() {
		return (EvanescenceEffect) Registry.STATUS_EFFECT.get(Identifiers.EVANESCENCE);
	}

	public static EntityType<SplashPotionOfBeesEntity> getSplashPotionOfBeesEntityType() {
	return (EntityType<SplashPotionOfBeesEntity>)Registry.ENTITY_TYPE.get(Identifiers.SPLASH_POTION_OF_BEES);
	}
}
