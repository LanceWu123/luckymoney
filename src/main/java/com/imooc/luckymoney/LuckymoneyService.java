package com.imooc.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * ClassName: LuckymoneyService
 * student ID:   20162180121
 * Author:   wujiayuan
 * E-mail:   1107661085@qq.com
 * Date:     2019/7/6 18:48
 * Description:
 */
@Service
public class LuckymoneyService {

    @Autowired
    private LuckymoneyRepository repository;

    /**
     * 事务
     * 因为mysql默认使用MyIsAm类型建立，此类型没有事务功能，所以需要将数据库类型改为innoDB
     */
    @Transactional
    public void createTwo(){
        Luckymoney luckymoney1=new Luckymoney();
        luckymoney1.setProducer("zan");
        luckymoney1.setMoney(new BigDecimal("111"));
        repository.save(luckymoney1);

        Luckymoney luckymoney2=new Luckymoney();
        luckymoney2.setProducer("zan");
        luckymoney2.setMoney(new BigDecimal("2222"));
        repository.save(luckymoney2);
    }
}
