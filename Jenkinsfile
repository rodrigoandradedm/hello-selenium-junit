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
                sh 'sed -i "s%capabilities.setCapability("browserName",  "firefox");%capabilities.setCapability("browserName",  "${BROWSER}");%g" "src/test/java/com/example/hello_selenium_junit/imdbTest.java"'

                sh 'sed -i "s%capabilities.setCapability("browserName",  "firefox");%capabilities.setCapability("browserName",  "${BROWSER}");%g" "src/test/java/com/example/hello_selenium_junit/RobobarTest.java"'

                sh 'sed -i "s%capabilities.setCapability("browserName",  "firefox");%capabilities.setCapability("browserName",  "${BROWSER}");%g" "src/test/java/com/example/hello_selenium_junit/SearchTest.java"'
                sh 'cat src/test/java/com/example/hello_selenium_junit/SearchTest.java'
                //sh './gradlew test'
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
