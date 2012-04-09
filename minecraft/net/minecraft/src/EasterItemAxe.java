package net.minecraft.src;

import net.minecraft.src.forge.ITextureProvider;

public class EasterItemAxe extends EasterItemTool implements ITextureProvider
{
    /** an array of the blocks this axe is effective against */
    private static Block[] blocksEffectiveAgainst = new Block[] {Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stairDouble, Block.stairSingle, Block.pumpkin, Block.pumpkinLantern};

    protected EasterItemAxe(int par1, EasterToolMaterial par2EnumToolMaterial, int i)
    {
        super(par1, i, par2EnumToolMaterial, blocksEffectiveAgainst);
        this.setIconIndex(i);
    }

	@Override
	public String getTextureFile() {
		return "/easter/EasterItems.png";
	}
    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        return par2Block != null && par2Block.blockMaterial == Material.wood ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
    }
}
