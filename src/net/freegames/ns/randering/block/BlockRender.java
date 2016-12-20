package net.freegames.ns.randering.block;

import static org.lwjgl.opengl.GL11.*;

import net.freegames.ns.randering.Renderer;
import net.freegames.ns.render.Texture;
import net.freegames.ns.world.Location;

public class BlockRender extends Renderer {

	public BlockRender(Texture texture) {
		super(texture, 0.0f, 6.0f, 1.0f);
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
		
		float xo = 0 % (int)getEnvWidth();
		float yo = 0 / (int)getEnvHeigth();
		
		glTexCoord2f((0+xo)/ getEnvWidth() + getOffSet(), (0+yo)/ getEnvHeigth() + getOffSet()); glVertex3f(x+l, y, z);
		glTexCoord2f((nbT+xo)/ getEnvWidth() - getOffSet(), (0+yo)/ getEnvHeigth() + getOffSet()); glVertex3f(x, y, z);
		glTexCoord2f((nbT+xo)/ getEnvWidth() - getOffSet(), (nbT+yo)/ getEnvHeigth() - getOffSet()); glVertex3f(x, y, z+la);
		glTexCoord2f((0+xo)/ getEnvWidth() + getOffSet(), (nbT+yo)/ getEnvHeigth() - getOffSet()); glVertex3f(x+l, y, z+la);
	}
	
	protected void setCielData(float x, float y, float z, float l, float la, int nbT){
		glColor3f(1.0f, 1.0f, 1.0f);
		
		float xo = 3 % (int)getEnvWidth();
		float yo = 3 / (int)getEnvHeigth();
		
		glTexCoord2f((0+xo)/ getEnvWidth() + getOffSet(), (0+yo)/ getEnvHeigth() + getOffSet()); glVertex3f(x, y, z);
		glTexCoord2f((nbT+xo)/ getEnvWidth() - getOffSet(), (0+yo)/ getEnvHeigth() + getOffSet()); glVertex3f(x+l, y, z);
		glTexCoord2f((nbT+xo)/ getEnvWidth() - getOffSet(), (nbT+yo)/ getEnvHeigth() - getOffSet()); glVertex3f(x+l, y, z+la);
		glTexCoord2f((0+xo)/ getEnvWidth() + getOffSet(), (nbT+yo)/ getEnvHeigth() - getOffSet()); glVertex3f(x, y, z+la);
	}
	
	protected void setWallData(float x0, float y0, float z0, float x1, float y1, float z1, float l, float la, int nbT, int t){
		glColor3f(1.0f, 1.0f, 1.0f);
		
		float xo = t % (int) getEnvWidth();
		float yo = t / (int) getEnvHeigth();
		
		glTexCoord2f((0+xo)/ getEnvWidth() + getOffSet(), (0+yo)/ getEnvHeigth() + getOffSet()); glVertex3f(x0, y0, z0);
		glTexCoord2f((nbT+xo)/ getEnvWidth() - getOffSet(), (0+yo)/ getEnvHeigth() + getOffSet()); glVertex3f(x1, y0, z1);
		glTexCoord2f((nbT+xo)/ getEnvWidth() - getOffSet(), (nbT+yo)/ getEnvHeigth() - getOffSet()); glVertex3f(x1, y1, z1);
		glTexCoord2f((0+xo)/ getEnvWidth() + getOffSet(), (nbT+yo)/ getEnvHeigth() - getOffSet()); glVertex3f(x0, y1, z0);
		
	}
}
