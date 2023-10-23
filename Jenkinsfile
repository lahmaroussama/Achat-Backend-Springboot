pipeline {
    agent any
environment {
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "192.168.1.94:8081"
        NEXUS_REPOSITORY = "maven-repo"
        NEXUS_CREDENTIAL_ID = "nexus"
    }
    stages {
        stage('Récupération du code source depuis Git') {
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
        stage('JUNIT'){
            steps{
                sh'mvn test'
                junit(testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true)
            }
        }
        stage('Mvn sonarqube'){
            steps{
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=fakher -Dmaven.test.skip=true'
            }
        }
        stage('Collect JaCoCo Coverage') {
            steps{
                   jacoco(execPattern: '**/target/jacoco.exec')
    }
        }
    
    stage('Test with JaCoCo') {
        steps{
         
                // Run your tests with JaCoCo enabled and generate JaCoCo XML reports
                sh 'mvn clean test jacoco:report'
        }   
    }
        stage('Nexus Repo'){
            steps{
                script{
                    
                    pom = readMavenPom file: "pom.xml";
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    artifactPath = filesByGlob[0].path;
                    artifactExists = fileExists artifactPath;
                    if(artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        nexusArtifactUploader(
                            nexusVersion: NEXUS_VERSION,
                            protocol: NEXUS_PROTOCOL,
                            nexusUrl: NEXUS_URL,
                            groupId: pom.groupId,
                            version: pom.version,
                            repository: NEXUS_REPOSITORY,
                            credentialsId: NEXUS_CREDENTIAL_ID,
                            artifacts: [
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );
                    } else {
                        error "*** File: ${artifactPath}, could not be found";
                   
                }
            }
        }
    } 
    stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t fakherr/achat .'
                }
            }
        }
          stage('push Docker Image') {
            steps {
                script {
                 withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                    sh 'docker login -u fakherr -p ${dockerhubpwd}'
                 }  
                 sh 'docker push fakherr/achat'
                }
            }
        }
        stage('Deploy with Docker Compose') {
         steps {
            script {
             sh 'docker-compose up -d'
             }
    }
}
}
}