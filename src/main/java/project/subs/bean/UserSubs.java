package project.subs.bean;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class UserSubs {
    private String username;
    private int serviceId;
    private String subsAccount;
    private LocalDateTime startTime = null;
    private LocalDateTime endTime = null;
    private int duration = 0;

    public UserSubs(String username, int serviceId, String subsAccount, LocalDateTime startTime, LocalDateTime endTime) {
        this.username = username;
        this.serviceId = serviceId;
        this.subsAccount = subsAccount;
        this.startTime = startTime;
        this.endTime = endTime;
        if (Objects.equals(startTime, null) || Objects.equals(endTime, null)) this.duration = 0;
        else this.duration = (int) Duration.between(startTime, endTime).toDays();
    }

    public UserSubs(String username, int serviceId, String subsAccount) {
        this.username = username;
        this.serviceId = serviceId;
        this.subsAccount = subsAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "UserSubs{" +
                "username='" + username + '\'' +
                ", serviceId=" + serviceId +
                ", subsAccount='" + subsAccount + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", duration=" + duration +
                '}';
    }
}
