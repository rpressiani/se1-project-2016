package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.player.Player;
import view.rmi.RMIView;
import view.socket.ServerSocketView;

public class Server {
	
	private final static int PORT = 29999; //load from file!
	private final static int RMI_PORT = 29998;
	private final String NAME = "co4";
	
	private static Map<Player, ServerSocketView> tmpViewSocket = new HashMap<Player, ServerSocketView>();
	private static Map<Player, RMIView> tmpViewRMI = new HashMap<Player, RMIView>();
	
	private ServerSocket serverSocket;
	
	private static MatchCreator matchCreator;
	
	/**
	 * start the socket
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void startSocket() throws IOException, ClassNotFoundException {
		ExecutorService viewExecutor = Executors.newCachedThreadPool(); 
		
		this.serverSocket = new ServerSocket(PORT); 
		System.out.println("SERVER SOCKET READY ON PORT: " + PORT);
		
		while(true) {
			Socket socket = serverSocket.accept();
			ServerSocketView view = new ServerSocketView(socket, this);
			viewExecutor.submit(view);
			tmpViewSocket.put(view.getPlayer(), view);
			System.out.println("NEW CLIENT_SOCKET ACCEPTED");
		}
	}
	
	private void startRMI() throws RemoteException, AlreadyBoundException{
		Registry registry = LocateRegistry.createRegistry(RMI_PORT);
		System.out.println("Constructing the RMI registry");
		RMIServer serverRMI=new RMIServer(tmpViewRMI, this);
		System.out.println("RMIVIEW SERVER: " + serverRMI);
		RMIServerInterface serverView=(RMIServerInterface) UnicastRemoteObject.exportObject(serverRMI, 0);
		System.out.println("Binding the server implementation to the registry");
		registry.bind(NAME, serverView);
	}
	
	private void closeServer() throws IOException{
		this.serverSocket.close();
	}
	
	public void disconnect(Player player){
		if (tmpViewSocket.containsKey(player)) {
			tmpViewSocket.remove(player);
			matchCreator.getEnabledPlayers().remove(player);
		}
		if (tmpViewRMI.containsKey(player)) {
			tmpViewRMI.remove(player);
			matchCreator.getEnabledPlayers().remove(player);
		}
	}
	
	/**
	 * 
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws AlreadyBoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, AlreadyBoundException {
		Server server = new Server();
		
		matchCreator = new MatchCreator(tmpViewSocket, tmpViewRMI);
		ExecutorService matchExecutor = Executors.newCachedThreadPool();
		matchExecutor.submit(matchCreator);
		
		System.out.println("STARTING RMI");
		server.startRMI();
		
		System.out.println("STARTING SOCKET");
		server.startSocket();
	
	}

}