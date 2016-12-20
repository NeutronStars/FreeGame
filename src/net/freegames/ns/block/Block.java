package net.freegames.ns.block;

import net.freegames.ns.randering.Renderer;
import net.freegames.ns.world.Location;

public abstract class Block {

	private final String name;
	private final BlockType type;
	private final Renderer render;
	private Location postion;
	
	public Block(String name, Location position, BlockType type, Renderer render) {
		this.name = name;
		this.type = type;
		this.postion = position;
		this.render = render;
	}
	
	public String getName() {
		return name;
	}
	
	public BlockType getType() {
		return type;
	}
	
	public Location getLocation() {
		return postion;
	}
	
	public int getID(){
		return getType().getId();
	}
	
	protected Renderer getRenderer(){
		return render;
	}
	
	public void update(){
		
	}
	
	public void render(){
		render.render(getLocation());
	}
	
}
