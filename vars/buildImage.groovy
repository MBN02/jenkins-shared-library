#!/usr/bin/env groovy

def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-user', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh 'docker build -t [nexus-ip]:[docker-port]/java-maven-app:1.0 .'
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin [nexus-ip]:[docker-port]"
        sh 'docker push [nexus-ip]:[docker-port]/java-maven-app:1.0'
    }
}