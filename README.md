## 软件设计模式

*参考于it黑马*



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



##### （1）饿汉式（静态变量方式）

该方式在成员位置声明 `Singleton` 类型的静态变量，并创建 `Singleton` 类的对象 `instance`，`instance` 对象随着类的加载被创建，如果该类足够大且一直没有被使用的情况下会造成内存的浪费



##### （2）饿汉式（静态代码块方式）

该方式在成员位置声明 `Singleton` 类型的静态变量，而对象的创建是在静态代码块中，也是随着类的加载而被创建，与**静态变量方式**类似



##### （3）懒汉式（线程不安全）

当调用 `getInstance()` 方法获取 `Singleton` 类的对象的时候才创建 `Singleton` 类的对象，这样就实现了**懒加载**，但在多线程操作时存在线程不安全的问题



##### （4）懒汉式（双重检测锁）

使用 `volatile` 关键字保证可见性和防止指令重排（JVM在实例化对象时会进行优化和指令重排序操作，可能产生空指针）



##### （5）懒汉式（静态内部类）

实例由内部类创建，由于JVM在加载外部类的过程中不会加载静态内部类，只有内部类的属性/方法被调用时才会被加载，并初始化其静态属性，其中静态属性由于被 `static` 修饰，保证只被实例化一次，并且严格保证实例化顺序

说明：第一次加载 `Singleton` 类时不会去初始化 `INSTANCE`，只有第一次调用 `getInstance()` 时，虚拟机加载 `SingletonHolder` 并初始化 `INSTANCE` ，这样既保证了现成安全，也保证了 `Singleton`  的唯一性，**在没有加任何锁的情况下保证了线程的安全且不造成性能和内存的浪费（双重检测锁方式 和 静态内部类方式可以任选其一）**



##### （6）枚举方式

枚举是线程安全的，且只会被加载一次，**注意枚举方式属于饿汉式**



##### （7）存在的问题

破坏单例模式的方式：

+ 序列化和反序列化
+ 反射

解决方法：

+ 序列化和反序列化 - 在单例类中添加 `readResolve()` 方法，在反序列化时，如果类中定义了这个方法，就返回这个方法的值，反之则创建新的对象
+ 反射 - 在单例类的构造方法中通过标志位来判断是否是第一次访问，且在该构造方法中需要加  `synchronized` 锁，锁该类 `synchronized(Singleton.class)`



#### 2. 工厂模式

##### （1）概述

以咖啡店点餐系统为例：

![1.1工厂模式](static/设计模式/创建者模式/1.1工厂模式.png)

当需要添加不同类型的咖啡的时候，需要修改原有的代码，违背了开闭原则，此时如果使用工厂来生产不同类型的咖啡，则只需要与工厂产生对接，工厂模式的最大优点即**解耦**



##### （2）简单工厂模式

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



##### （2）工厂方法模式

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



##### （3）抽象工厂模式

> 概念

为访问类提供一个创建一组或相互依赖对象的接口，且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构



> 结构

+ 抽象工厂：提供创建产品的接口，它包含多个创建产品的方法，可以创建多个不同等级的产品
+ 具体工厂：主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建
+ 抽象产品：定义产品的规范，描述产品的主要功能和特性（抽象工厂模式具有多个抽象产品）

+ 具体产品：实现抽象产品角色所定义的接口，由具体工厂来创建，它与具体工厂之间是**多对一**的关系



> 实现

当咖啡店业务发生变化时，不仅要上架咖啡，还需要上架甜点（提拉米苏、抹茶慕斯），按照工厂方法模式，很容易发生类爆炸的问题；其中：

+ 拿铁、美式属于一个产品等级，都是咖啡；

+ 提拉米苏、抹茶慕斯属于一个产品等级，都是甜点；

+ 拿铁、提拉米苏属于一个产品类别，都是意大利风味；

+ 美式、抹茶慕斯属于一个产品类别，都是美式风味

可以使用抽象工厂模式来实现：

![1.4抽象工厂模式](static/设计模式/创建者模式/1.4抽象工厂模式.png)

如果要添加同一个产品族的话，只需添加一个对应的甜品工厂类，满足开闭原则



> 优缺点

+ 当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象
+ 当产品族中需要增加一个新的产品时，所有的工厂类都需要需改



