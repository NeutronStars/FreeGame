package net.freegames.ns.render;

import static org.lwjgl.opengl.GL11.*;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

public class Fog {

	private final int gl_fog = GL_FOG;
	
	private boolean actived;
	
	public Fog(float density) {
		FloatBuffer fogColor = (FloatBuffer)BufferUtils.createFloatBuffer(4);
		fogColor.put(new float[]{0, 0, 0, 0.5f});
		fogColor.flip();
	
		glFogi(GL_FOG_MODE, GL_EXP);
		density(density);
		glFog(GL_FOG_COLOR, fogColor);
	}
	
	public boolean isActived() {
		return actived;
	}
	
	public void density(float density){
		glFogf(GL_FOG_DENSITY, density);
	}
	
	public void activedFog(){
		actived = true;
		glEnable(gl_fog);
	}
	
	public void desactivedFog(){
		actived = false;
		glDisable(gl_fog);
	}
}
