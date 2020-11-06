package project.subs.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "groupmember")
public class GroupMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    boolean isAdmin = false;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime joinTime = LocalDateTime.now();

    public GroupMember() {
    }

    public GroupMember(Group group, User user) {
        this.group = group;
        this.user = user;
    }

    @Override
    public String toString() {
        return "GroupMember{" +
                "id=" + id +
                ", group=" + group +
                ", user=" + user +
                ", isAdmin=" + isAdmin +
                ", joinTime=" + joinTime +
                '}';
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
