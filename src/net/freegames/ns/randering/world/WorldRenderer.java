package net.freegames.ns.randering.world;

import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex3f;

import net.freegames.ns.randering.Renderer;
import net.freegames.ns.render.Textures;
import net.freegames.ns.world.Location;

public class WorldRenderer extends Renderer{
	
	public WorldRenderer() {
		super(Textures.TEXTURE, 0.0f, 50.0f, 50.0f);
	}
	
	@Override
	public void render(Location postion) {
		renderFond();
	}
	
	protected void setFloorData(float x, float y, float z, float l, float la, int nbT){
		glColor3f(1.0f, 1.0f, 1.0f);
		
		float xo = 0 % (int)getEnvWidth();
		float yo = 0 / (int)getEnvHeigth();
		
		glTexCoord2f((0+xo)/ getEnvWidth() + getOffSet(), (0+yo)/ getEnvHeigth() + getOffSet()); glVertex3f(x+l, y, z);
		glTexCoord2f((nbT+xo)/ getEnvWidth() - getOffSet(), (0+yo)/ getEnvHeigth() + getOffSet()); glVertex3f(x, y, z);
		glTexCoord2f((nbT+xo)/ getEnvWidth() - getOffSet(), (nbT+yo)/ getEnvHeigth() - getOffSet()); glVertex3f(x, y, z+la);
		glTexCoord2f((0+xo)/ getEnvWidth() + getOffSet(), (nbT+yo)/ getEnvHeigth() - getOffSet()); glVertex3f(x+l, y, z+la);
	}
	
	private float time = 1.0f;
//	private boolean croi;
//	private int timer = 0;
	
	private void renderFond(){
		glClearColor(0.0f, time-0.1f, time, 1.0f);
		//setTime();
	}
	/*
	private void setTime(){
		timer++;
		
		if(croi){
			if(timer == 1000){
				time+=0.01f;
				timer = 0;
			}
		}else{
			if(timer == 1000){
				time-=0.01f;
				timer = 0;
			}
		}
		
		if(time < 0.0f) croi = true;
		if(time > 1.0f) croi = false;
	}*/
}
