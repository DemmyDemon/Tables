package com.webkonsept.bukkit.tables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class Tables extends JavaPlugin {
	private final static Logger log = Logger.getLogger("Minecraft");
	private final TablesBlockListener tableListener = new TablesBlockListener(this);
	
	private static String pluginName = "Tables";
	private static String pluginVersion = "???";
	private static boolean verbose = false;
	
	public final HashMap<Material,HashSet<Material>> onTop = new HashMap<Material,HashSet<Material>>(){
        private static final long serialVersionUID = -8296976368562050363L;
        {
	        put(Material.WOOD_PLATE,new HashSet<Material>(){
                private static final long serialVersionUID = 8076632167171102845L;
                {
	                add(Material.GLASS);
	                add(Material.THIN_GLASS);
	                add(Material.IRON_FENCE);
	                add(Material.WOOD_STAIRS);
	                add(Material.COBBLESTONE_STAIRS);
	                add(Material.BRICK_STAIRS);
	                add(Material.SMOOTH_STAIRS);
	                add(Material.NETHER_BRICK_STAIRS);
	                
	            }
	        });
	        
	        put(Material.STONE_PLATE,new HashSet<Material>(){
                private static final long serialVersionUID = -4085093673043901748L;
                {
                    add(Material.GLASS);
                    add(Material.THIN_GLASS);
                    add(Material.IRON_FENCE);
                    add(Material.WOOD_STAIRS);
                    add(Material.COBBLESTONE_STAIRS);
                    add(Material.BRICK_STAIRS);
                    add(Material.SMOOTH_STAIRS);
                    add(Material.NETHER_BRICK_STAIRS);
	            }
	        });
	        
           put(Material.CAKE_BLOCK,new HashSet<Material>(){
                private static final long serialVersionUID = -4085093673043901748L;
                {
                    add(Material.GLASS);
                    add(Material.THIN_GLASS);
                    add(Material.IRON_FENCE);
                }
            });
	        
	    }
	};
	public void onLoad() {
	    Tables.pluginVersion = getDescription().getVersion();
	    Tables.pluginName = getDescription().getName();
	}
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(tableListener,this);
		out("Enabled");
	}
	@Override
	public void onDisable() {
		out("Disabled");
	}
	public static void out(String message){
		log.info("["+Tables.pluginName+" v"+Tables.pluginVersion + "] "+message);
	}
	public void error(String message){
		log.severe("["+Tables.pluginName+" v"+Tables.pluginVersion + "] "+message);
	}
	public static void verbose(String message){
	    if (Tables.verbose){
	        log.info("["+Tables.pluginName+" v"+Tables.pluginVersion + "] "+message);
	    }
	}
}
