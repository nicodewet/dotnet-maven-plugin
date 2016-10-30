package io.makaro;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import java.io.IOException;

/**
 * Goal which executes dotnet build.
 */
@Mojo( name = "build", defaultPhase = LifecyclePhase.COMPILE )
public class DotnetBuildMojo extends AbstractMojo {
	
	private static final String COMMAND = "dotnet";
	private static final String COMMAND_PARAMETER = "build";
	private static final String ERROR_MESSAGE = COMMAND + " " + COMMAND_PARAMETER + " failed";

    public void execute() throws MojoExecutionException {
      
    	Process dotnet;
		try {
			dotnet = new ProcessBuilder().command(COMMAND, COMMAND_PARAMETER).inheritIO().start();
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
