package net.minecraft.src;

public class ContainerIncubator extends Container
{
    private TileEntityIncubator incubator;
    private int CookTime = 0;
    private int BurnTime = 0;
    private int ItemBurnTime = 0;

    public ContainerIncubator(InventoryPlayer InventoryPlayer, TileEntityIncubator TileEntityIncubator)
    {
        this.incubator = TileEntityIncubator;
        this.addSlot(new Slot(TileEntityIncubator, 0, 56, 17));
        this.addSlot(new Slot(TileEntityIncubator, 1, 56, 53));
        this.addSlot(new SlotIncubator(InventoryPlayer.player, TileEntityIncubator, 2, 116, 35));
        int var3;

        for (var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                this.addSlot(new Slot(InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (var3 = 0; var3 < 9; ++var3)
        {
            this.addSlot(new Slot(InventoryPlayer, var3, 8 + var3 * 18, 142));
        }
    }

    /**
     * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
     */
    public void updateCraftingResults()
    {
        super.updateCraftingResults();

        for (int var1 = 0; var1 < this.crafters.size(); ++var1)
        {
            ICrafting var2 = (ICrafting)this.crafters.get(var1);

            if (this.CookTime != this.incubator.incubatorCookTime)
            {
                var2.updateCraftingInventoryInfo(this, 0, this.incubator.incubatorCookTime);
            }

            if (this.BurnTime != this.incubator.incubatorBurnTime)
            {
                var2.updateCraftingInventoryInfo(this, 1, this.incubator.incubatorBurnTime);
            }

            if (this.ItemBurnTime != this.incubator.currentItemBurnTime)
            {
                var2.updateCraftingInventoryInfo(this, 2, this.incubator.currentItemBurnTime);
            }
        }

        this.CookTime = this.incubator.incubatorCookTime;
        this.BurnTime = this.incubator.incubatorBurnTime;
        this.ItemBurnTime = this.incubator.currentItemBurnTime;
    }

    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.incubator.incubatorCookTime = par2;
        }

        if (par1 == 1)
        {
            this.incubator.incubatorBurnTime = par2;
        }

        if (par1 == 2)
        {
            this.incubator.currentItemBurnTime = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer EntityPlayer)
    {
        return this.incubator.isUseableByPlayer(EntityPlayer);
    }

    /**
     * Called to transfer a stack from one inventory to the other eg. when shift clicking.
     */
    public ItemStack transferStackInSlot(int par1)
    {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.inventorySlots.get(par1);

        if (var3 != null && var3.getHasStack())
        {
            ItemStack var4 = var3.getStack();
            var2 = var4.copy();

            if (par1 == 2)
            {
                if (!this.mergeItemStack(var4, 3, 39, true))
                {
                    return null;
                }

                var3.func_48433_a(var4, var2);
            }
            else if (par1 != 1 && par1 != 0)
            {
                if (IncubatorRecipes.smelting().getSmeltingResult(var4.getItem().shiftedIndex) != null ||
                		var4.getItem().shiftedIndex == EasterBlocks.MysteryEgg1.blockID ||
                		var4.getItem().shiftedIndex == EasterBlocks.MysteryEgg2.blockID ||
                		var4.getItem().shiftedIndex == EasterBlocks.MysteryEgg3.blockID ||
                		var4.getItem().shiftedIndex == EasterBlocks.MysteryEgg4.blockID ||
                		var4.getItem().shiftedIndex == EasterBlocks.MysteryEgg5.blockID ||
                		var4.getItem().shiftedIndex == EasterBlocks.MysteryEgg6.blockID ||
                		var4.getItem().shiftedIndex == EasterBlocks.MysteryEgg7.blockID ||
                		var4.getItem().shiftedIndex == EasterBlocks.MysteryEgg8.blockID                		)
                {
                    if (!this.mergeItemStack(var4, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityIncubator.func_52005_b(var4))
                {
                    if (!this.mergeItemStack(var4, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (par1 >= 3 && par1 < 30)
                {
                    if (!this.mergeItemStack(var4, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (par1 >= 30 && par1 < 39 && !this.mergeItemStack(var4, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(var4, 3, 39, false))
            {
                return null;
            }

            if (var4.stackSize == 0)
            {
                var3.putStack((ItemStack)null);
            }
            else
            {
                var3.onSlotChanged();
            }

            if (var4.stackSize == var2.stackSize)
            {
                return null;
            }

            var3.onPickupFromSlot(var4);
        }

        return var2;
    }
}
