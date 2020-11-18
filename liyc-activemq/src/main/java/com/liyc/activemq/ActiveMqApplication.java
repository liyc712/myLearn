package com.liyc.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Author lyc
 * @Date 2020-11-16 19:44
 * @ClassName ActiveMqApplication
 * @Description TODO
 */
@SpringBootApplication
public class ActiveMqApplication {
    
    private static final Logger log = LoggerFactory.getLogger(ActiveMqApplication.class);

    public static final String QUEUE_NAME = "activemq_queue";

    public static final String TOPIC_NAME = "activemq_topic";

    public static void main(String[] args) {
        SpringApplication.run(ActiveMqApplication.class,args);
    }

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(QUEUE_NAME);
    }

    @Bean
    public Topic topic() {
        return new ActiveMQTopic(TOPIC_NAME);
    }

}
