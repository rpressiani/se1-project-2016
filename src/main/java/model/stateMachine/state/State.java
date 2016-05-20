package model.stateMachine.state;

import model.GameState;
import model.actions.MainAction;
import model.actions.NullAction;
import model.actions.QuickAction;
import model.player.Player;

public interface State {
	
	public default void transition(Player player, MainAction action, GameState gameState){
		System.out.println("You can't do a MainAction now");
		player.setState(this);
	}
	
	public default void transition(Player player, QuickAction action, GameState gameState){
		System.out.println("You can't do a QuickAction now");
		player.setState(this);
	}
	
	public default void transition(Player player, NullAction action, GameState gameState){
		System.out.println("You can't do a NullAction now");
		player.setState(this);
	}
	
	public default void checkTurn(Player player, GameState gameState){
		
	}
	
	public void printOut(Player player, State state);
}