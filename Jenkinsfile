pipeline {
	agent any
	
	tools {
		maven 'MAVEN-3.2.3'
	}
	
	stages {
		
		stage('checkou from SCM') {
			steps {
				git 'https://github.com/maeloc/spring4-mvc-hibernate4.git'
			}
		}
		
		stage('build') {
			steps {
				sh 'mvn clean compile' 	
			}
		}
		
		stage('test') {
			steps {
				sh 'mvn test'
				junit '**/target/surefire-reports/TEST-*.xml' 	
			}
		}
		
		stage('package') {
			steps {
				sh 'mvn package' 	
			}
		}
		
	}	
}
