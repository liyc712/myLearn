package com.liyc.common.test.qrcode;

/**
 * @Author lyc
 * @Date 2020-11-5 10:36
 * @ClassName QrCodeGenerator
 * @Description TODO
 */
public class QrCodeGenerator {

    public static void main(String[] args) {
        String imgPath = "D:/qrcode.png";// 二维码保存路径
        // 跳转的内容，如果http://则当做文字处理
        //String content = "王立明：13504782757";
        String content = "https://etp.faw.cn/xxgl/toXinXiDetail?guid=d3b5f285-8028-446e-b0ed-34a76abccb71";

        // 创建封装类
        QrCodeAssis assis = new QrCodeAssis(imgPath, content);
        boolean result = assis.createCode(480, 480);
        if (result) {
            System.out.println("二维码生成成功！");
        } else {
            System.out.println("二维码生成失败！");
        }
    }
}