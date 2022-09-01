package com.sw.设计模式.结构型模式.proxy.JDKProxy;

import com.sw.设计模式.结构型模式.proxy.staticProxy.SellTickets;
import com.sw.设计模式.结构型模式.proxy.staticProxy.TrainStation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Wang Hao
 * @date 2022/9/1 22:52
 * @description 获取代理对象的工厂类（代理类也实现了对应的接口）
 */
public class ProxyFactory {

    /**
     * 声明目标对象
     */
    private final TrainStation trainStation = new TrainStation();

    /**
     * 获取代理对象
     *
     * @return
     */
    public SellTickets getProxyInstance() {
        //返回代理对象
        /**
         * ClassLoader loader：类加载器（可以通过目标对象获取类加载器）
         * Class<?>[] interfaces：代理类实现的接口的字节码对象
         * InvocationHandler h：代理对象的调用处理程序
         */
        return (SellTickets) Proxy.newProxyInstance(
                trainStation.getClass().getClassLoader(),
                trainStation.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * Object proxy：代理对象，和proxyObject是同一个对象，在invoke方法中基本不用
                     * Method method：对接口中的方法进行封装的method对象
                     * Object[] args：调用方法的实际参数
                     * 返回值：方法的返回值
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代售点收取10元手续费（jdk动态代理）");
                        //执行目标对象的方法
                        return method.invoke(trainStation, args);
                    }
                });
    }
}
