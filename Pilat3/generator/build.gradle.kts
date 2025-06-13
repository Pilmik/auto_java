plugins {
    id("java")
    application
}

group = "org.homework.generator"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":file-utils"))
    implementation(project(":generator-interface"))
}

abstract class CodeGenerationPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.register<JavaExec>("generateCode") {
            group = "code_generation"
            description = "Генерація Java класу в заданій директорії."

            val directoryPath: String? by project.properties
            val className: String? by project.properties

            classpath = project.sourceSets["main"].runtimeClasspath
            mainClass.set("org.homework.generator.CodeGenerator")

            args = listOf(directoryPath ?: "generated", className ?: "GreetingClass")
        }

        project.tasks.register<Delete>("deleteGenerated") {
            group = "code_generation"
            description = "Видалення згенерованої директорії та її Java класу."

            dependsOn("generateCode")

            val directoryPath: String? by project.properties
            val className: String? by project.properties

            val dir = directoryPath ?: "generated"
            val cls = className ?: "GreetingClass"

            delete(project.file(dir).resolve("$cls.java"))
            delete(project.file(dir))
        }
    }
}

apply<CodeGenerationPlugin>()

application {
    mainClass = "org.homework.generator.CodeGenerator"
}

