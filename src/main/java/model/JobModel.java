package model;

import Dto.TaskDTO;

import java.util.List;

public class JobModel {
    private int id;
    private String name;
    private String start_date;
    private String end_date;


    private List<TaskDTO> taskModelList;

    private TaskModel taskModel;

    public TaskModel getTaskModel() {
        return taskModel;
    }

    public void setTaskModel(TaskModel taskModel) {
        this.taskModel = taskModel;
    }

    public List<TaskDTO> getTaskModelList() {
        return taskModelList;
    }

    public void setTaskModelList(List<TaskDTO> taskModelList) {
        this.taskModelList = taskModelList;
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

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
