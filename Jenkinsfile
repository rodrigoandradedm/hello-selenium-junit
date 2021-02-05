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
                sh 'sed -i "s%firefox%${BROWSER}%g" "build.gradle"'
                sh './gradlew  test'
            }
            post {
                always {
                    junit 'build/test-results/test/TEST-*.xml'
                }
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
