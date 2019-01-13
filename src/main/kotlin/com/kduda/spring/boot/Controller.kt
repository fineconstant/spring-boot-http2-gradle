package com.kduda.spring.boot

import mu.KLogging
import org.springframework.http.MediaType
import org.springframework.http.codec.ServerSentEvent
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration.ofSeconds
import java.util.*

@RestController
class Controller {
    @GetMapping("/")
    fun home() = Mono.just("Hello World")

    @GetMapping("sse", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun stream() =
        Flux.interval(ofSeconds(1))
            .map(this::serverSentEvent)
            .doOnSubscribe { logger.info("SSE Started") }
            .doOnCancel { logger.info("SSE Cancelled") }
            .doOnComplete { logger.info("SSE Completed") }

    private fun serverSentEvent(id: Long): ServerSentEvent<CurrentTime> {
        fun uuid() = UUID.randomUUID().toString()

        return ServerSentEvent.builder(CurrentTime())
            .id("$id-${uuid()}")
            .event("time-checked")
            .comment("Current time from server.")
            .build()
    }

    companion object : KLogging()
}


