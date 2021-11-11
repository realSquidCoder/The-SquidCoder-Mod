package com.SquidCoder.squidcoder.setup;

import com.SquidCoder.squidcoder.SquidCoderMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
    public static final class Blocks{
        //ORES
        public static final ITag.INamedTag<Block> ORES_SILVER = forge("ores/silver");
        public static final ITag.INamedTag<Block> ORES_COPPER = forge("ores/copper");
        
        //STORAGE BLOCKS
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_SILVER = forge("storage_blocks/silver");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_COPPER = forge("storage_blocks/copper");

        private static ITag.INamedTag<Block> forge(String path){
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Block> mod(String path){
            return BlockTags.bind(new ResourceLocation(SquidCoderMod.MOD_ID, path).toString());
        }
    }

    public static final class Items{
        //ORES
        public static final ITag.INamedTag<Item> ORES_SILVER = forge("ores/silver");
        public static final ITag.INamedTag<Item> ORES_COPPER = forge("ores/copper");
        
        //DUSTS
        public static final ITag.INamedTag<Item> DUSTS_SILVER = forge("dusts/silver");
        
        //NUGGETS
        public static final ITag.INamedTag<Item> NUGGETS_SILVER = forge("nuggets/silver");

        //INGOTS
        public static final ITag.INamedTag<Item> INGOTS_SILVER = forge("ingots/silver");
        public static final ITag.INamedTag<Item> INGOTS_COPPER = forge("ingots/copper");
        
        //STORAGE BLOCKS
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_SILVER = forge("storage_blocks/silver");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_COPPER = forge("storage_blocks/copper");

        
        private static ITag.INamedTag<Item> forge(String path){
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> mod(String path){
            return ItemTags.bind(new ResourceLocation(SquidCoderMod.MOD_ID, path).toString());
        }
    }
}
