package net.minecraft.src;

import net.minecraft.src.forge.ITextureProvider;

public class EasterItemWhiteChocolateDust extends Item implements ITextureProvider
{

	protected EasterItemWhiteChocolateDust(int par1) {
		super(par1);
		this.setIconIndex(9);
	}

	@Override
	public String getTextureFile() {
		return "/easter/EasterItems.png";
	}

}
