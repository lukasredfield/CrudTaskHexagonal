package com.raven.crudhexagonal.domain.service;

import com.raven.crudhexagonal.domain.model.TaskModel;
import com.raven.crudhexagonal.domain.port.TaskPersistencePort;
import com.raven.crudhexagonal.domain.port.TaskServicePort;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class TaskServicePortImp implements TaskServicePort {

    private final TaskPersistencePort taskPersistencePort;

    @Override
    public TaskModel getTaskById(Long id) {
        return this.taskPersistencePort.getTaskById(id);
    }

    @Override
    public void deleteTask(Long id) {
        this.taskPersistencePort.deleteTask(id);
    }

    @Override
    public TaskModel updateTask(Long id, String title, String content) {
        return this.taskPersistencePort.updateTask(id, title, content);
    }

    @Override
    public TaskModel createTask(TaskModel taskModel) {
        return this.taskPersistencePort.createTask(taskModel);
    }

    @Override
    public List<TaskModel> getAllTask() {
        return this.taskPersistencePort.getAllTask();
    }
}
