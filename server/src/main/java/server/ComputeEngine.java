package server;

import remote.Compute;
import remote.Task;

import java.rmi.RemoteException;

/**
 * 远程对象 - 任务执行引擎
 * 1.通过接收client传入的task, 进行远程计算
 * Created by jason-geng on 2/11/17.
 */
public class ComputeEngine implements Compute {

    public ComputeEngine() throws RemoteException{
        super();
    }

    public <T> T run(Task<T> task) throws RemoteException {
        return task.execute();
    }
}
