plugins {
  id("java")
  id("maven-publish")
}

group = "de.lukasbreuer"
version = "1.0.0-SNAPSHOT"

publishing {
  publications {
    create<MavenPublication>("library") {
      from(components["java"])
    }
  }
  repositories {
    maven {
      name = "GitHubPackages"
      url = uri("https://maven.pkg.github.com/breuerlukas/iteron")
      credentials {
        username = (project.findProperty("gpr.user") ?: System.getenv("GITHUB_USERNAME")) as String?
        password = (project.findProperty("gpr.token") ?: System.getenv("GITHUB_TOKEN")) as String?
      }
    }
  }
}

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(platform("org.junit:junit-bom:6.0.0"))
  testImplementation("org.junit.jupiter:junit-jupiter")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")

  implementation("com.google.inject:guice:7.0.0")

  implementation("com.google.guava:guava:33.5.0-jre")

  implementation("org.projectlombok:lombok:1.18.42")
  annotationProcessor("org.projectlombok:lombok:1.18.42")
  testImplementation("org.projectlombok:lombok:1.18.42")
  testAnnotationProcessor("org.projectlombok:lombok:1.18.42")

  implementation("org.json:json:20250517")
  implementation("commons-io:commons-io:2.20.0")
}

tasks.test {
  useJUnitPlatform()
}