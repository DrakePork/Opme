package opme.main;

import org.bukkit.plugin.java.JavaPlugin;

import opme.commands.Deopme;
import opme.commands.Opme;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		getCommand("opme").setExecutor(new Opme());
		getCommand("deopme").setExecutor(new Deopme());
	}
	
	public void onDisable() {
		
	}
	
	
}
