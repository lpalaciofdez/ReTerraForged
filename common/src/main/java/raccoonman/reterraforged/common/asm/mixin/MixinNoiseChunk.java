package raccoonman.reterraforged.common.asm.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.QuartPos;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.NoiseChunk;
import raccoonman.reterraforged.common.level.levelgen.density.FlatCache;

@Mixin(NoiseChunk.class)
class MixinNoiseChunk {
	@Shadow
	@Final
	private int firstNoiseX, 
				firstNoiseZ,
				cellCountXZ,
				cellWidth;
	
	@Inject(
		at = @At("HEAD"),
		cancellable = true,
		method = "wrapNew"
	)
	private void wrapNew(DensityFunction densityFunction, CallbackInfoReturnable<DensityFunction> callback) {
		if(densityFunction instanceof FlatCache.Marker function) {
			//TODO don't add the padding to the width here, pass it through the padding parameter when we add that
			FlatCache cache = new FlatCache(function.function(), this.cellWidth * this.cellCountXZ + 1, function.padding(), QuartPos.toBlock(this.firstNoiseX), QuartPos.toBlock(this.firstNoiseZ));
			callback.setReturnValue(cache);
		}
//		if(densityFunction instanceof XZGradient function) {
//			callback.setReturnValue(function.cache());
//		}
	}
}