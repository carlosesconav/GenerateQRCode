package com.example.demo.service;

import com.google.zxing.WriterException;

import java.io.IOException;

public interface QRService {

    byte[] generateQRCode(String content)throws WriterException, IOException;

}
