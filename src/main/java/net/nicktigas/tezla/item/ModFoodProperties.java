package net.nicktigas.tezla.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModFoodProperties {

    public static final FoodProperties INFECTED_APPLE = new FoodProperties.Builder().nutrition(4).saturationModifier(0.1f).alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600),100).build();

}