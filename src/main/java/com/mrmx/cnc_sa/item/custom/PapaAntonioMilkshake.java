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

public class PapaAntonioMilkshake extends MilkshakeItem {
    public PapaAntonioMilkshake(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.mrmx_dream.the_secret_milkshake").withStyle(ChatFormatting.LIGHT_PURPLE));
        tooltipComponents.add(Component.literal("§k???").withStyle(ChatFormatting.BLUE)
                .append(Component.literal(" (??:??)").withStyle(ChatFormatting.BLUE)));
    }
}

