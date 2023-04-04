package com.ekang.todorestapi.repository;

import com.ekang.todorestapi.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Override
    List<Todo> findAll();

    @Query("SELECT t FROM Todo t WHERE t.accountId = :accountId")
    List<Todo> findAllWithUserId(@Param("accountId") Long accountId);

}
