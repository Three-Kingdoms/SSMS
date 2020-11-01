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

    @ManyToOne
    @JoinColumn(name="service_id")
    private Service service;

    @Column(nullable = false)
    private String subsAccount;

    @Column(nullable = false)
    private LocalDateTime createTime = LocalDateTime.now();

    public Group() {
    }

    public Group(String groupName, GroupType groupType, int userCount, Service service, String subsAccount) {
        this.groupName = groupName;
        this.groupType = groupType;
        this.userCount = userCount;
        this.service = service;
        this.subsAccount = subsAccount;
    }

    public Group(String groupName, GroupType groupType, int userCount, Service service, String subsAccount, LocalDateTime createTime) {
        this.groupName = groupName;
        this.groupType = groupType;
        this.userCount = userCount;
        this.service = service;
        this.subsAccount = subsAccount;
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", groupType='" + groupType + '\'' +
                ", userCount=" + userCount +
                ", service=" + service +
                ", subsAccount='" + subsAccount + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
