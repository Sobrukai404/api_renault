package com.api.renault.controllers;


import com.api.renault.dto.NotificationDTO;
import com.api.renault.responses.ErrorResponse;
import com.api.renault.responses.SuccessResponse;
import com.api.renault.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/renault/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;


    @PostMapping
    public ResponseEntity<Object> createNotification(@RequestBody NotificationDTO notificationDTO) {
        try {
            NotificationDTO createdNotification = notificationService.create(notificationDTO);
            return SuccessResponse.success200(createdNotification);
        }catch (Exception e){
            return ErrorResponse.error500(e);
        }
    }


    @GetMapping("/one")
    public ResponseEntity<Object> getNotificationById(@RequestParam(name = "id_notification") Integer idNotification) {
        try {
            Optional<NotificationDTO> notification = notificationService.get(idNotification);
            return SuccessResponse.success200(notification);
    }catch (Exception e) {
            return ErrorResponse.error500(e);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getAllNotifications() {
        try {
            List<NotificationDTO> notifications = notificationService.getAll();
            return SuccessResponse.success200(notifications);

        }catch (Exception e){
            return ErrorResponse.error500(e);

        }

    }


    @DeleteMapping()
    public ResponseEntity<Object> deleteNotification(@RequestParam(name = "id_notification") Integer idNotification) {

        try {
            notificationService.delete(idNotification);
            return SuccessResponse.success200("ok");

        }catch (Exception e){
            return ErrorResponse.error500(e);

        }


        }
}
