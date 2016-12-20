package net.freegames.ns.world;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.freegames.ns.FreeGame;
import net.freegames.ns.entity.Entity;
import net.freegames.ns.maths.Vector3f;
import net.freegames.ns.randering.Renderer;
import net.freegames.ns.randering.world.WorldRenderer;

public class World {

	private final String name;
	private final Renderer render = new WorldRenderer();
	private final Map<Location, Chunck> chuncks = new HashMap<>();
	private final List<Entity> entities = new ArrayList<>();
	
	public World(String name) {
		this.name = name;
		genWorld();
	}
	
	private void genWorld(){
		Location loc = new Location(this, 0, 0, 0);
		chuncks.put(loc, new Chunck(loc));
	}
	
	public String getName() {
		return name;
	}
	
	public Set<Entry<Location, Chunck>> getChuncks(){
		return chuncks.entrySet();
	}
	
	public Collection<? extends Entity> getEntities(){
		return entities;
	}
	
	public void spawnEntity(Entity entity){
		entities.add(entity);
	}
	
	public void dispawnEntity(Entity entity){
		entities.remove(entity);
	}
	
	public void update(){
		FreeGame.getPlayer().getCamera().input();
		FreeGame.getPlayer().update(new Vector3f(0.0f, 0.0f, 0.0f), new Vector3f(50.0f, 0.1f, 50.0f));
		for(Entry<Location, Chunck> chunck : getChuncks()) chunck.getValue().update();
	}
	
	public void render(){
		FreeGame.getPlayer().getCamera().update();
		render.render(null);
		for(Entry<Location, Chunck> chunck : getChuncks()) chunck.getValue().render();
	}
}
