package Game.Entities.Static;

import Main.Handler;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class Apple {

	private Handler handler;

	public int xCoord;
	public int yCoord;

	public Apple(Handler handler,int x, int y){
		this.handler=handler;
		this.xCoord=x;
		this.yCoord=y;
	}

	// Method that return true if the apple is good, otherwise return false.
	public boolean isGood() {
		
		if (handler.getWorld().player.xCoord >= 20)
			return false;
		else	
			return true;
	}
}
