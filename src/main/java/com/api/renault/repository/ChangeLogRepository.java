package com.api.renault.repository;

import com.api.renault.models.ChangeLogModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangeLogRepository extends JpaRepository<ChangeLogModel, Long> {}
