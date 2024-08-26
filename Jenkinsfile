pipeline {
    agent any
    environment{
        branchName = sh(
            script: "echo ${env.GIT_BRANCH} | sed -e 's|/|-|g'",
            returnStdout: true
        ).trim()
        dockerTag="${env.branchName}-${env.BUILD_NUMBER}"
        dockerImage="${env.CONTAINER_IMAGE}:${env.dockerTag}"
        dockerImageProd="${env.CONTAINER_IMAGE}:prod-${env.dockerTag}"

        MINREPLICAS=1

        APPNAMESPACE_DEV="develop-nkdev-core"
        APPHOSTNAME_DEV="insurance-sale-platform.com"
        DEPLOYFILE_DEV="deployment-${APPNAME}-dev-${dockerTag}.yaml"

        APPNAMESPACE_UAT="uat-nkdev-core"
        APPHOSTNAME_UAT="uat-insurance-sale-platform.com"
        DEPLOYFILE_UAT="deployment-${APPNAME}-uat-${dockerTag}.yaml"

        APPNAME="insurance-sale-platform"
        INGRESS="nonprod-external"
        NODETIER="backend"

        CONTAINER_IMAGE="xxxxxxxxxxxxxxx.dkr.ecr.ap-southeast-1.amazonaws.com/nkdev/${APPNAME}"

        AWS_DEFAULT_REGION="ap-southeast-1"
    }

    stages {
        stage ('Cleanup') {
            steps {
                dir('directoryToDelete') {
                    deleteDir()
                }
            }
        }
        stage('Run Unit Tests & Static Analysis') {
            steps {
                sh './mvnw clean test'
                junit 'target/surefire-reports/**/*.xml'
                jacoco()
            }

        }

        stage('Build and Push to develop Registry') {
            when {
                anyOf {
                    branch 'develop';
                }
            }
            steps {
                sh '''
                    echo "Push to Registry"
                    ./mvnw clean package -DskipTest=true -P dev
                    docker build --build-arg APPENV=dev --pull -t ${dockerImage} -f docker/Dockerfile .
                    docker login ${CONTAINER_IMAGE} -p $(aws ecr get-login-password) -u AWS
                    docker push ${dockerImage}
                    docker tag ${dockerImage} ${CONTAINER_IMAGE}:${branchName}
                    docker push ${CONTAINER_IMAGE}:${branchName}
                '''
            }
        }

        stage('Build and Push to uat and prod Registry') {
            when {
                anyOf {
                    branch 'master'
                }
            }
            steps {
                sh '''
                    echo "Push to uat Registry"
                    ./mvnw clean package -DskipTest=true -P uat
                    docker build --build-arg APPENV=uat --pull -t ${dockerImage} -f docker/Dockerfile .
                    docker login ${CONTAINER_IMAGE} -p $(aws ecr get-login-password) -u AWS
                    docker push ${dockerImage}
                    docker tag ${dockerImage} ${CONTAINER_IMAGE}:${branchName}
                    docker push ${CONTAINER_IMAGE}:${branchName}

                    echo "Push to prod Registry"
                    ./mvnw clean package -DskipTest=true -P prod
                    docker build --build-arg APPENV=prod --pull -t ${dockerImageProd} -f docker/Dockerfile .
                    docker login ${CONTAINER_IMAGE} -p $(aws ecr get-login-password) -u AWS
                    docker push ${dockerImageProd}
                    docker tag ${dockerImageProd} ${CONTAINER_IMAGE}:prod-${branchName}
                    docker push ${CONTAINER_IMAGE}:prod-${branchName}
                '''
            }
        }

        stage('Create manifest') {
            parallel {
                stage('Deploy to develop environment') {
                    when {
                        anyOf {
                            branch 'develop';
                        }
                    }
                    steps {
                        sh '''
                            echo "Replace deploymentfile with variables"
                            cp deployment-k8s.yaml ${DEPLOYFILE_DEV}
                            sed -i "s/#APPNAME#/${APPNAME}/g" ${DEPLOYFILE_DEV}
                            sed -i "s/#VERSION#/${dockerTag}/g" ${DEPLOYFILE_DEV}
                            sed -i "s/#NAMESPACE#/${APPNAMESPACE_DEV}/g" ${DEPLOYFILE_DEV}
                            sed -i "s/#NODETIER#/${NODETIER}/g" ${DEPLOYFILE_DEV}
                            sed -i "s/#MINREPLICAS#/${MINREPLICAS}/g" ${DEPLOYFILE_DEV}
                            sed -i "s/#INGRESS#/${INGRESS}/g" ${DEPLOYFILE_DEV}
                            sed -i "s/#HOSTNAME#/${APPHOSTNAME_DEV}/g" ${DEPLOYFILE_DEV}
                        '''
                    }
                }
                stage('Deploy to uat environment') {
                    when {
                        anyOf {
                            branch 'master'
                        }
                    }
                    steps {
                        sh '''
                            echo "Replace deploymentfile with variables"
                            cp deployment-k8s.yaml ${DEPLOYFILE_UAT}
                            sed -i "s/#APPNAME#/${APPNAME}/g" ${DEPLOYFILE_UAT}
                            sed -i "s/#VERSION#/${dockerTag}/g" ${DEPLOYFILE_UAT}
                            sed -i "s/#NAMESPACE#/${APPNAMESPACE_UAT}/g" ${DEPLOYFILE_UAT}
                            sed -i "s/#MINREPLICAS#/${MINREPLICAS}/g" ${DEPLOYFILE_UAT}
                            sed -i "s/#NODETIER#/${NODETIER}/g" ${DEPLOYFILE_UAT}
                            sed -i "s/#INGRESS#/${INGRESS}/g" ${DEPLOYFILE_UAT}
                            sed -i "s/#HOSTNAME#/${APPHOSTNAME_UAT}/g" ${DEPLOYFILE_UAT}
                        '''
                    }
                }
            }
        }

        stage ('Deployment step') {
            parallel {
                stage('Deploy to develop environment') {
                    when {
                        anyOf {
                            branch 'develop';
                        }
                    }
                    steps {
                        sh '''
                            echo "Deployment"
                            echo "Deploy to develop namespace"
                            cat ${DEPLOYFILE_DEV}
                            kubectl apply -f ${DEPLOYFILE_DEV}
                        '''
                    }
                }
                stage('Deploy to uat environment') {
                    when {
                        anyOf {
                            branch 'master'
                        }
                    }
                    steps {
                        sh '''
                            # kubectl -n $APPNAMESPACE_DEV create secret generic $APPNAME --from-env-file=secret.dev -o yaml --dry-run=client | kubectl apply -f -
                            echo "Deployment"
                            echo "Deploy to develop namespace"
                            cat ${DEPLOYFILE_SATGING}
                            kubectl apply -f ${DEPLOYFILE_UAT}
                        '''
                    }
                }
            }
        }

        stage('Check Deployment Status') {
            parallel {
                stage('Develop environment') {
                    when {
                        anyOf {
                            branch 'develop';
                        }
                    }
                    steps {
                        sh '''
                            echo "Check Deployment Status"
                            sleep 10
                            kubectl get pod -n ${APPNAMESPACE_DEV}
                        '''
                    }
                }
                stage('UAT environment') {
                    when {
                        anyOf {
                            branch 'master'
                        }
                    }
                    steps {
                        sh '''
                            echo "Check Deployment Status"
                            sleep 10
                            kubectl get pod -n ${APPNAMESPACE_UAT}
                        '''
                    }
                }
            }
        }
    }
    post {
            always {
                deleteDir()
            }
    }
}