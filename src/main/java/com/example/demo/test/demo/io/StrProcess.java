package com.example.demo.test.demo.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
//乱码未解决
public class StrProcess {
	public static void main(String[] args) throws IOException {
		RandomAccessFile aFile = new RandomAccessFile("F:\\workspace\\DesignMode\\src\\demo\\io\\a.txt", "rw");
		FileChannel inChannel = aFile.getChannel();
		String str = "";
		ByteBuffer buf = ByteBuffer.allocate(48);

		int bytesRead = inChannel.read(buf); //read into buffer.
		while (bytesRead != -1) {

		  buf.flip();  //make buffer ready for read

		  while(buf.hasRemaining()){
		     str +=(char) buf.get(); // read 1 byte at a time
		  }

		  buf.clear(); //make buffer ready for writing
		  bytesRead = inChannel.read(buf);
		}
		
		aFile.close();
		//str = str.replaceAll("[^\\u4e00-\\u9fa5]", "");
		System.out.println(str);
	}
}
