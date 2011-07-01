package com.webkonsept.bukkit.tables;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;

public class TablesBlockListener extends BlockListener {
	private Tables plugin;
	
	public TablesBlockListener (Tables instance){
		plugin = instance;
	}
	
	public void onBlockCanBuild (BlockCanBuildEvent event){
		if (!plugin.isEnabled()) return;
		
		Material placing = event.getMaterial();
		Block thisBlock = event.getBlock();
		if (plugin.place.contains(placing)){
			Block belowBlock = thisBlock.getFace(BlockFace.DOWN);
			if (thisBlock.getType().equals(Material.AIR)){
				if (plugin.onTopOf.contains(belowBlock.getType())){
					event.setBuildable(true);
				}
			}
		}
	}
	
	@Override
	public void onBlockPhysics (BlockPhysicsEvent event){
		if (!plugin.isEnabled()) return;
		
		Block affected = event.getBlock();
		if (plugin.place.contains(affected.getType())){
			Material below = affected.getFace(BlockFace.DOWN).getType();
			if (plugin.onTopOf.contains(below)){
				event.setCancelled(true);
			}
		}
	}
}
