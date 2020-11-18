package com.liyc.activemq.controller;

import com.liyc.activemq.product.JmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lyc
 * @Date 2020-11-16 19:40
 * @ClassName TestSendMsg
 * @Description TODO
 */
@RestController
@RequestMapping("/testSendMsg")
public class TestSendMsgController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private JmsSender sender;

    @PostMapping("/testSendByQueue")
    public String testSendByQueue() {
        for (int i = 1; i < 6; i++) {
            this.sender.sendByQueue("hello activemq queue " + i);
        }
        return "success";
    }

    @PostMapping("/testSendByTopic")
    public String testSendByTopic() {
        for (int i = 1; i < 6; i++) {
            this.sender.sendByTopic("hello activemq topic " + i);
        }
        return "test2";
    }
}
