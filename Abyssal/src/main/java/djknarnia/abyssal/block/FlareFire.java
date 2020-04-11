package djknarnia.abyssal.block;

import lists.BlockList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class FlareFire extends FireBlock implements ILiquidContainer {
	
	public FlareFire(Properties builder) {
		super(builder);
	}
	
	@Override
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		if(entity instanceof ItemEntity)
		{
			entity.remove();
		} else if (entity instanceof LivingEntity){
			if(!entity.isImmuneToFire())
            {
                ((LivingEntity) entity).setFire(5);
            }
		}
	}
	
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
		return true;
	}

	@Override
	public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, IFluidState fluidStateIn) {
		/*worldIn.setBlockState(pos, BlockList.flare_fire_submerged.getDefaultState(), 0);*/
		return true;
	}
	
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos pos, BlockPos facingPos) {
		if(facingState.getBlock() == Blocks.WATER || facingState.getBlock() == BlockList.flare_fire_submerged) {
			return BlockList.flare_fire_submerged.getDefaultState();
		}
		
		return BlockList.flare_fire.getDefaultState();
	}
	
	/*public void updatePostPlacement(World world, BlockPos pos) {
		
		BlockPos[] neighbors = {pos.add(1,0,0), pos.add(-1,0,0), pos.add(0,1,0), pos.add(0,0,1), pos.add(0,0,-1)};
		
		for(int i = 0; i < neighbors.length; i++) {
			if(world.getBlockState(neighbors[i]).getBlock() == Blocks.COBBLESTONE) {
				world.setBlockState(pos, BlockList.flare_fire_submerged.getDefaultState());
			}
		}
	}*/

}
