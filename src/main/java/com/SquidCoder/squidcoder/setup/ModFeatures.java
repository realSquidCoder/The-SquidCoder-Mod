package com.SquidCoder.squidcoder.setup;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class FeatureInit {

	public static final RegistryObject<GeodeFeature> GEODE = Registration.FEATURES.register("geode", () -> new GeodeFeature(NoFeatureConfig.codec));

    
	OreGeneration.generateOres();
	
    static void register() {}
}
