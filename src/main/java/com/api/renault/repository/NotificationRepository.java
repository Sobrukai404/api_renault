package com.api.renault.repository;

import com.api.renault.models.NotificationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationModel, Integer> {
}
