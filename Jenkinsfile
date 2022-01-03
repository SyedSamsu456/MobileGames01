pipeline {
    agent any
    stages {
        stage('Clone Sources') {
            steps {
                git url: 'https://github.com/SyedSamsu/JenkinDemo.git'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                script{
                    withSonarQubeEnv('SonarQube') {
                        sh 'gradle sonarqube -Dsonar.projectKey=DemoJenkinPipeline -Dsonar.login=admin -Dsonar.password=syedsamsu -Dsonar.sources=src -Dsonar.host.url=http://192.168.0.103:9000/'
                    }
                }
            }
        }
    }
}