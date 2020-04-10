package djknarnia.abyssal.events;

import djknarnia.abyssal.abyssal;
import lists.BlockList;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.World;
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
			
		}
	}
}