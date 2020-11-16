package com.liyc.common.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lyc
 * @Date 2020-11-16 9:26
 * @ClassName QRCodeGenerator
 * @Description 生成二维码工具类
 */
public class QRCodeGenerator {

    private static final Logger log = LoggerFactory.getLogger(QRCodeGenerator.class);

    /**
     * 利用谷歌插件生成二维码
     * @param content 二维码内容
     * @param width 宽
     * @param height 高
     * @param qrPath 生成二维码路径(带文件名.png)
     * @throws WriterException
     * @throws IOException
     */
    public static void generateQrCode(String content, int width, int height,String qrPath)throws WriterException,IOException{
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MARGIN,1);
        BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
        int[] pixels = new int[width * height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (bitMatrix.get(j, i)) {
                    pixels[i * width + j] = 0x00000000;
                } else {
                    pixels[i * width + j] = 0xffffffff;
                }
            }
        }

        Path path = FileSystems.getDefault().getPath(qrPath);

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
