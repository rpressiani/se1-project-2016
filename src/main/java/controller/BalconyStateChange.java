package controller;

import council.BalconyState;

public class BalconyStateChange extends Change {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8385165612632503637L;
	private BalconyState balconyState; 
	
	public BalconyStateChange(BalconyState balconyState) {
		this.balconyState = balconyState; 
	}
	public BalconyState getBalconyStateChange() {
		return balconyState; 
	}
	@Override
	public String toString() {
		return "BalconyStateChange [balconyState=" + balconyState + "]";
	}
	

}
