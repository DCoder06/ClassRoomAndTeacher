package com.example.QRCodeGenerator.Controllers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scanQR")
public class ScanController {

    public void scanCode(@PathVariable String merchant) {
        System.out.println(merchant);
        System.out.println("Payment done by " + "99902020932.");
    }

}
