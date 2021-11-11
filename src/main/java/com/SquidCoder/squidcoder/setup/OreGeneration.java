/*
Helpful reference:
https://minecraft.fandom.com/wiki/Blob
*/

public class OreGeneration {

	public static void generateOres(final BiomeLoadingEvent event) {
	  boolean isTheEnd = event.getCategory().equals(Biome.Category.THEEND);
	  boolean isNether = event.getCategory().equals(Biome.Category.NETHER);
	  boolean isOverworld = !(isNether || isTheEnd);
    /*
    All Possible Biomes:
    BEACH
    DESERT
    EXTREME_HILLS
    FOREST
    ICY
    JUNGLE
    MESA
    MUSHROOM
    NETHER
    NONE
    OCEAN
    PLAINS
    RIVER
    SAVANNA
    SWAMP
    TAIGA
    THEEND
    */

		if (isOverworld) {
			
			//Hacky Triangle ore distribution but kinda square
			
			generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.COPPER_ORE.get().getDefaultState(), 8, 6, 31, 8);
			generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.COPPER_ORE.get().getDefaultState(), 10, 31, 69, 10);
			generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.COPPER_ORE.get().getDefaultState(), 8, 69, 100, 8);
			
		//generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,/*stuff goes here*/);
		}
	}

	private static void generateOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state, int veinSize, int minHeight, int maxHeight, int spawnTries) {
		settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
      new OreFeatureConfig(fillerType, state, veinSize))
                         .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight)))/*bottomOffset, topOffset, maximum*/
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
	
	private static void generateOreWithTriangleDistribution(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state, int veinSizeAtWidest, int minHeight, int maxHeight, int spawnTriesAtWidest) {
	  int range = maxHeight-minHeight;
	  float step1 = range / 3;
	  float step2 = step1 + step1;
	  generateOre(settings, fillerType, state, (int) veinSizeAtWidest, minHeight, (int) (minHeight+step1), spawnTriesAtWidest);
	  generateOre(settings, fillerType, state, (int) veinSizeAtWidest, (int) (minHeight+step1), (int) (minHeight+step2), spawnTriesAtWidest);
	  generateOre(settings, fillerType, state, (int) veinSizeAtWidest, (int) (minHeight+step2), maxHeight, spawnTriesAtWidest);
	}
