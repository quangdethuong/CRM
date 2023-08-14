package Service;

import Dto.TaskDTO;
import Respository.StatusRepository;
import Respository.TaskRepository;
import model.StatusModel;
import model.TaskModel;

import java.sql.Date;
import java.util.List;

public class TaskService {
    private TaskRepository taskRepository = new TaskRepository();
    private StatusRepository statusRepository = new StatusRepository();



    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll();
    }

    public  boolean insertTask(String name, Date startDay, Date endDay, int userId, int jobId) {
        return taskRepository.insertTask(name, startDay, endDay, userId, jobId);
    }

    public List<StatusModel> getAllStatus() {
        return statusRepository.findAll();
    }

    public boolean deleteTask(int id) {
        return taskRepository.deleteTaskById(id);
    }

    public TaskModel findById(int id) {
        return taskRepository.findTaskById(id);
    }

    public boolean updateTask(int id, String name, Date startDay, Date endDay, int userId, int jobId, int statusId) {
        return taskRepository.updateTask(id, name, startDay, endDay, userId, jobId, statusId);
    }
}
