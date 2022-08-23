package com.sw.设计原则.迪米特法则;

/**
 * @author Wang Hao
 * @date 2022/8/23 21:35
 * @description 经纪人类
 */
public class Agent {

    private Star star;
    private Fans fans;
    private Company company;

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public Fans getFans() {
        return fans;
    }

    public void setFans(Fans fans) {
        this.fans = fans;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void meeting() {
        System.out.println(star.getName() + "和粉丝：" + fans.getName() + "见面");
    }

    public void business() {
        System.out.println(star.getName() + "和" + company.getName() + "进行洽谈");
    }
}
