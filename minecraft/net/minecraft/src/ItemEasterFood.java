package net.minecraft.src;

import net.minecraft.src.forge.ITextureProvider;

public class ItemEasterFood extends ItemFood implements ITextureProvider
{
	public ItemEasterFood(int i, int j, boolean k, int texture){
		super(i, j, k);
		this.setIconIndex(texture);
	}

	@Override
	public String getTextureFile() {
		// TODO Auto-generated method stub
		return "/easter/EasterItems.png";
	}
}
