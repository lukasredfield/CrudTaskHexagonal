package com.raven.crudhexagonal.infrastructure.adapter;

import com.raven.crudhexagonal.domain.model.TaskModel;
import com.raven.crudhexagonal.domain.port.TaskPersistencePort;
import com.raven.crudhexagonal.infrastructure.mapper.TaskMapper;
import com.raven.crudhexagonal.infrastructure.persistence.TaskEntity;
import com.raven.crudhexagonal.infrastructure.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskAdapter implements TaskPersistencePort {

    public final TaskRepository taskRepository;

    @Override
    public TaskModel getTaskById(Long id) {
        Optional<TaskEntity> taskEntity = this.taskRepository.findById(id);
        return taskEntity.map(TaskMapper.INSTANCE::toTaskmodel).orElse(null);
    }

    @Override
    public void deleteTask(Long id) {
        this.taskRepository.deleteById(id);

    }

    @Override
    public TaskModel updateTask(Long id, String title, String content) {
        TaskModel findTask = this.getTaskById(id);
        findTask.setTitle(title);
        findTask.setContent(content);
        TaskEntity updateTask = TaskMapper.INSTANCE.toTaskEntity(findTask);
        this.taskRepository.save(updateTask);
        return TaskMapper.INSTANCE.toTaskmodel(updateTask);
    }

    @Override
    public TaskModel createTask(TaskModel taskModel) {
        TaskEntity newTask = this.taskRepository
                .save(TaskMapper.INSTANCE.toTaskEntity(taskModel));
        return TaskMapper.INSTANCE.toTaskmodel(newTask);
    }

    @Override
    public List<TaskModel> getAllTask(){
        List<TaskEntity> entityList = this.taskRepository.findAll();
        return TaskMapper.INSTANCE.mapToTaskModelList(entityList);
    }
}
