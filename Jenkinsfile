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
                dir ('backend/issue_service') {
                    sh 'mvn -DskipTests clean package'
                }
            }
        }
        stage('Test') {
            steps {
                dir ('backend/issue_service') {
                    sh 'mvn test'
                }
            }
            post {
                always {
                    junit 'backend/issue_service/target/surefire-reports/*.xml'
                }
            }
        }
    }
}