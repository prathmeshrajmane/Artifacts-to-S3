pipeline {
    agent any
    
    environment {
        AWS_ACCESS_KEY_ID     = credentials('jenkins-aws-secret-key-id')
        AWS_SECRET_ACCESS_KEY = credentials('jenkins-aws-secret-access-key')
    }      

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MVN_HOME"
    }
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/prathmeshrajmane/Spring-Boot-First.git'

                // Run Maven on a Unix agent.
                bat "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                success {
                    archiveArtifacts 'target/*.jar'
                     bat 'aws s3 ls'
                     bat 'aws configure set region us-east-1'
                     bat 'aws s3 cp ./target/SpringBootApp.jar s3://16pur/SpringBootApp.jar'
                }
            }
      }
   }
}

