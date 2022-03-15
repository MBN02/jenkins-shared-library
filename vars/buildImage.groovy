#!/usr/bin/env groovy

def call(String imageName) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-user', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh "docker build -t $imageName ."
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin 40.83.250.80:8083"
        sh "docker push $imageName"
    }
}