package net.freegames.ns.randering.block;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex3f;

import net.freegames.ns.randering.Renderer;
import net.freegames.ns.render.Animation;
import net.freegames.ns.render.Texture;
import net.freegames.ns.world.Location;

public class BlockAnimationRender extends Renderer{

	private final Animation animation;
	
	public BlockAnimationRender(Texture texture, Animation animation) {
		super(texture, 0.0f, 6.0f, 1.0f);
		this.animation = animation;
	}
	
	public Animation getAnimation() {
		return animation;
	}
	
	@Override
	public void render(Location pos) {
		getTexture().bind();
		
		glBegin(GL_QUADS);
		
		setCielData(pos.getX(), pos.getY(), pos.getZ(), 1, 1, 1);
		setFloorData(pos.getX(), pos.getY()+1, pos.getZ(), 1, 1, 1);
		
		setWallData(pos.getX(), pos.getY(), pos.getZ(),pos.getX(), pos.getY()+1, pos.getZ()+1, 1, 1, 1, 1);
		setWallData(pos.getX()+1, pos.getY(), pos.getZ(),pos.getX(), pos.getY()+1, pos.getZ(), 1, 1, 1, 2);
		setWallData(pos.getX()+1, pos.getY(), pos.getZ()+1,pos.getX()+1, pos.getY()+1, pos.getZ(), 1, 1, 1, 4);
		setWallData(pos.getX(), pos.getY(), pos.getZ()+1,pos.getX()+1, pos.getY()+1, pos.getZ()+1, 1, 1, 1, 5);
	
		glEnd();
		
		getTexture().unBind();
	}
	
	protected void setFloorData(float x, float y, float z, float l, float la, int nbT){
		glColor3f(1.0f, 1.0f, 1.0f);
		
		float xo = getAnimation().getFrame() % (int)getEnvWidth();
		float yo = getAnimation().getFrame() / (int)getEnvHeigth();
		
		glTexCoord2f((0+xo)/ getEnvWidth() + getOffSet(), (0+yo)/ getEnvHeigth() + getOffSet()); glVertex3f(x+l, y, z);
		glTexCoord2f((nbT+xo)/ getEnvWidth() - getOffSet(), (0+yo)/ getEnvHeigth() + getOffSet()); glVertex3f(x, y, z);
		glTexCoord2f((nbT+xo)/ getEnvWidth() - getOffSet(), (nbT+yo)/ getEnvHeigth() - getOffSet()); glVertex3f(x, y, z+la);
		glTexCoord2f((0+xo)/ getEnvWidth() + getOffSet(), (nbT+yo)/ getEnvHeigth() - getOffSet()); glVertex3f(x+l, y, z+la);
	}
	
	protected void setCielData(float x, float y, float z, float l, float la, int nbT){
		glColor3f(1.0f, 1.0f, 1.0f);
		
		float xo = getAnimation().getFrame() % (int)getEnvWidth();
		float yo = getAnimation().getFrame() / (int)getEnvHeigth();
		
		glTexCoord2f((0+xo)/ getEnvWidth() + getOffSet(), (0+yo)/ getEnvHeigth() + getOffSet()); glVertex3f(x, y, z);
		glTexCoord2f((nbT+xo)/ getEnvWidth() - getOffSet(), (0+yo)/ getEnvHeigth() + getOffSet()); glVertex3f(x+l, y, z);
		glTexCoord2f((nbT+xo)/ getEnvWidth() - getOffSet(), (nbT+yo)/ getEnvHeigth() - getOffSet()); glVertex3f(x+l, y, z+la);
		glTexCoord2f((0+xo)/ getEnvWidth() + getOffSet(), (nbT+yo)/ getEnvHeigth() - getOffSet()); glVertex3f(x, y, z+la);
	}
	
	protected void setWallData(float x0, float y0, float z0, float x1, float y1, float z1, float l, float la, int nbT, int t){
		glColor3f(1.0f, 1.0f, 1.0f);
		
		float xo = getAnimation().getFrame() % (int) getEnvWidth();
		float yo = getAnimation().getFrame() / (int) getEnvHeigth();
		
		glTexCoord2f((0+xo)/ getEnvWidth() + getOffSet(), (0+yo)/ getEnvHeigth() + getOffSet()); glVertex3f(x0, y0, z0);
		glTexCoord2f((nbT+xo)/ getEnvWidth() - getOffSet(), (0+yo)/ getEnvHeigth() + getOffSet()); glVertex3f(x1, y0, z1);
		glTexCoord2f((nbT+xo)/ getEnvWidth() - getOffSet(), (nbT+yo)/ getEnvHeigth() - getOffSet()); glVertex3f(x1, y1, z1);
		glTexCoord2f((0+xo)/ getEnvWidth() + getOffSet(), (nbT+yo)/ getEnvHeigth() - getOffSet()); glVertex3f(x0, y1, z0);
		
	}
}
