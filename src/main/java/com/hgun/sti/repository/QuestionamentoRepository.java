package com.hgun.sti.repository;

import com.hgun.sti.models.Questionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionamentoRepository extends JpaRepository<Questionamento, Long> {

    @Query("SELECT q FROM Questionamento q WHERE q.visualizada = true order by q.id DESC")
    List<Questionamento> getAllVisualizadas();

    @Query("SELECT q FROM Questionamento q WHERE q.visualizada = false order by q.id DESC")
    List<Questionamento> getAllNaoVisualizadas();
}
