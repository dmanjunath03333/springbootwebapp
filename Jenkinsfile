pipeline {
agent any
  tools {
   maven 'maven3.6.0'
    jdk 'java1.8.0'
  }
    
  stages {
    stage('Build') {
          steps {
            sh "mvn -B -DskipTests clean package"
          }
          }
    
    stage ('UnitTest'){
      steps {
        sh "mvn test" 
      }
      post {
        always {
        junit 'target/surefire-reports/*.xml'
        }
      }
    }
    
    stage ('Deploy') {
      steps {
        sh '"target/spring-boot-web-0.0.1-SNAPSHOT.jar" &'
      }
    }
    
    
 
          
          
  }

}
