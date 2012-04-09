package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.forge.MinecraftForge;

public class WorldGenEasterDungeons extends WorldGenerator
{
    public boolean generate(World world, Random rand, int i, int j, int k)
    {
		return false;
    	
//    	for (int asdsad = rand.nextInt(128); asdsad <= 120; asdsad++){
//    		world.setBlockWithNotify(i, asdsad, k, EasterBlocks.MilkBlock.blockID);
//    	}
//    	
//    	world.setBlockWithNotify(i, j, k, EasterBlocks.WhiteBlock.blockID);
//                        
//         
//           
//        world.setBlockWithNotify(i, j, k, Block.chest.blockID);
//        TileEntityChest var16 = (TileEntityChest)world.getBlockTileEntity(i, j, k);
//
//        if (var16 != null)
//        {
//            for (int var17 = 0; var17 < MinecraftForge.getDungeonLootTries(); ++var17)
//            {
//                ItemStack var18 = MinecraftForge.getRandomDungeonLoot(rand);
//
//                if (var18 != null)
//                {
//                    var16.setInventorySlotContents(rand.nextInt(var16.getSizeInventory()), var18);
//                }
//            }
//        }
//
//                                   
//                            
//            
//            TileEntityMobSpawner var19 = (TileEntityMobSpawner)world.getBlockTileEntity(i, j, k);
//
//            if (var19 != null)
//            {
//                var19.setMobID("Chicken");
//            }
//            else
//            {
//                System.err.println("Failed to fetch mob spawner entity at (" + par3 + ", " + par4 + ", " + par5 + ")");
//            }
//        	
//            
//            
//            par1World.setBlockWithNotify(par3, par4, par5, Block.mobSpawner.blockID);
//            
//            
//            return true;
//        }
//        else
//        {
//            return false;
//        }
    }

    /**
     * Picks potentially a random item to add to a dungeon chest.
     */
    private ItemStack pickCheckLootItem(Random par1Random)
    {
        int var2 = par1Random.nextInt(11);
        return var2 == 0 ? new ItemStack(EasterItems.grave) : (var2 == 1 ? new ItemStack(EasterItems.WhiteChocolateDust, par1Random.nextInt(4) + 1) : (var2 == 2 ? new ItemStack(EasterItems.HotCrossBun) : (var2 == 3 ? new ItemStack(EasterItems.Raisins, par1Random.nextInt(4) + 1) : (var2 == 4 ? new ItemStack(EasterItems.ChocolateDiamond, par1Random.nextInt(4) + 1) : (var2 == 5 ? new ItemStack(EasterItems.ChocolateBar, par1Random.nextInt(4) + 1) : (var2 == 6 ? new ItemStack(Item.bucketEmpty) : (var2 == 7 && par1Random.nextInt(100) == 0 ? new ItemStack(EasterItems.ChocolateEgg) : (var2 == 8 && par1Random.nextInt(2) == 0 ? new ItemStack(EasterBlocks.EasterIncubatorIdle) : (var2 == 9 && par1Random.nextInt(10) == 0 ? new ItemStack(Item.itemsList[Item.record13.shiftedIndex + par1Random.nextInt(2)]) : (var2 == 10 ? new ItemStack(Item.dyePowder, par1Random.nextInt(3)+3, 3) : null))))))))));
    }

    /**
     * Randomly decides which spawner to use in a dungeon
     */
    private String pickMobSpawner(Random par1Random)
    {
        int var2 = par1Random.nextInt(4);
        return var2 == 0 ? "Skeleton" : (var2 == 1 ? "Zombie" : (var2 == 2 ? "Zombie" : (var2 == 3 ? "Spider" : "")));
    }
}
