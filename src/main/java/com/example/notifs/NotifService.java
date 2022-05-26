package com.example.notifs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotifService {
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public NotifService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendGlobalNotification() {
        ResponseNotif notifResponse = new ResponseNotif("Global Notification");
        messagingTemplate.convertAndSend("/topic/global-notifications", notifResponse);
    }
}
