package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.forge.ITextureProvider;

public class EasterBlockChocolateOre extends Block implements ITextureProvider
{
    public EasterBlockChocolateOre(int par1)
    {
        super(par1, 10, Material.rock);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return EasterItems.WhiteChocolateDust.shiftedIndex;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int i, Random rand)
    {
        int var = rand.nextInt(i + 2) + 1;

            if (var < 0)
            {
                var = 0;
            }

            return this.quantityDropped(rand) * (var + 1);
    }

    
	@Override
	public String getTextureFile() {
		return "/easter/EasterBlocks.png";
	}
}
