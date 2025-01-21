package com.example.booking_service.service;

import com.example.booking_service.clients.User;
import com.example.booking_service.clients.UserClient;
import com.example.booking_service.entity.NotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private JavaMailSender javaMailSender;

   @Async
    public void notifyUser(NotificationMessage notificationMessage) {
        SimpleMailMessage message=new SimpleMailMessage();
        long userId=notificationMessage.getUserId();
        User user=userClient.getUserById(userId).getBody();
        if(user!=null){
           // message.setFrom(user.getEmailId());
            message.setTo(user.getEmailId());
            message.setText(notificationMessage.getMessage());
            message.setSubject("Booking Confirmation for Turf");
            for(int i=0;i<10;i++)
                javaMailSender.send(message);
        }else{
            System.out.println("No user founded with that id..............");
        }

    }

    @Async
    public void notifyTurf(NotificationMessage notificationMessage) {
        SimpleMailMessage message=new SimpleMailMessage();
        long userId=notificationMessage.getUserId();
        User user=userClient.getUserById(userId).getBody();
        if(user!=null){
            // message.setFrom(user.getEmailId());
            message.setTo("fujith076@gmail.com");
            message.setText(notificationMessage.getMessage());
            message.setSubject("Booking Confirmation for Turf");
            for(int i=0;i<10;i++)
                javaMailSender.send(message);
        }else{
            System.out.println("No user founded with that id..............");
        }
    }
}
