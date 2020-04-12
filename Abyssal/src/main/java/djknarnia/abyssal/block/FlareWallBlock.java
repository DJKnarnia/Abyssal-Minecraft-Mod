package djknarnia.abyssal.block;

import net.minecraft.block.WallTorchBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class FlareWallBlock extends WallTorchBlock {

	protected FlareWallBlock(Properties properties) {
		super(properties);
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int wx, int wy, int wz) {
		return null;
	}

}
