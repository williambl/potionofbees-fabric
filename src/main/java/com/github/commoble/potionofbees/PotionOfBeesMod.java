package com.github.commoble.potionofbees;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

public class PotionOfBeesMod implements ModInitializer
{
	public static final String MODID = "potionofbees";
	public static final double BEE_SEARCH_RADIUS = 10D;

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, Identifiers.POTION_OF_BEES, new PotionOfBeesItem(new Item.Settings().group(ItemGroup.BREWING)));
		Registry.register(Registry.ITEM, Identifiers.SPLASH_POTION_OF_BEES, new SplashPotionOfBeesItem(new Item.Settings().group(ItemGroup.BREWING)));
		Registry.register(Registry.STATUS_EFFECT, Identifiers.EVANESCENCE, new EvanescenceEffect(StatusEffectType.HARMFUL, 0));
		Registry.register(
				Registry.ENTITY_TYPE,
				Identifiers.SPLASH_POTION_OF_BEES,
				EntityType.Builder.create(
						SplashPotionOfBeesEntity::new,
						SpawnGroup.MISC
				).build(Identifiers.SPLASH_POTION_OF_BEES.toString())
		);
	}
}
