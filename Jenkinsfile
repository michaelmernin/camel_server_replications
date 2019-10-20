pipeline {
    agent any

    stages {
        stage ('Clone') {
            steps {
                git branch: 'master', url: "https://github.com/michaelmernin/camel_server_replications.git"
            }
        }
        stage ('Pip install requirements.txt'){
            steps{
                bat "pip install -r camel_python_server/requirements.txt"
            }
        }
        stage ('Exec Gradle for Camel Server') {
            steps {
                bat "echo 'navigate to camel server'"
                dir("java_server_replication_routes"){
                        bat "gradle build"
                    }
            }
        }
        stage("Start Servers/Run Tests"){
            steps{
                parallel(
                    "Python": {
                        timeout(time:2, unit: 'MINUTES'){
                        bat "python camel_python_server/app.py"
                        }
                    },
                    "Jar file": {
                        timeout(time: 2, unit: 'MINUTES') {
                            bat "java -jar java_server_replication_routes/build/libs/java_server_replication_routes-0.0.1-SNAPSHOT.jar"
                        }
                    },
                    "Build Rest Assured Jar": {
                        sleep(10)
                        bat "echo 'building rest_assured'"
                        dir("camel_rest_assured"){
                            bat "gradle build"
                        }
                    }                
                )
            }
        }
    }
}
