plugins{
    java
    application
}

repositories {
    mavenCentral()
}

dependencies{
    // https://mvnrepository.com/artifact/org.graalvm.truffle/truffle-api
    implementation("org.graalvm.truffle:truffle-api:23.1.2")
    // https://mvnrepository.com/artifact/org.graalvm.truffle/truffle-dsl-processor
    implementation("org.graalvm.truffle:truffle-dsl-processor:23.1.2")

    annotationProcessor("org.graalvm.truffle:truffle-dsl-processor:23.1.2")
    // https://mvnrepository.com/artifact/org.antlr/antlr4-runtime
    implementation("org.antlr:antlr4-runtime:4.13.1")
    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    //to run tests
    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.2")

}

tasks.test {
    useJUnitPlatform()
}