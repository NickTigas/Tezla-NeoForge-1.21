package net.nicktigas.tezla.block;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.bus.api.IEventBus;
import net.nicktigas.tezla.TezlaMod;
import net.nicktigas.tezla.block.custom.woodcutterblock;
import net.nicktigas.tezla.item.ModItems;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TezlaMod.MOD_ID);

    public static final DeferredBlock<Block> WOODCUTTER = registerBlock("woodcutter",
            () -> new woodcutterblock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS)
                    .mapColor(MapColor.WOOD).requiresCorrectToolForDrops()
                    .strength(3.5F).sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> COPPERBUTTON = registerBlock("copperbutton",
            properties -> new copperbuton(BlocksSetTypes.COPPER, properties.strength(1.0F)
                    .requiresCorrectToolForDrops().sound(SoundType.COPPER)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {BLOCKS.register(eventBus);}

}