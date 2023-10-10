pipeline {
    agent any

    stages {
        stage('checkout git'){
            steps{
                echo 'pulling'
                    git branch: 'fakher',
                    url: 'https://github.com/lahmaroussama/Achat-Backend-Springboot'
            }
        }
        stage('Maven Version'){
            steps{
                sh "mvn -version"
            }
        }
        stage('Récupération du code source depuis Git') {
            steps {
                checkout fakher
            }
        }
        stage('Affichage de la date système') {
            steps {
                sh 'date'
            }
        }
    } 
}