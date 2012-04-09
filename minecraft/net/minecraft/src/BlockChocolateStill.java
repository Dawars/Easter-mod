package net.minecraft.src;

import java.util.Random;

public class BlockChocolateStill extends BlockFluid
{

    protected BlockChocolateStill(int i, Material material)
    {
        super(i, material);
    }

    public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return 0x704d0a;
    }
    
    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        super.onNeighborBlockChange(world, i, j, k, l);
        if(world.getBlockId(i, j, k) == blockID)
        {
            func_30004_j(world, i, j, k);
        }
    }

    private void func_30004_j(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k);
        world.editingBlocks = true;
        world.setBlockAndMetadata(i, j, k, blockID - 1, l);
        world.markBlocksDirty(i, j, k, i, j, k);
        world.scheduleBlockUpdate(i, j, k, blockID - 1, tickRate());
        world.editingBlocks = false;
    }


    private boolean func_301_k(World world, int i, int j, int k)
    {
        return world.getBlockMaterial(i, j, k).getCanBurn();
    }
}