pipeline {

    agent any

    environment{
        dockerImage = ''
        registry = 'debojit/first-app'
    }


    stages{
        stage('Checkout'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/dsaikia/oil-balance.git']]])
            }
        }

        stage('Gradle Build') {
            steps {
                sh './gradlew clean build'
            }
        }

        stage('Build Docker Image'){
            steps{
                script{
                    dockerImage = docker.build registry
                }
            }
        }
    }
}