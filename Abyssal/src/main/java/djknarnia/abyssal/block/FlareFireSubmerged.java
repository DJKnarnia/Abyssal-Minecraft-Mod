package djknarnia.abyssal.block;

import lists.BlockList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class FlareFireSubmerged extends FlareFire implements ILiquidContainer {

	public FlareFireSubmerged(Properties builder) {
		super(builder);
	}
	
	public IFluidState getFluidState(BlockState state) {
		return Fluids.WATER.getStillFluidState(false);
	}
	
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos pos, BlockPos facingPos) {
		if(facingState.getBlock() == Blocks.AIR && facing != Direction.UP) {
			world.setBlockState(facingPos, Blocks.WATER.getDefaultState(), 0);
		}
		
		return BlockList.flare_fire_submerged.getDefaultState();
	}
	
}
