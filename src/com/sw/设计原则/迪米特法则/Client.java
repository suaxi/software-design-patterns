package com.sw.设计原则.迪米特法则;

/**
 * @author Wang Hao
 * @date 2022/8/23 21:39
 */
public class Client {
    public static void main(String[] args) {
        //经纪人
        Agent agent = new Agent();
        //明星
        Star star = new Star("孙笑川");
        agent.setStar(star);

        //粉丝
        Fans fans = new Fans("药水哥");
        agent.setFans(fans);

        //媒体公司
        Company company = new Company("xxxTV");
        agent.setCompany(company);

        //粉丝见面会
        agent.meeting();
        //商务洽谈
        agent.business();
    }
}
