package net.minecraft.src;

import java.util.Map;

public class EasterBlocks {

//	public static Block ChocolateLiquidStill;
//	public static Block ChocolateLiquidActive;
	public static Block EasterIncubatorActive;
	public static Block EasterIncubatorIdle;
	public static Block CocoaLog;
	public static Block CocoaSapling;
	public static Block CocoaLeaves;
	public static Block CocoaLeavesEmpty;
	public static Block EasterFlower;
	public static Block EasterEggFlower;
	public static Block ChocolateOre;
	public static Block RaisinsCrop;
	public static Block WhiteBlock;
	public static Block DarkBlock;
	public static Block MilkBlock;
	public static Block MysteryEgg1;
	public static Block MysteryEgg2;
	public static Block MysteryEgg3;
	public static Block MysteryEgg4;
	public static Block MysteryEgg5;
	public static Block MysteryEgg6;
	public static Block MysteryEgg7;
	public static Block MysteryEgg8;
	public static Block MysteryEgg9;
	public static Block grave;
	public static Block PinkyBush;
	public static Block Dahlia;
	public static Block Daisy;
	
	
	public EasterBlocks()
	{
		
//		ChocolateLiquidActive = (new BlockChocolateFlow(mod_easter.cB("", mod_easter.idBlockChocolateLiquidStill), Material.water)).setHardness(100F).setLightOpacity(255).setLightValue(1F).setBlockName("chocolateFlow").disableStats().setRequiresSelfNotify();
//		ChocolateLiquidStill = (new BlockChocolateStill(mod_easter.cB("", mod_easter.idBlockChocolateLiquidActive), Material.water)).setHardness(100F).setLightOpacity(255).setLightValue(1F).setBlockName("chocolateStill").disableStats().setRequiresSelfNotify();
		EasterIncubatorActive = (new EasterBlockIncubator(mod_easter.cB("EasterIncubatorActive", mod_easter.idBlockEasterIncubatorActive), true).setLightValue(0.875F).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setBlockName("EasterIncubator"));
		EasterIncubatorIdle = (new EasterBlockIncubator(mod_easter.cB("EasterIncubatorIdle", mod_easter.idBlockEasterIncubatorIdle), false).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setBlockName("EasterIncubator"));
		
		CocoaLog = new BlockCocoaLog(mod_easter.cB("CocoaLog", mod_easter.idBlockEasterCocoaBeansBushLog), 4).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setBlockName("EasterBushLog").setRequiresSelfNotify();
		CocoaSapling = new BlockCocoaSapling(mod_easter.cB("CocoaSapling", mod_easter.idBlockEasterCocoaBeansSapling), 7).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("CocoaSapling").setRequiresSelfNotify();
		CocoaLeaves = (new BlockCocoaLeaves(mod_easter.cB("CocoaLeaves", mod_easter.idBlockEasterCocoaBeansLeaves), 6)).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setBlockName("CocoaLeaves").setRequiresSelfNotify();
		CocoaLeavesEmpty = (new BlockCocoaLeaves(mod_easter.cB("CocoaLeavesEmpty", mod_easter.idBlockEasterCocoaBeansLeaves2), 5)).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setBlockName("CocoaLeavesEmpty").setRequiresSelfNotify();
		
		EasterFlower = ((BlockFlower)new EasterBlockFlower(mod_easter.cB("EasterFlower", mod_easter.idBlockEasterFlower), 8)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("EasterFlower");
		EasterEggFlower = ((BlockFlower)new EasterBlockFlower(mod_easter.cB("EasterEggFlower", mod_easter.idBlockEasterEggFlower), 9)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("EasterEggFlower");
		ChocolateOre = (new EasterBlockChocolateOre(mod_easter.cB("ChocolateOre", mod_easter.idBlockChocolateOre))).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreChocolate");
		
		RaisinsCrop = new BlockRaisinsCrop(mod_easter.cB("RaisinsCrop", mod_easter.idBlockRaisinsCrop), 11).setHardness(0.0F).setBlockName("RaisinsCrop");
		
		DarkBlock = new EasterBlock(mod_easter.cB("DarkBlock", mod_easter.idBlockDarkChocolateBlock), 17, Material.ground).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setBlockName("DarkBlock");
		WhiteBlock = new EasterBlock(mod_easter.cB("WhiteBlock", mod_easter.idBlockWhiteChocolateBlock), 18, Material.ground).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setBlockName("WhiteBlock");
		MilkBlock = new EasterBlock(mod_easter.cB("MilkBlock", mod_easter.idBlockMilkChocolateBlock), 16, Material.ground).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setBlockName("MilkBlock");
		
		
		MysteryEgg1 = new EasterBlockMysteryFlower(mod_easter.cB("MysteryEgg1", mod_easter.idBlockMysteryEgg1), 23).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("MysteryFlower");
		MysteryEgg2 = new EasterBlockMysteryFlower(mod_easter.cB("MysteryEgg2", mod_easter.idBlockMysteryEgg2), 24).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("MysteryFlower");
		MysteryEgg3 = new EasterBlockMysteryFlower(mod_easter.cB("MysteryEgg3", mod_easter.idBlockMysteryEgg3), 25).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("MysteryFlower");
		MysteryEgg4 = new EasterBlockMysteryFlower(mod_easter.cB("MysteryEgg4", mod_easter.idBlockMysteryEgg4), 26).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("MysteryFlower");
		MysteryEgg5 = new EasterBlockMysteryFlower(mod_easter.cB("MysteryEgg5", mod_easter.idBlockMysteryEgg5), 27).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("MysteryFlower");
		MysteryEgg6 = new EasterBlockMysteryFlower(mod_easter.cB("MysteryEgg6", mod_easter.idBlockMysteryEgg6), 28).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("MysteryFlower");
		MysteryEgg7 = new EasterBlockMysteryFlower(mod_easter.cB("MysteryEgg7", mod_easter.idBlockMysteryEgg7), 29).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("MysteryFlower");
		MysteryEgg8 = new EasterBlockMysteryFlower(mod_easter.cB("MysteryEgg8", mod_easter.idBlockMysteryEgg8), 30).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("MysteryFlower");
//		MysteryEgg9 = new EasterBlockMysteryFlower(mod_easter.cB("MysteryEgg9", mod_easter.idBlockMysteryEgg9), 31).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("MysteryFlower");
		
		grave = new BlockGrave(mod_easter.cB("grave", mod_easter.idBlockGrave)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("Grave");

		PinkyBush = ((BlockFlower)new EasterBlockFlower(mod_easter.cB("PinkyBush", mod_easter.idBlockPinkyBush), 32)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("PinkyBush");
		Dahlia = ((BlockFlower)new EasterBlockFlower(mod_easter.cB("Dahlia", mod_easter.idBlockDahlia), 33)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("Dahlia");
		Daisy = ((BlockFlower)new EasterBlockFlower(mod_easter.cB("Daisy", mod_easter.idBlockDaisy), 34)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("Daisy");

		
		RegisterBlocks(new Block[] {
//				ChocolateLiquidStill, ChocolateLiquidActive, 
				EasterIncubatorActive, EasterIncubatorIdle,
				CocoaLog, CocoaSapling, CocoaLeaves, CocoaLeavesEmpty, EasterFlower, ChocolateOre, EasterEggFlower, RaisinsCrop,
				WhiteBlock, MilkBlock, DarkBlock,
				MysteryEgg1, MysteryEgg2, MysteryEgg3, MysteryEgg4, MysteryEgg5, MysteryEgg6, MysteryEgg7, MysteryEgg8,
				PinkyBush, Dahlia, Daisy
		});
		
		
//		ModLoader.addName(ChocolateLiquidStill, "Chocolate Still");
//		ModLoader.addName(ChocolateLiquidActive, "Chocolate Active");
		ModLoader.addName(EasterIncubatorActive, "Egg Opener Active");
		ModLoader.addName(EasterIncubatorIdle, "Egg Opener");
		
		ModLoader.addName(CocoaLog, "Cocoa Beans Log");
		ModLoader.addName(CocoaSapling, "Cocoa Beans Sapling");
		ModLoader.addName(CocoaLeaves, "Cocoa Beans Leaves");
		ModLoader.addName(CocoaLeavesEmpty, "Cocoa Beans Leaves Empty");
		
		ModLoader.addName(EasterFlower, "Easter Flower");
		ModLoader.addName(EasterEggFlower, "Easter Egg Flower");
		ModLoader.addName(ChocolateOre, "White Chocolate Ore");
		ModLoader.addName(RaisinsCrop, "Raisins Crop");

		
		ModLoader.addName(WhiteBlock, "White Chocolate Block");
		ModLoader.addName(MilkBlock, "Milk Chocolate Block");
		ModLoader.addName(DarkBlock, "Dark Chocolate Block");
		ModLoader.addName(DarkBlock, "Dark Chocolate Block");
		
		ModLoader.addName(MysteryEgg1, "Mystery Egg");
		
		ModLoader.addName(PinkyBush, "Pinky Bush");
		ModLoader.addName(Dahlia, "Dahlia");
		ModLoader.addName(Daisy, "Daisy");
		
	}

	public void RegisterBlocks(Block ablock[])
    {
        Block ablock1[] = ablock;
        int i = ablock1.length;
        for(int j = 0; j < i; j++)
        {
            Block block = ablock1[j];
            ModLoader.registerBlock(block);
        }

    }
	
}
