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
                        bat 'gradle sonarqube -Dsonar.projectKey=DemoJenkinPipeline -Dsonar.login=admin -Dsonar.password=syedsamsu -Dsonar.sources=src -Dsonar.host.url=http://192.168.0.103:9000/'
                    }
                }
            }
        }
    }
}