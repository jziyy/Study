package com.example.demo.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/***
 * 在内存中将base进行裁剪返回裁剪后的base64
 * @author shaojz
 */
public class PictureCut {
    /**
     *  将base进行裁剪返回裁剪后的base64
     * @param base64    需要裁剪的图片的base64
     * @param x         裁剪位置信息
     * @param y         裁剪位置信息
     * @param w         裁剪位置信息
     * @param h         裁剪位置信息
     * @return          裁剪后的base64
     * @throws IOException
     */
    public static String CutPicture(String base64,int x,int y,int w,int h) throws IOException {
        byte[] bytes_in = Base64.getDecoder().decode(base64.replaceAll(" ", "+"));
        ByteArrayInputStream in = new ByteArrayInputStream(bytes_in);
        BufferedImage image = ImageIO.read(in);
        BufferedImage subimage = image.getSubimage(x, y, w, h);
        String imageWidth = String.valueOf(image.getWidth());
        String imageHeight = String.valueOf(image.getHeight());
        System.out.println(imageHeight + "---" + imageWidth);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(subimage,"JPG", byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();

        return Base64Util.encode(bytes);

    }

    public static void main(String[] args) throws IOException {
        String base64 = Base64Util.encode(Files.readAllBytes(Paths.get("F:\\项目2\\新建文件夹 (10)\\study\\src\\main\\resources\\statis\\base64.txt")));
        System.out.println(CutPicture(base64,5000,5000,-5000,-5000));

    }
}
