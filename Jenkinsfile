pipeline {
 environment {
  registry = 'dmanjunath03333/node-todo-frontend'
  registryCredential = 'dockerhub'
  dockerImage = ''
 containerId = sh(script: 'docker ps -aqf "name=node-app"', returnStdout:true)
 }
 agent any
 tools {
  nodejs "node"
 }

 stages {
  /*stage('Cloning project') {
   git 'https://github.com/gustavoapolinario/node-todo-frontend'
  }*/
  stage('Build') {
   steps {
    sh 'npm install'
   }
  }
  stage('Test') {
   steps {
    sh 'npm test'
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
    
    sh 'docker run --name=node-app"$BUILD_NUMBER" -d -p 3000:3000 $registry:$BUILD_NUMBER &'
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
