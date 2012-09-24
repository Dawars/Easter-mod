package easter.blocks;

import java.util.Random;

import easter.common.Easter;

import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

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
    	
        world.setBlockWithNotify(i, j, k, Easter.CocoaLog.blockID);
        world.setBlockWithNotify(i, j+1, k, Easter.CocoaLog.blockID);
        
        
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
    	return rand.nextInt(2) == 1 ? Easter.CocoaLeaves.blockID : Easter.CocoaLeavesEmpty.blockID;
    	
    }
}
