package easter.items;

import cpw.mods.fml.client.ITextureFX;
import easter.common.DefaultProps;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class EasterItem extends Item{

	public EasterItem(int i, int j) {
		super(i);
		this.iconIndex = j;
		this.setTabToDisplayOn(CreativeTabs.tabAllSearch);
	}
	
	public String getTextureFile(){
		return DefaultProps.TEXTURE_ITEMS;
	}
}
