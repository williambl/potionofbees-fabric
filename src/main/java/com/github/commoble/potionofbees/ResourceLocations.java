package com.github.commoble.potionofbees;

import net.minecraft.util.ResourceLocation;

public class ResourceLocations
{
	public static final ResourceLocation BEE_POTION = getModRL("potion_of_bees");
	public static final ResourceLocation SPLASH_BEE_POTION = getModRL("splash_potion_of_bees");
	
	public static ResourceLocation getModRL(String name)
	{
		return new ResourceLocation(PotionOfBeesMod.MODID, name);
	}
}
