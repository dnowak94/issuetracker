#!/usr/bin/env groovy
pipeline {
    agent any
    environment {
        DB_HOST = 'db'
        DB_PORT = 5432
    }
    stages {
        stage('Build') {
            steps {
                dir ('backend/projects') {
                    sh 'mvn clean package'
                }
            }

            steps {
                dir ('backend/projects') {
                    sh 'mvn test'
                }
            }
        }
        stage('Test') {
            post {
                always {
                    junit 'backend/projects/target/surefire-reports/*.xml'
                }
            }
        }
    }
}