package com.benrift.progressionmod.item.CustomItems;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class TortureDevice extends Item {
    public TortureDevice(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Apply effects on hit
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1)); // Slowness II for 5s
        target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 0));         // Blindness I for 5s
        target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 1));          // Weakness II for 5s
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public boolean canAttackBlock(net.minecraft.world.level.block.state.BlockState state, Level level, net.minecraft.core.BlockPos pos, net.minecraft.world.entity.player.Player player) {
        return false; // EOP
    }
}

