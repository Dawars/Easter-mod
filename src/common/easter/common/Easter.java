package easter.common;

import java.io.File;
import java.util.logging.Logger;

import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.FMLLog;
import easter.blocks.BlockCocoaLeaves;
import easter.blocks.BlockCocoaLog;
import easter.blocks.BlockCocoaSapling;
import easter.blocks.EasterBlock;
import easter.blocks.EasterGrave;
import easter.blocks.SqueezerWallBlock;
import easter.client.ClientPacketHandler;
import easter.items.EasterFood;
import easter.items.EasterGraveItem;
import easter.items.EasterRecipes;
import easter.server.ServerPacketHandler;
import net.minecraft.src.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarted;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.common.network.NetworkMod.*;
import cpw.mods.fml.common.registry.*;
//block ids 2650-3200

@Mod(modid = "Easter", name = "Easter mod", version = "1.9.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = true, clientPacketHandlerSpec =
@SidedPacketHandler(channels = { "easterMain" }, packetHandler = ClientPacketHandler.class), serverPacketHandlerSpec =
@SidedPacketHandler(channels = { "easterMain" }, packetHandler = ServerPacketHandler.class))
public class Easter{
	
	@Instance
	// The Easter Instance
	public static Easter instance = new Easter();

	// The Handler For Opening Guis
	private GuiHandler guiHandler = new GuiHandler();

	// Instance For Creating The Config File
	public static Configuration easterConfig;

	// Proxy
	@SidedProxy(clientSide = "easter.client.ClientProxy", serverSide = "easter.common.CommonProxy")
	public static CommonProxy proxy;

	// Pre-Init Method
	@PreInit
	public void preInit(FMLPreInitializationEvent event){
		easterConfig = new Configuration(event.getSuggestedConfigurationFile());
		easterConfig.load();
	}
	
	


	@PreInit
	public void load(FMLPreInitializationEvent evt) {
			
		GameRegistry.registerWorldGenerator(new EasterWorldGenerator());

		// Register Blocks
		
		RegisterBlocks(new Block[] {
//				ChocolateLiquidStill, ChocolateLiquidActive, 
				CocoaLog, CocoaSapling, CocoaLeaves, CocoaLeavesEmpty,
				Grave, Chocolate, 
				
				SqueezerWall
//				, EasterFlower, ChocolateOre, EasterEggFlower, RaisinsCrop,
//				WhiteBlock, MilkBlock, DarkBlock,
//				MysteryEgg1, MysteryEgg2, MysteryEgg3, MysteryEgg4, MysteryEgg5, MysteryEgg6, MysteryEgg7, MysteryEgg8,
//				PinkyBush, Dahlia, Daisy
		});
		
		// Register Names
		// -------------------------------------------------------------------
		// Block Names
		LanguageRegistry.addName(Chocolate, "Chocolate Block");
		LanguageRegistry.addName(Grave, "Grave");
		LanguageRegistry.addName(CocoaLog, "Cocoa Beans Log");
		LanguageRegistry.addName(CocoaSapling, "Cocoa Beans Sapling");
		LanguageRegistry.addName(CocoaLeaves, "Cocoa Beans Leaves");
		LanguageRegistry.addName(CocoaLeavesEmpty, "Cocoa Beans Leaves Empty");
		LanguageRegistry.addName(SqueezerWall, "Squeezer Wall Block");
		
		// Item Names
		LanguageRegistry.addName(chocolateBarItem, "Chocolate Bar");
		LanguageRegistry.addName(GraveItem, "Grave");
		
		// --------------------------------------------------------------------
		RecipeRegistry.registerRecipes();
		EntityRegistry.registerEntities();
//		MinecraftForge.setBlockHarvestLevel(Chocolate, "pickaxe", 1);
		
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
		proxy.registerRenderThings();
		
	}

	// Mods-Loaded Method
	@PostInit
	public void modsLoaded(FMLPostInitializationEvent evt){
		Easter.easterConfig.save();
	}

	// Server Started Method
	@ServerStarted
	public void serverStarted(FMLServerStartedEvent event) {

	}

