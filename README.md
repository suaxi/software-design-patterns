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



##### （6）三种代理模式的对比

+ 静态代理与动态代理：
  + 动态代理将接口中声明的所有方法都转移到调用处理器一个集中的方法中处理（JDK：InvocationHandler.invoke()），在接口方法较多的情况下可以进行灵活的处理；反之静态代理每增加一个方法就需要新增对应的代理类
+ JDK与CGLib动态代理：
  + `CGLib` 底层采用 `ASM` 字节码生成框架，使用字节码技术生成代理类，在 `JDK1.6` 之前比使用 Java反射效率要高，其中需注意：`CGLib` 不能对声明为 `final` 类型的类或方法进行代理，因为 `CGLib` 原理是动态生成被代理类的子类
  + 在`JDK1.6、1.7、1.8`逐步优化之后，在调用次数较少的情况下，其效率高于 `CGLib` 动态代理，在大量调用的情况下，`CGLib` 效率优于 `JDK1.6、1.7`，`JDK1.8` 时效率高于 `CGLib`
  + **有接口时**使用JDK动态代理，**没有接口时**使用CGLib动态代理



##### （7）优缺点

+ 代理模式在客户端与目标对象之间起到中介的作用和保护目标对象的作用
+ 可以扩展目标对象的功能
+ 将客户端与目标对象分离，降低了耦合度
+ 增加了系统的复杂度



##### （8）使用场景

+ 远程代理（Remote）

  本地服务通过网络请求远程服务，将通信部份隐藏起来，只暴露给本地服务一个接口，通过该接口访问远程服务所提供的功能，而不必过多关心通信细节的部分，如：`RPC` 远程调用

+ 防火墙代理

  在浏览器配置代理功能时，防火墙将请求转发给互联网，收到响应之后再转发给浏览器

+ 保护代理

  控制一个对象的访问，可以给不同的用户提供不同的使用权限



#### 2. 适配器模式

##### （1）概述

将一个类的接口转换成客户希望的另一个接口，使得原本由于接口不兼容而不能一起工作的类能一起工作，分为**类适配器模式**（耦合度高）和**对象适配器模式**



##### （2）结构

+ 目标接口：当前系统业务所期待的接口（抽象类或接口）
+ 适配者类：它是被访问和适配的现存组件库中的组件接口
+ 适配器类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者



##### （3）类适配器模式

实现方式：定义一个适配器类来实现当前系统的业务接口（即目标接口），同时又继承现有组件库中已经存在的组件（即适配者类）

以读卡器为例：

![2.1类适配器模式](static/设计模式/结构型模式/2.1类适配器模式.png)

类适配器模式违背了合成复用原则，在客户类有一个明确的接口规范的情况下可用，反之不可用



##### （4）对象适配器模式

实现方式：采用将现有组件库中已实现的组件引入适配器类中，该类同时实现当前系统的业务接口

读卡器案例改进：

![2.2对象适配器模式](static/设计模式/结构型模式/2.2对象适配器模式.png)

对象适配器模式解决了类适配器模式中存在的问题；同时还有**接口适配器模式**，当不希望实现一个接口中的所有方法时，可以定义一个 `Adapter` 抽象类，实现目标接口中的所有方法，适配器类再继承该抽象类，根据需要选择所需的方法



##### （5）应用场景

+ 原系统存在满足新系统功能需求的类，但存在接口不一致的问题时
+ 使用第三方提供的组件，但所需组件接口与自己接口定义不同的时候



#### 3. 装饰者模式

##### （1）概述

在不改变现有对象结构的情况下，动态的给该对象增加额外的职责或功能



##### （2）结构

+ 抽象构建角色：定义一个抽象接口以规范准备接收附加责任的对象
+ 具体构建角色：实现抽象构建，通过装饰角色为其添加一些职责
+ 抽象装饰角色：继承或实现抽象构建，并包含具体构建的实例，可以通过其子类扩展具体构建的功能
+ 具体装饰角色：实现抽象装饰的相关方法，并给具体构建对象添加附加的职责或功能



##### （3）案例

以快餐店为例：

![3.装饰者模式（快餐店案例）](static/设计模式/结构型模式/3.装饰者模式（快餐店案例）.png)



##### （4）优缺点

+ 装饰者模式可以带来比继承更加灵活的扩展功能，可以通过组合不同的装饰者对象来获取具有不同行为状态的多样化的结果
+ 遵循开闭原则，继承是静态的附加责任，装饰者则是动态的附加责任
+ 装饰类和被装饰类可以各自独立发展，不会产生耦合，装饰者模式是继承的一个替代模式，可以动态扩展一个实现类的功能



##### （5）使用场景

+ 当不能采用继承的方式对系统进行扩充或采用继承不利于系统扩展和维护时
  + 类中存在大量独立的扩展，使用继承可能会造成类爆炸时
  + 被 `final` 修饰的类
+ 在不影响其他对象的情况下，以动态、透明的方式给单个对象添加功能或职责
+ 当对象的功能要求动态添加，动态移除时



##### （6）静态代理与装饰者模式的区别

+ 相同点：

  + 都要实现与目标类相同的业务接口
  + 在两个类中都要声明目标对象
  + 都可以在不修改目标对象的前提下进行功能增强

+ 不同点：

  + 目的不同：

    装饰者增强目标对象

    静态代理保护和隐藏目标对象

  + 获取目标对象构建的地方不同

    装饰者中的目标对象由外界传递（通过构造方法或set赋值）

    静态代理的目标对象在代理类内部创建，以此来完成隐藏和保护



#### 4. 桥接模式

##### （1）概述

将抽象与实现分离，使它们可以独立变化，用组合关系代替继承关系来实现，从而降低抽象和实现这两个可变维度的耦合度



##### （2）结构

