外观模式（门面模式）
    定义了一个高层、统一的接口，外部通过这个统一的接口对子系统中的一群接口进行访问。

优点：
1.简化调用流程，客户端不需要知道子系统的实现，提高了安全性，符合“迪特米原则”。
2.提高灵活性，降低用户类和子系统类的耦合度，实现了松耦合。
3.更好的划分访问层次。

缺点：
如果新增子系统，需要修改外观类，违背了“开闭原则”。


外观（Facade）角色：为多个子系统对外提供一个共同的接口。
子系统（Sub System）角色：实现系统的部分功能，客户可以通过外观角色访问它。
客户（Client）角色：通过一个外观角色访问各个子系统的功能。


示例：模拟用户下订单的流程。用户需要进入订单服务后进入支付服务，最后进入物流服务。(订单服务->支付服务->物流服务)

