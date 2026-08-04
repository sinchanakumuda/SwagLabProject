pipeline {
    agent any

    tools {
        maven 'M2-HOME'   // Make sure Jenkins has Maven installed and named like this
        jdk 'JAVA_HOME'        // Adjust to the JDK you configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/sinchanakumuda/SwagLabProject.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Report') {
            steps {
                archiveArtifacts artifacts: 'test-output/**', fingerprint: true
            }
        }
    }

    post {
        success {
            echo '✅ Build and tests completed successfully!'
        }
        failure {
            echo '❌ Build failed. Check logs and reports.'
        }
    }
}
