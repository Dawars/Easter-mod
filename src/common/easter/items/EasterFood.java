package easter.items;

import easter.common.DefaultProps;
import net.minecraft.src.ItemFood;

public class EasterFood extends ItemFood{

	public EasterFood(int i, int j, float f, boolean isWolfFavoriteFood) {
		super(i, j, f, isWolfFavoriteFood);
	}

	public String getTextureFile(){
		return DefaultProps.TEXTURE_ITEMS;
	}

}
