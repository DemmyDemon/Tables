package com.webkonsept.bukkit.tables;

import java.util.HashSet;
import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Tables extends JavaPlugin {
	private Logger log = Logger.getLogger("Minecraft");
	protected TablesBlockListener blockListener = new TablesBlockListener(this);
	
	protected HashSet<Material> place = new HashSet<Material>();
	protected HashSet<Material> onTopOf = new HashSet<Material>();
	
	
	@Override
	public void onEnable() {
		PluginManager pm =getServer().getPluginManager();
		pm.registerEvent(Event.Type.BLOCK_CANBUILD	,blockListener	,Priority.Normal	,this);
		pm.registerEvent(Event.Type.BLOCK_PHYSICS	,blockListener	,Priority.Normal	,this);
		
		place.clear();
		place.add(Material.WOOD_PLATE);
		place.add(Material.STONE_PLATE);
		
		onTopOf.clear();
		onTopOf.add(Material.FENCE);
		onTopOf.add(Material.GLASS);
		out("Enabled");
	}
	@Override
	public void onDisable() {
		out("Disabled");
	}
	public void out(String message) {
		PluginDescriptionFile pdfFile = this.getDescription();
		log.info("[" + pdfFile.getName()+ " " + pdfFile.getVersion() + "] " + message);
	}
	public void crap(String message){
		PluginDescriptionFile pdfFile = this.getDescription();
		log.severe("[" + pdfFile.getName()+ " " + pdfFile.getVersion() + " CRAP] " + message);
	}

}
