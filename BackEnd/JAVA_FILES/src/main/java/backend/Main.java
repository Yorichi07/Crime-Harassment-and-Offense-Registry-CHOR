package backend;

import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class Main {
    public static void main(String[] args) {
        QRCode qrCode = QRCode.from("https://www.youtube.com/watch?v=SiYNfDUJl_Y").withSize(1, 1).withErrorCorrection(ErrorCorrectionLevel.H).withMargin(4);
        
        BufferedImage image = qrCode.to(ImageType.PNG).withSize(400, 400).stream()
                .reduce(BufferedImage::new, (a, b) -> {
                    b.copyData(a.getRaster());
                    return a;
                });
        
        try {
            ImageIO.write(image, "png", new File("youtube1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}