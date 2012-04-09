package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.forge.ITextureProvider;

public class ItemTombWand extends Item implements ITextureProvider
{
    protected ItemTombWand(int i, int j) {
		super(i);
		this.setIconIndex(j);
	}

	public boolean onItemUse(ItemStack ItemStack, EntityPlayer EntityPlayer, World world, int i, int j, int k, int x)
    {
		Random rand = new Random();
		WorldGenTomb worldgentomb = new WorldGenTomb();
		WorldGenTomb2 worldgentomb2 = new WorldGenTomb2();
		
		if (rand.nextInt(2) == 1)
			worldgentomb.generate(world, rand, i, j, k);
		else
			worldgentomb2.generate(world, rand, i, j, k);
//			new WorldGenEasterDungeons().generate(world, rand, i, j, k);
		if (!world.isRemote)
        {
            EntityPlayer.getCurrentEquippedItem().stackSize--;
        }
    	return true;
    }

	@Override
	public String getTextureFile() {
		return "/easter/EasterItems.png";
	}

}
