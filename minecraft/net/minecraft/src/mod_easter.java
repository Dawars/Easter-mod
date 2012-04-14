package net.minecraft.src;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.src.forge.Configuration;
import net.minecraft.src.forge.MinecraftForgeClient;

public class mod_easter extends BaseMod{	
	public static final Configuration configuration = new Configuration(new File(Minecraft.getMinecraftDir() + "./config/Easter.cfg"));
	
	protected static int cI(String var0, int var1)
    {
        return (new ConfigManager(configuration, var0)).itemProperty(var1);
    }

    protected static int cB(String var0, int var1)
    {
        return (new ConfigManager(configuration, var0)).blockProperty(var1);
    }
	private boolean addBlocks;
	
	public static final BiomeGenBase Easter = (new BiomeGenEaster(24)).setColor(0xf13a01).setBiomeName("Easter Land");
	
//	public static int idBlockChocolateLiquidStill = 166;
//	public static int idBlockChocolateLiquidActive = 167;
	public static int idBlockEasterIncubatorActive = 168;
	public static int idBlockEasterIncubatorIdle = 169;
	public static int idBlockEasterCocoaBeansBushLog = 170;
	public static int idBlockEasterCocoaBeansSapling = 171;
	public static int idBlockEasterCocoaBeansLeaves = 172;
	public static int idBlockEasterFlower = 173;
	public static int idBlockEasterEggFlower = 174;
	public static int idBlockChocolateOre = 175;
	public static int idBlockRaisinsCrop = 176;
	public static int idBlockWhiteChocolateBlock = 177;
	public static int idBlockDarkChocolateBlock = 178;
	public static int idBlockMilkChocolateBlock = 179;
	public static int idBlockEasterCocoaBeansLeaves2 = 180;
	public static int idBlockMysteryEgg1 = 181;
	public static int idBlockMysteryEgg2 = 182;
	public static int idBlockMysteryEgg3 = 183;
	public static int idBlockMysteryEgg4 = 184;
	public static int idBlockMysteryEgg5 = 185;
	public static int idBlockMysteryEgg6 = 186;
	public static int idBlockMysteryEgg7 = 187;
	public static int idBlockMysteryEgg8 = 188;
	public static int idBlockMysteryEgg9 = 189;
	public static int idBlockGrave = 190;

	public static int idBlockPinkyBush = 191;
	public static int idBlockDaisy = 192;
	public static int idBlockDahlia = 193;
	
	
	
	
	public static int idItemChocolateEgg = 4000;
	public static int idItemChocolateBar = 4001;
	public static int idBlockTombWand = 4002;
	public static int idItemCrossBun = 4003;
	public static int idItemHotCrossBun = 4004;
	public static int idItemRaisins = 4005;
	public static int idItemChocolateDiamonds = 4006;
	public static int idItemEasterMonsterSpawner = 4007;
	public static int idItemEasterWhiteChocolateDust = 4008;
	public static int idItemEasterWhiteChocolateBar = 4009;
	public static int idItemEasterDarkChocolateBar = 4010;

	public static int idItemEasterMilkChocolateHelmet = 4011;
	public static int idItemEasterMilkChocolatePlate = 4012;
	public static int idItemEasterMilkChocolateLegs = 4013;
	public static int idItemEasterMilkChocolateBoots = 4014;
	
	public static int idItemEasterDarkChocolateHelmet = 4015;
	public static int idItemEasterDarkChocolatePlate = 4016;
	public static int idItemEasterDarkChocolateLegs = 4017;
	public static int idItemEasterDarkChocolateBoots = 4018;
	

	public static int idItemEasterWhiteChocolateHelmet = 4019;
	public static int idItemEasterWhiteChocolatePlate = 4020;
	public static int idItemEasterWhiteChocolateLegs = 4021;
	public static int idItemEasterWhiteChocolateBoots = 4022;

