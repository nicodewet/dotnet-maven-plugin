package io.makaro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.maven.plugin.AbstractMojo;

public abstract class AbstractDotnetMojo extends AbstractMojo {
	
	enum Stream {ERROR, INPUT}
	
	final static String COMMAND = "dotnet";
	
	protected String getSubProcessStream(Process subProcess, Stream stream) throws IOException {
		BufferedReader reader;
		if (Stream.ERROR == stream) {
			reader = new BufferedReader(new InputStreamReader(subProcess.getErrorStream()));
		} else if (Stream.INPUT == stream) {
			reader = new BufferedReader(new InputStreamReader(subProcess.getInputStream()));
		} else {
			throw new IllegalArgumentException();
		}
		StringBuilder builder = new StringBuilder();
		String line = null;
		while ( (line = reader.readLine()) != null) {
			builder.append(line);
			builder.append(System.getProperty("line.separator"));
		}
		String result = builder.toString();
		return result;
	}
	
	/**
	 * Only logs if a non-empty string is presented.
	 */
	protected void logStream(String logMessage, Stream stream) {
		String trimmedMessage = logMessage.trim();
		if (trimmedMessage != null && trimmedMessage.length() > 0 && stream != null) {
			if (Stream.ERROR == stream) {
				getLog().error(trimmedMessage);
			} else if (Stream.INPUT == stream) {
				getLog().info(trimmedMessage);
			} else {
				throw new IllegalArgumentException();
			}
		}
	}

}
