package model.stateMachine.state;

import model.GameState;
import model.actions.MainAction;
import model.player.Player;

public class State3 implements State {
	
	@Override
	public void transition(Player player, MainAction action, GameState gameState){
	
		if(action.acceptMove(player, gameState)==true){
			//action.doAction(player, gameState);
			System.out.println(player.getNickname()+" did a MainAction");
			player.setState(new State4());
			player.getState().checkTurn(player, gameState);
		}
		
	}
	
	@Override
	public void printOut(Player player, State state){
		System.out.println(player.getNickname()+": "+"State3");
	}

}
