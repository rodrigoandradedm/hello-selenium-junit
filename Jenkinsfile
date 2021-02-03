#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                git branch: 'main', url: 'http://10.250.14.1:8929/root/hello-selenium-junit'
                sh './gradlew clean test'    
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
