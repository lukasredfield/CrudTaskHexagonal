package com.raven.crudhexagonal.application.controller;

import com.raven.crudhexagonal.application.mapper.TaskRestMapper;
import com.raven.crudhexagonal.application.model.TaskRequest;
import com.raven.crudhexagonal.application.model.TaskResponse;
import com.raven.crudhexagonal.domain.model.TaskModel;
import com.raven.crudhexagonal.domain.port.TaskServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskServicePort taskServicePort;

    @PostMapping("/new")
    public ResponseEntity<TaskResponse> newTask(@RequestBody TaskRequest taskRequest){
        TaskModel taskModel = TaskRestMapper.INSTANCE.toTaskModel(taskRequest);
        TaskResponse taskResponse = TaskRestMapper.INSTANCE.toTaskResponse(taskModel);
        this.taskServicePort.createTask(taskModel);
        return ResponseEntity.ok().body(taskResponse);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable Long id){
       TaskResponse taskfound = TaskRestMapper.INSTANCE.toTaskResponse(taskServicePort.getTaskById(id));
       return ResponseEntity.ok(taskfound);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TaskResponse>> getAllTask(){
        return ResponseEntity.ok(TaskRestMapper.INSTANCE.
                mapToTaskListResponse(this.taskServicePort.getAllTask())) ;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<TaskResponse> deleteTask(@RequestParam Long id){
        this.taskServicePort.deleteTask(id);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaskResponse> updateTask(@RequestBody TaskRequest taskRequest, @PathVariable Long id){
        TaskResponse taskResponse = TaskRestMapper.INSTANCE.toTaskResponse(this.taskServicePort.updateTask(id, taskRequest.getTitle(), taskRequest.getContent()));

        return ResponseEntity.status(HttpStatus.CREATED).body(taskResponse);
    }





}