+ 抽象化角色：定义抽象类，并包含一个对实现化角色的引用
+ 扩展抽象化角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法
+ 实现化角色：定义实现化角色的接口（也可以是抽象类），供扩展抽象化角色调用
+ 具体实现化角色：给出实现化角色接口的具体实现



##### （3）案例

以视频播放器为例（可以在不同操作系统上播放多种格式的视频文件）

![4.桥接模式（视频播放器案例）](static/设计模式/结构型模式/4.桥接模式（视频播放器案例）.png)



##### （4）优缺点

+ 提高了系统的可扩展性，在两个变化的维度中任意扩展一个维度，都不需要修改原有系统
+ 实现细节对客户透明



##### （5）使用场景

+ 当一个类存在两个独立变化的维度，且这两个维度都需要扩展时
+ 当一个系统不希望使用继承或因多层次继承导致类爆炸时
+ 当一个系统需要在构建的抽象化角色和具体化角色之间增加更多的灵活性时（避免在两个层次之间建立静态的继承联系，可通过桥接模式（聚合引用方式）使它们在抽象层建立一个关联关系）



#### 5. 外观模式

##### （1）概述

外观模式又称门面模式，是一种通过为多个复杂的子系统提供一个一致的接口，而使这些子系统更容易被访问，外部应用程序无需关心内部子系统的具体细节，它是“迪米特法则”的典型应用



##### （2）结构

+ 外观角色：为多个子系统对外提供一个共同的接口
+ 子系统角色：实现系统的部分功能，客户可以通过外观角色访问它



##### （3）案例

以智能音箱控制家电为例

![5.外观模式（智能音箱案例）](static/设计模式/结构型模式/5.外观模式（智能音箱案例）.png)



##### （4）优缺点

+ 降低了子系统与客户端之间的耦合度
+ 对客户屏蔽了子系统组件
+ 不符合开闭原则



##### （5）使用场景

+ 对分层系统构建时，使用外观模式定义每层的入口点可以简化子系统之间的依赖关系
+ 当一个复杂系统的子系统很多时，外观模式可以提供简单的接口供外界访问
+ 当客户端与多个子系统之间存在很大的联系时，引入外观模式可将他们分离从而提高子系统的独立性和可移植性



#### 6. 组合模式

##### （1）概述

组合模式又称为部分整体模式，是用于把一组相似的对象当作一个单一的对象，该模式依据树形结构来组合对象，用来表示部分以及整体层次



##### （2）结构

+ 抽象根节点：定义系统各层次对象的共有方法和属性，可以预先定义一些默认行为和属性
+ 树枝节点：定义树枝节点的行为，存储子节点，组合树枝节点和叶子节点形成树结构
+ 叶子节点：其下再无分支，是系统层次遍历的最小单位



##### （3）案例

以树形菜单为例：

![6.组合模式（树形菜单案例）](static/设计模式/结构型模式/6.1组合模式（树形菜单案例-标准组合模式）.png)



##### （4）分类

+ 透明组合模式

  + 在该模式中，抽象根节点角色声明了所有用于管理成员对象的方法，以此确保所有的构建类都有相同的接口，即标准组合模式
  + 该模式不够安全，因为**叶子对象**和**容器对象**有着本质上的区别，叶子对象不可能有下级节点（即不包含成员对象）因此提供的 `add()`、`remove()`方法是没有意义的，在运行时调用由于未提供相应的错误处理代码而出错

+ 安全组合模式

  + 该模式中的抽象根节点角色未提供任何管理成员对象的方法，而是在**树枝节点**类中声明并实现这些方法，它的缺点是不够透明，因为叶子对象和容器对象具有不同的方法，容器对象中用于管理成员对象的方法没有在抽象根节点中定义，客户端不能实现相应的抽象编程，必须**区别对待**叶子对象和容器对象

    ![6.2组合模式（安全组合模式）](static/设计模式/结构型模式/6.2组合模式（安全组合模式）.png)



##### （5）优缺点

+ 可以清楚定义分层次的复杂对象，表示对象的全部或部分层次，让客户端忽略了层次的差异，便于对整个层次结构的管理
+ 客户端可以一致的使用一个组合结构或其中的单个对象，无需关心处理的是单个对象还是整个组合结构
+ 新增/删除节点符合开闭原则
+ 通过叶子节点和树枝节点的递归组合，可以形成复杂的树形结构，但整个管理的过程并不复杂



##### （6）使用场景

多用于需要使用树形结构的场景



#### 7. 享元模式

##### （1）概述

运用共享技术来有效支持大量细粒度对象的复用，通过共享已经存在的对象来大幅度减少需要创建对象的数量、避免大量相似对象的开销，从而提高系统资源的利用率



##### （2）结构

享元模式存在两种状态：

+ 内部状态，即不会随着环境的改变而改变的可共享部分
+ 外部状态，内部状态反之

享元模式实现的要领就是区分应用中的这两种状态，并将外部状态外部化



包含的角色：

+ 抽象享元角色：通常是一个接口或抽象类，声明具体享元类公共的方法，这些方法可以向外界提供享元对象的内部数据（内部状态），同时也可以通过这些方法来设置外部数据（外部状态）
+ 具体享元角色：它实现了抽象享元类，称为享元对象；在具体享元类中为内部状态提供了存储空间（可以结合单例模式来设计具体享元类）
+ 非享元角色：并不是所有抽象享元类的子类都需要被共享不能被共享的子类可以设计为非共享具体享元类，当需要它时，可以直接通过实例化创建
+ 享元工厂角色：负责创建和管理享元角色，当客户对象请求一个享元对象时，享元工厂检查系统中是否存在该对象，有则直接提供，反之则创建一个对应的新的享元对象



##### （3）案例

以俄罗斯方块为例：

![7.享元模式（俄罗斯方块案例）](static/设计模式/结构型模式/7.享元模式（俄罗斯方块案例）.png)



##### （4）优缺点

