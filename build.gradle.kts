plugins {
    id("java")
}

group = "com.jbground"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("commons-fileupload:commons-fileupload:1.4")
    implementation("commons-io:commons-io:2.11.0")

    implementation("org.springframework.boot:spring-boot-starter:2.7.8")
    implementation("org.springframework:spring-orm:5.3.24")

    implementation("org.hibernate:hibernate-core:5.6.14.Final")
    implementation("org.hibernate:hibernate-entitymanager:5.6.14.Final")
    implementation("org.hibernate.validator:hibernate-validator:6.2.0.Final")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")



    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}