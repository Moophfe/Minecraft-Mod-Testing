package moop.Testmod1;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import moop.Testmod1.lists.ItemList;

@Mod(Reference.MODID)

public final class Main {

	//public static final String MODID = "myfirsttutorialmod";
	
	private static final Logger LOGGER = LogManager.getLogger(Reference.MODID);
	
	public static Main instance;
	
	public Main() {
		
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
		
		
	
		
		
	}
	
	private void setup(final FMLCommonSetupEvent event) 
	{
		LOGGER.info("Setup Registered BABEEEEEEEE!");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event) 
	{
		LOGGER.info("clientRegistries Registered BABEEEEEEEE!");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) 
		{
			
			event.getRegistry().registerAll
			(	
			ItemList.tutorial_item = new Item(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("tutorial_item"))
			);
			
			LOGGER.info("Items registered");
		}
		
		private static ResourceLocation location(String name) {
			return new ResourceLocation(Reference.MODID, name);
		}
	}
}


