package com.github.drakepork.opme.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Opdisable implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		sender.sendMessage(ChatColor.WHITE + "Unknown command. Type " + '"' + "/help" + '"' + " for help.");
		return true;
	}
}
