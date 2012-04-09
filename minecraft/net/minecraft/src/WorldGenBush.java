// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, mod_Beer, Block, 
//            BlockGrass

public class WorldGenBush extends WorldGenerator
{

    public WorldGenBush()
    {
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
    	int rand = random.nextInt(3)+1;
    	//if 1
    	if (world.getBlockId(i, j +1, k)+
        		world.getBlockId(i, j +1, k+1)+
        		world.getBlockId(i, j +1, k-1)+
        		world.getBlockId(i+1, j +1, k)+
        		world.getBlockId(i-1, j +1, k)+
        		
        		world.getBlockId(i-1, j +1, k-1)+
        		world.getBlockId(i+1, j +1, k-1)+
        		world.getBlockId(i+1, j +1, k+1)+
        		world.getBlockId(i-1, j +1, k+1)
        		!= 0){
    		return false;
    	}
    	
        world.setBlockWithNotify(i, j, k, EasterBlocks.CocoaLog.blockID);
        world.setBlockWithNotify(i, j+1, k, EasterBlocks.CocoaLog.blockID);
        
        
        world.setBlockWithNotify(i, j+1, k+1, getLeavesId());
        world.setBlockWithNotify(i, j+1, k-1, getLeavesId());
        world.setBlockWithNotify(i+1, j+1, k, getLeavesId());
        world.setBlockWithNotify(i-1, j+1, k, getLeavesId());
        
        world.setBlockWithNotify(i-1, j+1, k+1, getLeavesId());
        world.setBlockWithNotify(i-1, j+1, k-1, getLeavesId());
        world.setBlockWithNotify(i+1, j+1, k-1, getLeavesId());
        world.setBlockWithNotify(i+1, j+1, k+1, getLeavesId());
        
        //if 2 or 3
        if(rand >= 2){
        	world.setBlockWithNotify(i, j+2, k, getLeavesId());
        }
        if (rand == 3){
        	world.setBlockWithNotify(i, j+2, k+1, getLeavesId());
        	world.setBlockWithNotify(i, j+2, k-1, getLeavesId());
        	world.setBlockWithNotify(i-1, j+2, k, getLeavesId());
        	world.setBlockWithNotify(i+1, j+2, k, getLeavesId());
        }
        return true;
    }
    public int getLeavesId(){
		Random rand = new Random();
    	return rand.nextInt(2) == 1 ? EasterBlocks.CocoaLeaves.blockID : EasterBlocks.CocoaLeavesEmpty.blockID;
    	
    }
}
