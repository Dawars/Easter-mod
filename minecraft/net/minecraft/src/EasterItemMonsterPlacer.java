package net.minecraft.src;

import net.minecraft.src.forge.ITextureProvider;

public class EasterItemMonsterPlacer extends Item implements ITextureProvider
{
    public EasterItemMonsterPlacer(int par1)
    {
        super(par1);
        this.setHasSubtypes(true);
        this.setIconIndex(7);
    }

    public boolean func_46058_c()
    {
        return true;
    }

    public int func_46057_a(int par1, int par2)
    {
        return par2 > 0 ? super.func_46057_a(par1, par2) + 16 : super.func_46057_a(par1, par2);
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS !
     */
    public boolean onItemUse(ItemStack ItemStack, EntityPlayer player, World world, int i, int j, int k, int par7)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            int var8 = world.getBlockId(i, j, k);
            i += Facing.offsetsXForSide[par7];
            j += Facing.offsetsYForSide[par7];
            k += Facing.offsetsZForSide[par7];
            double var9 = 0.0D;

            if (par7 == 1 && var8 == Block.fence.blockID || var8 == Block.netherFence.blockID)
            {
                var9 = 0.5D;
            }

            if (func_48440_a(world, ItemStack.getItemDamage(), (double)i + 0.5D, (double)j + var9, (double)k + 0.5D) && !player.capabilities.isCreativeMode)
            {
                --ItemStack.stackSize;
            }

            return true;
        }
    }

    public static boolean func_48440_a(World world, int id, double i, double j, double k)
    {
        
        
            Entity monster = EntityList.createEntityByID(96, world);//2 = XP orb

            if (monster != null)
            {
            	monster.setLocationAndAngles(i, j, k, world.rand.nextFloat() * 360.0F, 0.0F);
                world.spawnEntityInWorld(monster);
//                ((EntityLiving)monster).playLivingSound();
            }

            return monster != null;
        
    }
    @Override
	public String getTextureFile() {
		return "/easter/EasterItems.png";
	}
}
