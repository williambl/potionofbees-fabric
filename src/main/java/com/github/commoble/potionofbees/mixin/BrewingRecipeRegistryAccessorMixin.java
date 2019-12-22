package com.github.commoble.potionofbees.mixin;

import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@SuppressWarnings("PublicStaticMixinMember")
@Mixin(BrewingRecipeRegistry.class)
public interface BrewingRecipeRegistryAccessorMixin {

    @Invoker("registerItemRecipe")
    static void registerItemRecipe(Item potionItem, Item modifier, Item resultPotionItem) {}
}