> 使用场景

+ 当需要创建的对象是一系列相互关联或相互依赖的产品族时，如生产厂商的电视机、洗衣机、空调等
+ 系统中有多个产品族，但每次只使用其中的一个产品族，如某人只喜欢某一品牌的服装
+ 系统中提供了产品的类库，且所有产品的接口相同，客户端不依赖产品实例的创建细节和内部结构，如输入法更换皮肤



##### （4）模式扩展

**简单工厂 + 配置文件解耦**

在工厂类中加载配置文件的全类名，并创建对象进行存储，客户端如果需要对象，直接获取即可

a. 定义配置文件

`bean.properties`

```properties
american=com.sw.设计模式.创建者模式.factory.configFactory.AmericanCoffee
latte=com.sw.设计模式.创建者模式.factory.configFactory.LatteCoffee
```

b. 改进工厂类

```java
public class CoffeeFactory {

    //加载配置文件，获取配置文件中配置的全类名，并创建该类的对象进行存储
    //1.定义容器对象存储咖啡
    private static HashMap<String, Coffee> map = new HashMap<>();

    //2.加载配置文件
    static {
        //创建properties对象
        Properties p = new Properties();
        //调用load()方法进行加载
        InputStream is = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            p.load(is);
            //从p集合中获取全类名并创建对象
            for (Object key : p.keySet()) {
                String className = p.getProperty((String) key);
                Class<?> clazz = Class.forName(className);
                Coffee coffee = (Coffee) clazz.newInstance();
                //存储
                map.put((String) key, coffee);
            }
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 根据名称获取对象
     *
     * @param name 名称
     * @return
     */
    public static Coffee createCoffee(String name) {
        return map.get(name);
    }
}
```

使用静态成员变量来存储创建的对象，在静态代码块中读取配置文件并创建对象

```java
public class Client {
    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.createCoffee("american");
        //美式咖啡
        System.out.println(coffee.getName());

        System.out.println("=============================");

        Coffee coffee1 = CoffeeFactory.createCoffee("latte");
        //拿铁咖啡
        System.out.println(coffee1.getName());
    }
}
```



#### 3. 原型模式

##### （1）概述

用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型对象相同的新对象



##### （2）结构

+ 抽象原型类：规定了具体原型对象必须实现的 `clone()` 方法

+ 具体原型类：实现抽象原型类的 `clone()` 方法，它是可被复制的对象

+ 访问类：使用具体原型类中的 `clone()` 方法来复制新的对象

接口类图：

![1.5原型模式](static/设计模式/创建者模式/1.5原型模式.png)



##### （3）实现

原型模式的克隆分为**浅克隆**和**深克隆**：

+ 浅克隆：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型，仍指向原有属性所指向的对象的内存地址
+ 深克隆：创建一个新对象，属性中引用的其他对象也会被克隆，且不再指向原有对象地址

Java中 `Object` 类提供了 `clone()` 方法来实现浅克隆，`Cloneable` 接口是上面类图中的抽象原型类，而实现了 `Cloneable` 接口的子实现类就是具体的原型类。

**原型类**

```java
public class Realizetype implements Cloneable {

    public Realizetype() {
        System.out.println("具体原型对象创建完成");
    }

    @Override
    public Realizetype clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功");
        return (Realizetype) super.clone();
    }
}
```

**测试**

```java
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        //创建原型对象
        Realizetype realizetype = new Realizetype();
        //调用clone方法进行对象的克隆
        Realizetype realizetype1 = realizetype.clone();

        //具体原型对象创建完成
        //具体原型复制成功
        //false
        System.out.println(realizetype == realizetype1);
    }
}
```



##### （4）案例

以学校发放“三好学生”奖状为例

![1.6原型模式（奖状案例）](static/设计模式/创建者模式/1.6原型模式（奖状案例）.png)



##### （5）使用场景

+ 对象的创建非常复杂
+ 性能和安全要求较高



##### （6）深克隆

将奖状案例中的 `name` 属性修改为 `Student` 复杂对象属性

