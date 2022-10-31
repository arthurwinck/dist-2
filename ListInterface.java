import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ListInterface extends Remote{

	public String get(int key) throws RemoteException, InterruptedException;
	public void add(int key, String value) throws RemoteException, InterruptedException;
	public String remove(int key) throws RemoteException, InterruptedException;
	public String size() throws RemoteException, InterruptedException;	
}
