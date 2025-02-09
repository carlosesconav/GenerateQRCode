package com.example.demo.controller;

import com.example.demo.constants.HeaderEnum;
import com.example.demo.service.QRService;
import com.example.demo.service.QRServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QRRestController {

    private final QRService qrService = new QRServiceImpl();

    @GetMapping("/generateQr")
    public ResponseEntity<byte[]> generateQrCode() {
        try {
            byte[] qrCode = qrService.generateQRCode("https://periferiaitgroup.com/");
            HttpHeaders headers = new HttpHeaders();
            headers.set(HeaderEnum.CONTENT_TYPE.getHeaderName(),
                    HeaderEnum.CONTENT_TYPE.getHeaderValue());
            return new ResponseEntity<>(qrCode, headers, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
