package com.rabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: rabbitmq
 * @Package: com.rabbitmq.controller
 * @Description: 发送者通过Controller类发送消息
 * @Author: xiangdc16781
 * @CreateDate: 2020-05-25 14:26
 * @UpdateUser: xiangdc16781
 * @UpdateDate: 2020-05-25 14:26
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 **/
@RestController
public class SendController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 一个发送者发送消息，一个接收者接收消息
     * @return
     */
    @RequestMapping("/send")
    public String send(){
        String content="Date:"+new Date();
        amqpTemplate.convertAndSend("xdc-test",content);
        return content;
    }

    /**
     * 一个发送者发送消息，多个接收者接收消息
     * @return
     */
    @RequestMapping("/multiSend")
    public String multiSend() {
        StringBuilder times = new StringBuilder();
        for (int i = 1; i < 11; i++) {
            long time = System.nanoTime();
            amqpTemplate.convertAndSend("xdc-test", "第" + i + "次发送的时间：" + time);
            times.append(time + "<br>");
        }
        return times.toString();
    }

    @RequestMapping("/multi2MultiSend")
    public String mutil2MutilSend(){
        StringBuilder times=new StringBuilder();
        for(int i=1;i<11;i++){
            long time=System.nanoTime();
            amqpTemplate.convertAndSend("xdc-test","第"+i+"次发送的时间："+time);
            amqpTemplate.convertAndSend("xdc-test2","第"+i+"次发送的时间："+time);
            times.append(time+"<br>");
        }
        return times.toString();
    }

}
