package com.example.demo.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class QRServiceImpl implements QRService {

    /**
     * Servicio para generar el código QR en formato imagen,
     * de esta manera usando la librería ZXING de google podemos
     * generar códigos QR con el contenido que queramos-
     *
     * @param content Contenido del código QR
     * @return La imagen del QR en bytes
     * @throws WriterException Por si ocurre un error al escribir el contenido del QR
     * @throws IOException     Por si ocurre un error generando la imagen
     */
    @Override
    public byte[] generateQRCode(String content) throws WriterException, IOException {
        //Método de la librería para escribir el contenido del QR
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        // Método de la librería para poder escribir el QR con su contenido, tipo de código y dimensiones
        BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, 200, 200);

        //Con estos métodos hacemos que se lea la imagen en bits para después poder transformarla
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        //Con este método escribimos la imagen que queremos generar y la guardamos en el array
        ImageIO.write(bufferedImage, "png", byteArrayOutputStream);

        //Retornamos el array con la imagen
        return byteArrayOutputStream.toByteArray();
    }

}
