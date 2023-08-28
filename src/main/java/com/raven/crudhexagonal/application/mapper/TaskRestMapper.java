package com.raven.crudhexagonal.application.mapper;

import com.raven.crudhexagonal.application.model.TaskRequest;
import com.raven.crudhexagonal.application.model.TaskResponse;
import com.raven.crudhexagonal.domain.model.TaskModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TaskRestMapper {

    TaskRestMapper INSTANCE = Mappers.getMapper(TaskRestMapper.class);

    TaskModel toTaskModel(TaskRequest taskRequest);

    TaskResponse toTaskResponse(TaskModel taskModel);

    List<TaskResponse> mapToTaskListResponse(List<TaskModel> taskModelList);

}
