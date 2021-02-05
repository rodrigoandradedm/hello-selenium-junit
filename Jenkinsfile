#!/usr/bin/env groovy
pipeline {
    agent any
    environment {
        BROWSER = 'chrome'
    }
    stages {
        stage('setup') {
            steps {
                git branch: 'remote', url: 'http://10.250.14.1:8929/root/hello-selenium-junit'    
            }                 
        }
        stage('Test') {
            steps {
                sh 'echo "${BROWSER}"'
                sh 'sed -i 's/capabilities.setCapability("browserName",  "firefox");/capabilities.setCapability("browserName",  "${BROWSER}");/g' "src/test/java/com/example/hello_selenium_junit/*.java"'
                sh './gradlew test'
            }                 
        }
        stage('Build') {
            steps {
                sh "./gradlew assemble"
            }
            post {
                success {
                    archiveArtifacts 'build/libs/*.jar'
                }
            }
        }
    }
}
