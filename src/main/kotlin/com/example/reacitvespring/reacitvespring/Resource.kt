package com.example.demo

import org.springframework.stereotype.Component

@Component
class Resource(
        var meta: Meta? = null,
        var implicitRules: String? = null,
        var language: String?= null,
        var resourceType: String?= null
){

}