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
                bat "pip install -r python_rest_api/requirements.txt"
            }
        }
        stage ('Gradle build Camel Server') {
            steps {
                bat "echo 'navigate to camel server'"
                dir("spring_boot_routes"){
                        bat "gradle build"
                    }
            }
        }
        stage("Start Servers/Run Tests"){
            steps{
                parallel(
                    "Python Rest Api": {
                        timeout(time:2, unit: 'MINUTES'){
                        bat "python python_rest_api/app.py"
                        }
                    },
                    "Spring Boot Routes": {
                        timeout(time: 2, unit: 'MINUTES') {
                            bat "java -jar spring_boot_routes/build/libs/java_server_replication_routes-0.0.1-SNAPSHOT.jar"
                        }
                    },
                    "Build Rest Assured Jar": {
						/* Allowing time for servers to start up */
                        sleep(10)
                        bat "echo 'building rest_assured'"
                        dir("rest_assured"){
                            bat "gradle build"
                        }
                    }                
                )
            }
        }
    }
}
