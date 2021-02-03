#!/usr/bin/env groovy
pipeline {
    agent any
    options {
        ansiColor('xterm')
    }
    stages {
        stage('Test') {
            steps {
                git branch: 'main', url: 'http://10.250.14.1:8929/root/hello-selenium-junit'
                sh 'test-precio.js'
                sh 'testtotal.spec.js'
            }
        }
    }
}
