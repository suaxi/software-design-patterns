## 软件设计模式

### 一、分类

+ 创建型模式：用于描述“怎样创建对象”，特点：将对象的创建与使用分离，包含：单例、原型、工厂、抽象工厂、建造者等5种；
+ 结构型模式：用于描述“如何将类或对象按某种布局组合成更大的结构”，包含：代理、适配器、桥接、装饰、外观、享元、组合等7种；
+ 行为型模式：用于描述“类或对象之间如何共同协作完成单个对象无法单独完成的任务，以及怎样分配职责”，包含：模板方法、策略、命令、职责链、状态、观察者、中介者、迭代器、访问者、备忘录、解释器等11种。



### 二、软件设计原则

#### 1. 开闭原则

定义：对扩展开放，对修改关闭

以输入法更换皮肤为例：

![1.开闭原则UML](static/设计原则/1.开闭原则UML.png)



#### 2. 里氏替换原则

定义：子类可以扩展父类的功能，但不能改变父类原有的功能（子类继承父类时，除了添加新的方法和功能外，尽量不要重写父类的方法）

以正方形不是长方形为例：

*在resize方法中，Rectangle类型的参数不能被Square类型的参数所代替，如果进行了替换，则不能得到预期的打印结果*

![2.1.里氏替换原则UML](static/设计原则/2.1里氏替换原则UML.png)



改进：

抽象出四边形接口，长方形、正方形实现四边形接口

![2.2里氏替换原则UML](static/设计原则/2.2里氏替换原则UML.png)