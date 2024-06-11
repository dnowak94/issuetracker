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
                    sh 'mvn -DskipTests clean package'
                }
            }
        }
        stage('Test') {
            steps {
                dir ('backend/projects') {
                    sh 'mvn test'
                }
            }
        }
    }
}