package net.freegames.ns.maths;

import net.freegames.ns.world.Location;
import net.freegames.ns.world.World;

public class Vector3f {

	private float x, y, z;
	
	public Vector3f() {
		this(0.0f, 0.0f, 0.0f);
	}
	
	public Vector3f(Vector3f vector) {
		this(vector.getX(), vector.getY(), vector.getZ());
	}
	
	public Vector3f(float x, float y, float z) {
		set(x, y, z);
	}
	
	//***********************************************
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getZ() {
		return z;
	}
	
	//***********************************************
	public Vector3f set(float x, float y, float z){
		setX(x);
		setY(y);
		setZ(z);
		return this;
	}
	
	public Vector3f set(Vector3f vector){
		set(vector.getX(), vector.getY(), vector.getZ());
		return this;
	}
	
	public Vector3f setX(float x) {
		this.x = x;
		return this;
	}
	
	public Vector3f setY(float y) {
		this.y = y;
		return this;
	}
	
	public Vector3f setZ(float z) {
		this.z = z;
		return this;
	}
	
	//***********************************************
	public Vector3f add(float x, float y, float z){
		addX(x);
		addY(y);
		addZ(z);
		return this;
	}
	
	public Vector3f add(Vector3f vector){
		add(vector.getX(), vector.getY(), vector.getZ());
		return this;
	}
	
	public Vector3f addX(float x){
		this.x += x;
		return this;
	}
	
	public Vector3f addY(float y){
		this.y += y;
		return this;
	}
	
	public Vector3f addZ(float z){
		this.z += z;
		return this;
	}
	
	//***********************************************
	public Vector3f sub(float x, float y, float z){
		subX(x);
		subY(y);
		subZ(z);
		return this;
	}
	
	public Vector3f sub(Vector3f vector){
		sub(vector.getX(), vector.getY(), vector.getZ());
		return this;
	}
	
	public Vector3f subX(float x){
		this.x -= x;
		return this;
	}
	
	public Vector3f subY(float y){
		this.y -= y;
		return this;
	}
	
	public Vector3f subZ(float z){
		this.z -= z;
		return this;
	}
	
	//***********************************************
	public Vector3f mul(float x, float y, float z){
		mulX(x);
		mulY(y);
		mulZ(z);
		return this;
	}
	
	public Vector3f mul(Vector3f vector){
		mul(vector.getX(), vector.getY(), vector.getZ());
		return this;
	}
	
	public Vector3f mulX(float x){
		this.x *= x;
		return this;
	}
	
	public Vector3f mulY(float y){
		this.y *= y;
		return this;
	}
	
	public Vector3f mulZ(float z){
		this.z *= z;
		return this;
	}
	
	//***********************************************
	public Vector3f div(float x, float y, float z){
		divX(x);
		divY(y);
		divZ(z);
		return this;
	}
	
	public Vector3f div(Vector3f vector){
		div(vector.getX(), vector.getY(), vector.getZ());
		return this;
	}
	
	public Vector3f divX(float x){
		this.x /= x;
		return this;
	}
	
	public Vector3f divY(float y){
		this.y /= y;
		return this;
	}
	
	public Vector3f divZ(float z){
		this.z /= z;
		return this;
	}
	
	//***********************************************
	public Location toLocation(World world){
		return new Location(world, x, y, z);
	}
}
