package com.raven.crudhexagonal.config;

import com.raven.crudhexagonal.domain.port.TaskPersistencePort;
import com.raven.crudhexagonal.domain.port.TaskServicePort;
import com.raven.crudhexagonal.domain.service.TaskServicePortImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {

    @Bean
    public TaskServicePort taskService(TaskPersistencePort taskPersistencePort){
        return new TaskServicePortImp(taskPersistencePort);
    }

}
