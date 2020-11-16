package com.liyc.common.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.junit.Test;

/**
 * 使用谷歌二维码插件生成二维码
 */
public class QRCodeGenerator {


    private static final String QR_CODE_IMAGE_PATH = "D:/qrcode1.png";


    private static final String CHARSET = "utf-8";

    @Test
    public void test() throws Exception{
        String text = "http://hqsurvey-uat.faw.cn/YB/?projectCode=项目代码&projectName=北京筑龙企业电子招标采购平台已在包括招商局集团、国家投资集团、东风汽车等超大型央企、国企中应用实践。平台建设围绕智慧业务+技术应用两大核心展开，最终建成和企业契合度极高、安全可靠、稳定高效、操作便捷、扩展性高的招标采购平台。目前平台已在各类型央企、国企中实现了深度的适配和应用，成为了行业领先的企业招标采购一体化智慧解决平台。&supplierCode=供应商代码&supplierName=供应商名称";
        getQRCodeImage(text,350,350);
    }

    public static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 1);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        Path path = FileSystems.getDefault().getPath(QR_CODE_IMAGE_PATH);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }


    private static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        Path path = FileSystems.getDefault().getPath(filePath);

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }

    public static void main(String[] args) {
        String text = "http://hqsurvey-uat.faw.cn/YB/?projectCode=项目代码&projectName=北京筑龙企业电子招标采购平台已在包括招商局集团、国家投资集团、东风汽车等超大型央企、国企中应用实践。平台建设围绕智慧业务+技术应用两大核心展开，最终建成和企业契合度极高、安全可靠、稳定高效、操作便捷、扩展性高的招标采购平台。目前平台已在各类型央企、国企中实现了深度的适配和应用，成为了行业领先的企业招标采购一体化智慧解决平台。&supplierCode=供应商代码&supplierName=供应商名称";
        //String text = "https://etp.faw.cn/xxgl/toXinXiDetail?guid=d3b5f285-8028-446e-b0ed-34a76abccb71";
        try {
            generateQRCodeImage(new String(text.getBytes("UTF-8"), "ISO-8859-1"), 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }

    }

    @Test
    public void test2() throws Exception{
        String text = "http://hqsurvey-uat.faw.cn/YB/?projectCode=项目代码&projectName=北京筑龙企业电子招标采购平台已在包括招商局集团、国家投资集团、东风汽车等超大型央企、国企中应用实践。平台建设围绕智慧业务+技术应用两大核心展开，最终建成和企业契合度极高、安全可靠、稳定高效、操作便捷、扩展性高的招标采购平台。目前平台已在各类型央企、国企中实现了深度的适配和应用，成为了行业领先的企业招标采购一体化智慧解决平台。&supplierCode=供应商代码&supplierName=供应商名称";
        generateQrCode(text,350,350);
    }

    public static void generateQrCode(String content, int width, int height){
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MARGIN,1);
        try {
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
            Path path = FileSystems.getDefault().getPath(QR_CODE_IMAGE_PATH);

            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}