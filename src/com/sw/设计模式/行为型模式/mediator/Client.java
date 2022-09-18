package com.sw.设计模式.行为型模式.mediator;

/**
 * @author Wang Hao
 * @date 2022/9/18 22:09
 */
public class Client {
    public static void main(String[] args) {
        //创建中介者
        MediatorStructure mediatorStructure = new MediatorStructure();

        //租房者
        Tenant tenant = new Tenant("孙笑川", mediatorStructure);

        //房东
        HouseOwner houseOwner = new HouseOwner("刘波", mediatorStructure);

        //中介需知道具体的租房者和房东
        mediatorStructure.setTenant(tenant);
        mediatorStructure.setHouseOwner(houseOwner);

        tenant.contact("我要租房");
        houseOwner.contact("我这里有");
    }
}
