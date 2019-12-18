package com.github.commoble.potionofbees;

import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RegistryObjects
{
	public static final RegistryObject<BeePotionItem> BEE_POTION_ITEM = makeRegistryObject(ResourceLocations.BEE_POTION, ForgeRegistries.ITEMS);
	public static final RegistryObject<BeePotionItem> SPLASH_BEE_POTION_ITEM = makeRegistryObject(ResourceLocations.SPLASH_BEE_POTION, ForgeRegistries.ITEMS);
	public static final RegistryObject<EntityType<BeePotionEntity>> BEE_POTION_ENTITY_TYPE = makeRegistryObject(ResourceLocations.BEE_POTION, ForgeRegistries.ENTITIES);
	
	public static <T extends IForgeRegistryEntry<T>, U extends T> RegistryObject<U> makeRegistryObject(final ResourceLocation location, IForgeRegistry<T> registry)
	{
		return RegistryObject.of(location, registry);
	}
}
