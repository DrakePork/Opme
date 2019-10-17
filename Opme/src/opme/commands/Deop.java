package opme.commands;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class Deop implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender; 
        if (p.hasPermission("opme.deop")) {
        	if (args.length == 1) {
        		String name = args[0];
        		Player player = Bukkit.getPlayer(name);
        		if(player != null) {
	        		if (!player.isOp()) {
	                	sender.sendMessage(ChatColor.RED + player.getName() + " is not opped");
	        		} else {
	        			player.setOp(false);
	                	sender.sendMessage(ChatColor.GRAY + player.getName() + " has been deopped!");
	                	Logger log = Bukkit.getLogger();
	                	log.info(ChatColor.RED + player.getName() + " has been deopped!");
	        		}
        		} else {
                	sender.sendMessage(ChatColor.RED + "Player is not online.");
        		}
        	} else {
            	sender.sendMessage(ChatColor.RED + "/deop <player>");
        	}
          return true;
        }
		return false;
      }
}
