package com.raven.crudhexagonal.domain.port;

import com.raven.crudhexagonal.domain.model.TaskModel;

import java.util.List;


public interface TaskServicePort {

    TaskModel getTaskById(Long id);

    void deleteTask(Long id);

    TaskModel updateTask(Long id, String title, String content);

    TaskModel createTask(TaskModel taskModel);

    List<TaskModel> getAllTask();



}
