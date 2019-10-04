package opme.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Deopme implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if (p.hasPermission("deopme.use")) {
          p.setOp(false);
          sender.sendMessage("Deopping " + p.getName());
          return true;
        }
        return false;
      }
}
