#!/usr/bin/env groovy

node {
    git url: "https://github.com/nicodewet/dotnet-maven-plugin.git"
    /**
    * The below assumes that you have named your Maven installation as M3 in Jenkins.
    * See: Jenkins >> Manage Jenkins >> Global Tool Configuration
    */
    def mvnHome = tool 'M3'
    sh "${mvnHome}/bin/mvn -B verify"
}