package project.subs.bean;

import java.time.LocalDateTime;

public class Notification {
    private int notiId = -1;
    private String sender;
    private String receiver;
    private int groupId;
    private String notiTypeName;
    private boolean isRead = false;
    private LocalDateTime notiTime = LocalDateTime.now();

    public Notification(String sender, String receiver, int groupId, String notiTypeName) {
        this.sender = sender;
        this.receiver = receiver;
        this.groupId = groupId;
        this.notiTypeName = notiTypeName;
    }

    public Notification(int notiId, String sender, String receiver, int groupId, String notiTypeName, boolean isRead, LocalDateTime notiTime) {
        this.notiId = notiId;
        this.sender = sender;
        this.receiver = receiver;
        this.groupId = groupId;
        this.notiTypeName = notiTypeName;
        this.isRead = isRead;
        this.notiTime = notiTime;
    }

    public int getNotiId() {
        return notiId;
    }

    public void setNotiId(int notiId) {
        this.notiId = notiId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getNotiTypeName() {
        return notiTypeName;
    }

    public void setNotiTypeName(String notiTypeName) {
        this.notiTypeName = notiTypeName;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public LocalDateTime getNotiTime() {
        return notiTime;
    }
}
