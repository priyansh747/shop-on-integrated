pipeline {
    agent {
      
        docker { image 'prabhavagrawal/seleniumchrome' }
    }
    stages {
        stage('Build'){
            steps {
                echo "Build Project"
                sh label: '', script: 'mvn clean install'
            }
        }
        stage('HTML REPORT'){
            steps{
                echo "HTML Report"
                //publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: '/var/lib/jenkins/workspace/so-pipe/', reportFiles: 'ExtentReportResults.html', reportName: 'HTML Report', reportTitles: ''])
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: true, reportDir: '', reportFiles: 'ExtentReportResults1.html', reportName: 'Selenium Report', reportTitles: ''])
            }
            
        }
        stage('JUnit REPORT'){
            steps{
                echo "JUNIT Reports"
                junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
            }
        }
    }
}
