pipeline {
	agent any
	
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
		
		stage('Build') {
			steps {
				sh 'mvn clean package -DskipTests'
			}
		}
	}
	
	post {
		success {
			echo 'Build Successful'
			archiveArtifacts 'target/*.jar'
		}
		
		failure{
			echo 'Build failed'
		}
	}
}