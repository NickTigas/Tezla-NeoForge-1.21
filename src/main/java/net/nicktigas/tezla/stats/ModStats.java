package net.nicktigas.tezla.stats;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.StatType;

public class ModStats {

    public static final StatType<ResourceLocation> CUSTOM = null;

    public static final ResourceLocation INTERACT_WITH_WOODCUTTER;

    public ModStats() {
    }

    private static ResourceLocation makeCustomStat(String key, StatFormatter formatter) {
        ResourceLocation resourcelocation = ResourceLocation.withDefaultNamespace(key);
        Registry.register(BuiltInRegistries.CUSTOM_STAT, key, resourcelocation);
        CUSTOM.get(resourcelocation, formatter);
        return resourcelocation;
    }

    private static <T> StatType<T> makeRegistryStatType(String key, Registry<T> registry) {
        Component component = Component.translatable("stat_type.minecraft." + key);
        return Registry.register(BuiltInRegistries.STAT_TYPE, ResourceLocation.parse("tezlamod"+ key), new StatType<>(registry, component));
    }

    static {
        INTERACT_WITH_WOODCUTTER = makeCustomStat("interact_with_woodcutter", StatFormatter.DEFAULT);
    }

}

