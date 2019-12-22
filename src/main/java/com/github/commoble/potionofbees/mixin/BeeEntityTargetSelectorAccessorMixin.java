package com.github.commoble.potionofbees.mixin;

import com.github.commoble.potionofbees.MobEntityTargetSelectorAccessor;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@SuppressWarnings("PublicStaticMixinMember")
@Mixin(MobEntity.class)
public abstract class BeeEntityTargetSelectorAccessorMixin extends LivingEntity implements MobEntityTargetSelectorAccessor {
    @Shadow @Final
    public GoalSelector targetSelector;

    @Override
    public GoalSelector getTargetSelector() {
        return targetSelector;
    }

    protected BeeEntityTargetSelectorAccessorMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }
}