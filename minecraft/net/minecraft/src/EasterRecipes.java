package net.minecraft.src;

public class EasterRecipes {
	  public EasterRecipes()
	    {
		  	ModLoader.addRecipe(new ItemStack(EasterItems.ChocolateBar, 6), new Object[] {
		  		"SMS", "CCC",
		  		Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 3),
		  		Character.valueOf('M'), Item.bucketMilk,
		  		Character.valueOf('S'), Item.sugar
	        });
		  	ModLoader.addRecipe(new ItemStack(EasterItems.DarkChocolateBar, 6), new Object[] {
		  		"CSC", "CCC",
		  		Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 3),
		  		Character.valueOf('S'), Item.sugar
	        });

		  	ModLoader.addRecipe(new ItemStack(EasterItems.ChocolateDiamond, 6), new Object[] {
		  		"ZZZ", "ZXZ", "ZZZ",
		  		Character.valueOf('Z'), EasterItems.ChocolateBar,
		  		Character.valueOf('X'), Item.diamond
	        });

		  	ModLoader.addRecipe(new ItemStack(EasterItems.ChocolateEgg, 1), new Object[] {
		  		" Z ", "ZXZ", " Z ", Character.valueOf('Z'), EasterItems.ChocolateBar,
		  		Character.valueOf('X'), Item.egg
	        });
		  	ModLoader.addRecipe(new ItemStack(EasterItems.WhiteChocolateEgg, 1), new Object[] {
		  		" Z ", "ZXZ", " Z ",
		  		Character.valueOf('Z'), EasterItems.WhiteChocolateBar,
		  		Character.valueOf('X'), Item.egg
	        });
		  	ModLoader.addRecipe(new ItemStack(EasterItems.DarkChocolateEgg, 1), new Object[] {
		  		" Z ", "ZXZ", " Z ",
		  		Character.valueOf('Z'), new ItemStack(Item.dyePowder, 1, 3),
		  		Character.valueOf('X'), Item.egg
	        });
		  	
		  	ModLoader.addRecipe(new ItemStack(EasterItems.TombWand, 1), new Object[] {
		  		" Z ", "ZXZ", " Z ",
		  		Character.valueOf('Z'), Block.wood,
		  		Character.valueOf('X'), Item.diamond
	        });

		  	ModLoader.addRecipe(new ItemStack(EasterBlocks.EasterIncubatorIdle, 1), new Object[] {
		  		"ZZZ", "ZYZ", "ZZZ",
		  		Character.valueOf('Y'), Block.glass,
		  		Character.valueOf('Z'), Block.stone
//		  		Character.valueOf('X'), Item.ingotIron
	        });
		  	ModLoader.addRecipe(new ItemStack(EasterItems.CrossBun, 4), new Object[] {
		  		"YXY", "#Z#", "YXY",
		  		Character.valueOf('Z'), Item.bucketMilk,
		  		Character.valueOf('Y'), Item.wheat,
		  		Character.valueOf('X'), Item.sugar,
		  		Character.valueOf('#'), EasterItems.Raisins
	        });
		  	
		  	//tools
		  	ModLoader.addRecipe(new ItemStack(EasterItems.DarkChocolateAxe, 1), new Object[] {
		  		"ZZ ", "ZX ", " X ",
		  		Character.valueOf('Z'), EasterItems.DarkChocolateBar,
		  		Character.valueOf('X'), Item.stick
	        });
		  	ModLoader.addRecipe(new ItemStack(EasterItems.WhiteChocolateAxe, 1), new Object[] {
		  		"ZZ ", "ZX ", " X ",
		  		Character.valueOf('Z'), EasterItems.WhiteChocolateBar,
		  		Character.valueOf('X'), Item.stick
	        });

		  	ModLoader.addRecipe(new ItemStack(EasterItems.MilkChocolateAxe, 1), new Object[] {
		  		"ZZ ", "ZX ", " X ",
		  		Character.valueOf('Z'), EasterItems.ChocolateBar,
		  		Character.valueOf('X'), Item.stick
	        });

		  	ModLoader.addRecipe(new ItemStack(EasterItems.DarkChocolatePickaxe, 1), new Object[] {
		  		"ZZZ", " X ", " X ",
		  		Character.valueOf('Z'), EasterItems.DarkChocolateBar,
		  		Character.valueOf('X'), Item.stick
	        });
		  	ModLoader.addRecipe(new ItemStack(EasterItems.MilkChocolatePickaxe, 1), new Object[] {
		  		"ZZZ", " X ", " X ",
		  		Character.valueOf('Z'), EasterItems.ChocolateBar,
		  		Character.valueOf('X'), Item.stick
	        });
		  	ModLoader.addRecipe(new ItemStack(EasterItems.WhiteChocolatePickaxe, 1), new Object[] {
		  		"ZZZ", " X ", " X ",
		  		Character.valueOf('Z'), EasterItems.WhiteChocolateBar,
		  		Character.valueOf('X'), Item.stick
	        });
		  	

		  	ModLoader.addRecipe(new ItemStack(EasterItems.WhiteChocolateHoe, 1), new Object[] {
		  		"ZZ ", " X ", " X ",
		  		Character.valueOf('Z'), EasterItems.WhiteChocolateBar,
		  		Character.valueOf('X'), Item.stick
	        });

		  	ModLoader.addRecipe(new ItemStack(EasterItems.WhiteChocolateHoe, 1), new Object[] {
		  		" ZZ", " X ", " X ",
		  		Character.valueOf('Z'), EasterItems.WhiteChocolateBar,
		  		Character.valueOf('X'), Item.stick
	        });

		  	ModLoader.addRecipe(new ItemStack(EasterItems.DarkChocolateHoe, 1), new Object[] {
		  		"ZZ ", " X ", " X ",
		  		Character.valueOf('Z'), EasterItems.DarkChocolateBar,
		  		Character.valueOf('X'), Item.stick
	        });

		  	ModLoader.addRecipe(new ItemStack(EasterItems.DarkChocolateHoe, 1), new Object[] {
		  		" ZZ", " X ", " X ",
		  		Character.valueOf('Z'), EasterItems.DarkChocolateBar,
		  		Character.valueOf('X'), Item.stick
	        });
		  	ModLoader.addRecipe(new ItemStack(EasterItems.MilkChocolateHoe, 1), new Object[] {
		  		"ZZ ", " X ", " X ",
		  		Character.valueOf('Z'), EasterItems.ChocolateBar,
		  		Character.valueOf('X'), Item.stick
	        });

		  	ModLoader.addRecipe(new ItemStack(EasterItems.MilkChocolateHoe, 1), new Object[] {
		  		" ZZ", " X ", " X ",
		  		Character.valueOf('Z'), EasterItems.ChocolateBar,
		  		Character.valueOf('X'), Item.stick
	        });
		  	ModLoader.addRecipe(new ItemStack(EasterItems.MilkChocolateSword, 1), new Object[] {
		  		" Z ", " Z ", " X ",
		  		Character.valueOf('Z'), EasterItems.ChocolateBar,
		  		Character.valueOf('X'), Item.stick
	        });

		  	ModLoader.addRecipe(new ItemStack(EasterItems.DarkChocolateSword, 1), new Object[] {
		  		" Z ", " Z ", " X ",
		  		Character.valueOf('Z'), EasterItems.DarkChocolateBar,
		  		Character.valueOf('X'), Item.stick
	        });

		  	ModLoader.addRecipe(new ItemStack(EasterItems.WhiteChocolateSword, 1), new Object[] {
		  		" Z ", " Z ", " X ",
		  		Character.valueOf('Z'), EasterItems.WhiteChocolateBar,
		  		Character.valueOf('X'), Item.stick
	        });
		  	

		  	ModLoader.addRecipe(new ItemStack(EasterItems.WhiteChocolateSpade, 1), new Object[] {
		  		" Z ", " X ", " X ",
		  		Character.valueOf('Z'), EasterItems.WhiteChocolateBar,
		  		Character.valueOf('X'), Item.stick
	        });
		  	ModLoader.addRecipe(new ItemStack(EasterItems.DarkChocolateSpade, 1), new Object[] {
		  		" Z ", " X ", " X ",
		  		Character.valueOf('Z'), EasterItems.DarkChocolateBar,
		  		Character.valueOf('X'), Item.stick
	        });
		  	ModLoader.addRecipe(new ItemStack(EasterItems.MilkChocolateSpade, 1), new Object[] {
		  		" Z ", " X ", " X ",
		  		Character.valueOf('Z'), EasterItems.ChocolateBar,
		  		Character.valueOf('X'), Item.stick
	        });
		  	
		  	
		  	//armor
		  	

		  	ModLoader.addRecipe(new ItemStack(EasterItems.MilkChocolateHelmet, 1), new Object[] {
		  		"ZZZ", "Z Z",
		  		Character.valueOf('Z'), EasterItems.ChocolateBar,
	        });

		  	ModLoader.addRecipe(new ItemStack(EasterItems.DarkChocolateHelmet, 1), new Object[] {
		  		"ZZZ", "Z Z",
		  		Character.valueOf('Z'), EasterItems.DarkChocolateBar,
	        });
		  	ModLoader.addRecipe(new ItemStack(EasterItems.WhiteChocolateHelmet, 1), new Object[] {
		  		"ZZZ", "Z Z",
		  		Character.valueOf('Z'), EasterItems.WhiteChocolateBar,
	        });


		  	
		  	ModLoader.addRecipe(new ItemStack(EasterItems.MilkChocolatePlate, 1), new Object[] {
		  		"Z Z", "ZZZ", "ZZZ",
		  		Character.valueOf('Z'), EasterItems.ChocolateBar,
	        });
		  	ModLoader.addRecipe(new ItemStack(EasterItems.DarkChocolatePlate, 1), new Object[] {
		  		"Z Z", "ZZZ", "ZZZ",
		  		Character.valueOf('Z'), EasterItems.DarkChocolateBar,
	        });
		  	ModLoader.addRecipe(new ItemStack(EasterItems.WhiteChocolatePlate, 1), new Object[] {
		  		"Z Z", "ZZZ", "ZZZ",
		  		Character.valueOf('Z'), EasterItems.WhiteChocolateBar,
	        });

		  	

		  	ModLoader.addRecipe(new ItemStack(EasterItems.MilkChocolateLegs, 1), new Object[] {
		  		"ZZZ", "Z Z", "Z Z",
		  		Character.valueOf('Z'), EasterItems.ChocolateBar,
	        });
		  	ModLoader.addRecipe(new ItemStack(EasterItems.DarkChocolateLegs, 1), new Object[] {
		  		"ZZZ", "Z Z", "Z Z",
		  		Character.valueOf('Z'), EasterItems.DarkChocolateBar,
	        });
		  	ModLoader.addRecipe(new ItemStack(EasterItems.WhiteChocolateLegs, 1), new Object[] {
		  		"ZZZ", "Z Z", "Z Z",
		  		Character.valueOf('Z'), EasterItems.WhiteChocolateBar,
	        });
		  	

		  	ModLoader.addRecipe(new ItemStack(EasterItems.MilkChocolateBoots, 1), new Object[] {
		  		"Z Z", "Z Z",
		  		Character.valueOf('Z'), EasterItems.ChocolateBar,
	        });
		  	ModLoader.addRecipe(new ItemStack(EasterItems.DarkChocolateBoots, 1), new Object[] {
		  		"Z Z", "Z Z",
		  		Character.valueOf('Z'), EasterItems.DarkChocolateBar,
	        });
		  	ModLoader.addRecipe(new ItemStack(EasterItems.WhiteChocolateBoots, 1), new Object[] {
		  		"Z Z", "Z Z",
		  		Character.valueOf('Z'), EasterItems.WhiteChocolateBar,
	        });
		  	//blocks
		  	
		  	

		  	ModLoader.addRecipe(new ItemStack(EasterBlocks.MilkBlock, 1), new Object[] {
		  		"ZZZ", "ZZZ", "ZZZ",
		  		Character.valueOf('Z'), EasterItems.ChocolateBar,
	        });

		  	ModLoader.addRecipe(new ItemStack(EasterBlocks.DarkBlock, 1), new Object[] {
		  		"ZZZ", "ZZZ", "ZZZ",
		  		Character.valueOf('Z'), EasterItems.DarkChocolateBar,
	        });

		  	ModLoader.addRecipe(new ItemStack(EasterBlocks.WhiteBlock, 1), new Object[] {
		  		"ZZZ", "ZZZ", "ZZZ",
		  		Character.valueOf('Z'), EasterItems.WhiteChocolateBar,
	        });
		  	
		  	
		  	
	        ModLoader.addShapelessRecipe(new ItemStack(EasterItems.Raisins,1),new Object[]{
	        	EasterItems.CrossBun
	        });
	        ModLoader.addShapelessRecipe(new ItemStack(EasterItems.Raisins,1),new Object[]{
	        	EasterItems.HotCrossBun
	        });

	        ModLoader.addShapelessRecipe(new ItemStack(Item.stick,2),new Object[]{
	        	EasterBlocks.CocoaLog
	        });
	        
	        
	        
	        ModLoader.addSmelting(EasterItems.CrossBun.shiftedIndex, new ItemStack(EasterItems.HotCrossBun, 1));
	        ModLoader.addSmelting(EasterItems.WhiteChocolateDust.shiftedIndex, new ItemStack(EasterItems.WhiteChocolateBar, 1));
	        
	    }
}
