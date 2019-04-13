package com.example.demo.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Base64toFile {

    public static void main(String[] args) throws IOException {
        String base64 = new String(Files.readAllBytes(Paths.get("F:\\项目2\\新建文件夹 (10)\\study\\src\\main\\resources\\statis\\base64.txt")));
        byte[] bytes_in1 = Base64.getDecoder().decode(base64);
        BufferedImage bufferedImage =ImageIO.read(new ByteArrayInputStream(bytes_in1));
        ImageIO.write(bufferedImage,"JPG",new File("aaa.JPG"));

    }
}
