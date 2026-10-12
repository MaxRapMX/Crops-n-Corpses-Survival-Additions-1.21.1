package com.mrmx.cnc_sa.event;

import com.mrmx.Barlious_Dream.item.ModItems;
import com.mrmx.cnc_sa.item.SA_ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import uwu.llkc.cnc.common.init.ItemRegistry;

@EventBusSubscriber(modid = "cnc_sa")
public class AddingItemsInCreativeTabs {

    @SubscribeEvent
    public static void AddingItemsInCreativeTabs(BuildCreativeModeTabContentsEvent event) {

        // Barlious Dream Tab
        if (ModList.get().isLoaded("mrmx_dream")) {
            ResourceKey<CreativeModeTab> cncTabKey = ResourceKey.create(
                    Registries.CREATIVE_MODE_TAB,
                    ResourceLocation.fromNamespaceAndPath("mrmx_dream", "barlious_dream_tab")
            ); if (event.getTabKey() == cncTabKey) {
                event.insertBefore(
                        new ItemStack((ItemLike) ModItems.BARLIOUS_UPGRADE), SA_ModItems.THE_SECRET_MILKSHAKE.get().getDefaultInstance(),
                        CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }

        // CNC Tab
        if (ModList.get().isLoaded("cnc")) {
            ResourceKey<CreativeModeTab> cncTabKey = ResourceKey.create(
                    Registries.CREATIVE_MODE_TAB,
                    ResourceLocation.fromNamespaceAndPath("cnc", "cnc_tab")
            ); if (event.getTabKey() == cncTabKey) {
                event.insertAfter(
                        new ItemStack((ItemLike) ItemRegistry.CHERRY_MILKSHAKE), SA_ModItems.WALNUT_MILKSHAKE.get().getDefaultInstance(),
                        CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertBefore(
                        new ItemStack((ItemLike) SA_ModItems.WALNUT_MILKSHAKE), SA_ModItems.RICE_PUDING_MILKSHAKE.get().getDefaultInstance(),
                        CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(
                        new ItemStack((ItemLike) SA_ModItems.WALNUT_MILKSHAKE), SA_ModItems.VANILLA_WITH_CHERRIES_MILKSHAKE.get().getDefaultInstance(),
                        CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }

        // Building Blocks
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.insertAfter(
                    new ItemStack(Items.OAK_BUTTON), ItemRegistry.WALNUT_LOG.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.WALNUT_LOG), ItemRegistry.WALNUT_WOOD.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.WALNUT_WOOD), ItemRegistry.STRIPPED_WALNUT_LOG.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.STRIPPED_WALNUT_LOG), ItemRegistry.STRIPPED_WALNUT_WOOD.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.STRIPPED_WALNUT_WOOD), ItemRegistry.WALNUT_PLANKS.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.WALNUT_PLANKS), ItemRegistry.WALNUT_STAIRS.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.WALNUT_STAIRS), ItemRegistry.WALNUT_SLAB.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.WALNUT_SLAB), ItemRegistry.WALNUT_FENCE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.WALNUT_FENCE), ItemRegistry.WALNUT_FENCE_GATE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.WALNUT_FENCE_GATE), ItemRegistry.WALNUT_DOOR.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.WALNUT_DOOR), ItemRegistry.WALNUT_TRAP_DOOR.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.WALNUT_TRAP_DOOR), ItemRegistry.WALNUT_PRESSURE_PLATE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.WALNUT_PRESSURE_PLATE), ItemRegistry.WALNUT_BUTTON.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        // Natural Blocks
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.insertAfter(
                    new ItemStack(Items.OAK_LEAVES), ItemRegistry.WALNUT_LEAVES.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack(Items.OAK_SAPLING), ItemRegistry.WALNUT_SAPLING.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack(Items.WHEAT_SEEDS), ItemRegistry.SUNFLOWER_SEEDS.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        // Natural Fuctional Blocks
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.insertAfter(
                    new ItemStack(Items.OAK_HANGING_SIGN), ItemRegistry.WALNUT_SIGN.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.WALNUT_SIGN), ItemRegistry.HANGING_WALNUT_SIGN.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        // Tools and Utilities
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.insertAfter(
                    new ItemStack(Items.OAK_CHEST_BOAT), ItemRegistry.WALNUT_BOAT.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.WALNUT_BOAT), ItemRegistry.WALNUT_CHEST_BOAT.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        // Combat
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.insertAfter(
                    new ItemStack(Items.WOLF_ARMOR), ItemRegistry.PLANT_ARMOR.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        // Food and Drinks
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.insertAfter(
                    new ItemStack(Items.ENCHANTED_GOLDEN_APPLE), ItemRegistry.CHERRIES.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.CHERRIES), ItemRegistry.GOLDEN_CHERRIES.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack(Items.SWEET_BERRIES), ItemRegistry.WALNUT.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack(Items.POISONOUS_POTATO), ItemRegistry.RAW_PEA.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.RAW_PEA), ItemRegistry.COOKED_PEA.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.COOKED_PEA), ItemRegistry.PEA_POD.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack(Items.CAKE), ItemRegistry.CHOCOLATE_CHERRY_CAKE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.CHOCOLATE_CHERRY_CAKE), ItemRegistry.CHERRY_PIE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack(Items.ROTTEN_FLESH), ItemRegistry.FROZEN_PEA.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(
                    new ItemStack(Items.MUSHROOM_STEW), ItemRegistry.CHOCOLATE_CHIP_MUFFIN.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.CHOCOLATE_CHIP_MUFFIN), ItemRegistry.SUNFLOWER_SEED_MUFFIN.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.SUNFLOWER_SEED_MUFFIN), ItemRegistry.CHERRY_MUFFIN.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack(Items.MUSHROOM_STEW), ItemRegistry.MASHED_POTATOES.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack(Items.MILK_BUCKET), ItemRegistry.VANILLA_MILKSHAKE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.VANILLA_MILKSHAKE), ItemRegistry.CHOCOLATE_MILKSHAKE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.CHOCOLATE_MILKSHAKE), ItemRegistry.CHERRY_MILKSHAKE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        // Spawn Eggs
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.insertBefore(
                    new ItemStack(Items.ZOMBIE_SPAWN_EGG), ItemRegistry.BROWNCOAT_SPAWN_EGG.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(
                    new ItemStack((ItemLike) ItemRegistry.BROWNCOAT_SPAWN_EGG), ItemRegistry.IMP_SPAWN_EGG.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
    @SubscribeEvent
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        System.out.println("[DEBUG TAB IDENTIFIER] Tab ID: " + event.getTabKey().location().toString());
    }
}
