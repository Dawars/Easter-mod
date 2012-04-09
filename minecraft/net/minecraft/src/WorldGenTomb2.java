package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.forge.MinecraftForge;

public class WorldGenTomb2 extends WorldGenerator
{
	int FLOOR = Block.gravel.blockID;
	int DOOR = Block.stone.blockID;
	
    public boolean generate(World world, Random rand, int i, int j, int k)
    {
    	//9*4*9
    	
    	for(int x = i-3; x <= i +3; x++){
        	for(int y = j+1; y <= j+4; y++){
            	for(int z = k -4; z <= k +4; z++){
            		world.setBlockWithNotify(x, y, z, 0);
            	}		
        	}
    	}
    	
    	for(int x = i-3; x <= i +3; x++){
        	for(int z = k-4; z <= k+4; z++){
    			world.setBlockWithNotify(x, j, z, FLOOR);
    			world.setBlockWithNotify(x, j-1, z, Block.dirt.blockID);
    		}
    	}
	        
    	
    	

    	
    	for(int y = 1; y <= 3 ; y++){
    		for(int a = 0; a <= 3 ; a++){
    			world.setBlockAndMetadataWithNotify(i-3, j+y, k+a, getWall(), getWallMetadata());
        		world.setBlockAndMetadataWithNotify(i-3, j+y, k-a, getWall(), getWallMetadata());
        		
        		world.setBlockAndMetadataWithNotify(i+3, j+y, k+a, getWall(), getWallMetadata());
        		world.setBlockAndMetadataWithNotify(i+3, j+y, k-a, getWall(), getWallMetadata());
        	
    		}
    	}
    	for(int y = 1; y <= 3 ; y++){
    		for(int a = 0; a <= 3 ; a++){
    			world.setBlockAndMetadataWithNotify(i-a, j+y, k+4, getWall(), getWallMetadata());
        		world.setBlockAndMetadataWithNotify(i+a, j+y, k+4, getWall(), getWallMetadata());
        		
        		world.setBlockAndMetadataWithNotify(i+a, j+y, k-4, getWall(), getWallMetadata());
        		world.setBlockAndMetadataWithNotify(i-a, j+y, k-4, getWall(), getWallMetadata());
        	
    		}
    	}

    	world.setBlockWithNotify(i-1, j+1, k-4, 0);
    	world.setBlockWithNotify(i-1, j+2, k-4, 0);
    	world.setBlockWithNotify(i-1, j+3, k-4, 0);
    	
    	world.setBlockWithNotify(i+1, j+1, k-5, Block.stone.blockID);
    	world.setBlockWithNotify(i+1, j+2, k-5, Block.stone.blockID);
    	world.setBlockWithNotify(i+1, j+3, k-5, Block.stone.blockID);

    	world.setBlockWithNotify(i, j+1, k-5, Block.stone.blockID);
    	world.setBlockWithNotify(i, j+2, k-5, Block.stone.blockID);
    	world.setBlockWithNotify(i, j+3, k-5, Block.stone.blockID);

    	world.setBlockWithNotify(i+2, j+1, k-5, Block.stone.blockID);
    	world.setBlockWithNotify(i+2, j+2, k-5, Block.stone.blockID);
    	world.setBlockWithNotify(i+2, j+3, k-5, Block.stone.blockID);

    	//celing
    	
    	for(int x = i-2; x <= i +2; x++){
        	for(int z = k-4; z <= k+4; z++){
        		world.setBlockAndMetadataWithNotify(x, j+4, z, getWall(), getWallMetadata());
        	}
    	}

    	world.setBlockWithNotify(i-2, j+2, k-3, Block.torchWood.blockID);
    	world.setBlockWithNotify(i+2, j+2, k-3, Block.torchWood.blockID);

    	world.setBlockWithNotify(i-1, j+2, k+3, Block.torchWood.blockID);
    	world.setBlockWithNotify(i+1, j+2, k+3, Block.torchWood.blockID);
    	
    	
    	

    	world.setBlockWithNotify(i+2, j+1, k, Block.stairSingle.blockID);
    	world.setBlockWithNotify(i-2, j+1, k, Block.stairSingle.blockID);

    	world.setBlockWithNotify(i+2, j+1, k-2, Block.stairSingle.blockID);
    	world.setBlockWithNotify(i-2, j+1, k-2, Block.stairSingle.blockID);
    	
    	world.setBlockWithNotify(i+2, j+1, k-1, Block.stairSingle.blockID);
    	world.setBlockWithNotify(i-2, j+1, k-1, Block.stairSingle.blockID);
    	//grave
    	placeGrave(world, i, j, k+2);


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
//		return rand.nextInt(5) != 1 ? Block.stoneBrick.blockID : Block.cobblestoneMossy.blockID;
		return Block.stoneBrick.blockID;
	}
	
	public int getWallMetadata(){
		Random rand = new Random();
		int random = rand.nextInt(20)+1;
		if (random < 3){
			return 3;
		} else if (random < 7){
			return 2;
		}else if (random < 15){
			return 1;
		} else {
			return 0;
		}
	}
	
	public void placeGrave(World world, int i, int j, int k)
    {
       
		++j;
        BlockGrave var8 = (BlockGrave)EasterBlocks.grave;
        int var9 = 0;//direction
        byte var10 = 0;
        byte var11 = 0;

        if (var9 == 0)
        {
            var11 = 1;
        }

        if (var9 == 1)
        {
            var10 = -1;
        }

        if (var9 == 2)
        {
            var11 = -1;
        }

        if (var9 == 3)
        {
            var10 = 1;
        }

       
        world.setBlockAndMetadataWithNotify(i, j, k, var8.blockID, var9);

        if (world.getBlockId(i, j, k) == var8.blockID)
        {
            world.setBlockAndMetadataWithNotify(i + var10, j, k + var11, var8.blockID, var9 + 8);
        }
        
    }
}

