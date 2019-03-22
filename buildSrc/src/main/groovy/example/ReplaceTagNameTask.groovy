package example

import groovy.transform.CompileStatic
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

@CompileStatic
class ReplaceTagNameTask extends DefaultTask {

    public static final String PROJECT_VERSION = "projectVersion"

    @InputFile
    File projectGradleProperties = project.file("gradle.properties")

    @OutputFile
    File cloudBuildDeploy = project.file("${project.buildDir.path}/cloudbuild-deploy.yaml")

    @TaskAction
    def replace() {
        Properties props = new Properties()
        props.load(projectGradleProperties.newDataInputStream())
        String version = props.get(PROJECT_VERSION)
        cloudBuildDeploy.text = cloudBuildDeploy.text.replaceAll('\\$TAG_NAME', version)
    }
}
