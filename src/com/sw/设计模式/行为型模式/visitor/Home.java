package com.sw.设计模式.行为型模式.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wang Hao
 * @date 2022/9/20 22:09
 * @description 对象结构
 */
public class Home {

    private List<Animal> nodeList = new ArrayList<>();

    void add(Animal animal) {
        nodeList.add(animal);
    }

    void action(Person person) {
        //访问者访问每一个元素
        for (Animal animal : nodeList) {
            animal.accept(person);
        }
    }
}
