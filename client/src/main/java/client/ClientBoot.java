package client;

import remote.Compute;
import remote.Task;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RMI客户端 - 调用远程对象
 * Created by jason-geng on 2/11/17.
 */
public class ClientBoot {

    private static final String REMOTE_NAME = "compute";
    private static final int REGISTRY_PORT = 9999;

    public static void main(String[] args) throws RemoteException {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            Task task = new client.HelloWorldTask();
            Registry registry = LocateRegistry.getRegistry(REGISTRY_PORT);
            Compute compute = (Compute) registry.lookup(REMOTE_NAME);
            String res = (String) compute.run(task);
            System.out.println("The result is " + res);
        } catch (NotBoundException e){
            e.printStackTrace();
        } catch (RemoteException e){
            e.printStackTrace();
        }

    }
}
