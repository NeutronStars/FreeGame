package net.freegames.ns.maths;

public class Vector4f {

	private float x, y, z, w;
	
	public Vector4f() {
		this(0.0f, 0.0f, 0.0f, 0.0f);
	}
	
	public Vector4f(Vector4f vector) {
		this(vector.getX(), vector.getY(), vector.getZ(), vector.getW());
	}
	
	public Vector4f(float x, float y, float z, float w) {
		set(x, y, z, w);
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
	
	public float getW() {
		return w;
	}
	
	//***********************************************
	public Vector4f set(float x, float y, float z, float w){
		setX(x);
		setY(y);
		setZ(z);
		setW(w);
		return this;
	}
	
	public Vector4f set(Vector4f vector){
		set(vector.getX(), vector.getY(), vector.getZ(), vector.getW());
		return this;
	}
	
	public Vector4f setX(float x) {
		this.x = x;
		return this;
	}
	
	public Vector4f setY(float y) {
		this.y = y;
		return this;
	}
	
	public Vector4f setZ(float z) {
		this.z = z;
		return this;
	}
	
	public Vector4f setW(float w) {
		this.w = w;
		return this;
	}
	
	//***********************************************
	public Vector4f add(float x, float y, float z, float w){
		addX(x);
		addY(y);
		addZ(z);
		addW(w);
		return this;
	}
	
	public Vector4f add(Vector4f vector){
		add(vector.getX(), vector.getY(), vector.getZ(), vector.getW());
		return this;
	}
	
	public Vector4f addX(float x){
		this.x += x;
		return this;
	}
	
	public Vector4f addY(float y){
		this.y += y;
		return this;
	}
	
	public Vector4f addZ(float z){
		this.z += z;
		return this;
	}
	
	public Vector4f addW(float w){
		this.w += w;
		return this;
	}
	
	//***********************************************
	public Vector4f sub(float x, float y, float z, float w){
		subX(x);
		subY(y);
		subZ(z);
		subW(w);
		return this;
	}
	
	public Vector4f sub(Vector4f vector){
		sub(vector.getX(), vector.getY(), vector.getZ(), vector.getW());
		return this;
	}
	
	public Vector4f subX(float x){
		this.x -= x;
		return this;
	}
	
	public Vector4f subY(float y){
		this.y -= y;
		return this;
	}
	
	public Vector4f subZ(float z){
		this.z -= z;
		return this;
	}
	
	public Vector4f subW(float w){
		this.w -= w;
		return this;
	}
	
	//***********************************************
	public Vector4f mul(float x, float y, float z, float w){
		mulX(x);
		mulY(y);
		mulZ(z);
		mulW(w);
		return this;
	}
	
	public Vector4f mul(Vector4f vector){
		mul(vector.getX(), vector.getY(), vector.getZ(), vector.getW());
		return this;
	}
	
	public Vector4f mulX(float x){
		this.x *= x;
		return this;
	}
	
	public Vector4f mulY(float y){
		this.y *= y;
		return this;
	}
	
	public Vector4f mulZ(float z){
		this.z *= z;
		return this;
	}
	
	public Vector4f mulW(float w){
		this.w *= w;
		return this;
	}
	
	//***********************************************
	public Vector4f div(float x, float y, float z, float w){
		divX(x);
		divY(y);
		divZ(z);
		divW(w);
		return this;
	}
	
	public Vector4f div(Vector4f vector){
		div(vector.getX(), vector.getY(), vector.getZ(), vector.getW());
		return this;
	}
	
	public Vector4f divX(float x){
		this.x /= x;
		return this;
	}
	
	public Vector4f divY(float y){
		this.y /= y;
		return this;
	}
	
	public Vector4f divZ(float z){
		this.z /= z;
		return this;
	}
	
	public Vector4f divW(float w){
		this.w /= w;
		return this;
	}
	
	//***********************************************
}

