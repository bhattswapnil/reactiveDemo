package com.example.reacitvespring.reacitvespring.fluxandmono

import org.junit.jupiter.api.Test
import reactor.core.Disposable
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import java.util.*


class FluxAndMonoTest {

    @Test
    fun flux(){
        val stringFlux : Flux<String> = Flux.just("daytoday" , "daytodayHealth" ,"daytodayReactive").
                concatWith(Flux.just("After Error"))

                stringFlux.log().subscribe(
                        { value -> println("Received: $value") },
                        { error -> println("Error: $error") },
                        { println("Completed!") }
                )

    }
    @Test
    fun fluxTestElemnts_WithoutError(){
        val stringFlux : Flux<String> = Flux.just("daytoday" , "daytodayHealth" ,"daytodayReactive")

        StepVerifier.create(stringFlux)
                .expectNext("daytoday")
                .expectNext("daytodayHealth")
                .expectNext("daytodayReactive")
                .verifyComplete()
    }
    @Test
    fun fluxTestElemnts_WithError(){
        val  stringFlux : Flux<String> = Flux.just("daytoday" , "daytodayHealth" ,"daytodayReactive")
                .concatWith(Flux.error(RuntimeException("Error occured")))

        StepVerifier.create(stringFlux)
                .expectNext("daytoday")
                .expectNext("daytodayHealth")
                .expectNext("daytodayReactive")
                .expectErrorMessage("Error occured")
                .verify()
    }
    @Test
    fun fluxTestElemntsCount_WithError(){
        val  stringFlux : Flux<String> = Flux.just("daytoday" , "daytodayHealth" ,"daytodayReactive")
                .concatWith(Flux.error(RuntimeException("Error occured")))

        StepVerifier.create(stringFlux)
                .expectNextCount(3)
                .expectErrorMessage("Error occured")
                .verify()
    }

    @Test
    fun mono(){
        val stringMono : Mono<String> = Mono.just("spring")
        StepVerifier.create(stringMono)
                .expectNext("spring")
                .verifyComplete()
    }
}