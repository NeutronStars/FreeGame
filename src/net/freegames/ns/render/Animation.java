package net.freegames.ns.render;

import net.freegames.ns.FreeGame;

public class Animation {

	private final int speed, maxFrame;
	private final ModeAnimation mode;
	
	private int frame, time;
	private boolean start, back;
	
	public Animation(int speed, int maxFrame, ModeAnimation mode) {
		this.speed = speed;
		this.maxFrame = maxFrame;
		this.mode = mode;
	}
	
	public int getFrame(){
		return frame;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getTime() {
		return time;
	}
	
	public int getMaxFrame() {
		return maxFrame;
	}
	
	public ModeAnimation getModeAnimation() {
		return mode;
	}
	
	public boolean isStart() {
		return start;
	}
	
	public void start(){
		start = true;
	}
	
	public void pause(){
		start = false;
	}
	
	public void stop(){
		start = false;
		frame = 0;
		time = 0;
	}
	
	public void update(){
		if(!isStart()) return;
		if(time < speed) time++;
		else{
			switch (getModeAnimation()) {
				case FRAME_COME_BACK:
					if(back){
						frame--;
						if(getFrame() < 0){
							frame = 0;
							back = false;
						}
					}else{
						frame++;
						if(getFrame() >= getMaxFrame()){
							frame = getMaxFrame()-1;
							back = true;
						}
					}
					break;
				case FRAME_NORMAL:
					frame++;
					if(getFrame() >= getMaxFrame()) frame = 0;
					break;
				case RANDOM_FRAME:
					frame = FreeGame.getIntRandom(getMaxFrame());
					break;
			}
			time = 0;
		}
	}
	
	public enum ModeAnimation{
		RANDOM_FRAME, FRAME_NORMAL, FRAME_COME_BACK;
	}
}
