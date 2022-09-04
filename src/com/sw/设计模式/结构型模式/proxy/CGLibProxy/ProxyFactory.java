package com.sw.设计模式.结构型模式.proxy.CGLibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Wang Hao
 * @date 2022/9/2 23:34
 * @description 代理对象工厂，用于获取代理对象
 */
public class ProxyFactory implements MethodInterceptor {

    /**
     * 声明火车站对象
     */
    private TrainStation trainStation = new TrainStation();

    public TrainStation getProxyObject() {
        //创建Enhancer对象（类似于JDK代理中的Proxy）
        Enhancer enhancer = new Enhancer();
        //设置父类的字节码对象
        enhancer.setSuperclass(TrainStation.class);
        //设置回调函数
        enhancer.setCallback(this);
        //创建代理对象
        TrainStation proxyObject = (TrainStation) enhancer.create();
        return proxyObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代售点收取15元手续费（CGLib代理）");
        //要调用目标方法的对象
        return method.invoke(trainStation, objects);
    }
}
