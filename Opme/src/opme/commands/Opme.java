package opme.commands;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Opme implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if (p.hasPermission("opme.opme")) {
          p.setOp(true);
          sender.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "Opping " + p.getName());
      	  Logger log = Bukkit.getLogger();
      	  log.info(ChatColor.RED + p.getName() + " has opped themselves!");
          return true;
        }
        return false;
      }
}