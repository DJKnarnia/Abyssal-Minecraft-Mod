package djknarnia.abyssal.item;

import djknarnia.abyssal.abyssal;
import lists.BlockList;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = abyssal.modid, bus = Bus.FORGE)

public class PrismarineAndSteel extends Item {

	public PrismarineAndSteel(Properties properties) {
		super(properties);
	}

	public ActionResultType onItemUse(ItemUseContext context) {
		
		World world = context.getWorld();
		Block clickedBlock = world.getBlockState(context.getPos().offset(context.getFace())).getBlock();
		
		if(clickedBlock == Blocks.AIR) {
			world.setBlockState(context.getPos().offset(context.getFace()), BlockList.flare_fire.getDefaultState());
			
			double x = context.getPos().getX();
			double y = context.getPos().getY();
			double z = context.getPos().getZ();
			
			SoundCategory soundCategory = SoundCategory.BLOCKS;
			
			world.playSound(x, y, z, SoundEvents.ITEM_FLINTANDSTEEL_USE, soundCategory, 1.0f, 1.0f, false);
			
			if(context.getPlayer() != null) {
				context.getItem().damageItem(1, context.getPlayer(), (damager) -> {
					damager.sendBreakAnimation(context.getHand());
				});
			}
			return ActionResultType.SUCCESS;
		} else if(world.getFluidState(context.getPos().offset(context.getFace())).getFluid() == Fluids.FLOWING_WATER || world.getFluidState(context.getPos().offset(context.getFace())).getFluid() == Fluids.FLOWING_WATER || clickedBlock == Blocks.WATER) {
			world.setBlockState(context.getPos().offset(context.getFace()), BlockList.flare_fire_submerged.getDefaultState());
			
			double x = context.getPos().getX();
			double y = context.getPos().getY();
			double z = context.getPos().getZ();
			
			SoundCategory soundCategory = SoundCategory.BLOCKS;
			
			world.playSound(x, y, z, SoundEvents.ITEM_FLINTANDSTEEL_USE, soundCategory, 1.0f, 1.0f, false);
			if(context.getPlayer() != null) {
				context.getItem().damageItem(1, context.getPlayer(), (damager) -> {
					damager.sendBreakAnimation(context.getHand());
				});
			}
			return ActionResultType.SUCCESS;
		}
		
		return ActionResultType.FAIL;
	}
	
}
