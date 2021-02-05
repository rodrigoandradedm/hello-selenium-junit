#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('setup') {
            steps {
                git branch: 'remote', url: 'http://10.250.14.1:8929/root/hello-selenium-junit'    
            }                 
        }
        stage('Test') {
            steps {
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
