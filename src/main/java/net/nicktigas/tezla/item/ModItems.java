package net.nicktigas.tezla.item;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nicktigas.tezla.TezlaMod;


public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TezlaMod.MOD_ID);


    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
