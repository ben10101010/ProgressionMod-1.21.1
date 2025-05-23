package com.benrift.progressionmod.item.CustomItems;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class DepthsPortalIgniter extends Item {
    public DepthsPortalIgniter(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canAttackBlock(net.minecraft.world.level.block.state.BlockState state, Level level, net.minecraft.core.BlockPos pos, net.minecraft.world.entity.player.Player player) {
        return false; // EOP
    }
}

