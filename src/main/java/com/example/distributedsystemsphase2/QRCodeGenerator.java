package com.example.distributedsystemsphase2;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.*;
import java.nio.file.*;

public class QRCodeGenerator {

    //Author: Trey Roche
    //Code from Callicoder: https://www.callicoder.com/generate-qr-code-in-java-using-zxing/

    private static final String QR_CODE_IMAGE_PATH = "./utils/QRCode.png";

    private static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {

        QRCodeWriter qrWriter = new QRCodeWriter();
        BitMatrix bitMat = qrWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMat, "PNG", path);
    }

    public static void main(String[] args) {
        try {
            generateQRCodeImage("Hello World", 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException :: " + e.getMessage());
        }
    }
}