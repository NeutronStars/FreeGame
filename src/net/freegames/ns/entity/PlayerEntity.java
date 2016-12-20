package net.freegames.ns.entity;

import org.lwjgl.input.Keyboard;

import net.freegames.ns.FreeGame;
import net.freegames.ns.maths.Vector3f;
import net.freegames.ns.randering.entities.PlayerRenderer;
import net.freegames.ns.render.Camera;
import net.freegames.ns.world.Location;

public class PlayerEntity extends Entity{

	private float speedFall = 0.08f;
	private Camera camera;
	
	public PlayerEntity(Location location) {
		super("Player", true, location, new PlayerRenderer(null, 0.0f, 6.0f, 1.0f));
		super.setFlying(true);
		camera = new Camera(location, 0.1F, 500.0F, 70.0F);
	}
	
	public Camera getCamera() {
		return camera;
	}
	
	@Override
	public void update(Vector3f v, Vector3f s) {
	
		Vector3f position = new Vector3f(getCamera().getPosition().toVector3f());
		
		if(Keyboard.isKeyDown(Keyboard.KEY_UP) || Keyboard.isKeyDown(Keyboard.KEY_Z)) position.add(getCamera().getDirectionLook(90.0F).mul(new Vector3f(-FreeGame.getSpeed(), -FreeGame.getSpeed(), -FreeGame.getSpeed())));
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN) || Keyboard.isKeyDown(Keyboard.KEY_S)) position.add(getCamera().getDirectionLook(90.0f).mul(new Vector3f(FreeGame.getSpeed(), FreeGame.getSpeed(), FreeGame.getSpeed())));
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT) || Keyboard.isKeyDown(Keyboard.KEY_Q)) position.add(getCamera().getDirectionLook(0.0F).mul(new Vector3f(-FreeGame.getSpeed(), -FreeGame.getSpeed(), -FreeGame.getSpeed())));
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT) || Keyboard.isKeyDown(Keyboard.KEY_D)) position.add(getCamera().getDirectionLook(0.0F).mul(new Vector3f(FreeGame.getSpeed(), FreeGame.getSpeed(), FreeGame.getSpeed())));
		
//		position = new Vector3f(FreeGame.getCamera().getPosition());
		
		if(isFlying()){
			if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) position.addY(FreeGame.getSpeed()*4);
			if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) position.addY(-FreeGame.getSpeed()*4);
		}else{
			position.addY(-speedFall);
		}
		
		getCamera().getPosition().setLocation(position.toLocation(getLocation().getWorld()));
//		if(!phys.intersect(position, v, s)){
//			FreeGame.getCamera().getPosition().set(position);
//			speedFall+=0.02f;
//		}else{
//			speedFall = 0.08f;
//		}
	}

}
