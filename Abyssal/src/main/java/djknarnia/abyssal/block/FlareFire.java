package djknarnia.abyssal.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlareFire extends FireBlock {

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
}
