package com.example.notifs;

import java.util.ArrayList;
import java.util.List;

public class Notif {
    private String notifType;
    private String notifMessage;

    public String getNotifType() {
        return notifType;
    }

    public void setNotifType(String notifType) {
        this.notifType = notifType;
    }

    public String getNotifMessage() {
        return notifMessage;
    }

    public void setNotifMessage(String notifMessage) {
        this.notifMessage = notifMessage;
    }

    public ArrayList<String> getContextActions() {
        return contextActions;
    }

    public void setContextActions(ArrayList<String> contextActions) {
        this.contextActions = contextActions;
    }

    private ArrayList<String> contextActions = new ArrayList<>();

    public Notif(String notifType, String notifMessage, ArrayList<String> contextActions) {
        this.notifType = notifType;
        this.notifMessage = notifMessage;
        this.contextActions = contextActions;
    }

    public Notif(String notifMessage) {
        this.notifMessage = notifMessage;
        this.notifType = "notif-alert";
        this.contextActions.add("report-notif");
    }
}
