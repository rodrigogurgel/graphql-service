import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.1"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.0"
	kotlin("plugin.spring") version "1.6.0"
}

group = "br.com.rodrigogurgel"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter:2.6.1")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.1")

	// graphql dependencies
	implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:11.1.0")
	implementation("com.graphql-java-kickstart:graphiql-spring-boot-starter:11.1.0")
	implementation("com.graphql-java-kickstart:voyager-spring-boot-starter:11.1.0")
	implementation("com.graphql-java-kickstart:playground-spring-boot-starter:11.1.0")
	implementation("org.springframework.boot:spring-boot-starter-actuator:2.6.1")
	implementation("org.slf4j:slf4j-api:1.7.32")

	// JDBC
	implementation("org.springframework.boot:spring-boot-starter-jdbc:2.6.1")

	// HikariCP
	implementation("com.zaxxer:HikariCP:5.0.0")

	// Postgresql Driver
	implementation("org.postgresql:postgresql:42.3.1")
}

//dependencyManagement {
//	imports {
//		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
//	}
//}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
