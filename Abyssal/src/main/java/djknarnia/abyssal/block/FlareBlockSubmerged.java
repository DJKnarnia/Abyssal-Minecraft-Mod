package djknarnia.abyssal.block;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class FlareBlockSubmerged extends FlareBlock {

	public FlareBlockSubmerged(Properties properties) {
		super(properties);
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int wx, int wy, int wz) {
		return null;
	}
}
