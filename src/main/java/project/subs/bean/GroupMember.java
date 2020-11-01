package project.subs.bean;

import javax.persistence.*;
import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "groupmember")
public class GroupMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    boolean isAdmin = false;

    @Column(nullable = false)
    LocalDateTime joinTime = LocalDateTime.now();

    public GroupMember() {
    }

    public GroupMember(Group group, User user) {
        this.group = group;
        this.user = user;
    }

    public GroupMember(Group group, User user, boolean isAdmin, LocalDateTime joinTime) {
        this.group = group;
        this.user = user;
        this.isAdmin = isAdmin;
        this.joinTime = joinTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
