package com.github.commoble.potionofbees;

import net.minecraft.util.Identifier;

public class Identifiers
{
	public static final Identifier POTION_OF_BEES = modId("potion_of_bees");
	public static final Identifier SPLASH_POTION_OF_BEES = modId("splash_potion_of_bees");
	public static final Identifier EVANESCENCE = modId("evanescence");
	public static final Identifier POTION_OF_BEES_INGREDIENTS = modId("potion_of_bees_ingredients");
	
	public static Identifier modId(String name)
	{
		return new Identifier(PotionOfBeesMod.MODID, name);
	}
}
