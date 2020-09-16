package com.liyc.springboot.service;

/**
 * @Author lyc
 * @Date 2020-9-15 18:01
 * @ClassName MailService
 * @Description TODO
 */
public interface MailService {

    public void sendHtmlMail(String to, String subject, String content);

    public void sendAttachmentsMail(String to, String subject, String content, String filePath);

    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
