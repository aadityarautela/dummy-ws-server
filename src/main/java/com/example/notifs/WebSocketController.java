package com.example.notifs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {
    @Autowired
    private WebSocketService service;

    @PostMapping("/send-notif")
    public void sendNotif(@RequestBody final Notif notif) {
        service.notifyFrontend(notif.getNotifMessage());
    }
}
