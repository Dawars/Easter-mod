package easter.blocks;

import net.minecraft.src.BlockContainer;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class SqueezerWallBlock extends EasterBlockContainer{

	public SqueezerWallBlock(int i) {
		super(i, 3 * 16 + 0, Material.wood);
		this.blockIndexInTexture = 3 * 16 + 0;
	}

	public int getBlockTextureFromSide(int i)
    {
        return i <= 1 ? this.blockIndexInTexture + 1 : this.blockIndexInTexture;
    }
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return null;
	}

}
