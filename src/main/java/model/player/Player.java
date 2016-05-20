package model.player;

import java.util.HashSet;
import java.util.Set;

import utilities.Color;
import model.GameState;
import model.actions.MainAction;
import model.actions.NullAction;
import model.actions.QuickAction;
import model.bonusable.PermissionCard;
import model.map.City;
import model.politicalDeck.PoliticalHand;
import model.politicalDeck.PoliticalRealDeck;
import model.stateMachine.state.State;
import parser.Parser;

/**
 * @author Riccardo Pressiani
 *
 */
public class Player {
	
	private int id;
	private String nickname;
	private Coins coins;
	private NobilityLevel nobilityLevel;
	private Score score;
	private Assistants assistants;
	private Color color;
	private PoliticalHand politicalHand;
	private Set<PermissionCard> permissionHand;
	private Set<City> builtCities; 
	private State state;
	
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
		this.nobilityLevel = new NobilityLevel();
		this.score = new Score();
		this.builtCities = new HashSet<City>();
		this.permissionHand= new HashSet<PermissionCard>();
	}

	/**
	 * initPlayer conclude the setting of the player after he has joined a specific match. An ID is set, coins and assistants
	 * are set based on the content of the configuration file and the PoliticalHand of the player is instantiated.
	 * 
	 * @param deck							PoliticalRealDeck in use during the match
	 * @param id							the order of the players, it must start from 0 (zero)and be incremental (e.g 0, 1, 2, 3, ...)
	 * @param parser						Parser in use during the match
	 * 
	 * @throws IlleagalArgumentException	if id is lower of zero
	 */
	public void initPlayer(PoliticalRealDeck deck, Integer id, Parser parser) throws IllegalArgumentException {
		if (id < 0) throw new IllegalArgumentException("id must be grater than zero");
		
		this.id = id;	//as a player register to a match this ID attribute has to increment, basically it'll represent the order
						//of the players in a match
		this.politicalHand = new PoliticalHand(deck);
		this.coins = new Coins(parser.getCFGRoot().getPlayers().getPlayer().get(this.id).getCoins().intValue());
		this.assistants = new Assistants(parser.getCFGRoot().getPlayers().getPlayer().get(this.id).getAssistants().intValue());
	}
	
	public void move(MainAction action, GameState gameState){
		this.getState().transition(this, action, gameState);
	}
	
	public void move(QuickAction action, GameState gameState){
		this.getState().transition(this, action, gameState);
	}
	
	public void move(NullAction action, GameState gameState){
		this.getState().transition(this, action, gameState);
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
		return "Player [id=" + id + ", nickname=" + nickname + ", coins=" + coins + ", nobilityLevel=" + nobilityLevel
				+ ", score=" + score + ", assistants=" + assistants + ", color=" + color + ", politicalHand="
				+ politicalHand + "]";
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
	
	/**
	 * @return the cities where a player has already built at least one emporium
	 */
	public Set<City> getBuiltCities() {
		return builtCities; 
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the currentState
	 */
	public State getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}
}