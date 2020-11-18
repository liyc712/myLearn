package com.liyc.activemq.test.product;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;

/**
 * @Author lyc
 * @Date 2020-11-18 15:16
 * @ClassName QueueProducer
 * @Description 队列模式--点对点
 */
public class QueueProducer {

    public static void main(String[] args) {
        try {
            // 创建工厂
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");


            // 创建连接
            Connection connection = connectionFactory.createConnection();
            connection.start();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
