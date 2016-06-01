package model.actions.main;

import model.GameState;
import model.bonusable.PermissionCard;
import model.council.Balcony;
import model.map.Region;
import model.player.Player;
import model.politicalDeck.PoliticalCard;
import model.politicalDeck.PoliticalContainer;
import model.politicalDeck.PoliticalHand;

public class BuyPermissionCard implements MainAction {
	
	private Region region;
	private PoliticalContainer proposal;
	private int index;

	//temporary for ClientLogic
	public BuyPermissionCard(){
		
	}
	
	public BuyPermissionCard(Region region, PoliticalContainer proposal, int index) {
		this.region=region;
		this.proposal=proposal;
		this.index=index;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		int numCards, sumToPay, sumJolly;
		int size=player.getPoliticalHand().getDeck().size();
		PermissionCard drawedCard;
		
		numCards=calculateNumCards(proposal);
		
		if(numCards==1) sumToPay=10;
		else if(numCards==2) sumToPay=7;
		else if(numCards==3) sumToPay=4;
		else sumToPay=0;
			
		sumJolly=(player.getPoliticalHand().getDeck().get(size).getNumCards());
		sumToPay=sumToPay+sumJolly;
			
		player.getCoins().sub(sumToPay);
		drawedCard=region.getPermissionDeck().drawCard(region.getPermissionDeck().getDeck(), region.getPermissionDeck().getVisibleCards(), index);
		drawedCard.assignBonuses(player, gameState);
		player.getPermissionHand().add(drawedCard);
	}
	
	public boolean checkProposal(PoliticalContainer proposal, Balcony balcony){
		
		int sum=calculateNumCards(proposal);
		
		if (sum>=balcony.getnCounsellorsPerBalcony() && sum!=0) return false;
		
		else{
			for(int i=0; i<proposal.getDeck().size()-1; i++){
				if(proposal.getDeck().get(i).getNumCards() > balcony.getBalconyState().getState().get(i).getCounter()) return false;
			}
		}
		
		return true;
	}
	
	public int calculateNumCards(PoliticalContainer proposal){
		int sum=0;
		
		for(PoliticalCard card : proposal.getDeck()){
			sum=sum+card.getNumCards();
		}
		
		return sum;
	}
	
	public void subProposal(PoliticalHand hand, PoliticalContainer proposal){
		for(int i=0; i<hand.getDeck().size(); i++){
			hand.getDeck().get(i).removeCards(proposal.getDeck().get(i).getNumCards());
		}
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		
		if(checkProposal(proposal, region.getBalcony())==false) return false;
		
		int sumToPay=0;
		int size=player.getPoliticalHand().getDeck().size();
		int numCards=calculateNumCards(proposal);
		int sumJolly=(player.getPoliticalHand().getDeck().get(size).getNumCards());
		
		if(numCards==1) sumToPay=10;
		else if(numCards==2) sumToPay=7;
		else if(numCards==3) sumToPay=4;
		
		sumToPay=sumToPay+sumJolly;
		
		if(sumToPay>player.getCoins().getItems()) return false;
		
		else return true;
	}
	
}
