pipeline {
    agent any
    tools {
        //Install the maven version
        maven "3.6.3"
    }
    stages {
        stage('Source'){
            //Run maven on Unix agent
            steps
            {
               git branch :'master' ,url:'https://github.com/koubra999/demo-test.git'
            }
    }
       stage('Build'){
                //Run maven on Unix agent
                steps
                {
                   sh 'mvn clean package'
                }
        }

}
}