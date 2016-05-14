package player;

import java.util.HashSet;
import java.util.Set;

import utilities.Color;
import politicalDeck.PoliticalHand;
import politicalDeck.PoliticalRealDeck;
import bonusable.PermissionCard;
import map.City;

/**
 * @author Riccardo Pressiani
 *
 */
public class Player {
	
	private String nickname;
	private Coins coins;
	private NobilityLevel nobilityLevel;
	private Score score;
	private Assistants assistants;
	private Color color;
	private PoliticalHand politicalHand;
	private Set<PermissionCard> permissionHand;
	private Set<City> builtCities; 
	
	/**
	 * Constructor
	 * Set nickname, color, hand and create the other objects.
	 * 
	 * @param nickname	nickname chosen by the player
	 * @param color		color chosen by the player
	 */
	public Player(String nickname, Color color) {
		this.nickname = nickname;
		this.color = color;
		this.builtCities = new HashSet<City>();
		this.permissionHand= new HashSet<PermissionCard>();
	}
	
	public void initPlayer(PoliticalRealDeck deck){
		this.politicalHand = new PoliticalHand(deck);
		this.coins = new Coins();
		this.nobilityLevel = new NobilityLevel();
		this.score = new Score();
		this.assistants = new Assistants();
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @return the coins
	 */
	public Coins getCoins(){
		return coins;
	}
	
	/**
	 * @return the nobility
	 */
	public NobilityLevel getNobilityLevel() {
		return nobilityLevel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return nickname;
	}

	/**
	 * @return the score
	 */
	public Score getScore() {
		return score;
	}

	/**
	 * @return the assistants
	 */
	public Assistants getAssistants() {
		return assistants;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @return the hand
	 */
	public PoliticalHand getPoliticalHand() {
		return politicalHand;
	}

	/**
	 * @return the permissionHand
	 */
	public Set<PermissionCard> getPermissionHand() {
		return permissionHand;
	}
	
	public Set<City> getBuiltCities() {
		return builtCities; 
	}

}
