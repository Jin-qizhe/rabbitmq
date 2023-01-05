package com.example.rabbitmq.service.impl;

import cn.hutool.core.date.DateUtil;
import com.example.rabbitmq.constant.RabbitMqConstant;
import com.example.rabbitmq.service.RabbitMQService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author jin
 * @Date 2023/1/5 11:16
 * @Description TODO
 */
@Service
public class RabbitMQServiceImpl implements RabbitMQService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public String sendMsg(String msg) {
        try {
            String msgId = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
            String sendTime = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
            Map<String, Object> map = new HashMap<>();
            map.put("msgId", msgId);
            map.put("sendTime", sendTime);
            map.put("msg", msg);
            rabbitTemplate.convertAndSend(RabbitMqConstant.RABBITMQ_DEMO_DIRECT_EXCHANGE, RabbitMqConstant.RABBITMQ_DEMO_DIRECT_ROUTING, map);
            return "操作成功!";
        } catch (Exception e) {
            e.printStackTrace();
            return "操作失败!";
        }
    }

}
