package com.mrmx.cnc_sa.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionContents;
import uwu.llkc.cnc.common.items.MilkshakeItem;

import java.util.List;
import java.util.Objects;

public class MilkshakeExtended extends MilkshakeItem {
    public MilkshakeExtended(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        FoodProperties food = stack.get(DataComponents.FOOD);
        if (food == null || food.effects().isEmpty()) {
            return;
        }
            PotionContents visualPotionContents = PotionContents.EMPTY;
            for (FoodProperties.PossibleEffect possibleEffect : food.effects()) {
                visualPotionContents = visualPotionContents.withEffectAdded(possibleEffect.effect());
            }
            Objects.requireNonNull(tooltipComponents);
            visualPotionContents.addPotionTooltip(tooltipComponents::add, 1.0F, context.tickRate());
    }
}

