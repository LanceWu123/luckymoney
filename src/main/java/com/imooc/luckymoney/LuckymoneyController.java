package com.imooc.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * ClassName: LuckymoneyController
 * student ID:   20162180121
 * Author:   wujiayuan
 * E-mail:   1107661085@qq.com
 * Date:     2019/7/2 21:49
 * Description:
 */
@RestController
public class LuckymoneyController {
    @Autowired
    private LuckymoneyRepository repository;

    @Autowired
    private LuckymoneyService service;
    /**
     * 获取红包列表
     * @return
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list(){
      return repository.findAll();
    }

    /**
     * 创建红包
     */
    @PostMapping
    public Luckymoney create(@RequestParam("producer") String producer,
                             @RequestParam("money") BigDecimal money){

        Luckymoney luckymoney=new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return repository.save(luckymoney);
    }

    /**
     * 通过id查询红包
     */

    @GetMapping("/luckymoneys/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id){
        return repository.findById(id).orElse(null);
    }
    /**
     * 更新红包
     */

    @PutMapping("/luckymoneys/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consumer){
        Optional<Luckymoney> optional=repository.findById(id);
        if(optional.isPresent()){
            Luckymoney luckymoney=optional.get();
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }
        return null;
    }


    /**
     * 运行事务
     */
    @PostMapping("/luckymoneys/two")
        public void createTwo(){
         service.createTwo();
        }
    }
