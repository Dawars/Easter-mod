package net.minecraft.src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class IncubatorRecipes
{
    private static final IncubatorRecipes smeltingBase = new IncubatorRecipes();

    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map metaSmeltingList = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final IncubatorRecipes smelting()
    {
        return smeltingBase;
    }

    private IncubatorRecipes()
    {
//        this.addSmelting(EasterItems.ChocolateEgg.shiftedIndex, new ItemStack(EasterItems.EasterMonsterSpawner));
        
    }

    /**
     * Adds a smelting recipe.
     */
    public void addSmelting(int par1, ItemStack par2ItemStack)
    {
        this.smeltingList.put(Integer.valueOf(par1), par2ItemStack);
    }

    /**
     * Returns the smelting result of an item.
     * Deprecated in favor of a metadata sensitive version
     */
    @Deprecated
    public ItemStack getSmeltingResult(int par1)
    {
        return (ItemStack)this.smeltingList.get(Integer.valueOf(par1));
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }
    
    /**
     * Add a metadata-sensitive incubator recipe
     * @param itemID The Item ID
     * @param metadata The Item Metadata
     * @param itemstack The ItemStack for the result
     */
    public void addSmelting(int itemID, int metadata, ItemStack itemstack)
    {
        metaSmeltingList.put(Arrays.asList(itemID, metadata), itemstack);
    }
    
    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * @param item The Source ItemStack
     * @return The result ItemStack
     */
    public ItemStack getSmeltingResult(ItemStack item) 
    {
    	Random rand = new Random();
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        if (item.itemID == EasterBlocks.MysteryEgg1.blockID ||
        		item.itemID == EasterBlocks.MysteryEgg2.blockID ||
        		item.itemID == EasterBlocks.MysteryEgg3.blockID ||
        		item.itemID == EasterBlocks.MysteryEgg4.blockID ||
        		item.itemID == EasterBlocks.MysteryEgg5.blockID ||
        		item.itemID == EasterBlocks.MysteryEgg6.blockID ||
        		item.itemID == EasterBlocks.MysteryEgg7.blockID ||
        		item.itemID == EasterBlocks.MysteryEgg8.blockID
        		){
        	return new ItemStack(getLoot(), 1, 0);
        } else {
        	return (ItemStack)smeltingList.get(Integer.valueOf(item.itemID));
        }
    }
    private int getLoot(){
    	Random rand = new Random();
    	switch(rand.nextInt(10)+1){
	    	case 1:
				return EasterBlocks.DarkBlock.blockID;
	    	case 2:
				return EasterItems.WhiteChocolateSword.shiftedIndex;
	    	case 3:
				return EasterItems.DarkChocolateLegs.shiftedIndex;
	    	case 4:
				return EasterItems.MilkChocolatePickaxe.shiftedIndex;
	    	case 5:
				return EasterItems.ChocolateDiamond.shiftedIndex;
	    	case 6:
				return EasterItems.ChocolateBar.shiftedIndex;
	    	case 7:
				return EasterBlocks.grave.blockID;
	    	case 8:
				return EasterBlocks.Dahlia.blockID;
	    	case 9:
				return EasterBlocks.PinkyBush.blockID;
	    	case 10:
				return EasterBlocks.MysteryEgg8.blockID;
    	}
    	return 0;
    }
}
