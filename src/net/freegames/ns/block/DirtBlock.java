package net.freegames.ns.block;

import net.freegames.ns.randering.block.BlockRender;
import net.freegames.ns.render.Textures;
import net.freegames.ns.world.Location;
import net.freegames.ns.world.World;

public class DirtBlock extends Block {

	public DirtBlock(World world, float x, float y, float z) {
		super("Dirt", new Location(world, x, y, z), BlockType.DIRT, new BlockRender(Textures.DIRT));
	}
}
