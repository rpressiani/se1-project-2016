package dto.queries.respond;

import java.util.Map;

import dto.DTOObject;
import dto.utilities.DTOContract;

public class DTOMarketStatusResponse implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7672161989409126013L;
	
	private final Map<String, DTOContract> contracts;
	
	public DTOMarketStatusResponse(Map<String, DTOContract> contracts) {
		this.contracts = contracts;
	}

	/**
	 * @return the contracts
	 */
	public Map<String, DTOContract> getContracts() {
		return contracts;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DTOMarketStatusResponse [contracts=" + contracts + "]";
	}
	
	

}