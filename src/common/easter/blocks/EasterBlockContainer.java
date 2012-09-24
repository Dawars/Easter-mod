package easter.blocks;

import easter.common.DefaultProps;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class EasterBlockContainer extends BlockContainer{

	protected EasterBlockContainer(int i, int j, Material mat) {
		super(i, j, mat);
	}

	@Override
	public TileEntity createNewTileEntity(World w) {
		return null;
	}
	
	@Override
	public String getTextureFile() {
		return DefaultProps.TEXTURE_BLOCKS;
	}

}
