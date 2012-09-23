package easter.client;

import java.util.Arrays;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import easter.common.CommonProxy;
import easter.common.DefaultProps;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderThings(){
		for (String texture : Arrays.asList(
				DefaultProps.TEXTURE_BLOCKS,
				DefaultProps.TEXTURE_ITEMS))
			MinecraftForgeClient.preloadTexture(texture);
	}
}