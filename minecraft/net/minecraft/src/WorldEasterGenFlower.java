package net.minecraft.src;

import java.util.Random;

public class WorldEasterGenFlower {

    /** The ID of the plant block used in this plant generator. */
    private int plantBlockId;

    public WorldEasterGenFlower(int par1)
    {
        this.plantBlockId = par1;
    }

    public boolean generate(World world, Random par2Random, int i, int j, int k)
    {
        for (int var6 = 0; var6 < 64; ++var6)
        {
        	
            int var7 = i + par2Random.nextInt(8) - par2Random.nextInt(8);
            int var8 = j + par2Random.nextInt(4) - par2Random.nextInt(4);
            int var9 = k + par2Random.nextInt(8) - par2Random.nextInt(8);

            if (world.isAirBlock(var7, var8, var9) && ((BlockFlower)Block.blocksList[this.plantBlockId]).canBlockStay(world, var7, var8, var9))
            {
            	BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(i, k);
            	if(biome instanceof BiomeGenEaster){
            		world.setBlock(var7, var8, var9, this.plantBlockId);
            	}
            }
        }

        return true;
    }
}
