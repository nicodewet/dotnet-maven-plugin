package io.makaro;

import java.io.IOException;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

import io.makaro.AbstractDotnetMojo.Stream;

/**
 * Goal which executes dotnet publish.
 */
@Mojo( name = "publish", defaultPhase = LifecyclePhase.PACKAGE )
public class DotnetPublishMojo extends AbstractDotnetMojo {
	
	
	private static final String COMMAND_PARAMETER = "publish";
	private static final String ERROR_MESSAGE = COMMAND + " " + COMMAND_PARAMETER + " failed";
	
	public void execute() throws MojoExecutionException {
	      
    	Process dotnet;
		try {
			dotnet = new ProcessBuilder().command(COMMAND, COMMAND_PARAMETER).start();
			String inputStreamResult = getSubProcessStream(dotnet, Stream.INPUT);
			String errorStreamResult = getSubProcessStream(dotnet, Stream.ERROR);
			logStream(inputStreamResult, Stream.INPUT);
			logStream(errorStreamResult, Stream.ERROR);
		} catch (IOException e) {
			throw new MojoExecutionException(ERROR_MESSAGE, e);
		}
    	int exitCode;
		try {
			exitCode = dotnet.waitFor();
			if (exitCode == 1) {
				throw new MojoExecutionException(ERROR_MESSAGE);
			}
		} catch (InterruptedException e) {
			throw new MojoExecutionException(ERROR_MESSAGE, e);
		}
    	
    }

}
