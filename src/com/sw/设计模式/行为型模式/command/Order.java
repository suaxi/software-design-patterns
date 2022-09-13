package com.sw.设计模式.行为型模式.command;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wang Hao
 * @date 2022/9/13 22:31
 * @description 订单类
 */
public class Order {

    private int diningTable;
    private Map<String, Integer> foodDic = new HashMap<>();

    public int getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(int diningTable) {
        this.diningTable = diningTable;
    }

    public Map<String, Integer> getFoodDic() {
        return foodDic;
    }

    public void setFood(String foodName, int num) {
        foodDic.put(foodName, num);
    }
}
