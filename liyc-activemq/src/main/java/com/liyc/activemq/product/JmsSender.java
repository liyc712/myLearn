package com.liyc.activemq.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Author lyc
 * @Date 2020-11-16 20:22
 * @ClassName JmsSender
 * @Description TODO
 */
@Component
public class JmsSender {

        @Autowired
        private Queue queue;

        @Autowired
        private Topic topic;

        @Autowired
        private JmsMessagingTemplate jmsTemplate;

        public void sendByQueue(String message) {
            this.jmsTemplate.convertAndSend(queue, message);
        }

        public void sendByTopic(String message) {
            this.jmsTemplate.convertAndSend(topic, message);
        }
    }
