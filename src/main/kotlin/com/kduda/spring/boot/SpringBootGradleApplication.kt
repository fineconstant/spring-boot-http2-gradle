package com.kduda.spring.boot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootGradleApplication

fun main(args: Array<String>) {
    runApplication<SpringBootGradleApplication>(*args)
}
