package com.webkonsept.bukkit.tables;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockPhysicsEvent;

public class TablesBlockListener implements Listener {
	private Tables plugin;
	
	public TablesBlockListener (Tables instance){
		plugin = instance;
	}
	
	@EventHandler
	public void onBlockCanBuild (BlockCanBuildEvent event){
		if (!plugin.isEnabled()) return;
		
		Material placing = event.getMaterial();
		Block thisBlock = event.getBlock();
		
		if (plugin.onTop.containsKey(placing)){
			Block belowBlock = thisBlock.getRelative(BlockFace.DOWN);
			if (thisBlock.getType().equals(Material.AIR) && plugin.onTop.get(placing).contains((belowBlock.getType()))){
				event.setBuildable(true);
			}
		}
	}
	
	@EventHandler
	public void onBlockPhysics (BlockPhysicsEvent event){
		if (!plugin.isEnabled()) return;
		
		Block affected = event.getBlock();
		if (plugin.onTop.containsKey(affected.getType())){
			Material below = affected.getRelative(BlockFace.DOWN).getType();
			if (plugin.onTop.get(affected.getType()).contains(below)){
				event.setCancelled(true);
			}
		}
	}
}
