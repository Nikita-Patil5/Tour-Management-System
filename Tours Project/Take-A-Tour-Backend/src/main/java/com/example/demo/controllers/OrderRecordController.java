
package com.example.demo.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.BookTourDummy;
import com.example.demo.entities.EmailModel;
import com.example.demo.entities.Orderrecord;
import com.example.demo.entities.PlannedTour;
import com.example.demo.entities.Tourist;
import com.example.demo.entities.Transaction;
import com.example.demo.services.EmailService;
import com.example.demo.services.OrderRecordService;
import com.example.demo.services.PlannedTourService;
import com.example.demo.services.TouristRegService;
import com.example.demo.services.TransactionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OrderRecordController {

    @Autowired
    TransactionService transactionserv;

    @Autowired
    PlannedTourService ptserv;

    @Autowired
    TouristRegService trstserv;

    @Autowired
    OrderRecordService orderservice;

    @Autowired
    EmailService emailService;

    @PostMapping("/Booktourbytourist")
    public Orderrecord InsertRecord(@RequestBody BookTourDummy booktobj) throws ParseException {
        System.out.println(booktobj);

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        String formattedDate = format.format(date);
        date = format.parse(formattedDate);
        System.out.println("-------------------" + date);

        Transaction tranobj = new Transaction(booktobj.getTotamount(), booktobj.getPaymenttype(), date);
        Transaction resptranobj = transactionserv.insertRecord(tranobj);

        System.out.println(resptranobj);

        PlannedTour resptourobj = ptserv.getPlannedTourByIdForBooking(booktobj.getTourid());
        if (resptourobj == null) {
            throw new RuntimeException("PlannedTour not found for id: " + booktobj.getTourid());
        }

        Tourist resptouristobj = trstserv.getTouristByIdForBooking(booktobj.getTouristid());
        if (resptouristobj == null) {
            throw new RuntimeException("Tourist not found for id: " + booktobj.getTouristid());
        }

        Orderrecord orderobj = new Orderrecord(booktobj.getTravellernumber(), resptourobj, resptranobj, resptouristobj);

        Orderrecord resporderobj = orderservice.saveOrderRecord(orderobj);

        int travno = resptourobj.getAvailseats() - booktobj.getTravellernumber();
        ptserv.updateavailableseats(booktobj.getTourid(), travno);

        // Send confirmation email
        EmailModel emailModel = new EmailModel();
        emailModel.setToMail(resptouristobj.getT_email());
        emailModel.setEmailSubject("Booking Confirmation");

        // Include tour details in the email body
        String emailBody = "Your booking has been confirmed. Order ID: " + resporderobj.getOrder_id() + "\n" +
                           "Tour Details:\n" +
                           "Tour Id: " + resptourobj.getTour_id() + "\n" +
                           "Tour Date: " + resptourobj.getStartdate() + "\n" +
                           "Number of Travellers: " + booktobj.getTravellernumber() + "\n" +
                           "Total Amount: " + booktobj.getTotamount() + "\n" +
                           "Payment Type: " + booktobj.getPaymenttype();
        emailModel.setEmailBody(emailBody);

        emailService.sendEmailWithAttachment(emailModel, null);

        return resporderobj;
    }
}