package com.wdc.base.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.lang.ProcessBuilder.Redirect;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class SysMonService {
	
	private static final Logger LOGGER = Logger.getLogger(SysMonService.class.getName());

	public String startService() {
		String pid = null;
		String command = "java -jar -Xmx1024m service.jar TRESXLB2 8875";
		
		
		ProcessBuilder builder = new ProcessBuilder(command.split(" "));
		builder.redirectError(Redirect.appendTo(new File("./err1.log")));
		builder.redirectOutput(Redirect.appendTo(new File("./output1.log")));
		builder.directory(new File("/Users/sc1000255563/Documents/Java-Scoring-2018-02-08"));
		try {
			builder.start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("done");
			
		}
		
		return pid;
	}
	
	public String ping(String server, int port) {
		String message = null;
		try {
			Socket echoSocket = new Socket();
			LOGGER.info("going to connect");
			echoSocket.connect(new InetSocketAddress(server, port), 2000);
			
			LOGGER.info("connected");
			
			echoSocket.setSoTimeout(2000);
			DataOutputStream out = new DataOutputStream(echoSocket.getOutputStream());
			DataInputStream in = new DataInputStream(echoSocket.getInputStream());
			
			out.writeUTF("status");
			out.flush();
			
			message = in.readUTF();
			LOGGER.info(message);
			
			out.close();
			in.close();
			echoSocket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return message;
	}
	
}
