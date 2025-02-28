package com.github.commoble.potionofbees.networking;

import com.github.commoble.potionofbees.Identifiers;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.server.PlayerStream;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;

import java.io.IOException;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public final class Packets {

    private Packets() {
    }

    public static Packet<?> newSpawnPacket(final Entity entity) {
        final PacketByteBuf bytes = new PacketByteBuf(Unpooled.buffer());
        try {
            new EntitySpawnS2CPacket(entity).write(bytes);
        } catch (final IOException e) {
            throw new IllegalArgumentException("Failed to write bytes for " + entity, e);
        }
        return ServerSidePacketRegistry.INSTANCE.toPacket(Identifiers.SPAWN, bytes);
    }

    public static <T extends Packet<?>> Optional<T> readFrom(final PacketByteBuf bytes, final Supplier<T> packet) {
        final T deserializedPacket = packet.get();
        try {
            deserializedPacket.read(bytes);
        } catch (final IOException e) {
            if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
                throw new IllegalStateException("Reading " + deserializedPacket + " from " + bytes, e);
            }
            return Optional.empty();
        }
        return Optional.of(deserializedPacket);
    }

    public static <T extends Entity> void dispatchToAllWatching(final T entity, final Function<T, Packet<?>> packet) {
        PlayerStream.watching(entity)
                .map(player -> ((ServerPlayerEntity) player).networkHandler)
                .forEach(handler -> handler.sendPacket(packet.apply(entity)));
    }
}
