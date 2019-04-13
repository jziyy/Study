package com.example.demo.java2d;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Demo1 {
	public static void main(String[] args) throws IOException {
		File file = new File("");
		BufferedImage image = ImageIO.read(file);
		Graphics2D graphics2D = image.createGraphics();
		//设置线段颜色
		graphics2D.setColor(Color.red);
		//设置线段宽度
		graphics2D.setStroke(new BasicStroke(20f));
		//划线
		graphics2D.drawLine(0,0,1111111,1111111);
		//保存
		ImageIO.write(image,"PNG",file);

	}
}
