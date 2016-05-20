package model.bonusItem;
import model.GameState;
import model.player.Player;

public class BonusAssistants implements BonusItem {
	private final int items;
	
	public BonusAssistants(int items) {
		this.items = items;
	}

	public void giveBonus(Player player, GameState gameState){
		player.getAssistants().add(items);
	}
}