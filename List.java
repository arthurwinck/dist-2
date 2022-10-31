import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject; 
import java.util.HashMap;
import java.util.concurrent.Semaphore;

public class List extends UnicastRemoteObject implements ListInterface {
	HashMap <Integer,String> list;
	Semaphore sem;

	public List() throws RemoteException {
		sem = new Semaphore(1);
		list = new HashMap<Integer,String>();
	}
	
	@Override
	public String get(int key) throws RemoteException, InterruptedException {
		try {
			sem.acquire();
			String result = list.get(key);
			sem.release();

			return result;

		} catch (InterruptedException e) {
			throw new InterruptedException("get Interrompido");
		}
	}

	@Override
	public void add(int key, String value) throws RemoteException, InterruptedException {
		try {
			sem.acquire();
			list.put(key, value);
			sem.release();

		} catch (InterruptedException e) {
			throw new InterruptedException("add Interrompido");
		}
	}

	@Override
	public String remove(int key) throws RemoteException, InterruptedException {
		try {
			sem.acquire();
			String result = list.remove(key);
			sem.release();
			return result;

		} catch (InterruptedException e) {
			throw new InterruptedException("remove Interrompido");
		}
	}

	@Override
	public String size() throws RemoteException, InterruptedException {
		try {
			sem.acquire();
			Integer result = list.size();
			sem.release();
			return Integer.toString(result);

		} catch (InterruptedException e) {
			throw new InterruptedException("size Interrompido");
		}
	}
}
