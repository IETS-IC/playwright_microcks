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
                                    sh "npx playwright install"
                                    sh "export CHROME_BIN=/var/lib/jenkins/.cache/ms-playwright/chromium-1091"
                                    sh "CHROME_BIN=/var/lib/jenkins/.cache/ms-playwright/chromium-1091"
                                    sh "echo \"Testing environment variable entries\""
                                    sh "env"
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
        stage('Builds') {
            parallel {
                stage('Frontend (Angular): Build') {
                    steps {
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
        stage('Unit Testing') {
            parallel {
                stage('Frontend (Angular): Unit Testing') {
                    steps {
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
        stage('End-to-end Testing') {
            parallel {
                stage('Playwright testing') {
                    steps {
                        dir('./client') {
                            script {
                                if (isUnix()) {
                                    sh "npx playwright test"
                                } else {
                                    bat "npx playwright test"
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
