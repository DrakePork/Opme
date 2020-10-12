package com.github.drakepork.opme.Utils;

import com.github.drakepork.opme.Main;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigCreator {
	private Main plugin;

	@Inject
	public ConfigCreator(Main plugin) {
		this.plugin = plugin;
	}

	public void init() {
		FileConfiguration config = this.plugin.getConfig();
		config.addDefault("lang-file", "en.yml");
		config.addDefault("enable-op-command", true);
		config.addDefault("enable-deop-command", true);
		config.addDefault("deop-on-join", false);
		config.addDefault("opped-access", Lists.newArrayList(""));
		config.options().copyDefaults(true);
		plugin.saveConfig();
	}
}