	// Block Registry
	public static Block Chocolate = new EasterBlock(DefaultProps.CHOCOLATE_BLOCK_ID, 1 * 16 + 0, Material.iron).setHardness(0.5F).setResistance(5F).setBlockName("Chocolate");
	public static Block Grave = new EasterGrave(DefaultProps.GRAVE_BLOCK_ID).setHardness(0.5F).setResistance(5F).setBlockName("Grave");
	public static Block SqueezerWall = new SqueezerWallBlock(DefaultProps.SQUEEZER_WALL_ID).setHardness(2F).setResistance(5F).setBlockName("SqueezerWall");
	public static Block CocoaSapling = new BlockCocoaSapling(DefaultProps.COCOA_BUSH_SAPLING_ID, 7).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("CocoaSapling");
	public static Block CocoaLeaves = (new BlockCocoaLeaves(DefaultProps.COCOA_BUSH_LEAVES_ID, 6)).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setBlockName("CocoaLeaves");
	public static Block CocoaLeavesEmpty = (new BlockCocoaLeaves(DefaultProps.COCOA_BUSH_LEAVES_EMPTY_ID, 5)).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setBlockName("CocoaLeavesEmpty");
	public static Block CocoaLog = new BlockCocoaLog(DefaultProps.COCOA_BUSH_LOG_ID, 4).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setBlockName("EasterBushLog");

	
//	CocoaLog = new BlockCocoaLog(mod_easter.cB("CocoaLog", mod_easter.idBlockEasterCocoaBeansBushLog), 4).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setBlockName("EasterBushLog").setRequiresSelfNotify();
//	CocoaSapling = new BlockCocoaSapling(mod_easter.cB("CocoaSapling", mod_easter.idBlockEasterCocoaBeansSapling), 7).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("CocoaSapling").setRequiresSelfNotify();
//	CocoaLeaves = (new BlockCocoaLeaves(mod_easter.cB("CocoaLeaves", mod_easter.idBlockEasterCocoaBeansLeaves), 6)).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setBlockName("CocoaLeaves").setRequiresSelfNotify();
//	CocoaLeavesEmpty = (new BlockCocoaLeaves(mod_easter.cB("CocoaLeavesEmpty", mod_easter.idBlockEasterCocoaBeansLeaves2), 5)).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setBlockName("CocoaLeavesEmpty").setRequiresSelfNotify();
	
//	EasterFlower = ((BlockFlower)new EasterBlockFlower(mod_easter.cB("EasterFlower", mod_easter.idBlockEasterFlower), 8)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("EasterFlower");
//	EasterEggFlower = ((BlockFlower)new EasterBlockFlower(mod_easter.cB("EasterEggFlower", mod_easter.idBlockEasterEggFlower), 9)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("EasterEggFlower");
//	ChocolateOre = (new EasterBlockChocolateOre(mod_easter.cB("ChocolateOre", mod_easter.idBlockChocolateOre))).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreChocolate");
//	
//	RaisinsCrop = new BlockRaisinsCrop(mod_easter.cB("RaisinsCrop", mod_easter.idBlockRaisinsCrop), 11).setHardness(0.0F).setBlockName("RaisinsCrop");
//	
//	DarkBlock = new EasterBlock(mod_easter.cB("DarkBlock", mod_easter.idBlockDarkChocolateBlock), 17, Material.ground).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setBlockName("DarkBlock");
//	WhiteBlock = new EasterBlock(mod_easter.cB("WhiteBlock", mod_easter.idBlockWhiteChocolateBlock), 18, Material.ground).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setBlockName("WhiteBlock");
//	MilkBlock = new EasterBlock(mod_easter.cB("MilkBlock", mod_easter.idBlockMilkChocolateBlock), 16, Material.ground).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setBlockName("MilkBlock");
//	
//	
//	MysteryEgg1 = new EasterBlockMysteryFlower(mod_easter.cB("MysteryEgg1", mod_easter.idBlockMysteryEgg1), 23).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("MysteryFlower");
//	MysteryEgg2 = new EasterBlockMysteryFlower(mod_easter.cB("MysteryEgg2", mod_easter.idBlockMysteryEgg2), 24).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("MysteryFlower");
//	MysteryEgg3 = new EasterBlockMysteryFlower(mod_easter.cB("MysteryEgg3", mod_easter.idBlockMysteryEgg3), 25).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("MysteryFlower");
//	MysteryEgg4 = new EasterBlockMysteryFlower(mod_easter.cB("MysteryEgg4", mod_easter.idBlockMysteryEgg4), 26).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("MysteryFlower");
//	MysteryEgg5 = new EasterBlockMysteryFlower(mod_easter.cB("MysteryEgg5", mod_easter.idBlockMysteryEgg5), 27).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("MysteryFlower");
//	MysteryEgg6 = new EasterBlockMysteryFlower(mod_easter.cB("MysteryEgg6", mod_easter.idBlockMysteryEgg6), 28).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("MysteryFlower");
//	MysteryEgg7 = new EasterBlockMysteryFlower(mod_easter.cB("MysteryEgg7", mod_easter.idBlockMysteryEgg7), 29).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("MysteryFlower");
//	MysteryEgg8 = new EasterBlockMysteryFlower(mod_easter.cB("MysteryEgg8", mod_easter.idBlockMysteryEgg8), 30).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("MysteryFlower");
////	MysteryEgg9 = new EasterBlockMysteryFlower(mod_easter.cB("MysteryEgg9", mod_easter.idBlockMysteryEgg9), 31).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("MysteryFlower");
//	
//	grave = new BlockGrave(mod_easter.cB("grave", mod_easter.idBlockGrave)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("Grave");
//
//	PinkyBush = ((BlockFlower)new EasterBlockFlower(mod_easter.cB("PinkyBush", mod_easter.idBlockPinkyBush), 32)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("PinkyBush");
//	Dahlia = ((BlockFlower)new EasterBlockFlower(mod_easter.cB("Dahlia", mod_easter.idBlockDahlia), 33)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("Dahlia");
//	Daisy = ((BlockFlower)new EasterBlockFlower(mod_easter.cB("Daisy", mod_easter.idBlockDaisy), 34)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("Daisy");
	public void RegisterBlocks(Block ablock[])
    {
        Block ablock1[] = ablock;
        int i = ablock1.length;
        for(int j = 0; j < i; j++)
        {
            Block block = ablock1[j];
            GameRegistry.registerBlock(block);
        }

    }
	
	
	
	
	// Item Registry
	public static Item chocolateBarItem = (new EasterFood(DefaultProps.CHOCOLATE_BAR_ID, 2, 1.0F, false)).setIconIndex(0 * 16 + 0).setItemName("chocolateBar");
	public static Item GraveItem = (new EasterGraveItem(DefaultProps.GRAVE_ITEM_ID, 0 * 16 + 15)).setItemName("GraveItem");
}