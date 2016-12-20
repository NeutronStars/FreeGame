package net.freegames.ns.world;

import net.freegames.ns.maths.Vector3f;

public class Location {

	private float x, y, z;
	private World world;
	
	public Location(World world) {
		this(world, 0.0f, 0.0f, 0.0f);
	}
	
	public Location(Location location) {
		this(location.getWorld(), location.getX(), location.getY(), location.getZ());
	}
	
	public Location(World world, int x, int y, int z) {
		this(world, (float)x, (float)y, (float)z);
	}
	
	public Location(World world, float x, float y, float z) {
		setLocation(world, x, y, z);
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getZ() {
		return z;
	}
	
	public World getWorld() {
		return world;
	}
	
	//****************************************************
	public Location setLocation(World world, float x, float y, float z){
		setX(x);
		setY(y);
		setZ(z);
		setWorld(world);
		return this;
	}
	
	public Location setLocation(World world, int x, int y, int z){
		setLocation(world, (float)x, (float)y, (float)z);
		return this;
	}
	
	public Location setLocation(Location location){
		setLocation(location.getWorld(), location.getX(), location.getY(), location.getZ());
		return this;
	}
	
	public Location setPostion(float x, float y, float z){
		setLocation(getWorld(), x, y, z);
		return this;
	}
	
	public Location setPostion(int x, int y, int z){
		setLocation(getWorld(), (float)x, (float)y, (float)z);
		return this;
	}
	
	public Location setX(float x) {
		this.x = x;
		return this;
	}
	
	public Location setY(float y) {
		this.y = y;
		return this;
	}
	
	public Location setZ(float z) {
		this.z = z;
		return this;
	}
	
	public Location setWorld(World world){
		this.world = world;
		return this;
	}
	
	//******************************************************
	public Vector3f toVector3f(){
		return new Vector3f(x, y, z);
	}
}
