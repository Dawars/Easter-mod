package easter;

import java.io.File;
import java.util.logging.Logger;

import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Block;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.network.NetworkMod;
import easter.common.DefaultProps;
import easter.common.EasterConfiguration;
import easter.common.Proxy;

//block ids 2650-3200

@Mod(modid = "Easter|Core", name = "Easter mod", version = DefaultProps.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class EasterCore{
	public static boolean trackNetworkUsage = false;
	public static boolean modifyWorld = false;	
	
	public static EasterConfiguration mainConfiguration;
	
	//Items
	public static Item chocolateBarItem;
	public static Item GraveItem;
	
	
	//Blocks
	public static net.minecraft.src.Block Chocolate;
	public static net.minecraft.src.Block Grave;
	public static net.minecraft.src.Block SqueezerWall;
	public static net.minecraft.src.Block CocoaLeaves;
	public static net.minecraft.src.Block CocoaLeavesEmpty;
	public static net.minecraft.src.Block CocoaSapling;
	public static net.minecraft.src.Block CocoaLog;
	
	
	
	
	public static boolean loadDefaultRecipes = true;
	public static boolean forcePneumaticPower = true;
	public static boolean consumeWaterSources = true;

	public static Logger bcLog = Logger.getLogger("Easter");

	@Instance("Easter|Core")
	public static EasterCore instance;

	@PreInit
	public void loadConfiguration(FMLPreInitializationEvent evt) {
		bcLog.setParent(FMLLog.getLogger());
		bcLog.info("Starting Easter " + DefaultProps.VERSION);
		bcLog.info("Copyright (c) Dawars, 2012");
		bcLog.info("http://www.hundevelopers.hu");
		
		mainConfiguration = new EasterConfiguration(new File(evt.getModConfigurationDirectory(), "easter/main.conf"));
		
		try
		{
			mainConfiguration.load();

			Property trackNetwork = EasterCore.mainConfiguration.getOrCreateBooleanProperty("trackNetworkUsage", Configuration.CATEGORY_GENERAL, false);
			trackNetworkUsage = trackNetwork.getBoolean(false);
			
			
			//Item IDs
			Property ChocolateBarId = EasterCore.mainConfiguration.getOrCreateIntProperty("chocolate_bar.id", Configuration.CATEGORY_ITEM, DefaultProps.CHOCOLATE_BAR_ID);
			Property GraveItemId = EasterCore.mainConfiguration.getOrCreateIntProperty("grave.id", Configuration.CATEGORY_ITEM, DefaultProps.GRAVE_ITEM_ID);

			//Items
			chocolateBarItem = (new EasterFood(ChocolateBarId.getInt(DefaultProps.CHOCOLATE_BAR_ID), 2, 1.0F, false)).setIconIndex(0 * 16 + 0).setItemName("chocolateBar");
			Proxy.addName(chocolateBarItem, "Chocolate Bar");
			
			GraveItem = (new EasterGraveItem(GraveItemId.getInt(DefaultProps.GRAVE_ITEM_ID), 0 * 16 + 15)).setItemName("GraveItem");
			Proxy.addName(GraveItem, "Grave");
			
			
			//Block IDs
			Property ChocolateBlockId = EasterCore.mainConfiguration.getOrCreateIntProperty("chocolate_block.id", Configuration.CATEGORY_BLOCK, DefaultProps.CHOCOLATE_BLOCK_ID);
			Property GraveId = EasterCore.mainConfiguration.getOrCreateIntProperty("grave.id", Configuration.CATEGORY_BLOCK, DefaultProps.GRAVE_BLOCK_ID);
			Property SqueezerWallId = EasterCore.mainConfiguration.getOrCreateIntProperty("squeezer_wall.id", Configuration.CATEGORY_BLOCK, DefaultProps.SQUEEZER_WALL_ID);

			
			//Blocks
			Chocolate = new EasterBlock(ChocolateBlockId.getInt(DefaultProps.CHOCOLATE_BLOCK_ID), 1 * 16 + 0, Material.iron).setHardness(2F).setResistance(5F).setBlockName("Chocolate");
			Proxy.registerBlock(Chocolate);
			Proxy.addName(Chocolate, "Chocolate Block");

			Grave = new EasterGrave(GraveId.getInt(DefaultProps.GRAVE_BLOCK_ID)).setHardness(2F).setResistance(5F).setBlockName("Grave");
			Proxy.registerBlock(Grave);
			Proxy.addName(Grave, "Grave");
			
			SqueezerWall = new SqueezerWallBlock(SqueezerWallId.getInt(DefaultProps.SQUEEZER_WALL_ID)).setHardness(2F).setResistance(5F).setBlockName("SqueezerWall");
			Proxy.registerBlock(SqueezerWall);
			Proxy.addName(SqueezerWall, "Squeezer Wall");
		}
		finally
		{
			mainConfiguration.save();
		}
	}
	
	@Init
	public void load(FMLInitializationEvent event){
		new EasterRecipes();
	}
}