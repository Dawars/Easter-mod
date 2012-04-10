package net.minecraft.src;

public class EasterItems {
	public static Item ChocolateEgg;
	public static Item WhiteChocolateEgg;
	public static Item DarkChocolateEgg;
	public static Item ChocolateBar;
	public static Item TombWand;
	public static Item CrossBun;
	public static Item HotCrossBun;
	public static Item Raisins;
	public static Item ChocolateDiamond;
	
	public static Item EasterMonsterSpawner;
	public static Item WhiteChocolateDust;
	public static Item WhiteChocolateBar;
	public static Item DarkChocolateBar;
	
	public static Item MilkChocolateHelmet;
	public static Item MilkChocolatePlate;
	public static Item MilkChocolateLegs;
	public static Item MilkChocolateBoots;

	public static Item DarkChocolateHelmet;
	public static Item DarkChocolatePlate;
	public static Item DarkChocolateLegs;
	public static Item DarkChocolateBoots;
	
	public static Item WhiteChocolateHelmet;
	public static Item WhiteChocolatePlate;
	public static Item WhiteChocolateLegs;
	public static Item WhiteChocolateBoots;

	
	public static Item MilkChocolateSword;
	public static Item MilkChocolatePickaxe;
	public static Item MilkChocolateSpade;
	public static Item MilkChocolateAxe;
	public static Item MilkChocolateHoe;

	public static Item DarkChocolateSword;
	public static Item DarkChocolatePickaxe;
	public static Item DarkChocolateSpade;
	public static Item DarkChocolateAxe;
	public static Item DarkChocolateHoe;

	public static Item WhiteChocolateSword;
	public static Item WhiteChocolatePickaxe;
	public static Item WhiteChocolateSpade;
	public static Item WhiteChocolateAxe;
	public static Item WhiteChocolateHoe;
	
	public static Item grave;
	
