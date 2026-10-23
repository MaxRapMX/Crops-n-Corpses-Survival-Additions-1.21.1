package com.mrmx.cnc_sa.item;

import com.mrmx.cnc_sa.CNC_SAMod;
import com.mrmx.cnc_sa.item.custom.ChorusFruitMilkshake;
import com.mrmx.cnc_sa.item.custom.PapaAntonioMilkshake;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import uwu.llkc.cnc.common.items.MilkshakeItem;
import static com.mrmx.cnc_sa.CNC_SAMod.isModInVersionRange;


public class SA_ModItems {
    public static final boolean FARMERS_DELIGHT_REQUIRED = ModList.get().isLoaded("farmersdelight");
    public static final boolean ANTONIO_CONDITIONS = isModInVersionRange("mrmx_dream", "[2.0.0,)");
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CNC_SAMod.MODID);

    public static final DeferredItem<Item> GLASS_CUP = ITEMS.register("glass_cup",
            () -> new Item(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<PapaAntonioMilkshake> THE_SECRET_MILKSHAKE = ANTONIO_CONDITIONS
            ? ITEMS.register("papa_antonio_milkshake",
            () -> new PapaAntonioMilkshake(new Item.Properties().durability(8).rarity(Rarity.RARE)
                    .food(SA_Milkshakes.THE_SECRET_MILKSHAKE))): null;

    // Vanilla Flavors Milkshakes
    public static final DeferredItem<MilkshakeItem> APPLE_MILKSHAKE = ITEMS.register("apple_milkshake",
            () -> new MilkshakeItem(new Item.Properties().durability(32).food(SA_Milkshakes.APPLE_MILKSHAKE)));
    public static final DeferredItem<MilkshakeItem> CARROT_MILKSHAKE = ITEMS.register("carrot_milkshake",
            () -> new MilkshakeItem(new Item.Properties().durability(32).food(SA_Milkshakes.CARROT_MILKSHAKE)));
    public static final DeferredItem<MilkshakeItem> GLOW_BERRIES_MILKSHAKE = ITEMS.register("glow_berries_milkshake",
            () -> new MilkshakeItem(new Item.Properties().durability(16).rarity(Rarity.UNCOMMON)
                    .food(SA_Milkshakes.GLOW_BERRIES_MILKSHAKE)));
    public static final DeferredItem<ChorusFruitMilkshake> CHORUS_FRUIT_MILKSHAKE = ITEMS.register("chorus_fruit_milkshake",
            () -> new ChorusFruitMilkshake(new Item.Properties().durability(16).rarity(Rarity.UNCOMMON)
                    .food(SA_Milkshakes.CHORUS_FRUIT_MILKSHAKE)));

    // CNC Flavors Milkshakes
    public static final DeferredItem<MilkshakeItem> WALNUT_MILKSHAKE = ITEMS.register("walnut_milkshake",
            () -> new MilkshakeItem(new Item.Properties().durability(32).food(SA_Milkshakes.WALNUT_MILKSHAKE)));
    public static final DeferredItem<MilkshakeItem> VANILLA_WITH_WALNUT_MILKSHAKE = ITEMS.register("mazapan_milkshake",
            () -> new MilkshakeItem(new Item.Properties().durability(16).rarity(Rarity.UNCOMMON)
                    .food(SA_Milkshakes.VANILLA_WITH_WALNUT_MILKSHAKE)));
    public static final DeferredItem<MilkshakeItem> VANILLA_WITH_CHERRIES_MILKSHAKE = ITEMS.register("angels_kiss_milkshake",
            () -> new MilkshakeItem(new Item.Properties().durability(16).rarity(Rarity.UNCOMMON)
                    .food(SA_Milkshakes.VANILLA_WITH_CHERRIES_MILKSHAKE)));

    // Farmers Delight Flavors Milkshakes
    public static final DeferredItem<MilkshakeItem> RICE_PUDING_MILKSHAKE = FARMERS_DELIGHT_REQUIRED
            ? ITEMS.register("rice_puding_milkshake",
            () -> new MilkshakeItem(new Item.Properties().durability(32).food(SA_Milkshakes.RICE_PUDING_MILKSHAKE))): null;


    static class SA_Milkshakes {
        public static final FoodProperties APPLE_MILKSHAKE;
        public static final FoodProperties CARROT_MILKSHAKE;
        public static final FoodProperties GLOW_BERRIES_MILKSHAKE;
        public static final FoodProperties CHORUS_FRUIT_MILKSHAKE;
        public static final FoodProperties WALNUT_MILKSHAKE;
        public static final FoodProperties VANILLA_WITH_WALNUT_MILKSHAKE;
        public static final FoodProperties VANILLA_WITH_CHERRIES_MILKSHAKE;
        public static final FoodProperties RICE_PUDING_MILKSHAKE;
        public static final FoodProperties THE_SECRET_MILKSHAKE;
        SA_Milkshakes() {}
        static {
            var AppleMilkshake = (new FoodProperties.Builder()).nutrition(3).saturationModifier(1.2f).alwaysEdible().fast()
                    .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 1), 1.0F);
            BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"))
                    .ifPresent(nourishment -> AppleMilkshake.effect(() -> new MobEffectInstance(nourishment, 900, 0), 1.0F));
            APPLE_MILKSHAKE = AppleMilkshake.build();

            var CarrotMilkshake = (new FoodProperties.Builder()).nutrition(3).saturationModifier(1.2f).alwaysEdible().fast()
                    .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 900, 0), 1.0F);
            BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"))
                    .ifPresent(nourishment -> CarrotMilkshake.effect(() -> new MobEffectInstance(nourishment, 900, 0), 1.0F));
            CARROT_MILKSHAKE = CarrotMilkshake.build();

            var GlowBerriesMilkshake = (new FoodProperties.Builder()).nutrition(5).saturationModifier(0.9f).alwaysEdible().fast()
                    .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2100, 1), 1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 500, 0), 1.0F);
            BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"))
                    .ifPresent(nourishment -> GlowBerriesMilkshake.effect(() -> new MobEffectInstance(nourishment, 900, 0), 1.0F));
            GLOW_BERRIES_MILKSHAKE = GlowBerriesMilkshake.build();

            var ChorusFruitMilkshake = (new FoodProperties.Builder()).nutrition(5).saturationModifier(0.9f).alwaysEdible().fast()
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 500, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 2400, 1), 1.0F);
            BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"))
                    .ifPresent(nourishment -> ChorusFruitMilkshake.effect(() -> new MobEffectInstance(nourishment, 900, 0), 1.0F));
            CHORUS_FRUIT_MILKSHAKE = ChorusFruitMilkshake.build();

            var WalnutMilkshake = (new FoodProperties.Builder()).nutrition(3).saturationModifier(1.2f).alwaysEdible().fast()
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1700, 0), 1.0F);
            BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"))
                    .ifPresent(nourishment -> WalnutMilkshake.effect(() -> new MobEffectInstance(nourishment, 900, 0), 1.0F));
            WALNUT_MILKSHAKE = WalnutMilkshake.build();

            var MazapanMilkshake = (new FoodProperties.Builder()).nutrition(5).saturationModifier(0.9f).alwaysEdible().fast()
                    .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 500, 1), 1.0F);
            BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:comfort"))
                    .ifPresent(comfort -> MazapanMilkshake.effect(() -> new MobEffectInstance(comfort, 1700, 0), 1.0F));
            BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"))
                    .ifPresent(nourishment -> MazapanMilkshake.effect(() -> new MobEffectInstance(nourishment, 900, 0), 1.0F));
            VANILLA_WITH_WALNUT_MILKSHAKE = MazapanMilkshake.build();

            var AngelsKissMilkshake = (new FoodProperties.Builder()).nutrition(5).saturationModifier(0.9f).alwaysEdible().fast()
                    .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 9000, 1), 1.0F);
            BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"))
                    .ifPresent(nourishment -> AngelsKissMilkshake.effect(() -> new MobEffectInstance(nourishment, 300, 0), 1.0F));
            VANILLA_WITH_CHERRIES_MILKSHAKE = AngelsKissMilkshake.build();

            var RicePudingMilkshake = (new FoodProperties.Builder()).nutrition(3).saturationModifier(1.2f).alwaysEdible().fast()
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 900, 0), 1.0F);
            BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"))
                    .ifPresent(nourishment -> RicePudingMilkshake.effect(() -> new MobEffectInstance(nourishment, 900, 0), 1.0F));
            RICE_PUDING_MILKSHAKE = RicePudingMilkshake.build();

            var MamaLuchaMilkshake = (new FoodProperties.Builder()).nutrition(7).saturationModifier(0.8f).alwaysEdible().fast()
                    .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 60, 0), 0.85F)
                    .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 0), 0.30F)
                    .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 900, 0), 0.10F)
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2900, 1), 0.40F)
                    .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 1), 0.40F)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300, 1), 0.35F)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2900, 0), 0.35F)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3000, 0), 0.35F)
                    .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 18000, 2), 0.10F);
            BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"))
                    .ifPresent(nourishment -> MamaLuchaMilkshake.effect(() -> new MobEffectInstance(nourishment, 1500, 0), 0.85F));
            THE_SECRET_MILKSHAKE = MamaLuchaMilkshake.build();
        }
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
