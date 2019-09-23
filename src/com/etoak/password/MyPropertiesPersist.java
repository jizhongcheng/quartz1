package com.etoak.password;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.util.DefaultPropertiesPersister;


public class MyPropertiesPersist extends DefaultPropertiesPersister {

	@Override
	public void load(Properties props, InputStream is) throws IOException {
		Properties properties = new Properties();
		properties.load(is);
		if (properties.getProperty("jdbc.password") != null) {
			try {
				String decryption = RSAUtils.decryptByPrivateKey(properties
						.getProperty("jdbc.password"));
				properties.setProperty("jdbc.password", decryption);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		OutputStream outputStream = null;
		try {
			outputStream = new ByteArrayOutputStream();
			properties.store(outputStream, "");
			is = outStream2InputStream(outputStream);
			super.load(props, is);
		} catch (IOException e) {
			throw e;
		} finally {
			outputStream.close();
		}
	}

	private InputStream outStream2InputStream(OutputStream out) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bos = (ByteArrayOutputStream) out;
		ByteArrayInputStream swapStream = new ByteArrayInputStream(
				bos.toByteArray());
		return swapStream;
	}
	public static void main(String[] args) {
		
	}
}
