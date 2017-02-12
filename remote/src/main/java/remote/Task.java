package remote;

/**
 * 任务接口
 * Created by jason-geng on 2/11/17.
 */
public interface Task<T> {

    T execute();

}