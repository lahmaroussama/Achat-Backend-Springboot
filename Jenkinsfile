pipeline {
    agent any

    stages {
        stage('Récupération du code source depuis Git') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                // Build the Maven project
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                // Build the Maven project
                sh 'mvn test'
            }
        }
        stage('Mvn sonarqube'){
            steps{
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=fakher -Dmaven.test.skip=true'
            }
        }
    } 
}