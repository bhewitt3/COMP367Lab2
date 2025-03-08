pipeline {
	agent any

	environment {
		DOCKER_IMAGE = "blake/lab3"
	}

	tools {
		maven "Maven"
		jdk "JDK17"
	}

	stages {
		stage('Checkout') {
			steps {
				checkout scm
			}
		}
		// Maven build is in Dockerfile as required to manually build the docker image in step 2
		// stage('Build') {
		// 	steps {
		// 		sh 'mvn clean package -DskipTests'
		// 	}
		// }
		stage('Docker Build') {
			steps {
				script {
					echo "Starting docker build"
					sh "docker build -t ${DOCKER_IMAGE} ."
				}
			}
		}
		stage('Docker Login') {
			steps {
				withCredentials([usernamePassword(credentialsId: 'd2e02ff4-b3d1-4520-83fb-8c690a37d127', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
					sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"
				}
			}
		}
		stage('Docker Push') {
			steps {
				script {
					sh "docker push ${DOCKER_IMAGE}"
				}
			}
		}
	}

	post {
		success {
			echo 'Build Successful'
			// archiveArtifacts 'target/*.jar'
		}
		
		failure{
			echo 'Build failed'
		}
	}
}
