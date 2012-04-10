package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.forge.ITextureProvider;

public class BlockCocoaSapling extends BlockFlower implements ITextureProvider
{
    protected BlockCocoaSapling(int par1, int par2)
    {
        super(par1, par2);
        float var3 = 0.4F;
        this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            super.updateTick(par1World, par2, par3, par4, par5Random);

            if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9 && par5Random.nextInt(7) == 0)
            {
                int var6 = par1World.getBlockMetadata(par2, par3, par4);

                if ((var6 & 8) == 0)
                {
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, var6 | 8);
                }
                else
                {
                    this.growTree(par1World, par2, par3, par4, par5Random);
                }
            }
        }
    }
    
    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer player){
    	Random rand = new Random();
    	ItemStack itemstack = player.getCurrentEquippedItem();
    	if(itemstack != null && itemstack.itemID == Item.dyePowder.shiftedIndex && itemstack.getItemDamage() == 15){
    		this.growTree(world, i, j, k, rand);
    		if (!world.isRemote)
            {
                player.getCurrentEquippedItem().stackSize--;
            }
    	}
    	
    	
    	return true;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        par2 &= 3;
        return par2 == 1 ? 63 : (par2 == 2 ? 79 : (par2 == 3 ? 30 : super.getBlockTextureFromSideAndMetadata(par1, par2)));
    }

    /**
     * Attempts to grow a sapling into a tree
     */
    public void growTree(World world, int i, int j, int k, Random rand)
    {
        
    	WorldGenBush worldgenbush = new WorldGenBush();
    	
        if (!((WorldGenerator)worldgenbush).generate(world, rand, i, j, k))
        {
            world.setBlock(i, j, k, this.blockID);
        }
    }

    public boolean func_50076_f(World par1World, int par2, int par3, int par4, int par5)
    {
        return par1World.getBlockId(par2, par3, par4) == this.blockID && (par1World.getBlockMetadata(par2, par3, par4) & 3) == par5;
    }

    @Override
	public String getTextureFile() {
		return "/easter/EasterBlocks.png";
	}
}