package com.vsc.darkhorse.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ParserUtils {

	

	public static String callAPI(String URL) {
		String inline = "";
		try {
			URL url = new URL(URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			int responseCode = connection.getResponseCode();

			if (responseCode != 200) {
				throw new RuntimeException("HttpResponseCode : " + responseCode);
			} else {
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(url.openStream());
				while (scanner.hasNext()) {
					inline += scanner.nextLine();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inline;
	}

	
}
