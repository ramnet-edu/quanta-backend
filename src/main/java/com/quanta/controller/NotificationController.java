package com.quanta.controller;

import com.quanta.model.Notification;
import com.quanta.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send")
    public ResponseEntity<Notification> send(@RequestBody Notification notification) {
        return ResponseEntity.ok(notificationService.sendNotification(notification));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Notification>> getByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(notificationService.getByStudent(studentId));
    }
}