     EasterItems()
	{
		ChocolateEgg = (new ItemEasterFood(mod_easter.idItemChocolateEgg, 8, false, 0)).setItemName("chocolateEgg");
		WhiteChocolateEgg = (new ItemEasterFood(mod_easter.idItemWhiteChocolateEgg, 8, false, 14)).setItemName("whiteChocolateEgg");
		DarkChocolateEgg = (new ItemEasterFood(mod_easter.idItemDarkChocolateEgg, 8, false, 13)).setItemName("DarkChocolateEgg");
		ChocolateBar = (new ItemEasterFood(mod_easter.idItemChocolateBar, 5, false, 12)).setItemName("chocolateBar");
		TombWand = (new ItemTombWand(mod_easter.idBlockTombWand, 2)).setItemName("TombWand");
		CrossBun = (new ItemEasterFood(mod_easter.idItemCrossBun, 1, false, 3)).setItemName("CrossBun");
		HotCrossBun = (new ItemEasterFood(mod_easter.idItemHotCrossBun, 10, true, 4)).setItemName("HotCrossBun");
		Raisins = (new EasterItemRaisins(mod_easter.idItemRaisins, EasterBlocks.RaisinsCrop.blockID, Block.tilledField.blockID)).setItemName("Raisins");
		ChocolateDiamond = (new ItemChocolateDiamonds(mod_easter.idItemChocolateDiamonds, 6)).setItemName("ChocolateDiamond");

//		EasterMonsterSpawner = (new EasterItemMonsterPlacer(mod_easter.idItemEasterMonsterSpawner)).setItemName("EasterMosterPlacer");
		WhiteChocolateDust = (new EasterItemWhiteChocolateDust(mod_easter.idItemEasterWhiteChocolateDust)).setItemName("WhiteChocolateDust");
		WhiteChocolateBar = (new ItemEasterFood(mod_easter.idItemEasterWhiteChocolateBar, 5, true, 10)).setItemName("WhiteChocolateBar");
		DarkChocolateBar = (new ItemEasterFood(mod_easter.idItemEasterDarkChocolateBar, 5, true, 11)).setItemName("DarkChocolateBar");
			
	    //tools
		MilkChocolateSword = new EasterItemSword(mod_easter.idItemMilkChocolateSword, EasterToolMaterial.MILK, 20).setItemName("swordMilk");
	    MilkChocolatePickaxe = new EasterItemPickaxe(mod_easter.idItemMilkChocolatePickaxe, EasterToolMaterial.MILK, 52).setItemName("pickMilk");
	    MilkChocolateSpade = new EasterItemSpade(mod_easter.idItemMilkChocolateSpade, EasterToolMaterial.MILK, 36).setItemName("spadeMilk");
	    MilkChocolateAxe = new EasterItemAxe(mod_easter.idItemMilkChocolateAxe, EasterToolMaterial.MILK, 68).setItemName("axeMilk");
	    MilkChocolateHoe = new EasterItemHoe(mod_easter.idItemMilkChocolateHoe, EasterToolMaterial.MILK, 84).setItemName("hoeMilk");

	    WhiteChocolateSword = new EasterItemSword(mod_easter.idItemWhiteChocolateSword, EasterToolMaterial.WHITE, 21).setItemName("swordWhite");
	    WhiteChocolatePickaxe = new EasterItemPickaxe(mod_easter.idItemWhiteChocolatePickaxe, EasterToolMaterial.WHITE, 53).setItemName("pickWhite");
	    WhiteChocolateSpade = new EasterItemSpade(mod_easter.idItemWhiteChocolateSpade, EasterToolMaterial.WHITE, 37).setItemName("spadeWhite");
	    WhiteChocolateAxe = new EasterItemAxe(mod_easter.idItemWhiteChocolateAxe, EasterToolMaterial.WHITE, 69).setItemName("axeWhite");
	    WhiteChocolateHoe = new EasterItemHoe(mod_easter.idItemWhiteChocolateHoe, EasterToolMaterial.WHITE, 85).setItemName("hoeWhite");

	    DarkChocolateSword = new EasterItemSword(mod_easter.idItemDarkChocolateSword, EasterToolMaterial.DARK, 19).setItemName("swordDark");
	    DarkChocolatePickaxe = new EasterItemPickaxe(mod_easter.idItemDarkChocolatePickaxe, EasterToolMaterial.DARK, 51).setItemName("pickDark");
	    DarkChocolateSpade = new EasterItemSpade(mod_easter.idItemDarkChocolateSpade, EasterToolMaterial.DARK, 35).setItemName("spadeDark");
	    DarkChocolateAxe = new EasterItemAxe(mod_easter.idItemDarkChocolateAxe, EasterToolMaterial.DARK, 67).setItemName("axeDark");
	    DarkChocolateHoe = new EasterItemHoe(mod_easter.idItemDarkChocolateHoe, EasterToolMaterial.DARK, 83).setItemName("hoeDark");
	    
	    //armours
	    

	    MilkChocolateHelmet = (new EasterItemArmor(mod_easter.idItemEasterMilkChocolateHelmet, EasterArmorMaterial.MILK, ModLoader.addArmor("milk"), 0)).setIconIndex(17).setItemName("MilkHelmet");
	    MilkChocolatePlate = (new EasterItemArmor(mod_easter.idItemEasterMilkChocolatePlate, EasterArmorMaterial.MILK, ModLoader.addArmor("milk"), 1)).setIconIndex(33).setItemName("MilkPlate");
	    MilkChocolateLegs = (new EasterItemArmor(mod_easter.idItemEasterMilkChocolateLegs, EasterArmorMaterial.MILK, ModLoader.addArmor("milk"), 2)).setIconIndex(49).setItemName("MilkLegs");
	    MilkChocolateBoots= (new EasterItemArmor(mod_easter.idItemEasterMilkChocolateBoots, EasterArmorMaterial.MILK, ModLoader.addArmor("milk"), 3)).setIconIndex(65).setItemName("MilkBoots");

	    DarkChocolateHelmet = (new EasterItemArmor(mod_easter.idItemEasterDarkChocolateHelmet, EasterArmorMaterial.DARK, ModLoader.addArmor("dark"), 0)).setIconIndex(16).setItemName("DarkHelmet");
	    DarkChocolatePlate = (new EasterItemArmor(mod_easter.idItemEasterDarkChocolatePlate, EasterArmorMaterial.DARK, ModLoader.addArmor("dark"), 1)).setIconIndex(32).setItemName("DarkPlate");
	    DarkChocolateLegs = (new EasterItemArmor(mod_easter.idItemEasterDarkChocolateLegs, EasterArmorMaterial.DARK, ModLoader.addArmor("dark"), 2)).setIconIndex(48).setItemName("DarkLegs");
	    DarkChocolateBoots= (new EasterItemArmor(mod_easter.idItemEasterDarkChocolateBoots, EasterArmorMaterial.DARK, ModLoader.addArmor("dark"), 3)).setIconIndex(64).setItemName("DarkBoots");

	    WhiteChocolateHelmet = (new EasterItemArmor(mod_easter.idItemEasterWhiteChocolateHelmet, EasterArmorMaterial.WHITE, ModLoader.addArmor("white"), 0)).setIconIndex(18).setItemName("WhiteHelmet");
	    WhiteChocolatePlate = (new EasterItemArmor(mod_easter.idItemEasterWhiteChocolatePlate, EasterArmorMaterial.WHITE, ModLoader.addArmor("white"), 1)).setIconIndex(34).setItemName("WhitePlate");
	    WhiteChocolateLegs = (new EasterItemArmor(mod_easter.idItemEasterWhiteChocolateLegs, EasterArmorMaterial.WHITE, ModLoader.addArmor("white"), 2)).setIconIndex(50).setItemName("WhiteLegs");
	    WhiteChocolateBoots= (new EasterItemArmor(mod_easter.idItemEasterWhiteChocolateBoots, EasterArmorMaterial.WHITE, ModLoader.addArmor("white"), 3)).setIconIndex(66).setItemName("WhiteBoots");
	    
	    
	    grave = (new ItemGrave(mod_easter.idItemGrave)).setMaxStackSize(1).setItemName("grave");
	    
	    
//	    MysterEgg= (new EasterItemMysterFlower(mod_easter.idItemMysteryEgg)).setItemName("mysteryEgg");

	    
        ModLoader.addName(ChocolateEgg, "Chocolate Egg");
        ModLoader.addName(ChocolateBar, "Milk Chocolate Bar");
        ModLoader.addName(CrossBun, "Cross Bun");
        ModLoader.addName(HotCrossBun, "Hot Cross Bun");
        ModLoader.addName(Raisins, "Raisins");
        ModLoader.addName(ChocolateDiamond, "Chocolate Diamond");
        ModLoader.addName(TombWand, "Jesus Tomb Cross");
//        ModLoader.addName(EasterMonsterSpawner, "Easter Bunny Spawner");
        ModLoader.addName(WhiteChocolateDust, "White Chocolate Dust");
        ModLoader.addName(WhiteChocolateBar, "White Chocolate Bar");
        ModLoader.addName(DarkChocolateBar, "Dark Chocolate Bar");
        

        ModLoader.addName(MilkChocolateSword, "Milk Chocolate Sword");
        ModLoader.addName(MilkChocolatePickaxe, "Milk Chocolate Pickaxe");
        ModLoader.addName(MilkChocolateSpade, "Milk Chocolate Shovel");
        ModLoader.addName(MilkChocolateAxe, "Milk Chocolate Axe");
        ModLoader.addName(MilkChocolateHoe, "Milk Chocolate Hoe");

        ModLoader.addName(WhiteChocolateSword, "White Chocolate Sword");
        ModLoader.addName(WhiteChocolatePickaxe, "White Chocolate Pickaxe");
        ModLoader.addName(WhiteChocolateSpade, "White Chocolate Shovel");
        ModLoader.addName(WhiteChocolateAxe, "White Chocolate Axe");
        ModLoader.addName(WhiteChocolateHoe, "White Chocolate Hoe");

        ModLoader.addName(DarkChocolateSword, "Dark Chocolate Sword");
        ModLoader.addName(DarkChocolatePickaxe, "Dark Chocolate Pickaxe");
        ModLoader.addName(DarkChocolateSpade, "Dark Chocolate Shovel");
        ModLoader.addName(DarkChocolateAxe, "Dark Chocolate Axe");
        ModLoader.addName(DarkChocolateHoe, "Dark Chocolate Hoe");
        
        //armors

        ModLoader.addName(MilkChocolateHelmet, "Milk Chocolate Helmet");
        ModLoader.addName(MilkChocolatePlate, "Milk Chocolate Chestplate");
        ModLoader.addName(MilkChocolateLegs, "Milk Chocolate Legs");
        ModLoader.addName(MilkChocolateBoots, "Milk Chocolate Boots");
        
        ModLoader.addName(DarkChocolateHelmet, "Dark Chocolate Helmet");
        ModLoader.addName(DarkChocolatePlate, "Dark Chocolate Chestplate");
        ModLoader.addName(DarkChocolateLegs, "Dark Chocolate Legs");
        ModLoader.addName(DarkChocolateBoots, "Dark Chocolate Boots");

        ModLoader.addName(WhiteChocolateHelmet, "White Chocolate Helmet");
        ModLoader.addName(WhiteChocolatePlate, "White Chocolate Chestplate");
        ModLoader.addName(WhiteChocolateLegs, "White Chocolate Legs");
        ModLoader.addName(WhiteChocolateBoots, "White Chocolate Boots");
        
        ModLoader.addName(grave, "Grave");
    }
}