+ 极大地减少了内存中相同或相似对象的数量，节约了资源
+ 享元模式中的外部状态相对独立，且不影响内部状态
+ 为了使对象可以共享，需要装享元对象的部分状态外部化，增加了系统的复杂度



##### （5）使用场景

+ 系统中有大量相同或相似的对象
+ 对象的大部分状态都可以外部化，可以将这些外部状态传入对象中
+ 在使用该模式时需要维护对应的享元对象存储池，需要耗费一定的资源，因此，须在多次重复使用享元对象且必要的情况下才使用该模式



### 五、行为型模式

用于描述程序在运行时复杂的流程控制，即描述多个类或对象之间怎样相互协作共同完成单个对象无法单独完成的任务，涉及算法和对象间职责的分配

分为：模板方法、策略模式、命令模式、责任链模式、状态模式、观察者模式、中介者模式、迭代器模式、访问者模式、备忘录模式、解释器模式；其中模板方法、解释器模式属于**类行为模式**，其他属于**对象行为模式**



#### 1. 模板方法

##### （1）概述

定义一个操作中的算法骨架，并将其中的一些步骤延迟到子类中执行，使得子类可以在不改变主干步骤的情况下重定义该算法的某些特定步骤



##### （2）结构

+ 抽象类：负责给出一个算法的轮廓和骨架，由一个模板方法和若干个基本方法构成
  + 模板方法：定义算法的骨架，按指定的顺序调用其包含的基本方法
  + 基本方法：实现算法的各个步骤（模板方法的组成部分）
    + 抽象方法：由抽象类声明，由其具体子类实现
    + 具体方法：由抽象类或具体类声明并实现，其子类可以进行覆盖也可以直接继承
    + 钩子方法：在抽象类中已实现，包括用于判断的逻辑方法和需要子类重写的空方法两个部分
+ 具体子类：实现抽象类中定义的抽象方法和钩子方法

*钩子方法一般是用于做判断的逻辑方法，类名为 `isXXX`，返回值类型为 `boolean`*



##### （3）案例

以炒菜为例

![1.模板方法（炒菜案例）](static/设计模式/行为型模式/1.模板方法（炒菜案例）.png)



##### （4）优缺点

+ 代码复用，相同的代码可以放到抽象父类中，不同的代码放在对应的子类中
+ 实现了反向控制，通过父类调用其子类的操作，并通过子类的不同实现扩展不同的行为，复合**开闭原则**
+ 对每个不同的实现都需要定义一个子类，导致类的个数及系统设计难度的增加
+ 反向控制降低了代码的易读性



##### （5）使用场景

+ 算法的整体步骤固定，但其中的个别部分易变时，使用模板方法可将易变的部分抽象出来，由其子类实现
+ 需要通过子类决定父类中的某个步骤是否执行，实现子类对父类的反向控制



#### 2. 策略模式

##### （1）概述

该模式定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，且算法的变换不会影响客户的使用；它属于对象行为模式，通过对算法进行封装，把使用算法的责任和算法的实现分开，并委派给不同的对象对这些算法进行管理



##### （2）结构

+ 抽象策略类：该角色给出所有的策略类所需的接口
+ 具体策略类：实现抽象策略定义的接口，提供具体的算法实现或行为
+ 环境类：持有一个策略类的引用，供客户端调用



##### （3）案例

以促销活动为例

![2.策略模式（商场促销案例）](static/设计模式/行为型模式/2.策略模式（商场促销案例）.png)



##### （4）优缺点

+ 策略类之间可以自由切换
+ 新增策略时增加对应的具体策略类即可，复合开闭原则
+ 在一定程度上减少了条件选择语句的使用
+ 客户端必须知道所有的策略类，并自行决定使用哪一个
+ 可能产生很多的具体策略类



##### （5）使用场景

+ 系统中需要动态的在几种算法中选择一种时
+ 一个类定义了多种行为，且这些行为在这个类的操作中以多个条件语句的形式出现时，可将每个分支条件移入各自对应的策略类中
+ 系统中的算法各自独立，且要求对客户隐藏实现的细节时
+ 多个类只区别在表现型为不同，可选择策略模式，在运行时动态选择具体要执行的行为



#### 3. 命令模式

##### （1）概述

将一个请求封装为一个对象，使发出请求的责任和执行请求的责任分割开，使两者之间通过命令对象来进行沟通，便于命令对象的存储、传递、调用、增加及管理



##### （2）结构

+ 抽象命令角色：定义命令的接口，声明执行的方法
+ 具体命令角色：具体的命令，实现命令接口，持有接收者，并调用接收者的功能来完成命令要执行的操作
+ 实现者/接收者角色：执行命令的对象（任何类都可能成为一个接收者，只要它能够实现命令要求实现的相应功能）
+ 调用者/请求者角色：要求命令对象执行请求，持有命令对象（一个或多个），客户端真正触发命令并要求命令执行相应操作的地方（即使用命令对象的入口）



##### （3）案例

以点餐为例

![3.命令模式（点餐案例）](static/设计模式/行为型模式/3.命令模式（点餐案例）.png)



##### （4）优缺点

+ 将调用操作的对象与实现该操作的对象解耦，降低了系统的耦合度
+ 增加/删除命令时不会影响其他的类，符合开闭原则
+ 通过与组合模式结合，将多个命令装配成一组命令，可以实现宏命令
+ 可以实现命令的撤销 `redo` 与恢复 `undo`
+ 使用该模式可能产生很多的具体命令类（但不会造成类爆炸）
+ 系统结构更加复杂



##### （5）使用场景

+ 系统需要将请求调用者和接收者解耦，使两者不进行直接交互时
+ 系统需要根据不同的情况指定请求、排队请求、执行请求时
+ 系统需要支持命令的撤销 `redo` 与恢复 `undo` 时



#### 4. 责任链模式

##### （1）概述

