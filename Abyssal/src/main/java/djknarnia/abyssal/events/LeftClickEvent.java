package djknarnia.abyssal.events;

import djknarnia.abyssal.abyssal;
import lists.BlockList;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = abyssal.modid, bus = Bus.FORGE)

public class LeftClickEvent {

	@SubscribeEvent
	public static void leftClickEvent(PlayerInteractEvent.EntityInteract.LeftClickBlock event) {
		
		World world = event.getWorld();
		Block clickedBlock = event.getWorld().getBlockState(event.getPos().offset(event.getFace())).getBlock();
		
		abyssal.logger.info("player left clicked " + event.getPos());
		
		if(clickedBlock == BlockList.flare_fire) {
			world.setBlockState(event.getPos().offset(event.getFace()), Blocks.AIR.getDefaultState());
			
			double x = event.getPos().getX();
			double y = event.getPos().getY();
			double z = event.getPos().getZ();
			
			SoundCategory soundCategory = SoundCategory.BLOCKS;
			
			world.playSound(x, y, z, SoundEvents.BLOCK_FIRE_EXTINGUISH, soundCategory, 1.0f, 1.0f, false);
		}
	}
}