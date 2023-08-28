package com.raven.crudhexagonal.infrastructure.mapper;

import com.raven.crudhexagonal.domain.model.TaskModel;
import com.raven.crudhexagonal.infrastructure.persistence.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskModel toTaskmodel(TaskEntity taskEntity);

    TaskEntity toTaskEntity(TaskModel taskModel);

    List<TaskModel> mapToTaskModelList(List<TaskEntity> taskEntityList);

}
