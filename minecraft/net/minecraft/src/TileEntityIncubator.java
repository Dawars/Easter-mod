package net.minecraft.src;

import net.minecraft.src.forge.ISidedInventory;

public class TileEntityIncubator extends TileEntity implements IInventory, ISidedInventory
{
    /**
     * The ItemStacks that hold the items currently being used in the incubator
     */
    private ItemStack[] incubatorItemStacks = new ItemStack[3];

    /** The number of ticks that the incubator will keep burning */
    public int incubatorBurnTime = 0;

    /**
     * The number of ticks that a fresh copy of the currently-burning item would keep the incubator burning for
     */
    public int currentItemBurnTime = 0;

    /** The number of ticks that the current item has been cooking for */
    public int incubatorCookTime = 0;

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.incubatorItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1)
    {
        return this.incubatorItemStacks[par1];
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.incubatorItemStacks[par1] != null)
        {
            ItemStack var3;

            if (this.incubatorItemStacks[par1].stackSize <= par2)
            {
                var3 = this.incubatorItemStacks[par1];
                this.incubatorItemStacks[par1] = null;
                return var3;
            }
            else
            {
                var3 = this.incubatorItemStacks[par1].splitStack(par2);

                if (this.incubatorItemStacks[par1].stackSize == 0)
                {
                    this.incubatorItemStacks[par1] = null;
                }

                return var3;
            }
        }
        else
        {
            return null;
        }
    }
    public static boolean func_52005_b(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }
    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.incubatorItemStacks[par1] != null)
        {
            ItemStack var2 = this.incubatorItemStacks[par1];
            this.incubatorItemStacks[par1] = null;
            return var2;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.incubatorItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInvName()
    {
        return "container.incubator";
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
        this.incubatorItemStacks = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.incubatorItemStacks.length)
            {
                this.incubatorItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.incubatorBurnTime = par1NBTTagCompound.getShort("BurnTime");
        this.incubatorCookTime = par1NBTTagCompound.getShort("CookTime");
        this.currentItemBurnTime = this.getItemBurnTime(this.incubatorItemStacks[1]);
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("BurnTime", (short)this.incubatorBurnTime);
        par1NBTTagCompound.setShort("CookTime", (short)this.incubatorCookTime);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.incubatorItemStacks.length; ++var3)
        {
            if (this.incubatorItemStacks[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.incubatorItemStacks[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        par1NBTTagCompound.setTag("Items", var2);
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
     * this more of a set than a get?*
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    public int getCookProgressScaled(int par1)
    {
        return this.incubatorCookTime * par1 / 200;
    }

    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    public int getBurnTimeRemainingScaled(int par1)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 20;
        }

        return this.incubatorBurnTime * par1 / this.currentItemBurnTime;
    }

    /**
     * Returns true if the incubator is currently burning
     */
    public boolean isBurning()
    {
        return this.incubatorBurnTime > 0;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
        boolean var1 = this.incubatorBurnTime > 0;
        boolean var2 = false;

        if (this.incubatorBurnTime > 0)
        {
            --this.incubatorBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.incubatorBurnTime == 0 && this.canSmelt())
            {
                this.currentItemBurnTime = this.incubatorBurnTime = this.getItemBurnTime(this.incubatorItemStacks[1]);

                if (this.incubatorBurnTime > 0)
                {
                    var2 = true;

                    if (this.incubatorItemStacks[1] != null)
                    {
                        if (this.incubatorItemStacks[1].getItem().func_46056_k())
                        {
                            this.incubatorItemStacks[1] = new ItemStack(this.incubatorItemStacks[1].getItem().setFull3D());
                        }
                        else
                        {
                            --this.incubatorItemStacks[1].stackSize;
                        }

                        if (this.incubatorItemStacks[1].stackSize == 0)
                        {
                            this.incubatorItemStacks[1] = null;
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt())
            {
                ++this.incubatorCookTime;

                if (this.incubatorCookTime == 200)
                {
                    this.incubatorCookTime = 0;
                    this.smeltItem();
                    var2 = true;
                }
            }
            else
            {
                this.incubatorCookTime = 0;
            }

            if (var1 != this.incubatorBurnTime > 0)
            {
                var2 = true;
                EasterBlockIncubator.updateIncubatorBlockState(this.incubatorBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (var2)
        {
            this.onInventoryChanged();
        }
    }

    /**
     * Returns true if the incubator can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt()
    {
        if (this.incubatorItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack var1 = IncubatorRecipes.smelting().getSmeltingResult(this.incubatorItemStacks[0]);
            if (var1 == null) return false;
            if (this.incubatorItemStacks[2] == null) return true;
            if (!this.incubatorItemStacks[2].isItemEqual(var1)) return false;
            int result = incubatorItemStacks[2].stackSize + var1.stackSize;
            return (result <= getInventoryStackLimit() && result <= var1.getMaxStackSize());
        }
    }

    /**
     * Turn one item from the incubator source stack into the appropriate smelted item in the incubator result stack
     */
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack var1 = IncubatorRecipes.smelting().getSmeltingResult(this.incubatorItemStacks[0]);

            if (this.incubatorItemStacks[2] == null)
            {
                this.incubatorItemStacks[2] = var1.copy();
            }
            else if (this.incubatorItemStacks[2].isItemEqual(var1))
            {
                this.incubatorItemStacks[2].stackSize += var1.stackSize;
            }

            if (this.incubatorItemStacks[0].getItem().func_46056_k())
            {
                this.incubatorItemStacks[0] = new ItemStack(this.incubatorItemStacks[0].getItem().setFull3D());
            }
            else
            {
                --this.incubatorItemStacks[0].stackSize;
            }

            if (this.incubatorItemStacks[0].stackSize <= 0)
            {
                this.incubatorItemStacks[0] = null;
            }
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the incubator burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack par1ItemStack)
    {
        if (par1ItemStack == null)
        {
            return 0;
        }
        else
        {
            int var1 = par1ItemStack.getItem().shiftedIndex;
            return var1 < 256 && Block.blocksList[var1].blockMaterial == Material.wood ? 300 : (var1 == Item.stick.shiftedIndex ? 100 : (var1 == Item.coal.shiftedIndex ? 1600 : (var1 == Item.bucketLava.shiftedIndex ? 20000 : (var1 == Block.sapling.blockID ? 100 : (var1 == Item.blazeRod.shiftedIndex ? 2400 : ModLoader.addAllFuel(par1ItemStack.itemID, par1ItemStack.getItemDamage()))))));
        }
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openChest() {}

    public void closeChest() {}

    @Override
    public int getStartInventorySide(int side) 
    {
        if (side == 0) return 1;
        if (side == 1) return 0;
        return 2;
    }

    @Override
    public int getSizeInventorySide(int side) 
    {
        return 1;
    }
}
