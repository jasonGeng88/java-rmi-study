package server;

import remote.Compute;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * RMI服务端
 * 1.创建远程对象
 * 2.将远程对象注册进RMI Registry
 * 3.等待client远程调用
 * Created by jason-geng on 2/11/17.
 */
public class ServerBoot {

    private static final String REMOTE_NAME = "compute";
    private static final int REGISTRY_PORT = 9999;

    public static void main(String[] args) throws RemoteException {

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        Compute hello = new ComputeEngine();
        Remote stub = UnicastRemoteObject.exportObject(hello, 0);
        Registry registry = LocateRegistry.getRegistry(REGISTRY_PORT);
        //采用相对路径注册远程对象
        registry.rebind(REMOTE_NAME, stub);

        //采用绝对路径注册远程对象（如rmi://IP:PORT/name）,若只写name,则使用默认IP,PORT
//        Naming.rebind(REMOTE_NAME, stub);

        System.out.println("server.ComputeEngine bound");


    }
}