为了避免请求发送者与多个请求处理者耦合在一起，将所有请求的处理者通过前一对象记住其下一个对象的引用而连城一条链；当有请求发生时，可将请求沿着这条链传递，只到有对象处理它为止



##### （2）结构

+ 抽象处理者角色：定义处理请求的接口，包含抽象处理方法和一个后继链接
+ 具体处理者角色：实现抽象处理者的处理方法，判断能否处理本次请求，如果可以处理则处理，否则将该请求转发给后继者
+ 客户类角色：创建处理链，并向链头的具体处理者对象提交请求，它不关心处理细节及请求传递的过程



##### （3）案例

以请假为例

![4.责任链模式（请假案例）](static/设计模式/行为型模式/4.责任链模式（请假案例）.png)



##### （4）优缺点

+ 降低了请求发送者和接收者的耦合度
+ 可根据需求添加新的处理类，复合开闭原则
+ 增强了给对象指派职责的灵活性，当工作流程发生变化时，可以动态的改变链内的成员或成员之间的顺序，也可以动态的新增/删除责任
+ 简化了对象之间的连接，一个对象只需保持一个指向其后继者的引用，不需要保持其他所有处理者的引用，对客户端来说避免了众多的 `if...else` 语句
+ 职责明确，每个类只需关心自己的职责内容，不能处理的传递给下一个对象，复合类的单一职责原则
+ 不能保证每一个请求一定被处理，由于一个请求没有明确的接收者，所以不能暴政它一定被处理，该请求可能一直传递到链的末端也得不到处理
+ 较长的责任链可能涉及的多个处理对象，对性能有一定的影响
+ 责任链建立的合理性需要靠客户端来保证，增加了客户端的复杂性，可能会由于责任链的设置错误而导致系统出错（如循环调用等）



#### 5. 状态模式

##### （1）概述

对有状态的对象，把复杂的“判断逻辑“提取到不同的状态对象中，允许其状态对象在其内部状态发生改变时改变其行为



##### （2）结构

+ 环境角色：也称为上下文，它定义了客户程序需要的接口，维护一个当前状态并将与状态相关的操作委托给当前状态对象来处理
+ 抽象状态角色：定义接口用以封装环境对象中的特定状态所对应的行为
+ 具体状态角色：实现抽象状态所定义的行为



##### （3）案例

以乘坐电梯为例

![5.状态模式（电梯案例）](static/设计模式/行为型模式/5.状态模式（电梯案例）.png)



##### （4）优缺点

+ 将所有与某个状态相关的行为放到一个类中，并且可以方便地增加新的状态，只需要改变对象状态即可改变对象的行为
+ 允许状态转换逻辑与状态对象合成一体，而不是某一个巨大的条件语句块
+ 可能导致类和对象的个数增多
+ 结果与实现较为复杂，若果使用不当可能会导致结构与代码的混乱
+ 不符合开闭原则



##### （5）使用场景

+ 当一个对象的行为取决于它的状态，并且它必须在运行时根据状态改变他的行为时
+ 一个操作中含有庞大的分支结构，并且这些分支决定于对象的状态时



#### 6. 观察者模式

##### （1）概述

观察者模式又称发布 - 订阅模式，它定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象，这个主题对象在状态变化时，会通知所有的观察者对象，使它们能够自动更新自己



##### （2）结构

+ 抽象主题（抽象被观察者）：抽象主题角色把所有观察者对象保存在一个集合里，每个主题都可以有任意数量的观察者，抽象主题提供一个接口，可以增加/删除观察者对象
+ 具体主题（具体被观察者）：该角色将有关状态存入具体观察者对象，在具体主题的内部发生改变时，给所有注册过的观察者发送通知
+ 抽象观察者：它定义了一个更新接口，使得在得到主题更改时通知更新自己
+ 具体观察者：实现抽象观察者定义的更新接口，以便在得到主题更改时通知更新自身的状态



##### （3）案例

以订阅公众号为例

![6.观察者模式（公众号案例）png](static/设计模式/行为型模式/6.观察者模式（公众号案例）png.png)



##### （4）优缺点

+ 降低了被观察者与观察者之间的耦合
+ 被观察者发送消息，所有观察者都可以收到，可以实现广播机制
+ 观察者过多时，对系统性能会产生一定的影响
+ 如果被观察者有循环依赖，在发送消息时可能导致观察者循环调用



##### （5）使用场景

+ 当对象存在一对多关系，一个对象的状态发生改变会影响其他的对象
+ 当一个抽象模型存在两个方面，其中一方面依赖于另一方面时



#### 7. 中介者模式

##### （1）概述

中介者模式又称调停模式，定义一个中介者角色来封装一系列对象之间的交互，使原有对象之间的耦合松散，且可以独立的改变它们之间的交互



##### （2）结构

+ 抽象中介者：它是中介者的接口，提供了同事对象注册与转发同事对象信息的抽象方法
+ 具体中介者：实现中介者接口，定义一个 `List` 来管理同事对象，协调各个同事对象之间的交互关系，须依赖于同事对象
+ 抽象同事类：定义同事类的接口，保存中介者对象，提供同事对象交互的抽象方法，实现所有相互影响的同事类的公共功能
+ 具体同事类：实现抽象同事类接口，当需要与其他同事对象交互时，由中介者对象负责后续的交互



##### （3）案例

以租房为例

![7.中介者模式（以租房为例）](static/设计模式/行为型模式/7.中介者模式（以租房为例）.png)



##### （4）优缺点

+ 松散耦合：通过把多个同事对象之间的交互封装到中介者对象里面，从而使得同事对象之间松散耦合，可以做到互补依赖，同事对象也可以独立的变化和复用
+ 集中控制交互：多个同事对象的交互，被封装在中介者对象中集中管理，在交互发生变化的时候，只需修改中介者（或者进行扩展）
+ 一对多的关联转变为一对一：引入中介者之后，中介者与同事对象的关系变为双向一对一，使同事对象的关系易于理解和实现
+ 当同事类较多时，中介者的职责很重，结构复杂且难以维护



