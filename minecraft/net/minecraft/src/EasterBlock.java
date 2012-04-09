package net.minecraft.src;

import net.minecraft.src.forge.ITextureProvider;

public class EasterBlock extends Block implements ITextureProvider
{

	protected EasterBlock(int par1, int par2, Material par3Material) {
		super(par1, par2, par3Material);
	}

	@Override
	public String getTextureFile() {
		return "/easter/EasterBlocks.png";
	}

}
