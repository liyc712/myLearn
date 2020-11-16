package com.liyc.common.test.qrcode;

/**
 * @Author lyc
 * @Date 2020-11-5 10:44
 * @ClassName QrcodeUtilTest
 * @Description TODO
 */
public class QrcodeUtilTest {

    public static void main(String[] args)  throws Exception{
        //生成二维码
        /*
         * 生成图片的路径        src/二维码.png
         * 文字信息、网址信息 ：  "helloworld"
         */
        String imgPath = "D:\\二维码2.png";
        String content =  "一汽测试环境：http://116.196.83.187:8083/yq-zbManager/";  //扫描二维码后，网页跳转

        //生成二维码
        /*
         * 加密：  文字信息 ->二维码
         * 解密：  二维码 -> 文字信息
         */
        QRCodeUtil qrUtil = new QRCodeUtil();
        //加密：  文字信息 ->二维码
        qrUtil.encoderQRCode(content, imgPath, "png", 17);

//           TwoDimensionCode handler = new TwoDimensionCode();
//           handler.encoderQRCode(content, imgPath, "png", 7);


//        //解密：  二维码 -> 文字信息
        String imgContent = qrUtil.decoderQRCode(imgPath) ;
        System.out.println(imgContent);


    }
}
