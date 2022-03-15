#!/usr/bin/env groovy
@Library('jenkins-shared-library')

def gv

pipeline {
    agent any
    tools {
    maven 'maven_3.8.4'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                buildJar()

                }
            }
        }
        stage("build image") {
            steps {
                script {
                buildImage '40.83.250.80:8083/java-maven-app:2.0'
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying"
                    //gv.deployApp()
                }
            }
        }
    }   
}