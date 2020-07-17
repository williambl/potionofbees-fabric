package com.github.commoble.potionofbees.client;

import com.github.commoble.potionofbees.Identifiers;
import com.github.commoble.potionofbees.RegistryObjects;
import com.github.commoble.potionofbees.SplashPotionOfBeesEntity;
import com.github.commoble.potionofbees.networking.EntityDispatcher;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

@Environment(EnvType.CLIENT)
public class PotionOfBeesModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(RegistryObjects.getSplashPotionOfBeesEntityType(), this::getSplashPotionOfBeesRenderer);

        ClientSidePacketRegistry.INSTANCE.register(Identifiers.SPAWN, EntityDispatcher::spawnFrom);
    }

    private FlyingItemEntityRenderer<SplashPotionOfBeesEntity> getSplashPotionOfBeesRenderer(EntityRenderDispatcher dispatcher, EntityRendererRegistry.Context ctx) {
        return new FlyingItemEntityRenderer<>(dispatcher, MinecraftClient.getInstance().getItemRenderer());
    }
}
