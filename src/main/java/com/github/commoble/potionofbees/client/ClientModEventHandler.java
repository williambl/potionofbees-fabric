package com.github.commoble.potionofbees.client;

import com.github.commoble.potionofbees.PotionOfBeesMod;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid=PotionOfBeesMod.MODID, value=Dist.CLIENT, bus=Bus.MOD)
public class ClientModEventHandler
{
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event)
	{
//		RenderingRegistry.registerEntityRenderingHandler(PotionOfBeesMod.BEE_POTION_ENTITY_TYPE.get(), renderManager -> new SpriteRenderer<>(renderManager, Minecraft.getInstance().getItemRenderer()));
	}
}
