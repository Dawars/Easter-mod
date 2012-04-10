package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.forge.ITextureProvider;

public class EasterBlockIncubator extends BlockContainer implements ITextureProvider
{
    /**
     * Is the random generator used by incubator to drop the inventory contents in random directions.
     */
    private Random incubatorRand = new Random();

    /** True if this is an active incubator, false if idle */
    private final boolean isActive;

    /**
     * This flag is used to prevent the incubator inventory to be dropped upon block removal, is used internally when the
     * incubator block changes from idle to active and vice-versa.
     */
    private static boolean keepIncubatorInventory = false;

    protected EasterBlockIncubator(int par1, boolean par2)
    {
        super(par1, Material.rock);
        this.isActive = par2;
        this.blockIndexInTexture = 35;
    }
    @Override
	public String getTextureFile() {
		return "/easter/EasterBlocks.png";
	}
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return EasterBlocks.EasterIncubatorIdle.blockID;
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }

    /**
     * set a blocks direction
     */
    private void setDefaultDirection(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            int var5 = par1World.getBlockId(par2, par3, par4 - 1);
            int var6 = par1World.getBlockId(par2, par3, par4 + 1);
            int var7 = par1World.getBlockId(par2 - 1, par3, par4);
            int var8 = par1World.getBlockId(par2 + 1, par3, par4);
            byte var9 = 3;

            if (Block.opaqueCubeLookup[var5] && !Block.opaqueCubeLookup[var6])
            {
                var9 = 3;
            }

            if (Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var5])
            {
                var9 = 2;
            }

            if (Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var8])
            {
                var9 = 5;
            }

            if (Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var7])
            {
                var9 = 4;
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, var9);
        }
    }

    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    public int getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        if (par5 == 1)
        {
            return this.blockIndexInTexture;
        }
        else if (par5 == 0)
        {
            return this.blockIndexInTexture;
        }
        else
        {
            int var6 = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
            return par5 != var6 ? this.blockIndexInTexture : (this.isActive ? this.blockIndexInTexture + 2 : this.blockIndexInTexture + 1);
        }
    }

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
//        if (this.isActive)
//        {
//            int var6 = par1World.getBlockMetadata(par2, par3, par4);
//            float var7 = (float)par2 + 0.5F;
//            float var8 = (float)par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
//            float var9 = (float)par4 + 0.5F;
//            float var10 = 0.52F;
//            float var11 = par5Random.nextFloat() * 0.6F - 0.3F;
//
//            if (var6 == 4)
//            {
//                par1World.spawnParticle("smoke", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
//                par1World.spawnParticle("flame", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
//            }
//            else if (var6 == 5)
//            {
//                par1World.spawnParticle("smoke", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
//                par1World.spawnParticle("flame", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
//            }
//            else if (var6 == 2)
//            {
//                par1World.spawnParticle("smoke", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
//                par1World.spawnParticle("flame", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
//            }
//            else if (var6 == 3)
//            {
//                par1World.spawnParticle("smoke", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
//                par1World.spawnParticle("flame", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
//            }
//        }
    }

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    public int getBlockTextureFromSide(int i)
    {
        return i == 1 ? this.blockIndexInTexture : (i == 0 ? this.blockIndexInTexture : (i == 3 ? this.blockIndexInTexture +1 : this.blockIndexInTexture));
    }

    /**
     * Called upon block activation (left or right click on the block.). The three integers represent x,y,z of the
     * block.
     */
    public boolean blockActivated(World world, int j, int k, int par4, EntityPlayer par5EntityPlayer)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            TileEntityIncubator tileentityincubator = (TileEntityIncubator)world.getBlockTileEntity(j, k, par4);

            if (tileentityincubator != null)
            {
            	ModLoader.openGUI(ModLoader.getMinecraftInstance().thePlayer, new GuiIncubator(ModLoader.getMinecraftInstance().thePlayer.inventory, tileentityincubator));
            }

            return true;
        }
    }

    /**
     * Update which block ID the incubator is using depending on whether or not it is burning
     */
    public static void updateIncubatorBlockState(boolean par0, World par1World, int par2, int par3, int par4)
    {
        int var5 = par1World.getBlockMetadata(par2, par3, par4);
        TileEntity var6 = par1World.getBlockTileEntity(par2, par3, par4);
        keepIncubatorInventory = true;

        if (par0)
        {
            par1World.setBlockWithNotify(par2, par3, par4, EasterBlocks.EasterIncubatorActive.blockID);
        }
        else
        {
            par1World.setBlockWithNotify(par2, par3, par4, EasterBlocks.EasterIncubatorIdle.blockID);
        }

        keepIncubatorInventory = false;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, var5);

        if (var6 != null)
        {
            var6.validate();
            par1World.setBlockTileEntity(par2, par3, par4, var6);
        }
    }

    /**
     * Returns the TileEntity used by this block.
     */
    public TileEntity getBlockEntity()
    {
        return new TileEntityIncubator();
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
    {
        int var6 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (var6 == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2);
        }

        if (var6 == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5);
        }

        if (var6 == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3);
        }

        if (var6 == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4);
        }
    }

    /**
     * Called whenever the block is removed.
     */
    public void onBlockRemoval(World par1World, int par2, int par3, int par4)
    {
        if (!keepIncubatorInventory)
        {
            TileEntityIncubator var5 = (TileEntityIncubator)par1World.getBlockTileEntity(par2, par3, par4);

            if (var5 != null)
            {
                for (int var6 = 0; var6 < var5.getSizeInventory(); ++var6)
                {
                    ItemStack var7 = var5.getStackInSlot(var6);

                    if (var7 != null)
                    {
                        float var8 = this.incubatorRand.nextFloat() * 0.8F + 0.1F;
                        float var9 = this.incubatorRand.nextFloat() * 0.8F + 0.1F;
                        float var10 = this.incubatorRand.nextFloat() * 0.8F + 0.1F;

                        while (var7.stackSize > 0)
                        {
                            int var11 = this.incubatorRand.nextInt(21) + 10;

                            if (var11 > var7.stackSize)
                            {
                                var11 = var7.stackSize;
                            }

                            var7.stackSize -= var11;
                            EntityItem var12 = new EntityItem(par1World, (double)((float)par2 + var8), (double)((float)par3 + var9), (double)((float)par4 + var10), new ItemStack(var7.itemID, var11, var7.getItemDamage()));

                            if (var7.hasTagCompound())
                            {
                                var12.item.setTagCompound((NBTTagCompound)var7.getTagCompound().copy());
                            }

                            float var13 = 0.05F;
                            var12.motionX = (double)((float)this.incubatorRand.nextGaussian() * var13);
                            var12.motionY = (double)((float)this.incubatorRand.nextGaussian() * var13 + 0.2F);
                            var12.motionZ = (double)((float)this.incubatorRand.nextGaussian() * var13);
                            par1World.spawnEntityInWorld(var12);
                        }
                    }
                }
            }
        }

        super.onBlockRemoval(par1World, par2, par3, par4);
    }
}
