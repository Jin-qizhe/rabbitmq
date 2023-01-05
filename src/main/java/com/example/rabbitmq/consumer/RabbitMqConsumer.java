package com.example.rabbitmq.consumer;

import com.example.rabbitmq.constant.RabbitMqConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author jin
 * @Date 2023/1/5 11:48
 * @Description 消费者
 */
@Component
@RabbitListener(queues = {RabbitMqConstant.RABBITMQ_DEMO_TOPIC})
public class RabbitMqConsumer {

    @RabbitHandler
    public void process(Map map) {
        System.out.println("消费者RabbitMqConsumer从MQ服务端消费消息:" + map.toString());
    }

}

