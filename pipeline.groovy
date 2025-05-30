pipeline {
    agent any

    environment {
        BUILD_TOOL = 'Maven'
        TEST_TOOL = 'JUnit and Postman'
        CODE_ANALYSIS_TOOL = 'SonarQube'
        SECURITY_SCAN_TOOL = 'OWASP Dependency-Check'
        STAGING_SERVER = 'AWS EC2 (Staging)'
        PRODUCTION_SERVER = 'AWS EC2 (Production)'
    }

    stages {
        stage('Build') {
            steps {
                echo "Stage 1: Build"
                echo "Task: Compile and package the code using ${env.BUILD_TOOL}"
            }
        }

        stage('Unit and Integration Tests') {
            steps {
                echo "Stage 2: Unit and Integration Tests"
                echo "Task: Run unit tests and integration tests using ${env.TEST_TOOL}"
            }
        }

        stage('Code Analysis') {
            steps {
                echo "Stage 3: Code Analysis"
                echo "Task: Analyze the code using ${env.CODE_ANALYSIS_TOOL} to ensure code quality"
            }
        }

        stage('Security Scan') {
            steps {
                echo "Stage 4: Security Scan"
                echo "Task: Perform security scan using ${env.SECURITY_SCAN_TOOL} to detect vulnerabilities"
            }
        }

        stage('Deploy to Staging') {
            steps {
                echo "Stage 5: Deploy to Staging"
                echo "Task: Deploy the application to ${env.STAGING_SERVER}"
            }
        }

        stage('Integration Tests on Staging') {
            steps {
                echo "Stage 6: Integration Tests on Staging"
                echo "Task: Run integration tests on the staging environment"
            }
        }

        stage('Deploy to Production') {
            steps {
                echo "Stage 7: Deploy to Production"
                echo "Task: Deploy the application to ${env.PRODUCTION_SERVER}"
            }
        }
    }
}
