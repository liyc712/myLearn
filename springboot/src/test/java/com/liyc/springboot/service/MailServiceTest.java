package com.liyc.springboot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author lyc
 * @Date 2020-9-16 10:01
 * @ClassName MailServiceTest
 * @Description TODO
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MailServiceTest {


    @Autowired
    private MailService mailService;

    @Test
    public void sendHtmlMail(){
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("liyc712@163.com","test simple mail",content);
    }

    @Test
    public void sendAttachmentsMail(){

    }

}
