 pipeline {
     agent any
      stages {
       stage('Build and Test') {
            steps {
                // Set up JDK and Maven in Jenkins Global Tool Configuration.
                // The 'jdk' and 'maven' labels should match the names you configured in Jenkins.
                // 'clean install' will build the project and run the tests.
                // Replace 'pom.xml' with the actual path to your project's pom.xml file.
                script {
                      sh"mvn clean install"
                     // sh "mvn test"
                    //sh "mvn build"

                }

            }
      }
      }
        }