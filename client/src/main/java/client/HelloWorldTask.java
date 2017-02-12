package client;

import remote.Task;

import java.io.Serializable;

/**
 * 任务 - 输出hello world
 * Created by jason-geng on 2/11/17.
 */
public class HelloWorldTask implements Task<String>, Serializable {

    private static final long serialVersionUID = 1L;

    public String execute() {
        String str = "hello word";
        System.out.printf(str);
        return str;
    }
}
