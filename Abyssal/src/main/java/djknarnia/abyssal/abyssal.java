package djknarnia.abyssal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import djknarnia.abyssal.block.FlareBlock;
import djknarnia.abyssal.block.FlareBlockSubmerged;
import djknarnia.abyssal.block.FlareFire;
import djknarnia.abyssal.block.FlareFireSubmerged;
import djknarnia.abyssal.item.PrismarineAndSteel;
import lists.BlockList;
import lists.ItemList;
import lists.ToolMaterialList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("abyssal")
public class abyssal {
	
	public static abyssal instance;
	public static final String modid = "abyssal";
	public static final Logger logger = LogManager.getLogger("abyssal");
	
	public static final ItemGroup abyssal = new AbyssalItemGroup("Abyssal");
	
	public abyssal() {
		
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		logger.info("Setup method registered.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event) {
		logger.info("clientRegistries method registered.");
	}
	
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			
			event.getRegistry().registerAll(
				/*Items*/
				ItemList.prismarine_quartz_shard = new Item(new Item.Properties().group(abyssal)).setRegistryName(location("prismarine_quartz_shard")),
				/*Tools*/
				ItemList.prismarine_and_steel = new PrismarineAndSteel(new Item.Properties().group(abyssal)).setRegistryName(location("prismarine_and_steel")),
				ItemList.prismarine_axe = new AxeItem(ToolMaterialList.prismarine, -1.0f, 6.0f, new Item.Properties().group(abyssal)).setRegistryName(location("prismarine_axe")),
				ItemList.prismarine_pickaxe = new PickaxeItem(ToolMaterialList.prismarine, -2, 6.0f, new Item.Properties().group(abyssal)).setRegistryName(location("prismarine_pickaxe")),
				ItemList.prismarine_shovel = new ShovelItem(ToolMaterialList.prismarine, -1.0f, 6.0f, new Item.Properties().group(abyssal)).setRegistryName(location("prismarine_shovel")),
				ItemList.prismarine_sword = new SwordItem(ToolMaterialList.prismarine, 1, 6.0f, new Item.Properties().group(abyssal)).setRegistryName(location("prismarine_sword")),
				ItemList.prismarine_hoe = new HoeItem(ToolMaterialList.prismarine, 6.0f, new Item.Properties().group(abyssal)).setRegistryName(location("prismarine_hoe")),
				/*Block Items*/
				ItemList.prismarine_quartz_block = new BlockItem(BlockList.prismarine_quartz_block, new Item.Properties().group(abyssal)).setRegistryName(BlockList.prismarine_quartz_block.getRegistryName()),
				ItemList.flare_fire = new BlockItem(BlockList.flare_fire, new Item.Properties().group(abyssal)).setRegistryName(BlockList.flare_fire.getRegistryName()),
				ItemList.flare_fire_submerged = new BlockItem(BlockList.flare_fire_submerged, new Item.Properties().group(abyssal)).setRegistryName(BlockList.flare_fire_submerged.getRegistryName()),
				ItemList.flare = new BlockItem(BlockList.flare, new Item.Properties().group(abyssal)).setRegistryName(BlockList.flare.getRegistryName()),
				ItemList.flare_submerged = new BlockItem(BlockList.flare_submerged, new Item.Properties().group(abyssal)).setRegistryName(BlockList.flare_submerged.getRegistryName())
			);
			
			logger.info("Items registered.");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			
			event.getRegistry().registerAll(
				BlockList.prismarine_quartz_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.STONE)).setRegistryName(location("prismarine_quartz_block")),
				BlockList.flare_fire = (FlareFire) new FlareFire(Block.Properties.create(Material.FIRE).lightValue(15)).setRegistryName(location("flare_fire")),
				BlockList.flare_fire_submerged = (FlareFireSubmerged) new FlareFireSubmerged(Block.Properties.create(Material.FIRE).lightValue(15)).setRegistryName(location("flare_fire_submerged")),
				BlockList.flare = (FlareBlock) new FlareBlock(TorchBlock.Properties.create(Material.AIR).lightValue(15)).setRegistryName(location("flare")),
				BlockList.flare_submerged = (FlareBlockSubmerged) new FlareBlockSubmerged(Block.Properties.create(Material.AIR).lightValue(15)).setRegistryName(location("flare_submerged"))
			);
				
				logger.info("Blocks registered.");
		}
		
		private static ResourceLocation location(String name) {
			return new ResourceLocation(modid, name);
		}
	}
}
