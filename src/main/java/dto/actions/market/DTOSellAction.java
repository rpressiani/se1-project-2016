package dto.actions.market;

import java.util.ArrayList;
import java.util.Set;

import controller.VisitorActions;
import dto.actions.DTOAction;
import dto.utilities.DTOPermissionCard;
import model.actions.market.SellAction;
import model.player.Player;

public class DTOSellAction implements DTOAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7083999479569360792L;
	
	private final int sellCoins, buyCoins;
	private final int sellAssistants, buyAssistants;
	private final Set<DTOPermissionCard> sellPermissions, buyPermissions;
	private final ArrayList<Integer> sellPoliticals, buyPoliticals;

	/**
	 * @param sellCoins
	 * @param sellAssistants
	 * @param sellPermissions
	 * @param sellPoliticals
	 * @param buyCoins
	 * @param buyAssistants
	 * @param buyPermissions
	 * @param buyPoliticals
	 * @throws IllegalArgumentException if one of the int parameters is <0
	 * @throws NullPointerException if one of the other parameters is null
	 */
	public DTOSellAction(int sellCoins, int sellAssistants, Set<DTOPermissionCard> sellPermissions, ArrayList<Integer> sellPoliticals,
			int buyCoins, int buyAssistants, Set<DTOPermissionCard> buyPermissions, ArrayList<Integer> buyPoliticals) {
		if(sellCoins<0 || sellAssistants<0 || buyCoins<0 || buyAssistants<0) {
			throw new IllegalArgumentException("int parameters must all be >=0"); 
		}
		if(sellPermissions==null || sellPoliticals==null || buyPermissions==null || buyPoliticals==null) {
			throw new NullPointerException("the other parameters cannot be null"); 
		}
		this.sellCoins=sellCoins;
		this.sellAssistants=sellAssistants;
		this.sellPermissions=sellPermissions;
		this.sellPoliticals=sellPoliticals;
		
		this.buyCoins=buyCoins;
		this.buyAssistants=buyAssistants;
		this.buyPermissions=buyPermissions;
		this.buyPoliticals=buyPoliticals;
	}

	public int getBuyCoins() {
		return buyCoins;
	}

	public int getSellCoins() {
		return sellCoins;
	}

	public int getBuyAssistants() {
		return buyAssistants;
	}

	public int getSellAssistants() {
		return sellAssistants;
	}

	public Set<DTOPermissionCard> getSellPermissions() {
		return sellPermissions;
	}

	public Set<DTOPermissionCard> getBuyPermissions() {
		return buyPermissions;
	}

	public ArrayList<Integer> getBuyPoliticals() {
		return buyPoliticals;
	}

	public ArrayList<Integer> getSellPoliticals() {
		return sellPoliticals;
	}

	@Override
	public SellAction accept(VisitorActions v, Player player) {
		return v.visit(this, player);
	}
}
