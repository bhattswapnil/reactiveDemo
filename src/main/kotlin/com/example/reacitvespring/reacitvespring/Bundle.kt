package com.example.reacitvespring.reacitvespring

import reactor.core.publisher.Mono

class Bundle(
        var type: String? =null,
        var entry: Mono<MutableSet<BundleEntry?>>? = null,
        var resourceType: String? = null
)