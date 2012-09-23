package easter.common;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Block;

public class Proxy {
	public static void registerBlock(Block block){
		GameRegistry.registerBlock(block);
	}
	
	public static void addName(Object block, String name){
		LanguageRegistry.addName(block, name);
	}
}
