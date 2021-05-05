package io.github.nuclearfarts.blahaj.mixin;

import net.minecraft.block.state.BlockStateContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(BlockStateContainer.StateImplementation.class)
public class BlockStateImplementationMixin {
	/* The vanilla hashCode implementation just hashes the properties map.
	 * However, this does not account for the block of the state, and they're reference compared anyway.
	 * So we just use the default Object#hashCode result instead to reduce collisions.
	 */
	@Overwrite
	public int hashCode() {
		return super.hashCode();
	}
}
