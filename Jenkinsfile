pipeline {
    agent any 
    
    stages { 

         stage('verif code source from Git') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                // Build the Maven project
                sh 'mvn clean install'
            }
        }
       stage('Test') {
            steps {
                // Build the Maven project
                sh 'mvn test'
            }
        }

         
    
stage('SonarQube Scanner') {
            steps {
                // Use the specified Maven installation
            withSonarQubeEnv('sq1') {
                 script{
                  
                    sh "mvn sonar:sonar"
                 }


                }
            }
        }



      
        
     
        

          

    }


}
