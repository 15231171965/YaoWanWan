package com.yao.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Reader extends Properties {
	private static Reader reader;

	private Reader() {
		InputStream is = this.getClass().getResourceAsStream("configuration");
		try {
			super.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Reader getReader() {
		if (reader == null) {
			return new Reader();
		}
		return reader;
	}
}
