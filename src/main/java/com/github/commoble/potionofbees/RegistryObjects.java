package com.github.commoble.potionofbees;

import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RegistryObjects
{
	public static final RegistryObject<PotionOfBeesItem> POTION_OF_BEES_ITEM = makeRegistryObject(ResourceLocations.POTION_OF_BEES, ForgeRegistries.ITEMS);
	public static final RegistryObject<PotionOfBeesItem> SPLASH_POTION_OF_BEES_ITEM = makeRegistryObject(ResourceLocations.SPLASH_POTION_OF_BEES, ForgeRegistries.ITEMS);
	
	public static final RegistryObject<EvanescenceEffect> EVANESCENCE_EFFECT = makeRegistryObject(ResourceLocations.EVANESCENCE, ForgeRegistries.POTIONS);
	
	// RegistryObjects/ObjectHolders for EntityTypes seem to be broken as of the moment this is being typed
//	public static final RegistryObject<EntityType<? extends SplashBeePotionEntity>> BEE_POTION_ENTITY_TYPE = makeRegistryObject(ResourceLocations.SPLASH_BEE_POTION, ForgeRegistries.ENTITIES);
	
	public static <T extends IForgeRegistryEntry<T>, U extends T> RegistryObject<U> makeRegistryObject(final ResourceLocation location, IForgeRegistry<T> registry)
	{
		return RegistryObject.of(location, registry);
	}
	
	@SuppressWarnings("unchecked")
	public static EntityType<? extends SplashPotionOfBeesEntity> getSplashPotionOfBeesEntityType()
	{
		return (EntityType<? extends SplashPotionOfBeesEntity>) ForgeRegistries.ENTITIES.getValue(ResourceLocations.SPLASH_POTION_OF_BEES);
	}
}
