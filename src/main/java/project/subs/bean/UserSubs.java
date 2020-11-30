package project.subs.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Table(name = "usersubs")
public class UserSubs {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="service_id")
    private Service service;

    @Column(nullable = false,unique = true)
    private String subsAccount;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startTime = null;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime endTime = null;
    private int duration;
    private String description;

    public UserSubs(Integer id, User user, Service service, String subsAccount, LocalDateTime startTime, LocalDateTime endTime, int duration, String description) {
        this.id = id;
        this.user = user;
        this.service = service;
        this.subsAccount = subsAccount;
        this.startTime = startTime;
        this.endTime = endTime;
        if (this.startTime == null || this.endTime == null) this.duration = 0;
        else this.duration = (int) Duration.between(this.startTime, this.endTime).toDays();
        this.description = description;
    }

    public UserSubs(User user, Service service, String subsAccount, LocalDateTime startTime, LocalDateTime endTime, String description) {
        this.user = user;
        this.service = service;
        this.subsAccount = subsAccount;
        this.startTime = startTime;
        this.endTime = endTime;
        if (this.startTime == null || this.endTime == null) this.duration = 0;
        else this.duration = (int) Duration.between(this.startTime, this.endTime).toDays();
        this.description = description;
    }

    public UserSubs(User user, Service service, String subsAccount) {
        this.user = user;
        this.service = service;
        this.subsAccount = subsAccount;
    }

    public UserSubs() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

//    public void setStartTime(String startTime) {
//        this.startTime = LocalDateTime.parse(startTime + " 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00"));
//    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

//    public void setEndTime(String endTime) {
//        this.endTime = LocalDateTime.parse(endTime + " 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00"));
//    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserSubs{" +
                "id=" + id +
                ", user=" + user +
                ", service=" + service +
                ", subsAccount='" + subsAccount + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                '}';
    }
}
