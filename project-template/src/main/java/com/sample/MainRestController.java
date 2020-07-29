package com.sample;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
	@GetMapping("/ping")
	public String ping() {
		return "ping";
	}

	@PostMapping(path = "/parse")
	public String addMember(@RequestBody String value) {
		return value;
	}

	public static void scanStream(InputStream inputStream) throws IOException, NoSuchAlgorithmException {
		Socket socket = null;
		OutputStream outStream = null;
		InputStream inStream = null;
		try {
			socket = new Socket("localhost", 3310);
			outStream = new BufferedOutputStream(socket.getOutputStream());
			socket.setSoTimeout(2000);
			outStream.write("zINSTREAM\0".getBytes(StandardCharsets.UTF_16));
			outStream.flush();
			byte[] buffer = new byte[2048];
			try {
				inStream = socket.getInputStream();
				int read = inputStream.read(buffer);
				while (read >= 0) {
					byte[] chunkSize = ByteBuffer.allocate(4).putInt(read).array();
					outStream.write(chunkSize);
					outStream.write(buffer, 0, read);
					if (inStream.available() > 0) {
						byte[] reply = IOUtils.toByteArray(inStream);
//	    	 throw new IOException("Reply from server: " + new String(reply, StandardCharsets.));
					}
					read = inputStream.read(buffer);
				}
				outStream.write(new byte[] { 0, 0, 0, 0 });
				outStream.flush();
				System.out.println(new String(IOUtils.toByteArray(inStream)));
			} finally {
			}
		} finally {
			try {
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				System.out.println("Exception occurred while closing socket = {} " + e.getMessage());
			}
			try {
				if (inStream != null)
					inStream.close();
			} catch (IOException e) {
				System.out.println("Exception occurred while closing input streams = {} " + e.getMessage());
			}
			try {
				if (outStream != null)
					outStream.close();
			} catch (IOException e) {
				System.out.println("Exception occurred while closing output streams = {} " + e.getMessage());
			}
		}
	}

}
