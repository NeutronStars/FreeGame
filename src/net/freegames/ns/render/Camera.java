package net.freegames.ns.render;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_TRANSFORM_BIT;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushAttrib;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.glu.GLU;

import net.freegames.ns.FreeGame;
import net.freegames.ns.maths.Vector3f;
import net.freegames.ns.world.Location;

public class Camera {

	private float zNear, zFar, fov;
	
	private Location position;
	private Vector3f rotation;
	
	public Camera(Location position, float zNear, float zFar, float fov) {
		this.position = position;
		rotation = new Vector3f();
		setPerspectiveProjection(zNear, zFar, fov);
	}
	
	public Location getPosition() {
		return position;
	}
	
	public void setPosition(Location position) {
		this.position = position;
	}
	
	private void setPerspectiveProjection(float zNear, float zFar, float fov){
		this.zNear = zNear;
		this.zFar = zFar;
		this.fov = fov;
	}
	
	private void getPerspectiveProjection(){
		FreeGame.glActived(GL_PROJECTION, GL_MODELVIEW);
		glLoadIdentity();
		GLU.gluPerspective(fov, (float)Display.getWidth()/(float)Display.getHeight(), zNear, zFar);
	}
	
	public Vector3f getDirectionLook(float y){
		float cosY = (float) Math.cos(Math.toRadians(rotation.getY()+y));
		float sinY = (float) Math.sin(Math.toRadians(rotation.getY()+y));
		return new Vector3f(cosY, 0.0f, sinY);	
	}
	
	public void update(){
		getPerspectiveProjection();
		
		glPushAttrib(GL_TRANSFORM_BIT);
			glRotatef(rotation.getX(), 1, 0, 0);
			glRotatef(rotation.getY(), 0, 1, 0);
			glRotatef(rotation.getZ(), 0, 0, 1);
			glTranslatef(-position.getX(), -position.getY(), -position.getZ());
		glPopMatrix();
	}
	
	public void input(){
		rotation.addX(-Mouse.getDY()*FreeGame.getSensibility());
		rotation.addY(Mouse.getDX()*FreeGame.getSensibility());
		
		if(rotation.getX() > 90) rotation.setX(90);
		if(rotation.getX() < -90) rotation.setX(-90);
	}
}
