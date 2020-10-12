package com.github.drakepork.opme;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.bstats.bukkit.Metrics;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import com.github.drakepork.opme.Commands.Deop;
import com.github.drakepork.opme.Commands.Deopme;
import com.github.drakepork.opme.Commands.Op;
import com.github.drakepork.opme.Commands.Opme;
import com.github.drakepork.opme.Utils.ConfigCreator;
import com.github.drakepork.opme.Utils.LangCreator;
import com.github.drakepork.opme.Utils.PluginReceiver;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Main extends JavaPlugin {


	@Inject private LangCreator lang;
	@Inject private ConfigCreator ConfigCreator;
	@Inject private Deop Deop;
	@Inject private Op Op;
	@Inject private Deopme Deopme;
	@Inject private Opme Opme;

	@Override
	public void onEnable() {
		PluginReceiver module = new PluginReceiver(this);
		Injector injector = module.createInjector();
		injector.injectMembers(this);

		int pluginId = 9090;
		Metrics metrics = new Metrics(this, pluginId);

		this.ConfigCreator.init();
		this.lang.init();

		File spawnloc = new File(this.getDataFolder() + File.separator + "spawnlocations.yml");
		if(!spawnloc.exists()) {
			try {
				spawnloc.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		this.getCommand("deop").setExecutor(this.Deop);
	}

	@Override
	public void onDisable() {
		getLogger().info("Disabled Opme - v" + getDescription().getVersion());
	}


	@EventHandler
	public void PlayerJoin(PlayerJoinEvent event) {

	}


	public String translateHexColorCodes(String message) {
		final Pattern hexPattern = Pattern.compile("\\{#" + "([A-Fa-f0-9]{6})" + "\\}");
		Matcher matcher = hexPattern.matcher(message);
		StringBuffer buffer = new StringBuffer(message.length() + 4 * 8);
		while (matcher.find()) {
			String group = matcher.group(1);
			matcher.appendReplacement(buffer, ChatColor.COLOR_CHAR + "x"
					+ ChatColor.COLOR_CHAR + group.charAt(0) + ChatColor.COLOR_CHAR + group.charAt(1)
					+ ChatColor.COLOR_CHAR + group.charAt(2) + ChatColor.COLOR_CHAR + group.charAt(3)
					+ ChatColor.COLOR_CHAR + group.charAt(4) + ChatColor.COLOR_CHAR + group.charAt(5)
			);
		}
		return matcher.appendTail(buffer).toString();
	}
}
