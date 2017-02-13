

RMI Demo 示例
===========================


Java Remote Method Invocation (RMI)为java远程调用中的最简单机制，实现了跨java虚拟机之间的通信（仅限JAVA间使用）。本示例主要演示RMI远程调用的机制，包括服务端、客户端以及远程调用的通用接口

****
###　　　　　　　　　　　　Author:Jason
###　　　　　　　　　 E-mail:372922638@qq.com

===========================

## 目录说明
* client 客户端调用示例
* remote 远程通用接口
* server 客户端启动示例

## 启动参数配置
### server

	-Djava.rmi.server.codebase=file:{workspace}/remote/target/classes/
	-Djava.rmi.server.useCodebaseOnly=false
	-Djava.rmi.server.hostname=localhost
	-Djava.security.policy={workspace}/server.policy

### client
	-Djava.rmi.server.codebase=file:{workspace}/client/target/classes/
	-Djava.security.policy={workspace}/client.policy

## 参数说明
* java.rmi.server.codebase：提供远程动态下载的资源路径
* java.rmi.server.useCodebaseOnly：默认为true, 表示仅依赖当前的codebase
* java.rmi.server.hostname：服务端对外的访问地址
* java.security.policy：资源动态下载的权限控制

## 参考
[https://docs.oracle.com/javase/tutorial/rmi/](https://docs.oracle.com/javase/tutorial/rmi/)