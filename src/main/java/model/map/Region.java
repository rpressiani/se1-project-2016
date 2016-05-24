package model.map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import jaxb.CFGCity;
import jaxb.CFGRegion;
import model.bonusItem.BonusItem;
import model.bonusable.RegionCard;
import model.council.Balcony;
import model.council.GarbageState;
import model.sharedObjects.PermissionDeck;
import parser.Parser;

/**
 * @author Alessandro Pezzotta
 *
 */
public class Region {
	private String name;
	private PermissionDeck permissionDeck;
	private Balcony balcony;
	private Set<City> regionCities;
	private RegionCard regionBonus;
	
	/**
	 * @param name
	 * @param garbage
	 * @param parser
	 * @param map
	 * constructor for object Region
	 */
	public Region(String name, GarbageState garbage, Parser parser, Map map){
		this.name = name;
		this.balcony = new Balcony(garbage, parser);
		
		this.regionCities = new HashSet<City>();
		Set<City> allCities = map.allVertexes();
		List<CFGRegion> cfgRegions = parser.getCFGRoot().getMap().getRegion();
		CFGRegion cfgRegion = new CFGRegion();
		for (Iterator<CFGRegion> iterator = cfgRegions.iterator(); iterator.hasNext();) {
			cfgRegion = iterator.next();
			if (cfgRegion.getName() == this.name) {
				break;
			}
		}
		
		for (Iterator<CFGCity> iteratorRegionCity = cfgRegion.getCities().getCity().iterator(); iteratorRegionCity.hasNext();) {
			
			String cityString =  iteratorRegionCity.next().getName();
			for (Iterator<City> iteratorAllCities = allCities.iterator(); iteratorAllCities.hasNext();) {
				City cityToAdd = iteratorAllCities.next(); 
				if (cityToAdd.getName() == cityString) {
					this.regionCities.add(cityToAdd);
					cityToAdd.setRegion(this);
					break;
				}
			}
		}
		
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>();
		bonuses = parser.getBonusesFromParser(cfgRegion.getBonuses().getBonus());
		
		this.regionBonus = new RegionCard(bonuses, this);
		this.permissionDeck = new PermissionDeck(parser, this);
	}
	
	/**
	 * @return the permissionDeck
	 */
	public PermissionDeck getPermissionDeck() {
		return permissionDeck;
	}
	
	/**
	 * @return the balcony
	 */
	public Balcony getBalcony() {
		return balcony;
	}

	/**
	 * @return the regionCities
	 */
	public Set<City> getRegionCities() {
		return regionCities;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the regionBonus
	 */
	public RegionCard getRegionBonus() {
		return regionBonus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Region [name=" + name + "]";
	}
	
}
