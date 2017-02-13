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

        /**
         * 内部创建RMI Registry,若无引用外部资源,可无需设置java.rmi.server.codebase (因为它共享server中的资源)
         * 外部创建RMI Registry （rmiregistry -J-Djava.rmi.server.useCodebaseOnly=false &）
         * 设置java.rmi.server.useCodebaseOnly=false （默认为true, 表示仅依赖当前的codebase. 如需使用外部（client or server）的codebase, 需把此参数设为false）
         */
        Registry registry = LocateRegistry.createRegistry(REGISTRY_PORT);
        //采用相对路径注册远程对象
        registry.rebind(REMOTE_NAME, stub);

        //采用绝对路径注册远程对象（如rmi://IP:PORT/name）,若只写name,则使用默认IP,PORT
//        Naming.rebind(REMOTE_NAME, stub);

        System.out.println("server.ComputeEngine bound");


    }
}