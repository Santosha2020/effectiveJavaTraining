package testapp.io01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

public class FileTests {

	String path="data/mydata.txt";
	File sourceFile, targetFile;
	String targetPath="data/mydata-out.txt";
	
	@Before
	public void setUp() throws Exception {
		sourceFile=new File(path);
		targetFile=new File(targetPath);
		
	}
	
	@After
	public void cleanup() {
		if(targetFile.exists())
			targetFile.delete();
	}

	@Test
	public void fileShouldExist() {
	
		assertTrue(sourceFile.exists());
	}
	
	@Test
	public void fileIsOlderThanCurrentTime() {
		long now=System.currentTimeMillis();
		
		long modified= sourceFile.lastModified();
		
		assertTrue(now>modified);
	}
	
	@Test
	public void canReadFileUsingInputStream() throws IOException {
		FileInputStream stream=new FileInputStream(path);
		String data="";
		int readCount=0;
		
		while(stream.available()>0) {
			int ch=stream.read();
			data+=(byte)ch;
			readCount++;
		}
		
		stream.close();
		
		assertEquals(sourceFile.length(), readCount);
		
	}
	
	@Test
	public void targetFileDoesntExits() {
		assertFalse(targetFile.exists());
	}

	
	@Test public void canCopyFileUsingStreams() throws IOException{
		
		Assume.assumeFalse(targetFile.exists());
		FileInputStream in=new FileInputStream(path);
		FileOutputStream out=new FileOutputStream(targetPath);
		
		int ch;
		int count=0;
		
		while((ch=in.read())!=-1) {
			
			out.write(ch);
			count++;
			
		}
		in.close();
		out.close();
		
		assertTrue( targetFile.exists());
		
		assertEquals(sourceFile.length(), targetFile.length());
	}
	
	@Test public void canWriteLineByLineUsingPrintWriter() {
		
		CharArrayWriter caw=new CharArrayWriter(); //writes to memory
		
		PrintWriter writer=new PrintWriter(caw);
		
		writer.println("Line1");
		writer.println("Line2");
		writer.println("Line3");
		
		writer.close();
		
		char [] data=caw.toCharArray();
		
		String str=new String(data);
		
		assertEquals("Line1\r\nLine2\r\nLine3\r\n", str);
		
		
		
	}
	
	
	@Test public void canWriteToFileUsingPrintWriter() throws FileNotFoundException {
		
		PrintWriter writer=new PrintWriter("data/sample.txt");
		writer.println("Title: The Accursed God");
		writer.println("Author:Vivek Dutta Mishra");
		writer.println("Series:The Lost Epic");
		
		writer.close();
	}
	
}
