package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.forge.ITextureProvider;

public class EasterBlockFlower extends BlockFlower implements ITextureProvider
{
	protected EasterBlockFlower(int i, int j) {
		super(i, j);
	}

	public boolean canPlaceBlockAt(World world, int i, int j, int k)
	{
		return super.canPlaceBlockAt(world, i, j, k) && this.canThisPlantGrowOnThisBlockID(world.getBlockId(i, j - 1, k));
	}
	 
	public int idDropped(int par1, Random rand, int par3)
	{
		if (this.blockID == mod_easter.idBlockEasterEggFlower){
			if (rand.nextInt(2) == 1){
				return EasterItems.ChocolateEgg.shiftedIndex;
			} else {
				return this.blockID;
			}
				
		}
		return this.blockID;
	}
 
	 protected boolean canThisPlantGrowOnThisBlockID(int par1)
    {
        return par1 == Block.grass.blockID || par1 == Block.dirt.blockID || par1 == Block.tilledField.blockID;
    }
	
	@Override
	public String getTextureFile() {
		return "/easter/EasterBlocks.png";
	}

}
