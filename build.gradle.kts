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
    // https://mvnrepository.com/artifact/org.antlr/antlr4-runtime
    implementation("org.antlr:antlr4-runtime:4.13.1")

}