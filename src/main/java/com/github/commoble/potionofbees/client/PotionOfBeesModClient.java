package com.github.commoble.potionofbees.client;

import com.github.commoble.potionofbees.RegistryObjects;
import com.github.commoble.potionofbees.SplashPotionOfBeesEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.MinecartCommandBlockScreen;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.Entity;

public class PotionOfBeesModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(RegistryObjects.SPLASH_POTION_OF_BEES_ENTITY_TYPE, this::getSplashPotionOfBeesRenderer);
    }

    private FlyingItemEntityRenderer<SplashPotionOfBeesEntity> getSplashPotionOfBeesRenderer(EntityRenderDispatcher dispatcher, EntityRendererRegistry.Context ctx) {
        return new FlyingItemEntityRenderer<>(dispatcher, MinecraftClient.getInstance().getItemRenderer());
    }
}
