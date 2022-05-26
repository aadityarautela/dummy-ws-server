package com.example.notifs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class NotifController {

    @Autowired
    private NotifService notifService;

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public ResponseNotif getNotif(final Notif notif) throws InterruptedException {
        Thread.sleep(1000);
        notifService.sendGlobalNotification();
        return new ResponseNotif(HtmlUtils.htmlEscape(notif.getNotifType()) +
                HtmlUtils.htmlEscape(notif.getNotifMessage()));
    }
}
