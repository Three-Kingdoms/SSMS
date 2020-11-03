package project.subs.bean;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false)
    private String groupName;

    @Column
    @Enumerated(EnumType.STRING)
    private GroupType groupType;

    @Column(nullable = false)
    private int userCount;


    @OneToOne
    @JoinColumn(name = "subs_id")
    private UserSubs userSubs;

    @Column(nullable = false)
    private LocalDateTime createTime = LocalDateTime.now();

    public Group() {
    }

    public Group(String groupName, GroupType groupType, int userCount, UserSubs userSubs) {
        this.groupName = groupName;
        this.groupType = groupType;
        this.userCount = userCount;
        this.userSubs = userSubs;
    }

    public Group(String groupName, GroupType groupType, int userCount, UserSubs userSubs, LocalDateTime createTime) {
        this.groupName = groupName;
        this.groupType = groupType;
        this.userCount = userCount;
        this.userSubs = userSubs;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public GroupType getGroupType() {
        return groupType;
    }

    public void setGroupType(GroupType groupType) {
        this.groupType = groupType;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public UserSubs getUserSubs() {
        return userSubs;
    }

    public void setUserSubs(UserSubs userSubs) {
        this.userSubs = userSubs;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", groupType=" + groupType +
                ", userCount=" + userCount +
                ", userSubs=" + userSubs +
                ", createTime=" + createTime +
                '}';
    }
}
