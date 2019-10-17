package opme.main;

import org.bukkit.plugin.java.JavaPlugin;

import opme.commands.Deop;
import opme.commands.Deopme;
import opme.commands.Opme;
import opme.commands.Op;
import opme.commands.Opdisable;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

public class Main extends JavaPlugin implements Listener {
	FileConfiguration config = this.getConfig();
	public void onEnable() {
		getCommand("opme").setExecutor(new Opme());
		getCommand("deopme").setExecutor(new Deopme());
	    Bukkit.getServer().getPluginManager().registerEvents(this, this);
		config.addDefault("enable-op-command", true);
		config.addDefault("enable-deop-command", true);
		config.addDefault("deop-on-join", false);
		config.options().copyDefaults(true);
		saveConfig();
		if (config.getBoolean("enable-op-command")) {
			getCommand("op").setExecutor(new Op());
		} else {
			getCommand("op").setExecutor(new Opdisable());
		}
		if (config.getBoolean("enable-deop-command")) {
			getCommand("deop").setExecutor(new Deop());
		} else {
			getCommand("deop").setExecutor(new Opdisable());
		}
	}
	
	public void onDisable() {
		
	}

	@EventHandler
	public void onjoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		if (config.getBoolean("deop-on-join")) {
			if (!p.hasPermission("opme.joinbypass")) {
				if(p.isOp()) {
					p.setOp(false);
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event)  {
		if(event.getMessage().startsWith("/") && event.getMessage().contains(":op")
		  | event.getMessage().contains(":OP") | event.getMessage().contains(":Op")
		  | event.getMessage().contains(":oP") | event.getMessage().contains(":deop") 
		  | event.getMessage().contains(":DEOP") | event.getMessage().contains(":Deop") 
		  | event.getMessage().contains(":dEop") | event.getMessage().contains(":deOp") 
		  | event.getMessage().contains(":deoP") | event.getMessage().contains(":DEop") 
		  | event.getMessage().contains(":dEOp") | event.getMessage().contains(":deOP") 
		  | event.getMessage().contains(":DeoP") | event.getMessage().contains(":DEOp") 
		  | event.getMessage().contains(":dEOP") | event.getMessage().contains(":DeOP") 
		  | event.getMessage().contains(":DEoP")){
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.WHITE + "Unknown command. Type " + '"' + "/help" + '"' + " for help.");
	    }
	}
}
