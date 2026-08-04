pipeline {
    agent any

    tools {
        maven 'M2-HOME'   // Adjust to your Maven installation name in Jenkins
        jdk 'JAVA_HOME'   // Adjust to your JDK installation name in Jenkins
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
                bat 'mvn test -P crossBrowser'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Archive Reports & Screenshots') {
            steps {
                archiveArtifacts artifacts: 'test-output/**', fingerprint: true
                archiveArtifacts artifacts: 'Screenshots/**', fingerprint: true
            }
        }

        stage('Publish ExtentReport') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'AdvanceReports',
                    reportFiles: 'Extentreport_*.html',
                    reportName: 'Extent Report'
                ])
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
