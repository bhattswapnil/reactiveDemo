package com.example.reacitvespring.reacitvespring

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WelcomeController {

    @RequestMapping
    fun Welcome(): String {
        return "Hello Swap!"
    }
}