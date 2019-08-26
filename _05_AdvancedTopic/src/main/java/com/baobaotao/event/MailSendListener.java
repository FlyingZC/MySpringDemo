package com.baobaotao.event;

import org.springframework.context.ApplicationListener;

public class MailSendListener implements ApplicationListener<MailSendEvent> {

    public void onApplicationEvent(MailSendEvent event) {
        System.out.println("MailSendListener:向" + event.getTo() + "发送完一封邮件");
    }
}
