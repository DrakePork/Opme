package com.github.drakepork.opme.Utils;

import com.google.inject.Inject;
import com.github.drakepork.opme.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LangCreator {
	private Main plugin;

	@Inject
	public LangCreator(Main plugin) {
		this.plugin = plugin;
	}

	public void init() {
		File lang = new File(this.plugin.getDataFolder() + File.separator
				+ "lang" + File.separator + plugin.getConfig().getString("lang-file"));
		try {
			FileConfiguration langConf = YamlConfiguration.loadConfiguration(lang);

			langConf.addDefault("plugin-prefix", "&f[&cOpme&f] ");
			langConf.addDefault("opme-message", "");
			langConf.addDefault("deopme-message", "");
			langConf.addDefault("op-message", "");
			langConf.addDefault("deop-message", "");
			langConf.addDefault("no-perm", "&4Error: &cYou do not have permission to execute this command...");

			langConf.options().copyDefaults(true);
			langConf.save(lang);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
