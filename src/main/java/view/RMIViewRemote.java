package view;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.rmi.ClientViewRemote;
import dto.actions.DTOAction;


public interface RMIViewRemote extends Remote {

	public void registerClient(ClientViewRemote clientStub) throws RemoteException;
	public void translateAction(DTOAction action) throws RemoteException;
}