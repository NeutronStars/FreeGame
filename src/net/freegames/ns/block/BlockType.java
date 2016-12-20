package net.freegames.ns.block;

public enum BlockType {

	DIRT(1),
	GRASS(2),
	TEST(3);
	
	private int id;
	
	private BlockType(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
