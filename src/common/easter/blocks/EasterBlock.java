package easter.blocks;

import easter.common.DefaultProps;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;


public class EasterBlock extends Block{
	
	public EasterBlock(int i, int j, Material mat){
		super(i, j, mat);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	 public EasterBlock(int i, Material mat)
    {
        super(i, mat);
    }
	
	public String getTextureFile(){
		return DefaultProps.TEXTURE_BLOCKS;
	}
	
}