	public static int idItemMilkChocolateSword = 4023;
	public static int idItemMilkChocolatePickaxe = 4024;
	public static int idItemMilkChocolateSpade = 4025;
	public static int idItemMilkChocolateAxe = 4026;
	public static int idItemMilkChocolateHoe = 4027;

	public static int idItemDarkChocolateSword = 4028;
	public static int idItemDarkChocolatePickaxe = 4029;
	public static int idItemDarkChocolateSpade = 4030;
	public static int idItemDarkChocolateAxe = 4031;
	public static int idItemDarkChocolateHoe = 4032;

	public static int idItemWhiteChocolateSword = 4033;
	public static int idItemWhiteChocolatePickaxe = 4034;
	public static int idItemWhiteChocolateSpade = 4035;
	public static int idItemWhiteChocolateAxe = 4036;
	public static int idItemWhiteChocolateHoe = 4037;

	public static int idItemDarkChocolateEgg = 4038;
	public static int idItemWhiteChocolateEgg = 4039;
	public static int idItemGrave = 4040;
	
	
	static Achievement openInventory = AchievementList.openInventory;
	static final Achievement Egg = new Achievement (2000, "EggOpener", -2, 0, Item.egg, openInventory).setSpecial().registerAchievement();

	public mod_easter(){
		
		ModLoader.addAchievementDesc(Egg, "Mystery Egg", "Search a painted egg on the ground");

		ModLoader.addBiome(Easter);
		
		
		ModLoader.setInGameHook(this, true, true);
		ModLoader.setInGUIHook(this, true, true);
		
		ModLoader.registerTileEntity(net.minecraft.src.TileEntityIncubator.class, "Egg Opener");
		
//		ModLoader.registerEntityID(EntityEasterBunny.class, "Easter Bunny", ModLoader.getUniqueEntityId());
//		ModLoader.addSpawn(EntityEasterBunny.class, 12, 4, 4, EnumCreatureType.creature);

	}

	
	public void addRenderer(Map map){
		map.put(EntityEasterBunny.class, new RenderEasterBunny(new ModelEasterBunny(), 0.5F));
	}
	
    public void onItemPickup(EntityPlayer player, ItemStack itemstack) {
    	if(itemstack.itemID == EasterBlocks.MysteryEgg1.blockID ||
    			itemstack.itemID == EasterBlocks.MysteryEgg2.blockID ||
    			itemstack.itemID == EasterBlocks.MysteryEgg3.blockID ||
    			itemstack.itemID == EasterBlocks.MysteryEgg4.blockID ||
    			itemstack.itemID == EasterBlocks.MysteryEgg5.blockID ||
    			itemstack.itemID == EasterBlocks.MysteryEgg6.blockID ||
    			itemstack.itemID == EasterBlocks.MysteryEgg7.blockID ||
    			itemstack.itemID == EasterBlocks.MysteryEgg8.blockID
    			){
    		player.addStat(Egg, 1);
    	}
    	
    }

	
	@Override
	public String getVersion() {
		return "1.3";
	}

	@Override
	public void load() {
		MinecraftForgeClient.preloadTexture("/easter/EasterBlocks.png");
		MinecraftForgeClient.preloadTexture("/easter/EasterItems.png");
		
		new EasterBlocks();
		new EasterItems();
		new EasterRecipes();
	}

	public boolean onTickInGame(float f, Minecraft minecraft){
		if(minecraft.currentScreen == null){
			addBlocks = false;
		}
		return true;
	}
	
