package net.freegames.ns.randering;

import net.freegames.ns.render.Texture;
import net.freegames.ns.world.Location;

public abstract class Renderer {

	private final Texture texture;
	
	private final float offSet;
	private final float envWidth;
	private final float envHeigth;
	
	public Renderer(Texture texture, float offSet, float envWidth, float envHeight) {
		this.texture = texture;
		this.offSet = offSet;
		this.envWidth = envWidth;
		this.envHeigth = envHeight;
	}
	
	protected float getOffSet() {
		return offSet;
	}
	
	protected float getEnvWidth() {
		return envWidth;
	}
	
	protected float getEnvHeigth() {
		return envHeigth;
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public abstract void render(Location position);
}
