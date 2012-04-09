package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.forge.MinecraftForge;

public class WorldGenTomb extends WorldGenerator
{
	int FLOOR = Block.sandStone.blockID;
	int DOOR = Block.stone.blockID;
	
    public boolean generate(World world, Random rand, int i, int j, int k)
    {
    	//9*4*9
    	
    	for(int x = i-4; x <= i +4; x++){
        	for(int y = j+1; y <= j+4; y++){
            	for(int z = k -4; z <= k +4; z++){
            		world.setBlockWithNotify(x, y, z, 0);
            	}		
        	}
    	}
    	
    	for(int x = i-2; x <= i +2; x++){
        	for(int z = k-2; z <= k+2; z++){
        		world.setBlockWithNotify(x, j, z, FLOOR);
        	}
    	}
    	

    	world.setBlockWithNotify(i-3, j, k, FLOOR);
    	world.setBlockWithNotify(i-3, j, k+1, FLOOR);
    	world.setBlockWithNotify(i-3, j, k-1, FLOOR);
    	
    	world.setBlockWithNotify(i+3, j, k, FLOOR);
    	world.setBlockWithNotify(i+3, j, k+1, FLOOR);
    	world.setBlockWithNotify(i+3, j, k-1, FLOOR);

    	world.setBlockWithNotify(i-1, j, k -3, FLOOR);
    	world.setBlockWithNotify(i, j, k -3, FLOOR);
    	world.setBlockWithNotify(i+1, j, k -3, FLOOR);
    	
    	world.setBlockWithNotify(i-1, j, k+3, FLOOR);
    	world.setBlockWithNotify(i, j, k+3, FLOOR);
    	world.setBlockWithNotify(i+1, j, k+3, FLOOR);
    	
    	for(int y = 1; y <= 2 ; y++){
    		world.setBlockWithNotify(i-4, j+y, k, getWall());
        	world.setBlockWithNotify(i-4, j+y, k+1, getWall());
        	world.setBlockWithNotify(i-4, j+y, k-1, getWall());

        	world.setBlockWithNotify(i+4, j+y, k, getWall());
        	world.setBlockWithNotify(i+4, j+y, k+1, getWall());
        	world.setBlockWithNotify(i+4, j+y, k-1, getWall());

        	world.setBlockWithNotify(i, j+y, k+4, getWall());
        	world.setBlockWithNotify(i+1, j+y, k+4, getWall());
        	world.setBlockWithNotify(i-1, j+y, k+4, getWall());

        	world.setBlockWithNotify(i, j+y, k-4, DOOR);
        	world.setBlockWithNotify(i+1, j+y, k-4, DOOR);
        	world.setBlockWithNotify(i+2, j+y, k-4, DOOR);
        	


        	world.setBlockWithNotify(i-2, j+y, k+3, getWall());
        	world.setBlockWithNotify(i+2, j+y, k+3, getWall());
        	
        	world.setBlockWithNotify(i-3, j+y, k+2, getWall());
        	world.setBlockWithNotify(i+3, j+y, k+2, getWall());

        	world.setBlockWithNotify(i-2, j+y, k-3, getWall());
        	world.setBlockWithNotify(i+2, j+y, k-3, getWall());
        	
        	world.setBlockWithNotify(i-3, j+y, k-2, getWall());
        	world.setBlockWithNotify(i+3, j+y, k-2, getWall());
        	//3th level
        	
        
    	}
    	world.setBlockWithNotify(i-3, j+3, k, getWall());
    	world.setBlockWithNotify(i-3, j+3, k+1, getWall());
    	world.setBlockWithNotify(i-3, j+3, k-1, getWall());
    	
    	world.setBlockWithNotify(i+3, j+3, k, getWall());
    	world.setBlockWithNotify(i+3, j+3, k+1, getWall());
    	world.setBlockWithNotify(i+3, j+3, k-1, getWall());

    	world.setBlockWithNotify(i, j+3, k+3, getWall());
    	world.setBlockWithNotify(i+1, j+3, k+3, getWall());
    	world.setBlockWithNotify(i-1, j+3, k+3, getWall());

    	world.setBlockWithNotify(i, j+3, k-3, getWall());
    	world.setBlockWithNotify(i+1, j+3, k-3, getWall());
    	world.setBlockWithNotify(i-1, j+3, k-3, getWall());
    	
    	
    	//corner
	
    	world.setBlockWithNotify(i-2, j+3, k+2, getWall());
    	world.setBlockWithNotify(i+2, j+3, k+2, getWall());
    	world.setBlockWithNotify(i-2, j+3, k-2, getWall());
    	world.setBlockWithNotify(i+2, j+3, k-2, getWall());
    	//celing
    	
    	for(int x = i-2; x <= i +2; x++){
        	for(int z = k-2; z <= k+2; z++){
        		world.setBlockWithNotify(x, j+4, z, getWall());
        	}
    	}
    	
    	world.setBlockWithNotify(i+2, j+4, k-2, 0);
    	world.setBlockWithNotify(i+2, j+4, k+2, 0);
    	world.setBlockWithNotify(i-2, j+4, k+2, 0);
    	world.setBlockWithNotify(i-2, j+4, k-2, 0);
    	
    	
    	world.setBlockWithNotify(i-3, j+2, k, Block.torchWood.blockID);
    	world.setBlockWithNotify(i+3, j+2, k, Block.torchWood.blockID);
    	world.setBlockWithNotify(i, j+2, k+3, Block.torchWood.blockID);
    	
    	//chests
    	
    	world.setBlockWithNotify(i, j+1, k+3, Block.chest.blockID);
        
        TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(i, j+1, k+3);
	    if(tileentitychest != null && tileentitychest.getSizeInventory() > 0)
	    {
	          
	    	for(int i1 = 0; i1 <= rand.nextInt(3)+5; i1++){
	        	  tileentitychest.setInventorySlotContents(rand.nextInt(18), getRandomLoot(rand));
	        
	          }
	    }
	    
    	world.setBlockWithNotify(i-3, j+1, k, Block.chest.blockID);
        
        TileEntityChest tileentitychest2 = (TileEntityChest)world.getBlockTileEntity(i-3, j+1, k);
	    if(tileentitychest2 != null && tileentitychest2.getSizeInventory() > 0)
	    {
	          for(int i1 = 0; i1 <= rand.nextInt(3)+4; i1++){
	        	  tileentitychest2.setInventorySlotContents(rand.nextInt(18), getRandomLoot(rand));
	        
	          }
	     }

		return true;
	}
	public ItemStack getRandomLoot(Random random){
		ItemStack itemstack = null;
		
		int rand = random.nextInt(100);
		
		
		if (rand < 3){
			itemstack = new ItemStack(EasterItems.ChocolateDiamond, random.nextInt(5)+2);
		}else if (rand < 15){
			itemstack = new ItemStack(EasterItems.ChocolateBar, random.nextInt(6)+10);
        }else if (rand < 25){
			itemstack = new ItemStack(EasterItems.ChocolateEgg, random.nextInt(3)+4);
        }else if (rand < 40){
			if(random.nextInt(5)+1<4){
				itemstack = new ItemStack(EasterItems.CrossBun, random.nextInt(2)+2);
			} else {
				itemstack = new ItemStack(EasterItems.HotCrossBun, random.nextInt(3)+2);
			}
        	
        }else if (rand < 60){
			itemstack = new ItemStack(EasterItems.Raisins, random.nextInt(4)+2);
        } else {
        	if(random.nextInt(6)+1<3)
        		itemstack = new ItemStack(EasterBlocks.CocoaSapling, random.nextInt(2)+1);
        }
		
		return itemstack;
	}
	public int getWall(){
		Random rand = new Random();
		return rand.nextInt(5) != 1 ? Block.cobblestone.blockID : Block.cobblestoneMossy.blockID;
	}
}
