package Game.GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Main.Handler;
import Resources.Images;
import UI.UIImageButton;
import UI.UIManager;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class GameOverState extends State {

    private int count = 0;
    private UIManager uiManager;
    private Graphics g;

    public GameOverState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);

//        uiManager.addObjects(new UIImageButton(56, 223, 128, 64, Images.Resume, () -> {
//            handler.getMouseManager().setUimanager(null);
//            State.setState(handler.getGame().gameState);
//        }));
//
        uiManager.addObjects(new UIImageButton(345, 223+(130+110), 128, 64, Images.butstart, () -> {
            handler.getMouseManager().setUimanager(null);
            handler.getGame().reStart();
            State.setState(handler.getGame().gameState);
        }));

        
//        uiManager.addObjects(new UIImageButton(310, (223+(110+110))+(64+16), 200, 64, Images.BTitle, () -> {
//            handler.getMouseManager().setUimanager(null);
//            State.setState(handler.getGame().menuState);
//
//            
//        }));


        
// Turned off the menu in Game Over & added start button in Game Over to restart the game 


    }

    @Override
    public void tick() {
        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();
        count++;
        if( count>=30){
            count=30;
        }
        if(handler.getKeyManager().pbutt && count>=30){
            count=0;

            State.setState(handler.getGame().gameState);
        }


    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.GameOver,0,0,800,600,null);
        uiManager.Render(g);
    }
}
