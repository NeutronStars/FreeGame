package net.freegames.ns;

import static org.lwjgl.opengl.GL11.glEnable;

import java.util.Random;

import net.freegames.ns.entity.PlayerEntity;
import net.freegames.ns.render.Fog;
import net.freegames.ns.world.Location;
import net.freegames.ns.world.World;

public final class FreeGame {

	private final static Fog fog = new Fog(0.03f);
	private final static PlayerEntity player = new PlayerEntity(new Location(new World("test"), 10.0f, 5.0f, 10.0f));
	private static float sensibility = 0.08f, speed = 0.1f, frame_cap = 5000.0f;
	private static int fps = 0, tps = 0;
	private static final Random random = new Random();
	
	private static int maxChunckLoading = 5;
	
	public static Fog getFog() {
		return fog;
	}
	
	public static float getSensibility() {
		return sensibility;
	}
	
	public static PlayerEntity getPlayer() {
		return player;
	}
	
	public static int getMaxChunckLoading() {
		return maxChunckLoading;
	}
	
	public static float getSpeed() {
		return speed;
	}
	
	public static float getFrameCap() {
		return frame_cap;
	}
	
	public static int getFPS() {
		return fps;
	}
	
	public static int getTPS() {
		return tps;
	}
	
	public static void setFPS(int fps) {
		FreeGame.fps = fps;
	}
	
	public static void setTPS(int tps) {
		FreeGame.tps = tps;
	}
	
	public static void glActived(int... index){
		for(int i : index) glEnable(i);
	}
	
	public static void glDisable(int... index){
		for(int i : index) glDisable(i);
	}
	
	public static int getIntRandom(int index){
		return random.nextInt(index);
	}
}
