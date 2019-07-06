package com.imooc.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: HelloController
 * student ID:   20162180121
 * Author:   wujiayuan
 * E-mail:   1107661085@qq.com
 * Date:     2019/7/1 20:02
 * Description:
 *
 * @Controller+@ResponseBody=@RestController
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private LimitConfig limitConfig;
    //@GetMapping("/say/{id}")  // public String say(@PathVariable("id") Integer id)    http://localhost:8081/luckymoney/hello/say/100
    @PostMapping("/say")       //public String say(@RequestParam("id") Integer id)    http://localhost:8081/luckymoney/hello/say?id=100
    //@PostMapping({"/say","/hi"})
    //@RequestMapping("/say")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        //return "说明："+limitConfig.getDescription();
        //return "index";
        return "id:"+id;
    }
}
