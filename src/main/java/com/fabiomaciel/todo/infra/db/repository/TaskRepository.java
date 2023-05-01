package com.fabiomaciel.todo.infra.db.repository;

import com.fabiomaciel.todo.infra.db.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
