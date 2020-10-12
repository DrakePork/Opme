package com.github.drakepork.opme.Commands;

import com.github.drakepork.opme.Main;
import com.google.inject.Inject;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class AutoTabCompleter implements TabCompleter {
	private Main plugin;

	@Inject
	public AutoTabCompleter(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return null;
	}
}
