package model.actions.market;

import model.GameState;
import model.actions.GeneralAction;
import model.changes.ChangeMsg;
import model.market.Contract;
import model.market.Marketable;
import model.player.Assistants;
import model.player.Coins;
import model.player.Player;

public class BuyAction implements GeneralAction {

	private Contract contract;
	
	/**
	 * create the buy action
	 */
	public BuyAction() {
		
	}
	
	public BuyAction(Contract contract){
		this.contract=contract;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		gameState.getMarket().acceptContract(contract, player);
		
		gameState.notifyObserver(contract.getSeller(), new ChangeMsg(player.getNickname()+" accepted your contract"));
		gameState.notifyAllExceptPlayer(contract.getSeller(), new ChangeMsg(player.getNickname()+" accepted a contract from "+contract.getSeller().getNickname()));
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		if(contract==null){
			gameState.notifyObserver(player, new ChangeMsg(player.getNickname()+", the player you want to buy from has no contracts in the market or someone already accepted his contract"));
			return false;
		}
		
		Coins coins=null;
		for(Marketable m : contract.getBuyBag()){
			if(m instanceof Coins){
				coins=(Coins) m;
			}
		}
		if(player.getCoins().getItems()<coins.getItems()){
			gameState.notifyObserver(player, new ChangeMsg("You don't have enough coins to accept this contract"));
			return false;
		}
		
		Assistants assistants=null;
		for(Marketable m : contract.getBuyBag()){
			if(m instanceof Assistants){
				assistants=(Assistants) m;
			}
		}
		if(player.getAssistants().getItems()<assistants.getItems()){
			gameState.notifyObserver(player, new ChangeMsg("You don't have enough assistants to accept this contract"));
			return false;
		}
		
		for(Marketable m : contract.getBuyBag()){
			if(m instanceof Assistants){
				
			}
		}
		
		return true;
	}

}
