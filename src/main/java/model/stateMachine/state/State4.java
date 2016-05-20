package model.stateMachine.state;

import model.GameState;
import model.player.Player;

public class State4 implements State {
	
	public void checkTurn(Player player, GameState gameState){
		gameState.nextPlayer(player);
	}
	
	@Override
	public void printOut(Player player, State state){
		System.out.println(player.getNickname()+": "+"State4");
	}
	
}