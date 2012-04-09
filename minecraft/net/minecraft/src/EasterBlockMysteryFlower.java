package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.forge.ITextureProvider;

public class EasterBlockMysteryFlower extends BlockFlower implements ITextureProvider
{
	private static int Damage;
	
    protected EasterBlockMysteryFlower(int i, int j)
    {
        super(i, j, Material.plants);
        this.blockIndexInTexture = j;
    }
    
    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    protected boolean canThisPlantGrowOnThisBlockID(int par1)
    {
        return par1 == Block.grass.blockID || par1 == Block.dirt.blockID || par1 == Block.tilledField.blockID || par1 == Block.sand.blockID;
    }
    
	@Override
	public String getTextureFile() {
		return "/easter/EasterBlocks.png";
	}
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	public int getRenderType()
    {
        return 1;//6
    }
    
}
