package easter;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import java.util.Iterator;
import java.util.Random;

import easter.common.DefaultProps;

import net.minecraft.src.Block;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.Direction;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumStatus;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class EasterGrave extends Block
{
    /** Maps the foot-of-bed block to the head-of-bed block. */
    public static final int[][] footBlockToHeadBlockMap = new int[][] {{0, 1}, { -1, 0}, {0, -1}, {1, 0}};

    public int back = 20;
    public int side = 19;
    public int head = 22;
    public int foot = 21;
    
    
    public EasterGrave(int par1)
    {
        super(par1, 1 * 16 + 3, Material.rock);
//        this.setBounds();
    }
    public String getTextureFile() {
		return DefaultProps.TEXTURE_BLOCKS;
	}

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            int var10 = world.getBlockMetadata(par2, par3, par4);

            if (!isBlockHeadOfBed(var10))
            {
                int var11 = getDirection(var10);
                par2 += footBlockToHeadBlockMap[var11][0];
                par4 += footBlockToHeadBlockMap[var11][1];

                if (world.getBlockId(par2, par3, par4) != this.blockID)
                {
                    return true;
                }

                var10 = world.getBlockMetadata(par2, par3, par4);
            }

            if (!world.provider.canRespawnHere())
            {
                double var19 = (double)par2 + 0.5D;
                double var21 = (double)par3 + 0.5D;
                double var15 = (double)par4 + 0.5D;
                world.setBlockWithNotify(par2, par3, par4, 0);
                int var17 = getDirection(var10);
                par2 += footBlockToHeadBlockMap[var17][0];
                par4 += footBlockToHeadBlockMap[var17][1];

                if (world.getBlockId(par2, par3, par4) == this.blockID)
                {
                    world.setBlockWithNotify(par2, par3, par4, 0);
                    var19 = (var19 + (double)par2 + 0.5D) / 2.0D;
                    var21 = (var21 + (double)par3 + 0.5D) / 2.0D;
                    var15 = (var15 + (double)par4 + 0.5D) / 2.0D;
                }

                world.newExplosion((Entity)null, (double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F), 5.0F, true);
                return true;
            }
            else
            {
                if (isBedOccupied(var10))
                {
                    EntityPlayer var18 = null;
                    Iterator var12 = world.playerEntities.iterator();

                    while (var12.hasNext())
                    {
                        EntityPlayer var13 = (EntityPlayer)var12.next();

                        if (var13.isPlayerSleeping())
                        {
                            ChunkCoordinates var14 = var13.playerLocation;

                            if (var14.posX == par2 && var14.posY == par3 && var14.posZ == par4)
                            {
                                var18 = var13;
                            }
                        }
                    }

                    if (var18 != null)
                    {
                        par5EntityPlayer.addChatMessage("tile.bed.occupied");
                        return true;
                    }

                    setBedOccupied(world, par2, par3, par4, false);
                }

                EnumStatus var20 = par5EntityPlayer.sleepInBedAt(par2, par3, par4);

                if (var20 == EnumStatus.OK)
                {
                    setBedOccupied(world, par2, par3, par4, true);
                    return true;
                }
                else
                {
                    if (var20 == EnumStatus.NOT_POSSIBLE_NOW)
                    {
                        par5EntityPlayer.addChatMessage("tile.bed.noSleep");
                    }
                    else if (var20 == EnumStatus.NOT_SAFE)
                    {
                        par5EntityPlayer.addChatMessage("tile.bed.notSafe");
                    }

                    return true;
                }
            }
        }
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        if (par1 == 0)
        {
            return back;
        }
        else
        {
            int var3 = getDirection(par2);
            int var4 = Direction.bedDirection[var3][par1];
            return isBlockHeadOfBed(par2) ? (var4 == 2 ? side : (var4 != 5 && var4 != 4 ? head : side)) : (var4 == 3 ? side : (var4 != 5 && var4 != 4 ? foot : side));
        }
    }


    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 14;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        this.setBounds();
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World world, int par2, int par3, int par4, int par5)
    {
        int var6 = world.getBlockMetadata(par2, par3, par4);
        int var7 = getDirection(var6);

        if (isBlockHeadOfBed(var6))
        {
            if (world.getBlockId(par2 - footBlockToHeadBlockMap[var7][0], par3, par4 - footBlockToHeadBlockMap[var7][1]) != this.blockID)
            {
                world.setBlockWithNotify(par2, par3, par4, 0);
            }
        }
        else if (world.getBlockId(par2 + footBlockToHeadBlockMap[var7][0], par3, par4 + footBlockToHeadBlockMap[var7][1]) != this.blockID)
        {
            world.setBlockWithNotify(par2, par3, par4, 0);

            if (!world.isRemote)
            {
                this.dropBlockAsItem(world, par2, par3, par4, var6, 0);
            }
        }
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return isBlockHeadOfBed(par1) ? 0 : EasterCore.GraveItem.shiftedIndex;
    }

    /**
     * Set the bounds of the bed block.
     */
    private void setBounds()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.7F, 1.0F);
    }

    /**
     * Returns whether or not this bed block is the head of the bed.
     */
    public static boolean isBlockHeadOfBed(int par0)
    {
        return (par0 & 8) != 0;
    }

    /**
     * Return whether or not the bed is occupied.
     */
    public static boolean isBedOccupied(int par0)
    {
        return (par0 & 4) != 0;
    }

    /**
     * Sets whether or not the bed is occupied.
     */
    public static void setBedOccupied(World par0World, int par1, int par2, int par3, boolean par4)
    {
        int var5 = par0World.getBlockMetadata(par1, par2, par3);

        if (par4)
        {
            var5 |= 4;
        }
        else
        {
            var5 &= -5;
        }

        par0World.setBlockMetadataWithNotify(par1, par2, par3, var5);
    }

    /**
     * Gets the nearest empty chunk coordinates for the player to wake up from a bed into.
     */
    public static ChunkCoordinates getNearestEmptyChunkCoordinates(World par0World, int par1, int par2, int par3, int par4)
    {
        int var5 = par0World.getBlockMetadata(par1, par2, par3);
        int var6 = getDirection(var5);

        for (int var7 = 0; var7 <= 1; ++var7)
        {
            int var8 = par1 - footBlockToHeadBlockMap[var6][0] * var7 - 1;
            int var9 = par3 - footBlockToHeadBlockMap[var6][1] * var7 - 1;
            int var10 = var8 + 2;
            int var11 = var9 + 2;

            for (int var12 = var8; var12 <= var10; ++var12)
            {
                for (int var13 = var9; var13 <= var11; ++var13)
                {
                    if (par0World.doesBlockHaveSolidTopSurface(var12, par2 - 1, var13) && par0World.isAirBlock(var12, par2, var13) && par0World.isAirBlock(var12, par2 + 1, var13))
                    {
                        if (par4 <= 0)
                        {
                            return new ChunkCoordinates(var12, par2, var13);
                        }

                        --par4;
                    }
                }
            }
        }

        return null;
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World world, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        if (!isBlockHeadOfBed(par5))
        {
            super.dropBlockAsItemWithChance(world, par2, par3, par4, par5, par6, 0);
        }
    }

    /**
     * Returns the mobility information of the block, 0 = free, 1 = can't push but can move over, 2 = total immobility
     * and stop pistons
     */
    public int getMobilityFlag()
    {
        return 1;
    }
    
    /**
     * Returns the orentation value from the specified metadata
     */
    public static int getDirection(int par0)
    {
        return par0 & 3;
    }

    //Bed override
    
    /**
     * Determines if this block is classified as a Bed, Allowing 
     * players to sleep in it, though the block has to specifically 
     * perform the sleeping functionality in it's activated event.
     * 
     * @param world The current world
     * @param x X Position
     * @param y Y Position
     * @param z Z Position
     * @param player The player or camera entity, null in some cases.
     * @return True to treat this as a bed
     */
    public boolean isBed(World world, int x, int y, int z, EntityLiving player)
    {
        return blockID == EasterCore.Grave.blockID;
    }
    
    /**
     * Returns the position that the player is moved to upon 
     * waking up, or respawning at the bed.
     * 
     * @param world The current world
     * @param x X Position
     * @param y Y Position
     * @param z Z Position
     * @param player The player or camera entity, null in some cases.
     * @return The spawn position
     */
    public ChunkCoordinates getBedSpawnPosition(World world, int x, int y, int z, EntityPlayer player)
    {
        return this.getNearestEmptyChunkCoordinates(world, x, y, z, 0);
    }

    /**
     * Called when a user either starts or stops sleeping in the bed.
     *  
     * @param world The current world
     * @param x X Position
     * @param y Y Position
     * @param z Z Position
     * @param player The player or camera entity, null in some cases.
     * @param occupied True if we are occupying the bed, or false if they are stopping use of the bed
     */
    public void setBedOccupied(World world, int x, int y, int z, EntityPlayer player, boolean occupied)
    {
    	this.setBedOccupied(world,  x, y, z, occupied);        
    }

    /**
     * Returns the direction of the block. Same values that 
     * are returned by BlockDirectional
     * 
     * @param world The current world
     * @param x X Position
     * @param y Y Position
     * @param z Z Position
     * @return Bed direction
     */
    public int getBedDirection(IBlockAccess world, int x, int y, int z) 
    {
        return this.getDirection(world.getBlockMetadata(x,  y, z));
    }
    
    /**
     * Determines if the current block is the foot half of the bed.
     * 
     * @param world The current world
     * @param x X Position
     * @param y Y Position
     * @param z Z Position
     * @return True if the current block is the foot side of a bed.
     */
    public boolean isBedFoot(IBlockAccess world, int x, int y, int z)
    {
        return this.isBlockHeadOfBed(world.getBlockMetadata(x,  y, z));
    }
    
    //Bed override end
    
    
    @SideOnly(Side.CLIENT)

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(World world, int par2, int par3, int par4)
    {
        return EasterCore.GraveItem.shiftedIndex;
    }
}