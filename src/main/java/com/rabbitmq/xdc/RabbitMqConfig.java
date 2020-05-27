package com.rabbitmq.xdc;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: rabbitmq
 * @Package: com.rabbitmq.xdc
 * @Description: :队列配置，队列的名称，发送者和接受者的名称必须一致，否则接收不到消息
 * @Author: xiangdc16781
 * @CreateDate: 2020-05-25 14:23
 * @UpdateUser: xiangdc16781
 * @UpdateDate: 2020-05-25 14:23
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 **/
@Configuration
public class RabbitMqConfig {
    @Bean
    public Queue Queue1() {
        return new Queue("xdc-test");

    }
    @Bean
    public Queue Queue2() {
        return new Queue("xdc-test2");

    }
}