package com.example.notifs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {
    private final SimpMessagingTemplate messagingTemplate;
    private final NotifService notifService;

    @Autowired
    public WebSocketService(SimpMessagingTemplate messagingTemplate, NotifService notifService) {
        this.messagingTemplate = messagingTemplate;
        this.notifService = notifService;
    }

    public void notifyFrontend(final String message) {
        ResponseNotif responseNotif = new ResponseNotif(message);
        notifService.sendGlobalNotification();
        messagingTemplate.convertAndSend("/topic/messages", responseNotif);
    }
}
