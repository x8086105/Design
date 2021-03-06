模板方法模式
模板方法是类的行为模式。准备一个抽象类，一个具体实现的方法是用来实现模板的具体步骤，一个基本方法。

模板方法模式（Template Method Pattern） 实际上是封装了一个固定流程，该流程由几个步骤组成，具体步骤可以由子类进行不同实现，
从而让固定的流程产生不同的结果。

模板方法模式 非常简单，其实就是类的继承机制，但它却是一个应用非常广泛的模式。

模板方法模式 本质：抽象封装流程，具体进行实现

当完成一个操作具有固定的流程时，由抽象固定流程步骤，具体步骤交给子类进行具体实现（固定的流程，不同的实现）。

优点

封装不变，扩展可变：父类封装了具体流程以及实现部分不变行为，其它可变行为交由子类进行具体实现；

流程由父类控制，子类进行实现：框架流程由父类限定，子类无法更改；子类可以针对流程某些步骤进行具体实现；


缺点

抽象规定了行为，具体负责实现，与通常事物的行为相反，会带来理解上的困难（通俗地说，“父类调用了子类方法”）；
