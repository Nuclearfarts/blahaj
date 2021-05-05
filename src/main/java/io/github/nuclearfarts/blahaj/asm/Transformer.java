package io.github.nuclearfarts.blahaj.asm;

import net.minecraft.launchwrapper.LaunchClassLoader;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.relauncher.CoreModManager;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion(ForgeVersion.mcVersion)
public class Transformer implements IFMLLoadingPlugin {
	public Transformer() {
		MixinBootstrap.init();
		Mixins.addConfiguration("blahaj.mixins.json");
	}
	
	@Override
	public String[] getASMTransformerClass() {
		return new String[0];
	}
	
	@Override
	public String getModContainerClass() {
		return null;
	}
	
	@Override
	public String getSetupClass() {
		return null;
	}
	
	@Override
	public void injectData(Map<String, Object> data) { }
	
	private void loadModJar(File jar) throws MalformedURLException {
		((LaunchClassLoader) this.getClass().getClassLoader()).addURL(jar.toURI().toURL());
		CoreModManager.getReparseableCoremods().add(jar.getName());
	}
	
	@Override
	public String getAccessTransformerClass() {
		return null;
	}

}