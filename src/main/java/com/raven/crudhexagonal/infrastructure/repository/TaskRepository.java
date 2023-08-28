package com.raven.crudhexagonal.infrastructure.repository;

import com.raven.crudhexagonal.infrastructure.persistence.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
