@Library('jenkins_option@main') _

pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Gradle 프로젝트 스캔
                sh 'chmod +x ./gradlew' // gradlew 실행 권한 부여
                sh './gradlew clean build'
            }
        }

        stage('Sonarqube Scan') {
            steps {
                script {
                    def repoName = getRepoName(env.GIT_URL)

                    echo "$env.GIT_URL"
                    echo "$repoName"

                    withSonarQubeEnv('SonarQube Server') {
                        sh './gradlew \
                            -Dsonar.projectKey=${repoName} \
                            -Dsonar.projectName="${repoName}" \
                            -Dsonar.plugins.downloadOnlyRequired=true sonar' 
                    }
                }
            }
        }

/*
        stage('Trigger Redmine Pipeline') {
            steps {
                script {
                    def upstreamJobs = ["SonarQube Scan"]

                    def allUpstreamSuccess = upstreamJobs.every { jobName ->
                        def job = Jenkins.instance.getItemByFullName(jobName)
                        def lastBuild = job.getLastBuild()
                        return lastBuild && lastBuild.result == 'SUCCESS'
                    }

                    if (allUpstreamSuccess) {
                        build job: 'report_redmine', wait: false
                        echo "report_redmine 파이프라인 트리거 완료"
                    } else {
                        echo "SonarQube Scan 단계가 실패하여 report_redmine 파이프라인을 트리거하지 않습니다."
                    }
                }
            }
        }
        */
    }
}