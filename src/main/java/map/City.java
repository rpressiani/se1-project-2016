package map;

import java.util.ArrayList;
import java.util.Set;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.Subgraph;
import org.jgrapht.Graph;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.ConnectivityInspector;

import bonusable.Bonusable;

import bonusItem.BonusItem;
import player.Player;

public class City extends Bonusable{
	private String name; 
	private Region region;
	private String ancestry;
	private boolean kingPresence;
	
	public City(String name, ArrayList<BonusItem> bonuses, String ancestry) {
		super(bonuses);
		this.name = name;
		this.region = null;
		this.ancestry = ancestry;
	}
	
	/**
	 * @return name of the city
	 */
	public String getName() {
		return name; 
	}
	
	/**
	 * @return name of the region
	 */
	public Region getRegion() {
		return region; 
	}
	
	/**
	 * @param player
	 * @return true if a player has built in a determined city
	 */
	public boolean hasBuiltHere(Player player) {
		return player.getBuiltCities().contains(this);
	}
	
	/**
	 * @return the kingPresence
	 */
	public boolean isKingPresence() {
		return kingPresence;
	}

	/**
	 * @param kingPresence the kingPresence to set
	 */
	public void setKingPresence(boolean kingPresence) {
		this.kingPresence = kingPresence;
	}
	
	/**
	 * @param map
	 * @param player
	 * @return all the connected cities where a player has built
	 */
	public Set<City> linkedCities(Map map, Player player) {
		Set<City> linkedCities = null;
		Subgraph sg = new Subgraph((UndirectedGraph<City, DefaultEdge>) map, player.getBuiltCities()); 
		ConnectivityInspector<City, DefaultEdge> inspector = new ConnectivityInspector<City, DefaultEdge>((UndirectedGraph<City, DefaultEdge>) sg);
		linkedCities = inspector.connectedSetOf(this); 
		return linkedCities; 
	}

	/**
	 * @return the ancestry
	 */
	public String getAncestry() {
		return ancestry;
	}

}
