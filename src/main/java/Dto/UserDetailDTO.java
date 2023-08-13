package Dto;

import java.util.List;

public class UserDetailDTO {
    private String userEmail;
    private String userAvatar;
    private String userName;
    private List<TaskDTO> taskDtoList;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<TaskDTO> getTaskDtoList() {
        return taskDtoList;
    }

    public void setTaskDtoList(List<TaskDTO> taskDtoList) {
        this.taskDtoList = taskDtoList;
    }
}
