package com.github.drakepork.opme.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Deopme implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			p.setOp(false);
			sender.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "Deopping " + p.getName());
		} else {

		}
		return true;
	}
}
