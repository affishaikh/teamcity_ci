import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2019.2"

project {

    vcsRoot(QuoteWall)

    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(QuoteWall)
    }

    steps {
    }

    triggers {
        vcs {
        }
    }
})

object QuoteWall : GitVcsRoot({
    name = "QuoteWall"
    url = "git@github.com:affishaikh/quotewallservice.git"
    authMethod = password {
        userName = "affishaikh"
        password = "zxxb2a18b93f89e4d102a5ade8cbbd7624d775d03cbe80d301b"
    }
})
