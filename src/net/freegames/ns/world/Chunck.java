package net.freegames.ns.world;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.freegames.ns.block.Block;
import net.freegames.ns.block.GrassBlock;

public class Chunck {

	private static final float w = 20/*, h = 50*/;
	
	private final Map<Location, Block> blocks = new HashMap<>();
	private final Location location;
	
	public Chunck(Location location) {
		this.location = location;
		genChunck();
	}
	
	private void genChunck(){
		for(int x = 0; x < w; x++){
			for(int z = 0; z < w; z++){
				for(int y = 0; y < 1; y++){
					Location loc = new Location(location.getWorld(),location.getX()+x, location.getY()+y, location.getZ()+z);
					blocks.put(loc, new GrassBlock(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ()));
				}
			}
		}
	}
	
	public void update(){
		for(Entry<Location, Block> block : blocks.entrySet()){
			block.getValue().update();
		}
	}
	
	public void render(){
		for(Entry<Location, Block> block : blocks.entrySet()){
			block.getValue().render();
		}
	}
}
