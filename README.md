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



#### 3. 依赖倒置原则

定义：高层模块不应该依赖低层模块，两者都应该依赖其抽象；抽象不应该依赖细节，细节应该依赖抽象

以组装电脑为例：

*存在的问题：现在的电脑只能使用给定的组件，如果要使用其他的，则违背了开闭原则*

![3.1依赖倒置原则](static/设计原则/3.1依赖倒置原则.png)



改进：

抽象出各个配件的接口，让Computer类依赖抽象，而不是依赖于各组件的具体实现类

![3.2依赖倒置原则](static/设计原则/3.2依赖倒置原则.png)



#### 4. 接口隔离原则

定义：客户端不应该被迫依赖于它不使用的方法，即：一个类对另一个类的依赖应该建立在最小的接口上

以安全门为例：

存在的问题：如果要增加新的品牌的安全门，则违背了开闭原则

![4.1接口隔离原则](static/设计原则/4.1接口隔离原则.png)



改进：

抽象出安全门各个功能的接口，新增其他品牌的安全门时只需实现对应功能的接口

![4.2接口隔离原则](static/设计原则/4.2接口隔离原则.png)



#### 5. 迪米特法则

定义：如果两个软件实体无需直接通信，那么就不应当发生直接的相互调用，可以通过第三方转发该调用，其目的是降低耦合，提高模块的相对独立性

以明星和经纪人为例：

![5.迪米特法则](static/设计原则/5.迪米特法则.png)



#### 6. 合成复用原则

定义：尽量先使用组合或聚合等关联关系来实现，其次才考虑使用继承关系来实现

类的复用通常分为：继承复用、合成复用

+ 继承复用
  + 破坏了类的封装性，将父类的实现细节暴露给了子类，父类对子类是透明的，这种复用又称为**“白箱”**复用
  + 耦合度高，父类的实现的任何变化都会导致子类的实现发生变化，不利于类的维护和扩展
  + 灵活性低，从父类继承而来的实现是静态的，在编译时已定义，所以在运行时不可能发生变化
+ 合成复用（可将已有对象纳入新对象中，使之成为新对象的一部分，新对象可以调用已有对象的功能）
  + 维持了类的封装性，因为成员对象的内部细节是新对象看不见的，所以又称为**“黑箱”**复用
  + 耦合度低，可以在类的成员位置声明抽象
  + 灵活性高，这种复用可以在运行时动态进行，新对象可以动态的引用与成员对象类型相同的对象

以汽车分类管理为例：

汽车按**动力源**可分为汽油车、新能源车；按**颜色**可分为白色、红色；如果同时考虑这两种成分，会产生多种组合

![6.1合成复用原则](static/设计原则/6.1合成复用原则.png)

可以看出使用继承复用会产生很多子类，如果要**添加新的**能源类型的车，就需要再定义**新**的类

![6.2合成复用原则](static/设计原则/6.2合成复用原则.png)



### 三、创建者模式

特点：将对象的创建与使用分离，可以降低系统的耦合度，使用者不需要关注对象的创建细节

分为：单例模式、工厂模式、抽象工厂模式、原型模式、建造者模式



#### 1. 单例模式

单例模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建，这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象

单例模式的实现：

+ 饿汉式：类一加载就创建该实例对象
+ 懒汉式：需要使用时才创建该实例对象



（1）饿汉式（静态变量方式）

该方式在成员位置声明 `Singleton` 类型的静态变量，并创建 `Singleton` 类的对象 `instance`，`instance` 对象随着类的加载被创建，如果该类足够大且一直没有被使用的情况下会造成内存的浪费



（2）饿汉式（静态代码块方式）

该方式在成员位置声明 `Singleton` 类型的静态变量，而对象的创建是在静态代码块中，也是随着类的加载而被创建，与**静态变量方式**类似



（3）懒汉式（线程不安全）

当调用 `getInstance()` 方法获取 `Singleton` 类的对象的时候才创建 `Singleton` 类的对象，这样就实现了**懒加载**，但在多线程操作时存在线程不安全的问题



（4）懒汉式（双重检测锁）

使用 `volatile` 关键字保证可见性和防止指令重排（JVM在实例化对象时会进行优化和指令重排序操作，可能产生空指针）



（5）懒汉式（静态内部类）

