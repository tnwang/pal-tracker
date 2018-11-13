package io.pivotal.pal.tracker;

import java.time.LocalDate;

/**
 * Created by tiwang on 11/11/18.
 */
public class TimeEntry {

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry() {
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getProjectId(){
        return projectId;
    }

    public void setProjectId(long projectId){
        this.projectId = projectId;
    }

    public long getUserId(){
        return userId;
    }

    public void setUserId(long userId){
        this.userId = userId;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public int getHours(){
        return hours;
    }

    public void setHours(int hours){
        this.hours = hours;
    }

    public boolean equals(Object obj) {
        return obj instanceof TimeEntry
                && id == (((TimeEntry) obj).getId())
                && projectId == (((TimeEntry) obj).getProjectId())
                && userId == (((TimeEntry) obj).getUserId())
                && (date.compareTo(((TimeEntry) obj).getDate()) == 0)
                && hours == (((TimeEntry) obj).getHours());
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(id);
        result = 31 * result + Long.hashCode(projectId);
        result = 31 * result + Long.hashCode(userId);
        result = 31 * result + date.hashCode();
        result = 31 * result + hours;
        return result;
    }

    public String toString() {
        return "ID: " + id
                + " | projectID: " + projectId
                + " | userID: " + userId
                + " | date: " + date
                + " | hours: " + hours;
    }

}
