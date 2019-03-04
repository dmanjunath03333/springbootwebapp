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
   
    
    
    stage ('Deploy') {
      steps {
        sh "java -jar target/spring-boot-web-0.0.1-SNAPSHOT.jar"
      }
    }
    
    
 
          
          
  }

}
