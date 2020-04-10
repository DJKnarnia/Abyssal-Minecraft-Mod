package djknarnia.abyssal.block;

import djknarnia.abyssal.abyssal;
import net.minecraft.block.FireBlock;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = abyssal.modid, bus = Bus.FORGE)

public class FlareFire extends FireBlock {

	public FlareFire(Properties builder) {
		super(builder);
	}
	
	@SubscribeEvent
	public void leftClickEvent(PlayerInteractEvent.EntityInteract.LeftClickBlock event) {
		
		abyssal.logger.info("Player left click event fired.");
		
		/*abyssal.logger.info(event.getPos().toString());*/
		
	}
}
