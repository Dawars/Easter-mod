package net.minecraft.src;

import java.util.Random;

public class BiomeEasterDecorator extends BiomeDecorator {
//	protected WorldGenerator spikeGen;

	protected WorldEasterGenFlower flowerGen;

	public BiomeEasterDecorator(BiomeGenBase par1BiomeGenBase)
    {
        super(par1BiomeGenBase);
//        this.spikeGen = new WorldGenEasterSpikes(Block.grass.blockID);
//        this.flowerGen = new WorldEasterGenFlower(EasterBlocks.EasterFlower.blockID);
    }

    /**
     * The method that does the work of actually decorating chunks
     */
    protected void decorate()
    {
    	
    	
    	World world = this.currentWorld;
    	for (int var6 = 0; var6 < 5; ++var6)
        {
        	
    		int i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
    		int k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
    		int j = this.currentWorld.getTopSolidOrLiquidBlock(i, k);

            if (world.isAirBlock(i, j, k) && ((BlockFlower)Block.blocksList[EasterBlocks.EasterFlower.blockID]).canBlockStay(world, i, j, k))
            {
            	BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(i, k);
            	int rand = this.randomGenerator.nextInt(5)+1;
	            	if(biome instanceof BiomeGenEaster){
            		if (rand == 1){
            			world.setBlock(i, j, k, EasterBlocks.EasterFlower.blockID);
            		} else if (rand == 2){
            			world.setBlock(i, j, k, EasterBlocks.PinkyBush.blockID);
            		} else if (rand == 3){
            			world.setBlock(i, j, k, EasterBlocks.Daisy.blockID);
            		} else if (rand == 4){
            			world.setBlock(i, j, k, EasterBlocks.Dahlia.blockID);
            		} else {
            			world.setBlock(i, j, k, EasterBlocks.EasterEggFlower.blockID);
            		}
            	}
            	
        	}
            if (this.randomGenerator.nextInt(100) < 5){
        		world.setBlock(i, j, k, getID());
        	}
    	}
    	

    	
    }

    private int getID(){
    		Random rand = new Random();
    		switch(rand.nextInt(9)+1){
   
	    		case 1:
	    			return EasterBlocks.MysteryEgg1.blockID;
	    		case 2:
	    			return EasterBlocks.MysteryEgg2.blockID;
	    		case 3:
	    			return EasterBlocks.MysteryEgg3.blockID;
	    		case 4:
	    			return EasterBlocks.MysteryEgg4.blockID;
	    		case 5:
	    			return EasterBlocks.MysteryEgg5.blockID;
	    		case 6:
	    			return EasterBlocks.MysteryEgg6.blockID;
	    		case 7:
	    			return EasterBlocks.MysteryEgg7.blockID;
	    		case 8:
	    			return EasterBlocks.MysteryEgg8.blockID;
	    		case 9:
	    			return EasterBlocks.MysteryEgg9.blockID;
	    			
    		}
			return EasterBlocks.MysteryEgg9.blockID;
    		
    		
    	}
}
