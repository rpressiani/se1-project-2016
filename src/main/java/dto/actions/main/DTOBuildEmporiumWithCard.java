package dto.actions.main;

import dto.DTOAction;
import dto.map.DTOCity;
import dto.utilities.DTOPermissionCard;

public class DTOBuildEmporiumWithCard implements DTOAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 85255788780648973L;
	
	private final DTOPermissionCard permissionCard;
	private final DTOCity city;
	
	public DTOBuildEmporiumWithCard(DTOPermissionCard permissionCard, DTOCity city) {
		this.permissionCard = permissionCard;
		this.city = city;
	}

	/**
	 * @return the permissionCard
	 */
	public DTOPermissionCard getPermissionCard() {
		return permissionCard;
	}

	/**
	 * @return the city
	 */
	public DTOCity getCity() {
		return city;
	}
	
	

}
