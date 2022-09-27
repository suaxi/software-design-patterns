package com.spring.controller;

import com.spring.context.ApplicationContext;
import com.spring.context.support.ClassPathXmlApplicationContext;
import com.spring.service.UserService;

/**
 * @author Wang Hao
 * @date 2022/9/25 22:22
 */
public class UserController {
    public static void main(String[] args) throws Exception {
        //创建spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        //从容器中获取userService对象
        UserService userService = (UserService) applicationContext.getBean("userService");
        //业务逻辑处理
        userService.add();
    }
}
