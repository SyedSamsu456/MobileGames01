pipeline {
    agent any
    stages {
        stage('Clone Sources') {
            steps {
                git url: 'https://github.com/SyedSamsu456/MobileGames01.git'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                script{
                    withSonarQubeEnv('SonarQube') {
                        bat 'gradle  sonarqube -Dsonar.projectKey=MobileGames01 -Dsonar.login=admin -Dsonar.password=#CAPss24 -Dsonar.sources=src -Dsonar.host.url=http://localhost:9000/'
                    }
                }
            }
        }
    }
}