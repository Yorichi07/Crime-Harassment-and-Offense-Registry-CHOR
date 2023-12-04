package backend;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class QRCodeGenerator {

    public static void main(String[] args) {
        String link = "https://evaluation-mrgz.vercel.app/login"; // Replace with your link
        String filePath = "qrcode.png"; // Replace with your desired file path

        generateQRCode(link, filePath);
    }

    public static void generateQRCode(String link, String filePath) {
        try {
            int width = 300;
            int height = 300;

            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(link, BarcodeFormat.QR_CODE, width, height, hints);

            File qrCodeFile = new File(filePath);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", qrCodeFile.toPath());
            System.out.println("QR code generated and saved to: " + filePath);
        } catch (Exception e) {
            System.err.println("Error generating QR code: " + e.getMessage());
        }
    }
}

