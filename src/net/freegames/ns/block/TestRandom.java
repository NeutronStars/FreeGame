package net.freegames.ns.block;

import net.freegames.ns.randering.block.BlockAnimationRender;
import net.freegames.ns.render.Animation;
import net.freegames.ns.render.Animation.ModeAnimation;
import net.freegames.ns.render.Textures;
import net.freegames.ns.world.Location;

public class TestRandom extends Block {

	public TestRandom(Location position) {
		super("test", position, BlockType.TEST, new BlockAnimationRender(Textures.TESTRANDOM, new Animation(10, 6, ModeAnimation.RANDOM_FRAME)));
		((BlockAnimationRender)getRenderer()).getAnimation().start();
	}

	@Override
	public void update() {
		((BlockAnimationRender)getRenderer()).getAnimation().update();
	}
}
