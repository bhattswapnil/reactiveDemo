package com.example.demo

abstract class DomainResource(
        meta: Meta? = null,
        implicitRules: String? = null,
        language: String? = null
) : Resource(meta, implicitRules, language)