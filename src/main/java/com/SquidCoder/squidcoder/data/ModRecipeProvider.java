package com.SquidCoder.squidcoder.data;

import com.SquidCoder.squidcoder.SquidCoderMod;
import com.SquidCoder.squidcoder.setup.ModBlocks;
import com.SquidCoder.squidcoder.setup.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }


    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(ModItems.SILVER_INGOT.get(),9)
                .requires(ModBlocks.SILVER_BLOCK.get())
                .unlockedBy("has_item", has(ModItems.SILVER_INGOT.get()))
                .save(consumer,modId("silver_ingots_from_storage_block"));

        ShapedRecipeBuilder.shaped(ModBlocks.SILVER_BLOCK.get())
                .define('#', ModItems.SILVER_INGOT.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.SILVER_INGOT.get()))
                .save(consumer,modId("silver_storage_block"));

        ShapedRecipeBuilder.shaped(ModItems.SILVER_INGOT.get())
                .define('#', ModItems.SILVER_NUGGET.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.SILVER_NUGGET.get()))
                .save(consumer, modId("silver_ingot_from_nuggets"));

        ShapedRecipeBuilder.shaped(ModBlocks.COPPER_BLOCK.get())
                .define('#', ModItems.COPPER_INGOT.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.COPPER_INGOT.get()))
                .save(consumer);
        
        ShapedRecipeBuilder.shaped(ModItems.SPYGLASS.get())
                .define('c', ModItems.COPPER_INGOT.get())
                .define('a', ModItems.AMETHYST_SHARD.get())
                .pattern("a")
                .pattern("c")
                .pattern("c")
                .unlockedBy("has_item", has(ModItems.AMETHYST_SHARD.get()))
                .save(consumer);
        

        //Melting Recipes:

        //From ore block
        makeMeltingRecipesFromOre(ModBlocks.SILVER_ORE.get(), ModItems.SILVER_INGOT.get(), 0.7f, consumer, "silver_ingot");
        makeMeltingRecipesFromOre(ModBlocks.COPPER_ORE.get(), ModItems.COPPER_INGOT.get(), 0.7f, consumer, "copper_ingot");

        //From raw item
        makeMeltingRecipesFromItem(ModItems.RAW_COPPER.get(), ModItems.COPPER_INGOT.get(), 0.7f, consumer, "copper_ingot");
        makeMeltingRecipesFromItem(ModItems.RAW_IRON.get(), Items.IRON_INGOT.getItem(), 0.7f, consumer, "iron_ingot");
        makeMeltingRecipesFromItem(ModItems.RAW_GOLD.get(), Items.GOLD_INGOT.getItem(), 1f, consumer, "gold_ingot");
    }

    private void makeCompactingRecipe(Item input, Item output, String result_name, Consumer<IFinishedRecipe> consumer){
      ShapedRecipeBuilder.shaped(output)
                .define('#', input)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_item", has(input))
                .save(consumer, modId(result_name+"_from_compacting"));
    }

    private void makeCompactingRecipe(Item input, Block output, String result_name, Consumer<IFinishedRecipe> consumer){
      ShapedRecipeBuilder.shaped(output)
                .define('#', input)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_item", has(input))
                .save(consumer, modId(result_name+"_from_compacting"));
    }

    private void makeDecompactingRecipe(Item input, Item output, String result_name, Consumer<IFinishedRecipe> consumer){
      ShapelessRecipeBuilder.shapeless(output,9)
                .requires(input)
                .unlockedBy("has_item", has(input))
                .save(consumer,modId(result_name+"_from_decompacting"));
    }
    
    private void makeDecompactingRecipe(Block input, Item output, String result_name, Consumer<IFinishedRecipe> consumer){
      ShapelessRecipeBuilder.shapeless(output,9)
                .requires(input)
                .unlockedBy("has_item", has(input))
                .save(consumer,modId(result_name+"_from_decompacting"));
    }
    
    private void makeCompactingAndDecompactingRecipe(Item compactingInput, Item compactingOutput, String compacting_result, String decompacting_result, Consumer<IFinishedRecipe> consumer){
      makeCompactingRecipe(compactingInput, compactingOutput, compacting_result, consumer);
      makeDecompactingRecipe(compactingOutput, compactingInput, decompacting_result, consumer);
    }

    private void makeCompactingAndDecompactingRecipe(Item compactingInput, Block compactingOutput, String compacting_result, String decompacting_result, Consumer<IFinishedRecipe> consumer){
      makeCompactingRecipe(compactingInput, compactingOutput, compacting_result, consumer);
      makeDecompactingRecipe(compactingOutput, compactingInput, decompacting_result, consumer);
    }

    
    private void makeMeltingRecipesFromItem(Item ingredient, Item result, float exp, Consumer<IFinishedRecipe> consumer, String result_name) {
        CookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, exp, 200)
                .unlockedBy("has_item", has(ingredient))
                .save(consumer, modId(result_name+"_from_smelting_raw"));
        CookingRecipeBuilder.blasting(Ingredient.of(ingredient), result, exp, 100)
                .unlockedBy("has_item", has(ingredient))
                .save(consumer, modId(result_name+"_from_blasting_raw"));
    }

    private void makeMeltingRecipesFromOre(Block ingredient, Item result, float exp, Consumer<IFinishedRecipe> consumer, String result_name) {
        CookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, exp, 200)
                .unlockedBy("has_item", has(ingredient))
                .save(consumer, modId(result_name+"_from_smelting_ore"));
        CookingRecipeBuilder.blasting(Ingredient.of(ingredient), result, exp, 100)
                .unlockedBy("has_item", has(ingredient))
                .save(consumer, modId(result_name+"_from_blasting_ore"));
    }

    private ResourceLocation modId(String path) {
        return new ResourceLocation(SquidCoderMod.MOD_ID, path);
    }
}
