package com.SquidCoder.squidcoder.setup;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> SILVER_BLOCK = register("silver_block", () ->
            new Block(AbstractBlock.Properties
                    .of(Material.METAL)
                    .strength(3, 10)
                    .sound(SoundType.METAL)));

    public static final RegistryObject<Block> SILVER_ORE = register("silver_ore", () ->
            new Block(AbstractBlock.Properties
                    .of(Material.STONE)
                    .strength(3, 3)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> COPPER_ORE = register("copper_ore", () ->
            new Block(AbstractBlock.Properties
                    .of(Material.STONE)
                    .strength(3, 3)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> COPPER_BLOCK = register("copper_block", () ->
            new Block(AbstractBlock.Properties
                    .of(Material.METAL)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .strength(3, 6)
                    .sound(ModSoundType.COPPER)));//make copper sounds
                    
    
    public static final RegistryObject<Block> AMETHYST_BLOCK = register("amethyst_block", () ->
            new Block(AbstractBlock.Properties
                    .of(Material.WOOD)//ModMaterials.AMETHYST
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .strength(0,0)
                    .sound(ModSoundType.AMETHYST)));//make gem sounds
                    
    
    public static final RegistryObject<Block> BUDDING_AMETHYST = register("budding_amethyst", () ->
            new Block(AbstractBlock.Properties
                    .of(Material.WOOD)//ModMaterials.AMETHYST
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .strength(0,0)
                    .sound(ModSoundType.AMETHYST)));//make gem sounds
                    
    

    static void register() {}

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(ModItemGroup.SQUIDCODER_MOD)));
        return ret;
    }
}
