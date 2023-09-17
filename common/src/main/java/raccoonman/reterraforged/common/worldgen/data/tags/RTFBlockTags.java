package raccoonman.reterraforged.common.worldgen.data.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import raccoonman.reterraforged.common.ReTerraForged;

public final class RTFBlockTags {
	public static final TagKey<Block> ERODIBLE = resolve("erodible");
	public static final TagKey<Block> SOIL = resolve("soil");
	public static final TagKey<Block> ROCK = resolve("rock");
	public static final TagKey<Block> CLAY = resolve("clay");
	public static final TagKey<Block> SEDIMENT = resolve("sediment");
	
    private static TagKey<Block> resolve(String path) {
    	return TagKey.create(Registries.BLOCK, ReTerraForged.resolve(path));
    }
}
