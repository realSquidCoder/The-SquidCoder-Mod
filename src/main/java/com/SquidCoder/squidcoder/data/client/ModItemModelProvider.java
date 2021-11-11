package com.SquidCoder.squidcoder.data.client;

import com.SquidCoder.squidcoder.SquidCoderMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, SquidCoderMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("silver_block", modLoc("block/silver_block"));
        withExistingParent("copper_block", modLoc("block/copper_block"));
        withExistingParent("silver_ore", modLoc("block/silver_ore"));
        withExistingParent("copper_ore", modLoc("block/copper_ore"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        //Ingots
        builder(itemGenerated, "silver_ingot");
        builder(itemGenerated, "copper_ingot");

        //Dusts
        builder(itemGenerated, "silver_dust");

        //Nuggets
        builder(itemGenerated, "silver_nugget");

        //Raw Ores
        builder(itemGenerated, "raw_copper");
        builder(itemGenerated, "raw_iron");
        builder(itemGenerated, "raw_gold");
        
        //Misc
        builder(itemGenerated, "amethyst_shard");
        builder(itemGenerated, "spyglass");
        
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