##### （5）使用场景

+ 系统中对象间存在复杂的引用关系，系统结构混乱且难以理解
+ 需创建一个运行于多个类之间的对象，又不想生成新的子类时



#### 8. 迭代器模式

##### （1）概述

提供一个对象来顺序访问聚合对象中的一系列数据，而不暴露内部对象的表示



##### （2）结构

+ 抽象聚合角色：定义存储、添加、删除聚合元素以及创建迭代器对象的接口
+ 具体聚合角色：实现抽象聚合类，返回一个具体迭代器的实例
+ 抽象迭代器角色：定义访问和遍历聚合元素的接口，通常包含 `hasNext()`、`next()` 等方法
+ 具体迭代器角色：实现抽象迭代器接口中所定义的方法，完成对聚合对象的遍历，记录遍历的当前位置



##### （3）案例

以遍历学生对象集合为例

![8.迭代器模式（集合遍历案例）](static/设计模式/行为型模式/8.迭代器模式（集合遍历案例）.png)



##### （4）优缺点

+ 支持以不同的方式遍历一个聚合对象，在同一个聚合对象上可以定义多种遍历方式，在迭代器模式中只需要用一个不同的迭代器来替换原有的迭代器即可改变遍历算法
+ 简化了聚合类，在原有的聚合类中不需要再自行提供遍历等方法
+ 由于引入了抽象层，新增新的聚合类和迭代器类都很方便，满足开闭原则



##### （5）使用场景

+ 当需要为聚合对象提供多种遍历方式时
+ 当需要为遍历不同的聚合结构提供一个统一的接口时
+ 当需要访问一个聚合对象的内容而无需暴露其内部细节时



#### 9. 访问者模式

##### （1）概述

封装一些作用于某种数据结构中的各元素的操作，它可以在不改变这个数据结构的前提下定义作用于这些元素的新的操作



##### （2）结构

+ 抽象访问者角色：定义对每一个元素访问的行为，它的参数就是可以访问的元素（它的方法个数理论上来说与元素个数相等）
+ 具体访问者角色：给出对每一个元素类访问时所产生的具体行为
+ 抽象元素角色：定义接受访问者的方法（即每一个元素都可以被访问者访问）
+ 具体元素角色：提供接受访问方法的具体实现，而这个具体的实现，通常情况下是使用访问者提供的访问该元素类的方法
+ 对象结构角色：一个具有容器性质或复合对象特性的类，它含有一组元素，且可以迭代这些元素，供访问者访问



##### （3）案例

以宠物喂食为例

+ 访问者角色：给宠物喂食的人
+ 具体访问者角色：宠物主人、其他人等
+ 抽象元素角色：动物抽象类
+ 具体元素角色：宠物狗、宠物猫
+ 结构对象角色：主人家

![9.访问者模式（喂宠物案例）](static/设计模式/行为型模式/9.访问者模式（喂宠物案例）.png)



##### （4）优缺点

+ 扩展性好：在不修改对象结构中的元素的情况下，为对象结构中的元素添加新的功能
+ 复用性好：通过访问者来定义整个对象结构的通用的功能，从而提高代码复用
+ 分离无关行为：通过访问者来分离无关的行为，把相关的行为封装在一起，构成一个访问者，使得每一个访问者的功能都比较单一
+ 对象结构变化困难：每增加一个新的元素类，都要在每一个具体访问者中增加相应的具体操作，违背了开闭原则
+ 违反了依赖倒置原则：访问者依赖具体类，而不依赖抽象类



##### （5）使用场景

+ 对象结构稳定，但其操作算法经常变更时
+ 对象结构中对象需要提供多种不同且不相关的操作，而且要避免让这些操作的变化影响对象的结构时



##### （6）扩展

*访问者模式使用了双分派技术*

**1. 分派**

变量被声明时的类型叫做变量的静态类型，变量所引用的对象的真实类型叫实际类型 `Map map = new HashMap()`

+ 静态分派：发生在编译时期，分派根据静态类型信息发生，如：方法重载
+ 动态分派：发生在运行时期，动态分派动态地置换掉某个方法，如：方法重写



**2. 动态分派**

```java
public class Animal {
    
    public void execute() {
        System.out.println("Animal");
    }
}

public class Dog extends Animal {
    
    @Override
    public void execute() {
        System.out.println("Dog");
    }
}

public class Cat extends Animal {
    
    @Override
    public void execute() {
        System.out.println("Cat");
    }
}

public class Client {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.execute();
        
        Animal a1 = new Cat();
        a1.execute();
    }
}
```

Java编译器在编译时期并不总是知道哪些代码会被执行，因为编译器仅仅知道对象的静态类型，而方法的调用则是根据对象的真实类型



**3. 静态分派**

```java
public class Animal {

}

public class Dog extends Animal {

}

public class Cat extends Animal {

}

public class Execute() {
    
    public void print(Animal a) {
        System.out.println("Animal");
    }

    public void print(Dog d) {
        System.out.println("Dog");
    }

    public void print(Cat c) {
        System.out.println("Cat");
    }
}

public class Client {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal d = new Dog();
        Animal c = new Cat();
        
        Execute execute = new Execute();
        execute.print(a); //Animal
        execute.print(d); //Animal
        execute.print(c); //Animal
    }
}
```

重载是根据方法的静态类型进行的，该分派过程在编译期完成，所以打印结果都是 `Animal`



**4. 双分派**

双分派在选择一个方法的时候，不仅要根据消息接收者的运行时区别，还要根据参数的运行时区别

