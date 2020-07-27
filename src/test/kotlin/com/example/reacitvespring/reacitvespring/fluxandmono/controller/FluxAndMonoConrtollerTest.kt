package com.example.reacitvespring.reacitvespring.fluxandmono.controller


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.web.reactive.server.EntityExchangeResult
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBodyList
import reactor.core.publisher.Flux

@WebFluxTest
class FluxAndMonoConrtollerTest(@Autowired
                                val webTestClient: WebTestClient) {

    @Test
    fun getfluxTest(){
         webTestClient.get()
                .uri("/flux")
                .exchange()
                .expectStatus().isOk

    }
    @Test
    fun getFluxTest_approcah2(){
       val acceptedList: List<Int> = listOf(1,2,3,4)
        val entityExchnageResult : EntityExchangeResult<List<Int>> =
                webTestClient.get()
                        .uri("/flux")
                        .exchange()
                        .expectStatus().isOk
                        .expectBodyList<Int>()
                        .returnResult()

        assertEquals(acceptedList,entityExchnageResult.responseBody)
    }
}