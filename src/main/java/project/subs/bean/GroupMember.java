package project.subs.bean;

import java.time.LocalDateTime;

public class GroupMember {
    boolean isAdmin = false;
    LocalDateTime joinTime = LocalDateTime.now();
    private int groupId;
    private String username;

    public GroupMember(int groupId, String username) {
        this.groupId = groupId;
        this.username = username;
    }

    public GroupMember(int groupId, String username, boolean isAdmin, LocalDateTime joinTime) {
        this.groupId = groupId;
        this.username = username;
        this.isAdmin = isAdmin;
        this.joinTime = joinTime;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public LocalDateTime getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(LocalDateTime joinTime) {
        this.joinTime = joinTime;
    }
}
