#!/usr/bin/env groovy

node {
    stage 'Build and deploy'
    git url: "https://github.com/nicodewet/dotnet-maven-plugin.git"
    /**
    * The below assumes that you have named your Maven installation as M3 in Jenkins.
    * See: Jenkins >> Manage Jenkins >> Global Tool Configuration
    */
    def mvnHome = tool 'M3'
    env.PATH = "${mvnHome}/bin:${env.PATH}"
    sh 'mvn deploy'
}