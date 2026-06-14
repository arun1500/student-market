pipeline {
    agent any

    environment {
        APP_NAME = "student-market-app"
        DOCKER_IMAGE = "yourdockerhubusername/student-market-app"
        DOCKER_TAG = "${BUILD_NUMBER}"
    }

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout Source Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/yourusername/student-market-app.git'
            }
        }

        stage('Build Application') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Run Unit Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh """
                    docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} .
                    docker tag ${DOCKER_IMAGE}:${DOCKER_TAG} ${DOCKER_IMAGE}:latest
                """
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([
                    usernamePassword(
                        credentialsId: 'dockerhub-creds',
                        usernameVariable: 'DOCKER_USER',
                        passwordVariable: 'DOCKER_PASS'
                    )
                ]) {
                    sh '''
                        echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                        docker push '${DOCKER_IMAGE}:${DOCKER_TAG}'
                        docker push '${DOCKER_IMAGE}:latest'
                    '''
                }
            }
        }

        stage('Deploy Container') {
            steps {
                sh '''
                    docker stop student-market-container || true
                    docker rm student-market-container || true

                    docker run -d \
                    --name student-market-container \
                    -p 8080:8080 \
                    ${DOCKER_IMAGE}:latest
                '''
            }
        }
    }

    post {
        success {
            echo 'Student Market App deployed successfully!'
        }

        failure {
            echo 'Pipeline failed. Please check logs.'
        }

        always {
            cleanWs()
        }
    }
}
