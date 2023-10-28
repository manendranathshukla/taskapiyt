package com.mycodeworks.taskapiyt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycodeworks.taskapiyt.models.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    
}