实例由内部类创建，由于JVM在加载外部类的过程中不会加载静态内部类，只有内部类的属性/方法被调用时才会被加载，并初始化其静态属性，其中静态属性由于被 `static` 修饰，保证只被实例化一次，并且严格保证实例化顺序

说明：第一次加载 `Singleton` 类时不会去初始化 `INSTANCE`，只有第一次调用 `getInstance()` 时，虚拟机加载 `SingletonHolder` 并初始化 `INSTANCE` ，这样既保证了现成安全，也保证了 `Singleton`  的唯一性，**在没有加任何锁的情况下保证了线程的安全且不造成性能和内存的浪费（双重检测锁方式 和 静态内部类方式可以任选其一）**



（6）枚举方式

枚举是线程安全的，且只会被加载一次，**注意枚举方式属于饿汉式**



（7）存在的问题

破坏单例模式的方式：

+ 序列化和反序列化
+ 反射

解决方法：

+ 序列化和反序列化 - 在单例类中添加 `readResolve()` 方法，在反序列化时，如果类中定义了这个方法，就返回这个方法的值，反之则创建新的对象
+ 反射 - 在单例类的构造方法中通过标志位来判断是否是第一次访问，且在该构造方法中需要加  `synchronized` 锁，锁该类 `synchronized(Singleton.class)`



#### 2. 工厂模式

（1）概述

以咖啡店点餐系统为例：

![1.1工厂模式](static/设计模式/创建者模式/1.1工厂模式.png)

当需要添加不同类型的咖啡的时候，需要修改原有的代码，违背了开闭原则，此时如果使用工厂来生产不同类型的咖啡，则只需要与工厂产生对接，工厂模式的最大优点即**解耦**



（2）简单工厂模式

*简单工厂模式不属于GOF的23种经典设计模式，其更像是一种编程习惯*



> 结构

+ 抽象产品：定义产品的规范，描述产品的主要特性和功能

+ 具体产品：实现或继承抽象产品的子类
+ 具体工厂：提供创建产品的方法，调用者通过该方法来获取产品



> 实现

![1.2简单工厂模式](static/设计模式/创建者模式/1.2简单工厂模式.png)

工厂处理创建对象的细节，一旦有了 `SimpleCoffeeFactory` 工厂类，`CoffeeStore` 类中的 `orderCoffee()` 就变成此对象的客户，后期如果需要 `Coffee` 对象直接从工厂获取即可，解除了和 `Cooffee` 实现类的耦合，但同时又产生了新的耦合：`CoffeeStore` 对象与 `SimpleCoffeeFactory` 工厂对象，`SimpleCoffeeFactory` 工厂对象 与 生产的商品对象



> 优缺点

+ 封装了创建对象的过程，可以通过参数直接获取对象，把对象的创建与业务逻辑分开，避免了修改客户端代码，如果要添加新的产品则直接修改工厂类
+ 增加新产品时需要修改原有的工厂类，违背了**开闭原则**



> 扩展（静态工厂）

```java
public class SimpleCoffeeFactory {

    public static Coffee createCoffee(String type) {
        //声明coffee类型的变量，根据不同类型创建不同的coffee子类
        Coffee coffee = null;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("该类型的咖啡暂未上架");
        }
        return coffee;
    }
}
```



（2）工厂方法模式

> 概念

定义一个用于创建对象的接口，让子类决定实例化哪个产品类对象，工厂方法使一个产品类的实例化延迟到其工厂的子类



> 结构

+ 抽象工厂：提供创建产品的接口，调用者通过它访问具体工厂的方法来创建产品
+ 具体工厂：实现抽象工厂中的抽象方法，完成具体产品的创建
+ 抽象产品：定义产品的规范，描述产品的主要功能和特性
+ 具体产品：实现抽象产品定义的接口，由具体工厂来创建（与具体工厂一一对应）



> 实现

![1.3工厂方法模式](static/设计模式/创建者模式/1.3工厂方法模式.png)

工厂方法模式是简单工厂模式的进一步抽象，由于使用了多态，既保持了简单工厂模式的优点，同时也解决了它的缺点



> 优缺点

+ 用户只需要知道具体工厂的名称就能得到需要的产品，无需关心产品的具体创建过程
+ 增加新的产品时只需添加具体产品类和对应的工厂类，无须对原工厂进行修改，满足**开闭原则**
+ 每增加一个产品就要增加一个具体产品类和对应的工厂类，增加了系统的复杂度