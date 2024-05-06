@Library('checkUpstreamJobs') _

pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('SonarQube Scan') {
            steps {
                // Gradle 프로젝트 스캔
                withSonarQubeEnv('SonarQube Server') {
                    sh 'chmod +x ./gradlew' // gradlew 실행 권한 부여
                    sh './gradlew clean build \
                        -Dsonar.projectKey=gradle_sonar_jenkins_redmine \
                        -Dsonar.projectName="gradle_sonar_jenkins_redmine" \
                        -Dsonar.plugins.downloadOnlyRequired=true sonar'
                }
            }
        }
        stage('Trigger Redmine Pipeline') {
            steps {
                script {
                    def upstreamJobs = ["SonarQube Scan"]
                    if (checkUpstreamJobs(upstreamJobs)) {
                        build job: 'report_redmine', wait: false
                        echo "report_redmine 파이프라인 트리거 완료"
                    } else {
                        echo "SonarQube Scan 단계가 실패하여 report_redmine 파이프라인을 트리거하지 않습니다."
                    }
                }
            }
        }
    }
}