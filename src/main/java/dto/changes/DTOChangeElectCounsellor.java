package dto.changes;

import dto.map.DTORegion;
import dto.playerInfo.DTOCoins;
import dto.utilities.DTOColor;

public class DTOChangeElectCounsellor implements DTOChange {

	/**
	 * 
	 */
	private static final long serialVersionUID = -164544571255023350L;

	private final DTOCoins coins;
	private final DTOColor color;
	private final DTORegion region;
	
	public DTOChangeElectCounsellor(DTOCoins coins, DTOColor color, DTORegion region){
		this.coins=coins;
		this.color=color;
		this.region=region;
	}

	public DTOCoins getCoins() {
		return coins;
	}
	
	public DTOColor getColor() {
		return color;
	}

	public DTORegion getRegion() {
		return region;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "You gained "+coins+" for having elected a "+color+" counsellor in "+region+"'s balcony";
	}

}