```java
public class Animal {
    
    public void accept(Execute execute) {
        execute.print(this);
    }
}

public class Dog extends Animal {
    
    @Override
    public void accept(Execute execute) {
        execute.print(this);
    }
}

public class Cat extends Animal {
    
    @Override
    public void accept(Execute execute) {
        execute.print(this);
    }
}

public class Execute() {
    
    public void print(Animal a) {
        System.out.println("Animal");
    }

    public void print(Dog d) {
        System.out.println("Dog");
    }

    public void print(Cat c) {
        System.out.println("Cat");
    }
}

public class Client {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal d = new Dog();
        Animal c = new Cat();
        
        Execute execute = new Execute();
        a.accept(execute); //Animal
        d.accept(execute); //Dog
        c.accept(execute); //Cat
    }
}
```

客户端将 `Execute` 作为参数传递给 `Animal` 类型的变量调用的方法，这里通过**方法重写**完成了第一次分派（动态分派），同时也将自己 `this` 作为参数传递到 `Execute.print()` 方法中，这里通过**方法重载**完成了第二次分派（静态分派）

**双分派实现动态绑定的本质就是在重载委派之前加上继承体系中的重写**



#### 10. 备忘录模式

##### （1）概述

备忘录模式又叫快照模式，在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，以便需要时能将该对象恢复到之前保存的状态



##### （2）结构

+ 发起人角色：记录当前时刻的内部状态信息，提供创建备忘录和恢复备忘录的功能，它可以访问备忘录里的所有信息
+ 备忘录角色：负责存储发起人的内部状态，在需要的时候提供这些内部状态给发起人
+ 管理者角色：对备忘录进行管理，提供保存与获取备忘录的功能，但其不能对备忘录没有读写权限



备忘录有两个等效接口：

+ 窄接口：管理者对象（和其他除发起人对象之外的任何对象），看到的是窄接口，该接口只允许把备忘录对象传递给其他对象
+ 宽接口：发起人对象可以看到宽接口，该接口允许读取所有的数据，以便恢复对象之前的内部状态



##### （3）案例

以游戏存档为例：

+ “白箱”备忘录

  备忘录角色对任何对象都提供宽接口（破坏了封装性）

  ![10.1备忘录模式（白箱模式）](static/设计模式/行为型模式/10.1备忘录模式（白箱模式）.png)

  

+ “黑箱”备忘录

备忘录角色对发起人提供宽接口，对其他对象提供窄接口（即将备忘录类设置为发起人的内部类）

![10.2备忘录模式（黑箱模式）](static/设计模式/行为型模式/10.2备忘录模式（黑箱模式）.png)



##### （4）优缺点

+ 提供了一种可恢复状态的机制，当用户需要事，可方便的恢复到某个历史状态
+ 实现了内部状态的封装，除发起人之外的角色对这些状态信息都没有读写权限
+ 简化了发起人类，内部状态由管理者进行管理，发起人无需关心，复合单一职责原则
+ 当需要存储的状态信息及频率过多过大时，需要消耗更多的资源



##### （5）使用场景

+ 需要保存与恢复数据时
+ 需要提供可回滚操作时，如 `ctrl + z` 、数据库回滚等



#### 11. 解释器模式

##### （1）概述

定义一个语言，定义它的文法表示，并定义一个解释器，根据文法规则来解释语言中的句子

> 文法（语法）规则：

用于描述语言的语法结构的形式规则

```bash
# 例：
expression ::= value | plus | minus # ::= 表示定义为
plus ::= expression '+' expression
minus ::= expression '-' expression
value ::= integer

# 表达式可以是一个值，也可以是plus、minus运算， 而plus、minus又由表达式结合运算符构成，值的类型为整数
```



> 抽象语法树

在计算机科学中，抽象语法树（AbstractSyntaxTree，ATS）简称语法树（Syntax Tree），是源代码语法的一种抽象表示，它以树状的形式表现编程语言的语法结构，树上的每个节点都表示源代码中的一种结构。

如：`1 + 2 + 3 - 4`

![11.1抽象语法树](static/设计模式/行为型模式/11.1抽象语法树.png)



##### （2）结构

+ 抽象表达式：定义解释器的接口，约定解释器的解释操作，主要包含解释方法 `interpret()`
+ 终结符表达式：抽象表达式的子类，实现文法与终结符相关的操作，文法中的每一个终结符都有与之对应的具体终结表达式
+ 非终结符表达式：抽象表达式的子类，实现文法与非终结符相关的操作，文法中的每条规则都对应一个非终结符表达式
+ 环境角色：包含各个解释器需要的数据或公共功能，用来传递被所有解释器共享的数据，后面的解释器可以从该角色获取相应的数据
+ 客户端：将需要分析的句子或表达式转换成使用解释器对象描述的抽象语法树，然后调用解释器的解释方法，同时也可以通过环境角色间接访问解释器的解释方法



##### （3）案例

以加减运算为例

![11.2解释器模式（加减运算案例）](static/设计模式/行为型模式/11.2解释器模式（加减运算案例）.png)



##### （4）优缺点

+ 易于改变和扩展文法：由于解释器模式中使用类来表示语言的文法规则，因此可以使用继承等机制来扩展或改变文法
+ 实现文法较为容易：在抽象语法树中，每一个表达式节点类的实现方式都是类似的，且不是特别复杂
+ 增加新的解释表达式较为方便：在需要扩展时只需增加一个对应的终结符/非终结符表达式类，符合开闭原则
+ 复杂文法难以维护：在该模式中，每一条规则至少需要定义一个类，类的个数会随着文法规则的增加而增加
+ 执行效率低：该模式使用了大量的循环和递归调用，在解释较为复杂的句子时存在性能问题（变量类型重写抽象表达式的解释（解析）方法，直接获取对应 `key` 的值，非终结符表达式先调用其他表达式父类的解释（解析）方法，然后才到自身这边）



### 六、自定义spring-context demo

applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans>

    <bean id="userMapper" class="com.spring.mapper.impl.UserMapperImpl">
        <property name="name" value="孙笑川"/>
        <property name="password" value="123456"/>
    </bean>

    <bean id="userService" class="com.spring.service.impl.UserServiceImpl">
        <property name="userMapper" ref="userMapper"/>
    </bean>
