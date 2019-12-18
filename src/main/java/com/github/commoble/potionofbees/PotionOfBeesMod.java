package com.github.commoble.potionofbees;

import java.util.function.Consumer;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod(PotionOfBeesMod.MODID)
public class PotionOfBeesMod
{
	public static final String MODID = "potionofbees";
	public static final double BEE_SEARCH_RADIUS = 10D;

	public static ResourceLocation getModRL(String name)
	{
		return new ResourceLocation(PotionOfBeesMod.MODID, name);
	}

	public static <T extends IForgeRegistryEntry<T>> Consumer<Register<T>> getRegistrator(Consumer<Registrator<T>> consumer)
	{
		return event -> consumer.accept(new Registrator<>(event.getRegistry()));
	}

	public PotionOfBeesMod()
	{
		final IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		final IEventBus forgeBus = MinecraftForge.EVENT_BUS;

		modBus.addGenericListener(Item.class, getRegistrator(CommonModEvents::onRegisterItems));
		modBus.addGenericListener(EntityType.class, getRegistrator(CommonModEvents::onRegisterEntityTypes));
		
		forgeBus.addListener(CommonForgeEvents::onProjectileImpact);
	}
}
