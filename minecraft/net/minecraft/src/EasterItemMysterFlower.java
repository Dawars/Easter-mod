package net.minecraft.src;

import net.minecraft.src.forge.ITextureProvider;

public class EasterItemMysterFlower extends Item implements ITextureProvider
{

	public EasterItemMysterFlower(int i) {
		super(i);
		this.setMaxDamage(9);
		this.setIconIndex(23);
	}
	@Override
	public String getTextureFile() {
		return "/easter/EasterBlocks.png";
	}
	
	public int getIconIndex(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
		
		return 23+stack.getItemDamage();
    }

}
