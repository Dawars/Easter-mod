package net.minecraft.src;

import net.minecraft.src.forge.ITextureProvider;

public class EasterItemSpade extends EasterItemTool implements ITextureProvider
{
    /** an array of the blocks this spade is effective against */
    private static Block[] blocksEffectiveAgainst = new Block[] {Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium};

    public EasterItemSpade(int par1, EasterToolMaterial par2EnumToolMaterial, int i)
    {
        super(par1, i, par2EnumToolMaterial, blocksEffectiveAgainst);
        this.setIconIndex(i);
    }

	@Override
	public String getTextureFile() {
		return "/easter/EasterItems.png";
	}
    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Block.snow ? true : par1Block == Block.blockSnow;
    }
}