</beans>
```



#### 1. pojo

##### （1）PropertyValue类

用于封装bean的属性

```java
public class PropertyValue {

    /**
     * name
     */
    private String name;

    /**
     * ref
     */
    private String ref;

    /**
     * value:给基本数据类型及String类型赋的值
     */
    private String value;

    public PropertyValue() {
    }

    public PropertyValue(String name, String ref, String value) {
        this.name = name;
        this.ref = ref;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
```



##### （2）MutablePropertyValues类

一个`bean`标签可以有多个 `property` 子标签，该类用于存储并管理多个 `Propertyvalue` 对象

```java
public class MutablePropertyValues implements Iterable<PropertyValue> {

    private final List<PropertyValue> propertyValueList;

    public MutablePropertyValues() {
        this.propertyValueList = new ArrayList<>();
    }

    public MutablePropertyValues(List<PropertyValue> propertyValueList) {
        if (propertyValueList == null) {
            this.propertyValueList = new ArrayList<>();
        } else {
            this.propertyValueList = propertyValueList;
        }
    }

    /**
     * 获取PropertyValue数组
     *
     * @return
     */
    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 根据名称获取PropertyValue对象
     *
     * @param propertyName
     * @return
     */
    public PropertyValue getPropertyValueByName(String propertyName) {
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyValue.getName().equals(propertyValue)) {
                return propertyValue;
            }
        }
        return null;
    }

    /**
     * 判断集合是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return propertyValueList.isEmpty();
    }

    /**
     * 添加
     *
     * @param propertyValue
     * @return
     */
    public MutablePropertyValues addPropertyValue(PropertyValue propertyValue) {
        for (int i = 0; i < propertyValueList.size(); i++) {
            PropertyValue currentPropertyValue = this.propertyValueList.get(i);
            if (currentPropertyValue.getName().equals(propertyValue.getName())) {
                propertyValueList.set(i, new PropertyValue(propertyValue.getName(), propertyValue.getRef(), propertyValue.getValue()));
                return this;
            }
        }
        this.propertyValueList.add(propertyValue);
        return this;
    }

    /**
     * 判断是否包含指定名称的PropertyValue对象
     *
     * @param propertyName
     * @return
     */
    public boolean contains(String propertyName) {
        return this.getPropertyValueByName(propertyName) != null;
    }

    /**
     * 获取迭代器对象
     *
     * @return
     */
    @Override
    public Iterator<PropertyValue> iterator() {
        return propertyValueList.listIterator();
    }
}

```



##### （3）BeanDefinition

`BeanDefinition` 用来封装 `bean` 的信息，主要包含`id`（`bean`对象的名称）、`class`（需交由 `spring` 管理的类的全路径类名）、子标签 `property` 数据

```java
public class BeanDefinition {

    private String id;
    private String className;
    private MutablePropertyValues propertyValues;

