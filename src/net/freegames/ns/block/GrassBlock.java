package net.freegames.ns.block;

import net.freegames.ns.randering.block.BlockRender;
import net.freegames.ns.render.Textures;
import net.freegames.ns.world.Location;
import net.freegames.ns.world.World;

public class GrassBlock extends Block {

	public GrassBlock(World world, float x, float y, float z) {
		super("Grass", new Location(world, x, y, z), BlockType.GRASS, new BlockRender(Textures.GRASS));
	}

}
