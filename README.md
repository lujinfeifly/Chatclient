# Chatclient
the java socket client with its own thread, that can process it with your self

the main.java is the file that you can use it for reference


使用方法：

连接
// 创建连接体
BoChatClient client = new BoChatClient("10.127.129.120", 6200);
// 创建登录用户信息
UserEnterBean bean = new UserEnterBean("2323", "hehe", "2200068409", "hehe");
// 设置登录用户信息
client.setLoginBean(bean);
// 连接
client.connect();
// 进入房间
client.enterroom();
// 开始心跳等处理
client.start();

至此，就和客户端保持着连接，并可以接收到服务器发送的消息。
如果需要获取到服务器发送过来的内容，需要创建一个代理，实现下面的接口
MsgListener      消息接收
ErrorListener   错误消息接收
并设置好代理
client.setMsgListener(listener);
client.setErrorListener(listener);

这样就可以拿到具体的处理值了，但是有一点需要注意的是，代理中的方法需要尽量保持简单，如果复杂则会影响消息的接收速度，最好接入后做好客户端的相关测试。建议的方案是listenr方法里面的获取相关的事件后将消息放进队列中慢慢处理即可。

操作：
在聊天室中可以进行发送消息之类的操作，所有的方法如下：
client.sendMessage("ssssssssssssssssssss");     // 聊天室中发送文字，发送的文字
client.sendQueryList("1", "40");                  // 查询聊天室列表，页数和每页的记录
client.sendQueryUserMsg("672030622");            // 查询用户信息，用户uid
查询信息不会立即返回，这里发送了查询请求后，会随着接收消息中返回，这里是异步的。如果需要同步处理，可以在外端时间等待同步。

以上内容可参考Main.java中的内容。
