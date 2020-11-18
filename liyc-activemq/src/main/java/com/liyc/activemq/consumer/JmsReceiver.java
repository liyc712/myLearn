package com.liyc.activemq.consumer;

import com.liyc.activemq.ActiveMqApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author lyc
 * @Date 2020-11-16 20:23
 * @ClassName JmsReceiver
 * @Description TODO
 */
@Component
public class JmsReceiver {

    private static final Logger log = LoggerFactory.getLogger(JmsReceiver.class);

    @JmsListener(destination = ActiveMqApplication.QUEUE_NAME)
    public void receiveByQueue(String message) {
        log.info("receiveByQueue接收队列消息:" + message);
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @JmsListener(destination = ActiveMqApplication.QUEUE_NAME)
    public void receiveByQueue2(String message) {
        log.info("receiveByQueue2接收队列消息:" + message);
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @JmsListener(destination = ActiveMqApplication.TOPIC_NAME)
    public void receiveByTopic(String message) {
        log.info("receiveByTopic接收主题消息:" + message);
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @JmsListener(destination = ActiveMqApplication.TOPIC_NAME)
    public void receiveByTopic2(String message) {
        log.info("receiveByTopic2接收主题消息:" + message);
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
