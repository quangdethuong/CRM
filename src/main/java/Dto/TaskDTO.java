package Dto;

import java.util.Date;

public class TaskDTO {

    private int id;
    private String name;
    private Date startDay;
    private Date endDay;

    private String start_DayStr;

    public String getStart_DayStr() {
        return start_DayStr;
    }

    public void setStart_DayStr(String start_DayStr) {
        this.start_DayStr = start_DayStr;
    }

    public String getEnd_DayStr() {
        return end_DayStr;
    }

    public void setEnd_DayStr(String end_DayStr) {
        this.end_DayStr = end_DayStr;
    }

    private String end_DayStr;
    private int userId;
    private String userName;
    private int jobId;
    private String jobName;
    private int statusId;
    private String statusDesc;

    private String taskName;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}