	public boolean onTickInGUI(float f, Minecraft minecraft, GuiScreen screen){
		if (screen instanceof GuiContainerCreative){
			if(addBlocks == false){
				Container container = ((GuiContainer)screen).inventorySlots;
				List list = ((ContainerCreative)container).itemList;
				
				list.add(new ItemStack(EasterBlocks.EasterIncubatorIdle));
				list.add(new ItemStack(EasterBlocks.CocoaLog));
				list.add(new ItemStack(EasterBlocks.CocoaSapling));
				list.add(new ItemStack(EasterBlocks.CocoaLeaves));
				list.add(new ItemStack(EasterBlocks.CocoaLeavesEmpty));
				list.add(new ItemStack(EasterBlocks.EasterFlower));
//				list.add(new ItemStack(EasterBlocks.ChocolateLiquidActive));
				list.add(new ItemStack(EasterBlocks.EasterEggFlower));
				list.add(new ItemStack(EasterBlocks.ChocolateOre));
				list.add(new ItemStack(EasterBlocks.DarkBlock));
				list.add(new ItemStack(EasterBlocks.MilkBlock));
				list.add(new ItemStack(EasterBlocks.WhiteBlock));
				list.add(new ItemStack(EasterBlocks.MysteryEgg1));
				list.add(new ItemStack(EasterBlocks.MysteryEgg2));
				list.add(new ItemStack(EasterBlocks.MysteryEgg3));
				list.add(new ItemStack(EasterBlocks.MysteryEgg4));
				list.add(new ItemStack(EasterBlocks.MysteryEgg5));
				list.add(new ItemStack(EasterBlocks.MysteryEgg6));
				list.add(new ItemStack(EasterBlocks.MysteryEgg7));
				list.add(new ItemStack(EasterBlocks.MysteryEgg8));
				list.add(new ItemStack(EasterBlocks.Dahlia));
				list.add(new ItemStack(EasterBlocks.Daisy));
				list.add(new ItemStack(EasterBlocks.PinkyBush));
			}
			addBlocks = true;
		}
		return true;
	}
	
	public void generateSurface(World world, Random rand, int x, int z){

		int i = x + rand.nextInt(16) + 8;
		int k = z + rand.nextInt(16) + 8;
		int j = world.getTopSolidOrLiquidBlock(i, k);

		WorldGenTomb tomb = new WorldGenTomb();
		WorldGenTomb2 tomb2 = new WorldGenTomb2();
		
        if (world.isAirBlock(i, j, k))
        {
        	if (!world.isAirBlock(i, j-1, k)){
	        	BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(i, k);
	        	if(biome instanceof BiomeGenEaster){
	        		if (rand.nextInt(100) == 1)
	        			if(rand.nextInt(2) == 1){
	        				tomb2.generate(world, rand, i, j-1, k);
	        			} else {
	        				tomb.generate(world, rand, i, j-1, k);
	        			}
	        	}
        	}
        }
	            
		for (int var6 = 0; var6 < 20; ++var6)
        {
			
			WorldGenBush bush = new WorldGenBush();
			
	        if (world.isAirBlock(i, j, k))
	        {
	        	BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(i, k);
	        	if(biome instanceof BiomeGenEaster){
	        		if (world.getBlockId(i, j-1, k) == Block.grass.blockID ||
        				world.getBlockId(i, j-1, k) == Block.dirt.blockID){
	        			bush.generate(world, rand, i, j, k);
	        		}
	        	}
	        }
        }
		
		for(int e = 0; e < 20; e++)
        {
			BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(i, k);
        	if(biome instanceof BiomeGenEaster){
	            int randPosX = x + rand.nextInt(16);
	            int randPosY = rand.nextInt(50);
	            int randPosZ = z + rand.nextInt(16);
	            (new WorldGenMinable(EasterBlocks.ChocolateOre.blockID, 25)).generate(world, rand, randPosX, randPosY, randPosZ);
        	}
        }
//		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(i, k);
//    	if(biome instanceof BiomeGenEaster){
//    		if (rand.nextInt(100) <20){
//		    	int var4 = x * 16;
//		    	int var5 = z * 16;
//		    	int var13;
//				int var14;
//		    	
//		    	for (int var12 = 0; var12 < 8; ++var12)
//		        {
//		    		var13 = var4 + rand.nextInt(16) + 8;
//		            var14 = rand.nextInt(128);
//		            int var15 = var5 + rand.nextInt(16) + 8;
//		
//		            new WorldGenEasterDungeons().generate(world, rand, var13, var14, var15);
//		        }
//    		}
//    	}
	}
}

