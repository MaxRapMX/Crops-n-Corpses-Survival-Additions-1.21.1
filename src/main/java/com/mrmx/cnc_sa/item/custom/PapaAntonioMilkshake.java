package com.mrmx.cnc_sa.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.Level;
import uwu.llkc.cnc.common.items.MilkshakeItem;

import java.util.List;
import java.util.Objects;

public class PapaAntonioMilkshake extends MilkshakeItem {
    public PapaAntonioMilkshake(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        ItemStack result = super.finishUsingItem(stack, level, livingEntity);
        if (!level.isClientSide() && livingEntity instanceof Player player) {
            player.getCooldowns().addCooldown(this, 150);
        }

        return result;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.cnc_sa.mrmx_dream.the_secret_milkshake").withStyle(ChatFormatting.YELLOW));
        tooltipComponents.add(Component.literal("§k?????????").withStyle(ChatFormatting.BLUE)
                .append(Component.literal(" (??:??)").withStyle(ChatFormatting.BLUE)));
    }
}

