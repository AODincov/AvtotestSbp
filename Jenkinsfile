pipeline{
	agent any

tools {
	maven 'maven3'
	jdk 'jdk8Manually'
	}



	stages{
		stage ("Git") {

			steps{
				git credentialsId: 'AOdincov', url: 'https://github.com/AODincov/AvtotestSbp'
				git branch: 'AOdincov', url: 'https://github.com/AODincov/AvtotestSbp'
			}
		}

		stage ("Run") {

			steps{
			    catchError{
				    sh "mvn clean install"
			    }
			}
		}

		stage ("Report") {

			steps {
				allure([
					includeProperties: false,
					jdk: '',
					properties: [],
					reportBuildPolicy: 'ALWAYS',
					results: [[path: 'target/allure-results']]
				])
  	        }
         }
		}

	}