```java
public class CitationTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        //创建原型对象
        Citation citation = new Citation();

        //创建学生
        Student student = new Student();
        student.setName("孙笑川");
        citation.setStudent(student);

        //复制奖状
        Citation citation1 = citation.clone();
        citation1.getStudent().setName("药水哥");

        //展示奖状
        citation.show();
        citation1.show();

        //药水哥同学，在本学年表现优秀，被评为“三好学生”，特发此状，以资鼓励！
        //药水哥同学，在本学年表现优秀，被评为“三好学生”，特发此状，以资鼓励！
    }
}
```

存在的问题：使用浅克隆时，克隆出来的对象属性中的 `student1` 和第一次创建的 `student` 是同一个对象，此时 `setName` 方法设置的值是同一个

改进：（使用对象流）

```java
public class CitationTest {
    public static void main(String[] args) throws Exception {
        //创建原型对象
        Citation citation = new Citation();

        //创建学生
        Student student = new Student();
        student.setName("孙笑川");
        citation.setStudent(student);

        //创建对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("D:/citation.txt")));
        //写对象
        oos.writeObject(citation);
        //释放资源
        oos.close();

        //创建对象
        ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("D:/citation.txt")));
        Citation citation1 = (Citation) ois.readObject();
        ois.close();

        citation1.getStudent().setName("药水哥");

        citation.show();
        citation1.show();
    }
}
```



#### 4. 建造者模式

##### （1）概述

将一个复杂对象的构建与表示分离，使得同样的构建过程可以创建不同的表示



##### （2）结构

+ 抽象建造者类（Builder）：该接口规定要实现复杂对象的哪些部分的创建，并不涉及具体部件的创建
+ 具体建造者类（ConcreteBuilder）：实现 `Builder` 接口，完成复杂对象的各个部件的具体创建方法，在构造过程完成后，提供产品的实例
+ 产品类（Product）：要创建的复杂对象
+ 指导者类（Director）：调用具体建造者来创建复杂对象的各个部分，在指导者中不涉及具体产品的信息，只负责保证对象各部分完整创建或按某种顺序创建

![1.7建造者模式](static/设计模式/创建者模式/1.7建造者模式.png)



##### （3）实例

以生产单车为例

![1.8建造者模式（生产单车案例）](static/设计模式/创建者模式/1.8建造者模式（生产单车案例）.png)

以上实例可以将**指导者**和**抽象建造者**结合，这样做可以简化系统复杂度，但**不符合单一职责原则**

```java
public abstract class Builder {

    protected Bike bike = new Bike();

    /**
     * 生产车架
     */
    public abstract void buildFrame();

    /**
     * 生产车座
     */
    public abstract void buildSeat();

    /**
     * 生产自行车
     *
     * @return
     */
    public abstract Bike createBike();
    
    public Bike construct() {
        this.buildFrame();
        this.buildSeat();
        return this.createBike();
    }
}
```



##### （5）优缺点

+ 封装性好，建造者模式可以有效的封装变化，在该过程中，产品类与建造者类相对稳定，将复杂的业务逻辑封装在指导者类中对整体而言有较好的稳定性
+ 在建造者模式中，客户端无需关心产品内部组成的细节，将产品本身与创建的过程解耦，使得相同的创建过程可以建造不同的产品
+ 可以更细粒度的控制产品的创建过程，即将复杂对象的创建步骤分解在不同的方法中，可以使创建过程更加清晰，也可以更好的控制创建过程
+ 易扩展，当有同类产品的新的需求时，新增一个建造者就可以完成，符合开闭原则
+ 建造者模式所创建的产品一般来说有较多的相同点，其组成部分相似，如果产品之间差异较大，则不适合使用建造者模式，使其适用范围受限



##### （6）使用场景

+ 创建的对象较复杂，有多个部件构成，各部件面临着复杂的变化，但构件间的建造顺序是稳定的
+ 创建复杂对象的算法独立于该对象的组成部分以及它们的装配方式，即产品的构建过程和最终的表示是独立的



##### （7）扩展

当一个类的构造器需要传入很多参数时，如果创建该类的实例，可能导致代码可读性差和引入新的错误，此时可以使用建造者模式进行重构

