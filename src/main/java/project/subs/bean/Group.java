package project.subs.bean;

import java.time.LocalDateTime;

public class Group {
    private int groupId = -1;
    private String groupName;
    private String groupType;
    private int userCount;
    private int serviceId;
    private String subsAccount;
    private LocalDateTime createTime = LocalDateTime.now();

    public Group(String groupName, String groupType, int userCount, int serviceId, String subsAccount) {
        this.groupName = groupName;
        this.groupType = groupType;
        this.userCount = userCount;
        this.serviceId = serviceId;
        this.subsAccount = subsAccount;
    }

    public Group(int groupId, String groupName, String groupType, int userCount, int serviceId, String subsAccount, LocalDateTime createTime) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupType = groupType;
        this.userCount = userCount;
        this.serviceId = serviceId;
        this.subsAccount = subsAccount;
        this.createTime = createTime;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getSubsAccount() {
        return subsAccount;
    }

    public void setSubsAccount(String subsAccount) {
        this.subsAccount = subsAccount;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
