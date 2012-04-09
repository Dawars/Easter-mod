package net.minecraft.src;

import net.minecraft.src.forge.ITextureProvider;

public class ItemGrave extends Item implements ITextureProvider
{
    public ItemGrave(int par1)
    {
        super(par1);
        this.setIconIndex(15);
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS !
     */
    public boolean onItemUse(ItemStack itemtack, EntityPlayer par2EntityPlayer, World world, int i, int j, int k, int l)
    {
        if (l != 1)
        {
            return false;
        }
        else
        {
            ++j;
            BlockGrave var8 = (BlockGrave)EasterBlocks.grave;
            int var9 = MathHelper.floor_double((double)(par2EntityPlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
            byte var10 = 0;
            byte var11 = 0;

            if (var9 == 0)
            {
                var11 = 1;
            }

            if (var9 == 1)
            {
                var10 = -1;
            }

            if (var9 == 2)
            {
                var11 = -1;
            }

            if (var9 == 3)
            {
                var10 = 1;
            }

            if (par2EntityPlayer.canPlayerEdit(i, j, k) && par2EntityPlayer.canPlayerEdit(i + var10, j, k + var11))
            {
                if (world.isAirBlock(i, j, k) && world.isAirBlock(i + var10, j, k + var11) && world.isBlockNormalCube(i, j - 1, k) && world.isBlockNormalCube(i + var10, j - 1, k + var11))
                {
                    world.setBlockAndMetadataWithNotify(i, j, k, var8.blockID, var9);

                    if (world.getBlockId(i, j, k) == var8.blockID)
                    {
                        world.setBlockAndMetadataWithNotify(i + var10, j, k + var11, var8.blockID, var9 + 8);
                    }

                    --itemtack.stackSize;
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
    }
    @Override
	public String getTextureFile() {
		return "/easter/EasterItems.png";
	}
}
