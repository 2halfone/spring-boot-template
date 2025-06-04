package com.example.springmon.repository;

import com.example.springmon.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
    // Metodi comuni per tutte le entità che estendono BaseEntity
}
