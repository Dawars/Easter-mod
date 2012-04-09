package net.minecraft.src;

import net.minecraft.src.forge.ITextureProvider;

public class ItemChocolateDiamonds extends Item implements ITextureProvider
{

	 protected ItemChocolateDiamonds(int i, int j) {
			super(i);
			this.setIconIndex(j);
		}

	@Override
	public String getTextureFile() {
		return "/easter/EasterItems.png";
	}

}
