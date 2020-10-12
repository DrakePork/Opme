package com.github.drakepork.opme.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class Opme {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			p.setOp(true);
			sender.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "Opping " + p.getName());
			Logger log = Bukkit.getLogger();
			log.info(ChatColor.RED + p.getName() + " has opped themselves!");
		} else {

		}
		return true;
	}
}
