pipeline {
 environment {
 
  registry = 'dmanjunath03333 / spring_boot_app'
  registryCredential = 'dockerhub'
  dockerImage = ''
  containerId = sh(script: 'docker ps -aqf "name=chat-app"', returnStdout: true)
 }
 agent any
 tools {
  maven 'maven'
   jdk 'jdk'
 }

 stages {

  stage('Build') {
   steps {
    sh "mvn clean package"
   }
  }
  
  stage('UnitTest') {
   steps {
    sh "mvn test"
   }
   
   }
  

 stage('Building image') {
   steps {
    script {
     dockerImage = docker.build registry + ":$BUILD_NUMBER"
    }
   }
  }

  
  stage('Run Container') {
   steps {
    sh 'docker run --name=chat-app -d -p 5000:8080 $registry:$BUILD_NUMBER &'
   }
  }
 
  stage('push image') {
   steps {
    script {
     docker.withRegistry('', registryCredential) {
      dockerImage.push()
     }
    }
   }
  }
 }
}
