pipeline {
    agent any
    environment {
        CHROME_BIN = '/var/lib/jenkins/.cache/ms-playwright/chromium-1091/chrome-linux/chrome'
    }
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
                                    sh "npx playwright install --with-deps"
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
