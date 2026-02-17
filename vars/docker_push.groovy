def call(String credId, String imageName){
  withCredentials([usernamePassword(
                        credentialsId: "${credId}",
                        passwordVariable: "DOCKER_PASS",
                        usernameVariable: "DOCKER_USER",
                    )]){
                    
                    sh "docker login -u ${env.DOCKER_USER} -p ${env.DOCKER_PASS}"
                    sh "docker image tag ${imageName} ${env.DOCKER_USER}/${imageName}"
                    sh "docker push ${env.DOCKER_USER}/${imageName}"
}
