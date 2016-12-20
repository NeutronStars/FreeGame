package net.freegames.ns.randering.entities;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex3f;

import net.freegames.ns.randering.Renderer;
import net.freegames.ns.render.Texture;
import net.freegames.ns.world.Location;

public class PlayerRenderer extends Renderer{

	public PlayerRenderer(Texture texture, float offSet, float envWidth, float envHeight) {
		super(texture, offSet, envWidth, envHeight);
	}

	@Override
	public void render(Location position) {
		/*//getTexture().bind();
		Location loc = new Location(position);
		genCube(loc, 0.3f, 0.2f, 0.5f);
		
		loc.setPostion(1.0f, 0.0f, 1.0f);
		genCube(loc, 0.3f, 0.2f, 0.5f);
		
		//getTexture().unBind();
	*/}
	
	private void genCube(Location pos, float w, float h, float y){
		glBegin(GL_QUADS);

		setCielData(pos.getX(), pos.getY(), pos.getZ(), w, h, 1);
		setFloorData(pos.getX(), pos.getY()+y, pos.getZ(), w, h, 1);
		
		setWallData(pos.getX(), pos.getY(), pos.getZ(),pos.getX(), pos.getY()+y, pos.getZ()+h, 1, 1);
		setWallData(pos.getX()+w, pos.getY(), pos.getZ(),pos.getX(), pos.getY()+y, pos.getZ(), 1, 2);
		setWallData(pos.getX()+w, pos.getY(), pos.getZ()+h, pos.getX()+w, pos.getY()+y, pos.getZ(), 1, 4);
		setWallData(pos.getX(), pos.getY(), pos.getZ()+h, pos.getX()+w, pos.getY()+y, pos.getZ()+h, 1, 5);
		
		glEnd();
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
	
	protected void setWallData(float x0, float y0, float z0, float x1, float y1, float z1, int nbT, int t){
		glColor3f(1.0f, 1.0f, 1.0f);
		
		float xo = t % (int) getEnvWidth();
		float yo = t / (int) getEnvHeigth();
		
		glTexCoord2f((0+xo)/ getEnvWidth() + getOffSet(), (0+yo)/ getEnvHeigth() + getOffSet()); glVertex3f(x0, y0, z0);
		glTexCoord2f((nbT+xo)/ getEnvWidth() - getOffSet(), (0+yo)/ getEnvHeigth() + getOffSet()); glVertex3f(x1, y0, z1);
		glTexCoord2f((nbT+xo)/ getEnvWidth() - getOffSet(), (nbT+yo)/ getEnvHeigth() - getOffSet()); glVertex3f(x1, y1, z1);
		glTexCoord2f((0+xo)/ getEnvWidth() + getOffSet(), (nbT+yo)/ getEnvHeigth() - getOffSet()); glVertex3f(x0, y1, z0);
		
	}

	
}
