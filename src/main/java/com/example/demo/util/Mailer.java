package com.example.demo.util;

import com.example.demo.entity.BookinginfoStruct;
import com.example.demo.entity.FlightMasterStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;

@Service
public class Mailer {

    @Autowired
    private JavaMailSender sender;

    public String sendMail(String emailid, BookinginfoStruct bookinginfoStruct) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo("somjoy.bit@gmail.com");
/*
            helper.setTo(bookinginfoStruct.getCust_email());
*/
//            helper.setTo("somjoy.bit@gmail.com");
           // helper.setText("Test email "+emailid+" and your interview is scheduled on at 11:00 AM");
            helper.setText("Flight Booking Confirmation : Departure Date/Time : "+ bookinginfoStruct.getFlightDate() +
                    " No of Seats : " + bookinginfoStruct.getNoOfPass() + " Cost Rs. "+ bookinginfoStruct.getTotal_fare() );
            helper.setSubject("Your Ticket Booking Confirmation");
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending mail ..";
        }
        sender.send(message);
        return "Mail Sent Success!";
    }


}
