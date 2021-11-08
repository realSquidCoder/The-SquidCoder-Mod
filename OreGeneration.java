/*
Helpful reference:
https://minecraft.fandom.com/wiki/Blob
*/

public class OreGeneration {

	public static void generateOres(final BiomeLoadingEvent event) {
		if (!(event.getCategory().equals(Biome.Category.NETHER) || event.getCategory().equals(Biome.Category.THEEND))) {
			generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,/*stuff goes here*/);
		}
	}

	private static void generateOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state, int veinSize, int minHeight, int maxHeight, int spawnTries) {
		settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
      new OreFeatureConfig(fillerType, state, veinSize))
                         .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
                         .square()
                         .count(spawnTries));
	}
	private static void generateOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state, int veinSize, int maxHeight, int spawnTries) {
		settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
      new OreFeatureConfig(fillerType, state, veinSize))
                         .range(maxHeight) /*Returns this.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, range))); */
                         .square()
                         .count(spawnTries));
	}
