package com.sakura.springboottask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {

    @Resource
    JavaMailSender javaMailSender;

    @Test
    public void contextLoads() {
    }

    /**
     * @Description: 发送简单邮件
     * @auther: Sakura
     * @date: 2018/11/28 10:40
     * @param: []
     * @return: void
     */
    @Test
    public void test01() {
        // 创建简单邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("邮件主题-SpringBoot Mail");
        message.setTo("921690132@qq.com");
        message.setFrom("921690132@qq.com");
        message.setText("感谢学习SpringBoot");
        message.setSentDate(new Date("1995/12/22 10:12:12"));
        javaMailSender.send(message);
    }

    /**
     * @Description: 发送复杂的邮件
     * @auther: Sakura
     * @date: 2018/11/28 10:52
     * @param: []
     * @return: void
     */
    @Test
    public void test02() {
        // 创建复杂邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // 邮件助手
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("921690132@qq.com");
            helper.setTo("921690132@qq.com");
            helper.setSubject("Topic-复杂的邮件");
            helper.setText("<h1 style='color:red'>感谢学习SpringBoot</h1>", true);
            helper.addAttachment("pic",new File("C:\\Users\\92169\\Pictures\\8c1001e93901213fdd3370e359e736d12f2e9588.jpg"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }

}
