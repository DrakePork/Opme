package opme.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Opme implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender; 
        if (p.hasPermission("opme.use")) {
          p.setOp(true);
          sender.sendMessage("Opping " + p.getName());
          return true;
        }
        return false;
      }
}