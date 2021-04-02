plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.30"
    application
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
    implementation("io.ktor:ktor-client:1.5.2")
    implementation("io.ktor:ktor-client-cio:1.5.2")
    implementation("com.github.UBotPlatform.KtUBotCommon:KtUBotCommon:0.6.0")
    implementation("org.slf4j:slf4j-simple:1.7.30")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

application {
    mainClassName = "ubot.app.echo.kotlin.AppKt"
}