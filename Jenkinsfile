//SCRIPTED

//DECLARATIVE
pipeline {
	agent any
	// agent { docker { image 'maven:3.6.3'} }
	// agent { docker { image 'node:13.8'} }
	environment {
		dockerHome = tool 'myDocker'
		mavenHome = tool 'myMaven'
		PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
	}

	stages {
		stage('Checkout') {
			steps {
				bat 'mvn --version'
				bat 'docker version'
				echo "Build"
				echo "PATH - $PATH"
				echo "BUILD_NUMBER - $env.BUILD_NUMBER"
				echo "BUILD_ID - $env.BUILD_ID"
				echo "JOB_NAME - $env.JOB_NAME"
				echo "BUILD_TAG - $env.BUILD_TAG"
				echo "BUILD_URL - $env.BUILD_URL"
			}
		}
		stage('Compile') {
			steps {
				bat "mvn clean compile"
			}
		}

		stage('Test') {
			steps {
				bat "mvn test"
			}
		}

		stage('Integration Test') {
			steps {
				bat "mvn failsafe:integration-test failsafe:verify"
			}
		}

		stage('Package') {
			steps {
				bat "mvn package -DskipTests"
			}
		}

		stage('Build Docker Image') {
			steps {
				bat "docker build -t thiagogregorio/currency-exchange-devops:$env.BUILD_TAG"
				//"docker build -t thiagogregorio/currency-exchange-devops:$env.BUILD_TAG"
				script {
					dockerImage = docker.build("thiagogregorio/currency-exchange-devops:${env.BUILD_TAG}")
				}

			}
		}

		stage('Push Docker Image') {
			steps {
				script {
					docker.withRegistry('', 'dockerhub') {
						dockerImage.push();
						dockerImage.push('latest');
					}
				}
			}
		}
	} 
	
	post {
		always {
			echo 'Im awesome. I run always'
		}
		success {
			echo 'I run when you are successful'
		}
		failure {
			echo 'I run when you fail'
		}
	}
}
