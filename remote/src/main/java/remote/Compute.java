package remote;


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程对象接口 - 执行任务
 * Created by jason-geng on 2/11/17.
 */
public interface Compute extends Remote {

    <T> T run(Task<T> task) throws RemoteException;

}