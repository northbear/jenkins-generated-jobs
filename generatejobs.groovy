
def folderName = 'generated-jobs'
def gitRepo = 'https://github.com/northbear/jenkins-generated-jobs.git'
def githubRepo = 'northbear/jenkins-generated-jobs.git'

folder('generated-jobs') {
    displayName('Generated Jobs')
    description('Folder for jobs generated by another jobs')
}    

pipelineJob("$folderName/build-flask-app") {
    definition {
        cpsScm {
            scm {
                github(githubRepo)
            }
            scriptPath('docker-flask-builder/Jenkinsfile')
            sandbox()
        }
    }
}

pipelineJob("$folderName/build-nginx-proxy") {}
pipelineJob("$folderName/run-application") {}

