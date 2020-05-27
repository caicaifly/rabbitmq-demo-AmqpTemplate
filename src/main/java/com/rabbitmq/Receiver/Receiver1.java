package com.rabbitmq.Receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: rabbitmq
 * @Package: com.rabbitmq.Receiver
 * @Description: note
 * @Author: xiangdc16781
 * @CreateDate: 2020-05-25 14:28
 * @UpdateUser: xiangdc16781
 * @UpdateDate: 2020-05-25 14:28
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 **/

@Component
@RabbitListener(queues = "xdc-test")
public class Receiver1 {
    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("Test1 receiver1:" + msg);

    }
}
