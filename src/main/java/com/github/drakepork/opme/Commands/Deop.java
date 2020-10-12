package com.github.drakepork.opme.Commands;

import com.github.drakepork.opme.Main;
import com.google.inject.Inject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Deop implements CommandExecutor {
	private Main plugin;
	@Inject
	public Deop(Main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			FileConfiguration config = YamlConfiguration.loadConfiguration(new File(""));
			ArrayList opped = (ArrayList) config.getStringList("opped-access");
			if(opped.contains(((Player) sender).getUniqueId().toString())) {
				if (args.length == 1) {
					String name = args[0];
					OfflinePlayer player = Bukkit.getOfflinePlayer(name);
					Player user = Bukkit.getPlayer(name);
					if(user != null) {
						if (!player.isOp()) {
							sender.sendMessage(ChatColor.RED + player.getName() + " is not opped");
						} else {
							player.setOp(false);
							sender.sendMessage(ChatColor.GRAY + player.getName() + " has been deopped!");
							Logger log = Bukkit.getLogger();
							log.info(ChatColor.RED + player.getName() + " has been deopped!");
						}
					} else {
						sender.sendMessage(ChatColor.RED + "Player has not been on the server.");
					}
				} else {
					sender.sendMessage(ChatColor.RED + "/deop <player>");
				}
			} else {
				sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "You do not have permission to execute this command...");
			}
		} else {
			if (args.length == 1) {
				String name = args[0];
				OfflinePlayer player = Bukkit.getOfflinePlayer(name);
				Player user = Bukkit.getPlayer(name);
				if(user != null) {
					if (player.isOp()) {
						sender.sendMessage(ChatColor.RED + player.getName() + " is already opped!");
					} else {
						player.setOp(true);
						sender.sendMessage(ChatColor.GRAY + player.getName() + " has been opped!");
						Logger log = Bukkit.getLogger();
						log.info(ChatColor.RED + player.getName() + " has been opped!");
					}
				} else {
					sender.sendMessage(ChatColor.RED + "Player has not been on the server.");
				}
			} else {
				sender.sendMessage(ChatColor.RED + "/op <player>");
			}
		}
		return true;
	}
}
