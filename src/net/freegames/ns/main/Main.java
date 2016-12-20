package net.freegames.ns.main;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glViewport;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import net.freegames.ns.FreeGame;

public class Main{

	private boolean running;
	
	public Main() {
		try{
			Display.setDisplayMode(new DisplayMode(720, 480));
			Display.setTitle("FreeGame || -- FPS || -- TPS || X = ?? - Y = ?? - Z = ??");
			Display.setResizable(true);
			Display.create();
		
			FreeGame.glActived(GL_DEPTH_TEST, GL_CULL_FACE);
			//FreeGame.getFog().activedFog();
			
		}catch(LWJGLException ioe){
			ioe.printStackTrace();
		}
	}
	
	public void start(){
		running = true;
		run();
	}
	
	public void stop(){
		running = false;
	}
	
	public void close(){
		System.exit(0);
		Display.destroy();	
	}
	
	public void update(){
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) Mouse.setGrabbed(false);
		if(Mouse.isButtonDown(0)) Mouse.setGrabbed(true);
		if(!Mouse.isGrabbed()) return;
		FreeGame.getPlayer().getLocation().getWorld().update();
	}
	
	public void render(){
		if(Display.wasResized()) glViewport(0, 0, Display.getWidth(), Display.getHeight());
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		FreeGame.getPlayer().getLocation().getWorld().render();
	}
	
	public void run() {
		
		long lastTickTime = System.nanoTime();
		long lastRenderTime = System.nanoTime();
		double tickTime = 1000000000.0/60.0;
		double renderTime = 1000000000.0/FreeGame.getFrameCap();
		int tps = 0;
		int fps = 0;
		long timeur = System.currentTimeMillis();
		
		while(running){
			if(Display.isCloseRequested()) stop();
			
			if(System.nanoTime() -lastTickTime > tickTime){
				update();
				tps++;
				lastTickTime+=tickTime;
			}else if(System.nanoTime() -lastRenderTime > renderTime){
				render();
				Display.update();
				fps++;
				lastRenderTime+=renderTime;
			}else{
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if(System.currentTimeMillis() - timeur > 1000){
				timeur+=1000;
				FreeGame.setFPS(fps);
				FreeGame.setTPS(tps);
				tps = 0;
				fps = 0;
			}
			Display.setTitle("FreeGame || "+FreeGame.getFPS()+" FPS || "+FreeGame.getTPS()+" TPS || X = "+((int)FreeGame.getPlayer().getCamera().getPosition().getX())+" - Y = "+((int)FreeGame.getPlayer().getCamera().getPosition().getY())+" - Z = "+((int)FreeGame.getPlayer().getCamera().getPosition().getZ()));
		}
		close();
	}
	
	public static void main(String[] args) {
		new Main().start();
	}
}
