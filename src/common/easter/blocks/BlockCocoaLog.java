package easter.blocks;

import java.util.Random;

import easter.common.Easter;

import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockCocoaLog extends EasterBlock{
	 public BlockCocoaLog(int i, int j)
	    {
	        super(i, j, Material.wood);
	        float f = 0.375F;
	        float f1 = 0.625F;
	        this.setBlockBounds(f, 0.0F, f, f1, 1.0F, f1);
	        this.setRequiresSelfNotify();
	    }
	  

	    public boolean isOpaqueCube()
	    {
	        return false;
	    }

	    public boolean renderAsNormalBlock()
	    {
	        return false;
	    }

	    public int idDropped(int i, Random random)
	    {
	        return this.blockID;//log
	    }
	    
	    public void onBlockRemoval(World world, int par2, int par3, int par4)
	    {
	        byte var5 = 4;
	        int var6 = var5 + 1;

	        if (world.checkChunksExist(par2 - var6, par3 - var6, par4 - var6, par2 + var6, par3 + var6, par4 + var6))
	        {
	            for (int var7 = -var5; var7 <= var5; ++var7)
	            {
	                for (int var8 = -var5; var8 <= var5; ++var8)
	                {
	                    for (int var9 = -var5; var9 <= var5; ++var9)
	                    {
	                        int var10 = world.getBlockId(par2 + var7, par3 + var8, par4 + var9);

	                        if (var10 == Easter.CocoaLeaves.blockID)
	                        {
	                            int var11 = world.getBlockMetadata(par2 + var7, par3 + var8, par4 + var9);

	                            if ((var11 & 8) == 0)
	                            {
	                                world.setBlockMetadata(par2 + var7, par3 + var8, par4 + var9, var11 | 8);
	                            }
	                        }
	                    }
	                }
	            }
	        }
	    }
}
