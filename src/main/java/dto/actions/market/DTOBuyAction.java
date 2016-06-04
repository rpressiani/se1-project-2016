package dto.actions.market;

import controller.VisitorActions;
import dto.actions.DTOAction;
import model.actions.market.BuyAction;
import model.player.Player;

public class DTOBuyAction implements DTOAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4077745546664700273L;

	private final String playerName;
	
	public DTOBuyAction(String playerName){
		this.playerName=playerName;
	}

	public String getPlayerName() {
		return playerName;
	}
	
	@Override
	public BuyAction accept(VisitorActions v, Player player) {
		return v.visit(this);
	}

}
