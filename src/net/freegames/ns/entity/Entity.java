package net.freegames.ns.entity;

import net.freegames.ns.maths.Vector3f;
import net.freegames.ns.randering.Renderer;
import net.freegames.ns.render.Animation;
import net.freegames.ns.world.Location;

public abstract class Entity {

	private final Renderer render;
	
	private Animation animation;
	private String name;
	private boolean flying, canFly;
	private Location location;
	
	public Entity(String name, boolean ghost, Location location, Renderer render) {
		this.location = location;
		this.render = render;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isFlying() {
		return flying;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public Animation getAnimation() {
		return animation;
	}
	
	public boolean canFly() {
		return canFly;
	}
	
	public boolean hasAnimation(){
		return animation != null;
	}
	
	public void setFlying(boolean flying) {
		this.flying = flying;
	}
	
	public void setAnimation(Animation animation) {
		this.animation = animation;
	}
	
	public void update(Vector3f v, Vector3f s){
		if(hasAnimation()) getAnimation().update();
	}
	
	public void render(){
		render.render(getLocation());
	}
}