```java
public class Phone {

    private String cpu;
    private String screen;
    private String memory;
    private String mainBoard;

    //私有构造器
    private Phone(Builder builder) {
        this.cpu = builder.cpu;
        this.screen = builder.screen;
        this.memory = builder.memory;
        this.mainBoard = builder.mainBoard;
    }

    public static final class Builder {
        private String cpu;
        private String screen;
        private String memory;
        private String mainBoard;

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder screen(String screen) {
            this.screen = screen;
            return this;
        }

        public Builder memory(String memory) {
            this.memory = memory;
            return this;
        }

        public Builder mainBoard(String mainBoard) {
            this.mainBoard = mainBoard;
            return this;
        }

        //使用建造者创建Phone对象
        public Phone build() {
            return new Phone(this);
        }
    }

    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", screen='" + screen + '\'' +
                ", memory='" + memory + '\'' +
                ", mainBoard='" + mainBoard + '\'' +
                '}';
    }
}
```



### 四、结构型模式

描述如何将类或对象按某种布局组合成更大的结构，分为类结构型模式和对象结构型模式，前者采用继承来组织接口和类，后者采用组合或聚合来组合对象

分为：代理模式、适配器模式、装饰者模式、桥接模式、外观模式、组合模式、享元模式

#### 1. 代理模式

##### （1）概述

由于某些原因需要给某对象提供一个代理以控制对该对象的访问，这时，访问对象不适合或不能直接引用目标对象，代理对象作为访问对象与目标对象之间的中介

Java中的代理按照类生成时机的不同分为**静态代理**和**动态代理**，静态代理 代理类在编译时生成，动态代理 代理类在运行时动态生成（JDK动态代理、CGLib动态代理）



##### （2）结构

+ 抽象主题类：通过接口或抽象类声明真实主题和代理对象实现的业务方法
+ 真实主题类：实现抽象主题中的具体业务，是代理对象所代表的真实对象，是最终要引用的对象
+ 代理类：提供与真实主题相同的接口，其内部含有对真实主题的引用，它可以访问、控制以及扩展真实主题的功能



##### （3）静态代理

以火车站卖票为例

![1.静态代理（火车站卖票案例）](static/设计模式/结构型模式/1.静态代理（火车站卖票案例）.png)



##### （4）JDk动态代理

Java中提供了一个动态代理类 `Proxy` ，即提供了一个创建代理对象的静态方法 `newProxyInstance` 来获取代理对象

使用`Arthas` （阿尔萨斯）查看代理类的结构：

```java
package com.sun.proxy;

import com.itheima.proxy.dynamic.jdk.SellTickets;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public final class $Proxy0 extends Proxy implements SellTickets {
    private static Method m1;
    private static Method m2;
    private static Method m3;
    private static Method m0;

    public $Proxy0(InvocationHandler invocationHandler) {
        super(invocationHandler);
    }

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
            m3 = Class.forName("com.itheima.proxy.dynamic.jdk.SellTickets").getMethod("sell", new Class[0]);
            m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
            return;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new NoSuchMethodError(noSuchMethodException.getMessage());
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }

    public final boolean equals(Object object) {
        try {
            return (Boolean)this.h.invoke(this, m1, new Object[]{object});
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final String toString() {
        try {
            return (String)this.h.invoke(this, m2, null);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final int hashCode() {
        try {
            return (Integer)this.h.invoke(this, m0, null);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final void sell() {
        try {
            this.h.invoke(this, m3, null);
            return;
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }
}
```

从以上类结构可以看出：

+ 代理类 `$Proxy0` 实现了 `SellTickets`，即真实类和代理类都实现了同样的接口
+ 代理类 `$Proxy0` 将我们提供了的匿名内部类 `invocationHandler` 传递给了父类
+ 动态代理执行流程：
  + 在测试类（访问类）中通过代理对象调用 `sell()` 方法
  + 根据多态的特性，执行的代理类是 `$Proxy0` 中的 `sell()` 方法
  + 代理类 `$Proxy0` 中的 `sell()` 方法中又调用了 `invocationHandler` 接口的子实现类对象的 `invoke()` 方法
  + `invoke` 方法通过反射执行了真实对象所属类 `TrainStation` 中的 `sell()` 方法



##### （5）CGLib动态代理

如果没有定义 `SellTickets` 接口，只定义了 `TrainStation` 火车站类，此时无法使用JDK动态代理，因为它要求必须定义接口

