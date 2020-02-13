plugins {
    kotlin("jvm") version "1.3.61"
}

group = "ru.mipt.npm"

repositories {
    jcenter()
    maven("https://dl.bintray.com/mipt-npm/scientifik") // production repository for kmath
    maven("https://dl.bintray.com/mipt-npm/dev") // development repository for kmath
}

dependencies {
    //Kmath apache-commons bindings. Loads kmath core transitively
    api("scientifik:kmath-commons:0.1.3")
    //api("scientifik:kmath-core-jvm:0.1.3") if one needs core only
}