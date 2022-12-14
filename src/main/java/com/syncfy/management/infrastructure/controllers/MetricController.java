package com.syncfy.management.infrastructure.controllers;

import com.syncfy.management.domain.*;
import com.syncfy.management.infrastructure.services.IMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/metrics")
public class MetricController {
    @Autowired
    private IMetricService metricService;

    @PostMapping("/alert/new-alert")
    public ResponseEntity<AlertDtoDomain> newAlert(@RequestBody AlertDtoCreatorDomain creatorDomain)  {
        AlertDtoDomain alertDtoDomain = metricService.newAlert(creatorDomain);
        return new ResponseEntity<>(alertDtoDomain, HttpStatus.OK);
    }

    @GetMapping("/alert/{id}")
    public ResponseEntity<List<AlertDtoDomain>> alertsByOAuth(@PathVariable String id) {
        List<AlertDtoDomain> alertList = metricService.alertsByOAuth(id);
        return new ResponseEntity<>(alertList, HttpStatus.OK);
    }

    @DeleteMapping("/alert/{id}")
    public ResponseEntity<Void> deleteAlertByOAuth(@PathVariable String id) {
        metricService.deleteAlertByOAuth(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/notification/{id}")
    public ResponseEntity<List<NotificationDtoDomain>> notificationByOAuth(@PathVariable String id) {
        List<NotificationDtoDomain> notificationList = metricService.notificationByOAuth(id);
        return new ResponseEntity<>(notificationList, HttpStatus.OK);
    }

    @PostMapping("/notification/new-notification")
    public ResponseEntity<NotificationDtoDomain> newNotification(@RequestBody  NotificationDtoCreatorDomain creatorDomain) {
        NotificationDtoDomain notificationDtoDomain = metricService.newNotification(creatorDomain);
        return new ResponseEntity<>(notificationDtoDomain, HttpStatus.OK);
    }

    @DeleteMapping("/notification/{id}")
    public ResponseEntity<Void> deleteNotificationById(@PathVariable String id) {
        metricService.deleteNotificationById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
