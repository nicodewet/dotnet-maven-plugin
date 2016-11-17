#!/usr/bin/env groovy

node {

    /**
    * The below assumes that you have named your Maven installation as M3 in Jenkins.
    * See: Jenkins >> Manage Jenkins >> Global Tool Configuration
    */
    def mvnHome = tool 'M3'
    env.PATH = "${mvnHome}/bin:${env.PATH}"
    
    stage 'Maven build and deploy'
        git url: "https://github.com/nicodewet/dotnet-maven-plugin.git"
        sh 'mvn deploy'
    
    stage 'Maven site generate and deploy'
        git url: "https://github.com/nicodewet/dotnet-maven-plugin.git"
        sh 'mvn site:site site:deploy'
        
}