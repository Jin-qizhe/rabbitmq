package com.example.rabbitmq.controller;

import com.example.rabbitmq.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jin
 * @Date 2023/1/5 11:20
 * @Description TODO
 */
@RestController
@RequestMapping("/rabiitmq")
public class RabbitMQController {

    @Autowired
    private RabbitMQService rabbitMQService;

    @PostMapping("sendMsg")
    public String sendMsg(String msg){
        return rabbitMQService.sendMsg(msg);
    }

}
