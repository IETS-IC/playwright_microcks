pipeline {
    agent any
    tools {
        nodejs "Node Default"
    }
    stages {
        stage('Installations') {
            parallel {
                stage('Frontend (Angular): Install npm packages') {
                    steps {
                        dir('./client') {
                            script {
                                if (isUnix()) {
                                    sh "npm run nuke-install:unix"
                                } else {
                                    bat "npm run nuke-install:windows"
                                }
                            }
                        }
                    }
                }
            }
        }
        stage('Builds') {
            parallel {
                stage('Frontend (Angular): Build') {
                    steps {
                        dir('./client') {
                            bat "npm run build"
                        }
                    }
                }
            }
        }
        stage('Unit Testing') {
            parallel {
                stage('Frontend (Angular): Unit Testing') {
                    steps {
                        dir('./client') {
                            bat 'npm test'
                        }
                    }
                }
            }
        }
        stage('End-to-end Testing') {
            parallel {
                stage('Playwright testing') {
                    steps {
                        dir('./client') {
                            sh 'npx playwright test'
                        }
                    }
                }
            }
        }
    }
}
