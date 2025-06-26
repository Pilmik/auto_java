plugins {
    id("java")
}

group = "org.homework"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.13.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    testImplementation("org.junit.platform:junit-platform-suite-api:1.13.0")
    testRuntimeOnly("org.junit.platform:junit-platform-suite-engine:1.13.0")
}

tasks.test {
    useJUnitPlatform()
}