    public BeanDefinition() {
        propertyValues = new MutablePropertyValues();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public MutablePropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(MutablePropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
```



#### 2. 注册表

##### （1）BeanDefinitionRegistry接口

+ 注册 `BeanDefinition` 对象到注册表中

+ 从注册表中删除指定名称的对象

+ 根据名称获取指定对象

+ 根据名称判断是否包含指定对象

+ 获取已注册 `bean` 的个数

+ 获取已注册 `bean` 的名称数组

  ```java
  public interface BeanDefinitionRegistry {
  
      /**
       * 注册BeanDefinition对象到注册表中
       *
       * @param beanName
       * @param beanDefinition
       */
      void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
  
      /**
       * 从注册表中删除指定名称的对象
       *
       * @param beanName
       */
      void removeBeanDefinition(String beanName);
  
      /**
       * 根据名称获取指定对象
       *
       * @param beanName
       * @return
       */
      BeanDefinition getBeanDefinition(String beanName);
  
      /**
       * 根据名称判断是否包含指定对象
       *
       * @param beanName
       * @return
       */
      boolean containsBeanDefinition(String beanName);
  
      /**
       * 获取已注册bean的个数
       *
       * @return
       */
      int getBeanDefinitionCount();
  
      /**
       * 获取已注册bean的名称数组
       *
       * @return
       */
      String[] getBeanDefinitionNames();
  }
  ```



##### （2）SimpleBeanDefinitionRegistry类

该类实现了 `BeanDefinitionRegistry` 接口，并定义Map集合作为注册表容器

  ```java
public class SimpleBeanDefinitionRegistry implements BeanDefinitionRegistry {

    /**
     * BeanDefinition存储容器
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public void removeBeanDefinition(String beanName) {
        beanDefinitionMap.remove(beanName);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public int getBeanDefinitionCount() {
        return beanDefinitionMap.size();
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }
}
  ```


#### 3. 解析器

##### （1）BeanDefinitionReader接口

用于解析配置文件并在注册表中注册bean的信息：

+ 获取注册表功能，让外界可以通过此对象获取注册表对象
+ 加载配置文件，并注册bean数据

  ```java
  public interface BeanDefinitionReader {
  
    /**
     * 获取注册表对象
     *
     * @return
     */
    BeanDefinitionRegistry getRegistry();
  
    /**
     * 加载配置文件并在注册表中注册
     *
     * @param configLocation
     */
    void loadBeanDefinitions(String configLocation) throws DocumentException;
  }
  ```



##### （2）XmlBeanDefinitionReader类

用于解析xml配置文件，该类实现了 `BeanDefinitionReader` 接口

  ```java
public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    /**
     * 声明注册表对象
     */
    private BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader() {
        registry = new SimpleBeanDefinitionRegistry();
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public void loadBeanDefinitions(String configLocation) throws DocumentException {
        SAXReader reader = new SAXReader();
        //获取类路径下的配置文件
        InputStream is = XmlBeanDefinitionReader.class.getClassLoader().getResourceAsStream(configLocation);
        Document document = reader.read(is);

        //根标签
        Element rootElement = document.getRootElement();
        //根标签下的bean标签对象
        List<Element> beanElementList = rootElement.elements();

        for (Element beanElement : beanElementList) {
            //id
            String id = beanElement.attributeValue("id");

            //class
            String className = beanElement.attributeValue("class");

            MutablePropertyValues propertyValues = new MutablePropertyValues();
            //property
            List<Element> propertyList = beanElement.elements("property");
            for (Element propertyElement : propertyList) {
                String name = propertyElement.attributeValue("name");
                String ref = propertyElement.attributeValue("ref");
                String value = propertyElement.attributeValue("value");
                propertyValues.addPropertyValue(new PropertyValue(name, ref, value));
            }

            //封装
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setId(id);
            beanDefinition.setClassName(className);
            beanDefinition.setPropertyValues(propertyValues);

            //将beanDefinition注册到注册表中
            registry.registerBeanDefinition(id, beanDefinition);
        }
    }
}
  ```



#### 4. IOC容器

##### （1）BeanFactory接口

在该接口中定义IOC容器的统一规范（即获取 `bean` 对象）

  ```java
public interface BeanFactory {

    /**
     * 根据名称获取bean
     *
     * @param name
     * @return
     */
    Object getBean(String name) throws Exception;

    /**
     * 根据名称、class类获取bean
     *
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T getBean(String name, Class<? extends T> clazz) throws Exception;
}
  ```



##### （2）ApplicationContext接口

该接口的所有子实现类对 `bean` 对象的创建都是非延时的，所以在该接口中定义 `refresh()` 方法：

+ 加载配置文件
+ 根据注册表中的 `BeanDefinition` 对象封装的数据进行 `bean` 对象的创建

```java
public interface ApplicationContext extends BeanFactory {

    /**
     * 加载配置文件并创建对象
     *
     * @throws Exception
     */
    void refresh() throws Exception;
}
```



##### （3）AbstractApplicationContext类

+ 作为 `ApplicationContext` 接口的子类，该类也是非延时加载，所以在该类中定义Map集合作为 `bean` 对象的存储容器
+ 声明 `BeanDefinitionReader` 类型的变量，进行xml配置文件解析； `BeanDefinitionReader` 类型的对象的创建交由子类实现（因为只有子类明确创建 `BeanDefinitionReader` 哪个子实现类对象）

```java
public abstract class AbstractApplicationContext implements ApplicationContext {

    /**
     * 声明解析器
     */
    protected BeanDefinitionReader beanDefinitionReader;

    /**
     * 存储bean的容器
     */
    protected Map<String, Object> singleObjects = new HashMap<>();

    /**
     * 配置文件路径
     */
    protected String configLocation;

    @Override
    public void refresh() throws Exception {
        //加载BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(configLocation);
        //初始化bean
        this.finishBeanInitialization();
    }

    /**
     * 初始化bean
     */
    private void finishBeanInitialization() throws Exception {
        //获取注册表对象
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();

        //获取BeanDefinition
        String[] beanNames = registry.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            //执行初始化
            getBean(beanName);
        }
    }
}
```

注：`finishBeanInitialization()` 方法中的 `getBean()` 使用了模板方法



##### （4）ClassPathXmlApplicationContext类

该类主要功能是加载类路径下的配置文件，并创建 `bean` 对象：

+ 在构造方法中，创建 `BeanDefinitionReader` 对象
+ 在构造方法中，调用 `refresh()` 方法，用于加载配置文件、创建 `bean` 对象并存储到容器中
+ 重写父接口中的 `getBean()` 方法，并实现依赖注入

```java
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String configLocation) {
        this.configLocation = configLocation;
        //构建解析器
        beanDefinitionReader = new XmlBeanDefinitionReader();
        try {
            this.refresh();
        } catch (Exception e) {

        }
    }

    @Override
    public Object getBean(String name) throws Exception {
        //判断对象容器中是否包含指定名称的容器对象，如果有则直接返回，反之进行创建
        Object obj = singleObjects.get(name);
        if (obj != null) {
            return obj;
        }

        //获取BeanDefinition
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        BeanDefinition beanDefinition = registry.getBeanDefinition(name);

        //根据bean标签数据中的类名反射创建对象
        Class<?> clazz = Class.forName(beanDefinition.getClassName());
        Object beanObj = clazz.newInstance();

        //执行依赖注入
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues()) {
            //name
            String propertyName = propertyValue.getName();
            //value
            String value = propertyValue.getValue();
            //ref
            String ref = propertyValue.getRef();
            if (ref != null && !"".equals(ref)) {
                //获取依赖的bean对象
                Object bean = getBean(ref);
                //拼接方法名
                String methodName = StringUtils.getSetMethodNameByFieldName(propertyName);
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (method.getName().equals(methodName)) {
                        method.invoke(beanObj, bean);
                    }
                }

            }
            if (value != null && !"".equals(value)) {
                String methodName = StringUtils.getSetMethodNameByFieldName(propertyName);
                Method method = clazz.getMethod(methodName, String.class);
                method.invoke(beanObj, value);
            }
        }

        //在返回之前将该对象存储到bean容器中
        singleObjects.put(name, beanObj);
        return beanObj;
    }

    @Override
    public <T> T getBean(String name, Class<? extends T> clazz) throws Exception {
        Object bean = getBean(name);
        if (bean == null) {
            return null;
        }
        return clazz.cast(bean);
    }
}
```



#### 5. 补充

pom.xml

```xml
<!-- dom4j -->
<dependency>
    <groupId>dom4j</groupId>
    <artifactId>dom4j</artifactId>
    <version>1.6.1</version>
</dependency>
```



项目结构：

![自定义spring-context项目结构](static/设计模式/自定义spring-context项目结构.png)