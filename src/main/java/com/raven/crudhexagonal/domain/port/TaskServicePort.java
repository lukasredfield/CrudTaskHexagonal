package com.raven.crudhexagonal.domain.port;

import com.raven.crudhexagonal.domain.model.TaskModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface TaskServicePort {

    TaskModel getTaskById(Long id);

    void deleteTask(Long id);

    TaskModel updateTask(Long id);

    TaskModel createTask(TaskModel taskModel);

    List<TaskModel> getAllTask();



}
