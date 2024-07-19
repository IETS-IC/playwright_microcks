pipeline {
    agent {
        label 'chrome-sidecar-exp'
    }
    environment {
        PLAYWRIGHT_FLAG_CI = 'true'
    }
    stages {
        stage('Installations') {
            parallel {
                stage('Frontend (Angular): Install npm packages') {
                    steps {
                        container('chrome-sidecar') {
                            dir('./client') {
                                script {
                                    if (isUnix()) {
                                        sh "npm run nuke-install:unix"
                                    } else {
                                        bat "npm run nuke-install:windows"
                                        bat "npx playwright install"
                                    }
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
                        container('chrome-sidecar') {
                            dir('./client') {
                                script {
                                    if (isUnix()) {
                                        sh "npx ng build"
                                    } else {
                                        bat "npx ng build"
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        stage('Unit Testing') {
            parallel {
                stage('Frontend (Angular): Unit Testing') {
                    steps {
                        container('chrome-sidecar') {
                            dir('./client') {
                                script {
                                    if (isUnix()) {
                                        sh "npx ng test"
                                    } else {
                                        bat "npx ng test"
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        stage('End-to-end Testing') {
            parallel {
                stage('Playwright testing') {
                    steps {
                        container('chrome-sidecar') {
                            dir('./client') {
                                script {
                                    if (isUnix()) {
                                        sh "npx playwright test -x"
                                    } else {
                                        bat "npx playwright test -x"
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
