package com.dsz.nioDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FilechannelDemo {
	public static void fileChannelTest() throws IOException{
		File file = new File("C:/Users/Administrator/Desktop/test.txt");
		RandomAccessFile f = new RandomAccessFile(file,"rw");
		FileChannel fc = f.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.clear();
		int bytesRead = fc.read(buf);
		while(bytesRead != -1){
			System.out.println("Read"+bytesRead);
			buf.flip();
			while(buf.hasRemaining()){
				System.out.println((char)buf.get());
			}
			buf.clear();
			bytesRead = fc.read(buf);
		}
		f.close();
	}
	public static void fileTransform() throws IOException{//通道间转换
		FileChannel from = new RandomAccessFile(new File("C:/Users/Administrator/Desktop/test.txt"),"rw").getChannel();
		FileChannel to = new RandomAccessFile(new File("C:/Users/Administrator/Desktop/to.txt"),"rw").getChannel();
		from.transferTo(0, from.size(),to);
	}
	public static void fileChannelWrite() throws IOException{
		FileChannel to = new RandomAccessFile(new File("C:/Users/Administrator/Desktop/to.txt"),"rw").getChannel();
		String newData = "New String to write to file..." + System.currentTimeMillis();
		ByteBuffer bbf = ByteBuffer.allocate(48);
		bbf.put(newData.getBytes());
		bbf.flip();
		while(bbf.hasRemaining()){
			to.write(bbf);
		}
		to.close();
	}
	public static void main(String[] args) throws IOException {
		//fileChannelTest();
		//fileTransform();
		fileChannelWrite();
	}
}
