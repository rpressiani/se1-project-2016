package actions;

import gameState.GameState;
import player.Player;

public abstract class QuickAction implements GeneralAction {
	
	public QuickAction(){
		
	}
	
	public QuickAction(MainAction action) {
		// TODO Auto-generated constructor stub
	}
	
	public boolean acceptMove(Player player){
		return true;
	}

	public void doAction(Player player, GameState gameState) {
		// TODO Auto-generated method stub
		
	}
}